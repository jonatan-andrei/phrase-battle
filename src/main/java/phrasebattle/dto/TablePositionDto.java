package phrasebattle.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablePositionDto {

    private Long tablePositionId;

    private Integer row;

    private Integer column;

    private Character letter;

}
