package phrasebattle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "language")
public class Language {

    @Id
    @SequenceGenerator(name = "languageSeq", sequenceName = "language_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "languageSeq")
    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "name", unique = true, length = 100)
    private String name;
}
