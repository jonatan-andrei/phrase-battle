package phrasebattle.util;

import lombok.extern.slf4j.Slf4j;
import phrasebattle.dto.TablePositionDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class TablePositionLog {

    public static void logTablePositions(List<TablePositionDto> positions){
        Map<Integer, List<TablePositionDto>> groupingByRow = positions
                .stream().collect(Collectors.groupingBy(r -> r.getRow()));
        for (Map.Entry<Integer, List<TablePositionDto>> entry : groupingByRow.entrySet()) {
            StringBuilder row = new StringBuilder();
            for (TablePositionDto position : entry.getValue()) {
                row.append(position.getLetter() != null ? position.getLetter() : '#').append(" ");
            }
            log.info(row.toString());
        }
    }
}
