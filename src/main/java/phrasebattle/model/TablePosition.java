package phrasebattle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "table_position")
public class TablePosition {

    @Id
    @SequenceGenerator(name = "tablePositionSeq", sequenceName = "table_position_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tablePositionSeq")
    @Column(name = "table_position_id")
    private Long tablePositionId;

    private Long userGameId;

    private Integer row;

    private Integer column;

    private Character letter;

    private Long wordPhraseId;

    private boolean displayed;

}
