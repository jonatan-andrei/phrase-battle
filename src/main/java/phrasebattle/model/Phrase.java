package phrasebattle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "phrase")
public class Phrase {

    @Id
    @SequenceGenerator(name = "phraseSeq", sequenceName = "phrase_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phraseSeq")
    @Column(name = "phrase_id")
    private Long phraseId;

    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "number_of_words")
    private Integer numberOfWords;

    @Column(name = "text")
    private String text;

}
