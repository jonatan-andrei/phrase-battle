package phrasebattle.service;

import jakarta.enterprise.context.ApplicationScoped;
import phrasebattle.domain.Direction;
import phrasebattle.dto.TablePositionDto;
import phrasebattle.factory.TablePositionFactory;
import phrasebattle.model.TablePosition;
import phrasebattle.model.WordPhrase;
import phrasebattle.repository.TablePositionRepository;
import phrasebattle.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@ApplicationScoped
public class TablePositionService {

    TablePositionRepository tablePositionRepository;

    public List<List<TablePosition>> hideWords(Long userGameId, List<WordPhrase> words) {
        List<List<TablePosition>> positions = createTable(userGameId);
        for (WordPhrase word : words) {
            hideWord(word, positions);
        }
        return positions;
        //return savePositions(positions);
    }

    private Integer defineRow() {
        return random(Constants.NUMBER_OF_TABLE_ROWS);
    }

    private Integer defineColumn() {
        return random(Constants.NUMBER_OF_TABLE_COLUMNS);
    }

    private Direction defineDirection() {
        return random(2).equals(0) ? Direction.HORIZONTAL : Direction.VERTICAL;
    }

    private Integer random(Integer bound) {
        Random random = new Random();
        Integer result = random.nextInt(bound);
        return result;
    }

    private void hideWord(WordPhrase word, List<List<TablePosition>> positions) {
        Character[] wordLetters =
                word.getText().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        boolean hidden = false;
        do {
            Integer row = defineRow();
            Integer column = defineColumn();
            Direction direction = defineDirection();
            if (direction.equals(Direction.VERTICAL) && !checkAvailabilityInRows(positions, row, column, word.getLetters())) {
                continue;
            }
            if (direction.equals(Direction.HORIZONTAL) && !checkAvailabilityInColumns(positions, row, column, word.getLetters())) {
                continue;
            }
            for (int l = 0; l < word.getLetters(); l++) {
                Integer rowPosition = direction.equals(Direction.VERTICAL) ? row + l : row;
                Integer columnPosition = direction.equals(Direction.HORIZONTAL) ? column + l : column;
                TablePosition position = positions.get(rowPosition).get(columnPosition);
                position.setLetter(wordLetters[l]);
                position.setWordPhraseId(word.getWordPhraseId());
            }
            hidden = true;
        } while (!hidden);
    }

    private boolean checkAvailabilityInRows(List<List<TablePosition>> positions, Integer row, Integer column, Integer letters) {
        if (row + letters > Constants.NUMBER_OF_TABLE_ROWS) {
            return false;
        }

        if (row != 0) {
            TablePosition previousPosition = positions.get(row - 1).get(column);
            if (previousPosition.getLetter() != null) {
                return false;
            }
        }

        if (row + letters + 1 !=  Constants.NUMBER_OF_TABLE_ROWS) {
            TablePosition nextPosition = positions.get(row + letters + 1).get(column);
            if (nextPosition.getLetter() != null) {
                return false;
            }
        }

        for (int i = 0; i < letters; i++) {
            TablePosition position = positions.get(row + i).get(column);
            if (position.getLetter() != null) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAvailabilityInColumns(List<List<TablePosition>> positions, Integer row, Integer column, Integer letters) {
        if (column + letters > Constants.NUMBER_OF_TABLE_COLUMNS) {
            return false;
        }

        if (column != 0) {
            TablePosition previousPosition = positions.get(row).get(column - 1);
            if (previousPosition.getLetter() != null) {
                return false;
            }
        }

        if (column + letters + 1 != Constants.NUMBER_OF_TABLE_COLUMNS) {
            TablePosition nextPosition = positions.get(row).get(column + letters + 1);
            if (nextPosition.getLetter() != null) {
                return false;
            }
        }

        for (int i = 0; i < letters; i++) {
            TablePosition position = positions.get(row).get(column + i);
            if (position.getLetter() != null) {
                return false;
            }
        }
        return true;
    }

    private List<List<TablePosition>> createTable(Long userGameId) {
        List<List<TablePosition>> positions = new ArrayList<>();
        for (int i = 0; i < Constants.NUMBER_OF_TABLE_ROWS; i++) {
            List<TablePosition> rowPositions = new ArrayList<>();
            for (int j = 0; j < Constants.NUMBER_OF_TABLE_COLUMNS; j++) {
                rowPositions.add(TablePosition.builder()
                        .userGameId(userGameId)
                        .row(i)
                        .column(j)
                        .displayed(false)
                        .build());
            }
            positions.add(rowPositions);
        }
        return positions;
    }

//    private List<TablePositionDto> savePositions(List<List<TablePosition>> positions) {
//        return tablePositionRepository.saveAll(positions.stream()
//                        .flatMap(List::stream)
//                        .collect(Collectors.toList()))
//                .stream().map(TablePositionFactory::newTablePositionDto)
//                .collect(Collectors.toList());
//    }

}
