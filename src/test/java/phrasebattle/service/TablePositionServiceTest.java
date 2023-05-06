package phrasebattle.service;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import phrasebattle.dto.TablePositionDto;
import phrasebattle.model.WordPhrase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestTransaction
public class TablePositionServiceTest extends AbstractServiceTest {

    @Inject
    TablePositionService tablePositionService;

    @Test
    public void hideWords_ThankYou() {
        // Arrange
        List<WordPhrase> words = new ArrayList<>();
        words.add(createWord("THANK", 5));
        words.add(createWord("YOU", 3));

        // Act
        List<TablePositionDto> result = tablePositionService.hideWords(1L, words);

        // Assert
        for (WordPhrase word : words) {
            assertWord(word.getText(), result);
        }
    }

    @Test
    public void hideWords_AYellowBirdSings() {
        List<WordPhrase> words = new ArrayList<>();
        words.add(createWord("A", 1));
        words.add(createWord("YELLOW", 6));
        words.add(createWord("BIRD", 4));
        words.add(createWord("SINGS", 5));

        // Act
        List<TablePositionDto> result = tablePositionService.hideWords(1L, words);

        // Assert
        for (WordPhrase word : words) {
            assertWord(word.getText(), result);
        }
    }

    @Test
    public void hideWords_CatRanInStreet() {
        List<WordPhrase> words = new ArrayList<>();
        words.add(createWord("CAT", 3));
        words.add(createWord("RAN", 3));
        words.add(createWord("IN", 2));
        words.add(createWord("HOME", 4));

        // Act
        List<TablePositionDto> result = tablePositionService.hideWords(1L, words);

        // Assert
        for (WordPhrase word : words) {
            assertWord(word.getText(), result);
        }
    }

    private WordPhrase createWord(String text, Integer letters) {
        return WordPhrase.builder()
                .text(text)
                .letters(letters)
                .build();
    }

    private void assertWord(String word, List<TablePositionDto> positions) {
        List<Character> wordLetters = Arrays.asList(word.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        TablePositionDto firstLetter = null;
        for (int i = 0; i < wordLetters.size(); i++) {
            if (i == 0) {
                firstLetter = findByLetter(positions, wordLetters.get(i));
                assertTrue(firstLetter != null);
            } else {
                assertLetter(positions, firstLetter.getRow(), firstLetter.getColumn(), i, wordLetters.get(i));
            }
        }
    }

    private void assertLetter(List<TablePositionDto> positions, Integer originalRow, Integer originalColumn, Integer positionInWord, Character letter) {
        TablePositionDto positionInRow = findByRowAndColumn(positions, originalRow + positionInWord, originalColumn);
        TablePositionDto positionInColumn = findByRowAndColumn(positions, originalRow, originalColumn + positionInWord);
        assertTrue((positionInRow != null && positionInRow.getLetter() == letter)
                || (positionInColumn != null && positionInColumn.getLetter() == letter));
    }

    private TablePositionDto findByLetter(List<TablePositionDto> positions, Character letter) {
        return positions.stream().filter(p -> p.getLetter() != null && letter == p.getLetter()).findFirst().orElse(null);
    }

    private TablePositionDto findByRowAndColumn(List<TablePositionDto> positions, Integer row, Integer column) {
        return positions.stream().filter(p -> p.getRow().equals(row) && p.getColumn().equals(column)).findFirst().orElse(null);
    }

}
