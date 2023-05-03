package phrasebattle.factory;

import phrasebattle.dto.TablePositionDto;
import phrasebattle.model.TablePosition;

public class TablePositionFactory {

    public static TablePositionDto newTablePositionDto(TablePosition tablePosition) {
        return TablePositionDto.builder()
                .tablePositionId(tablePosition.getTablePositionId())
                .row(tablePosition.getRow())
                .column(tablePosition.getColumn())
                .letter(tablePosition.getLetter())
                .build();
    }
}
