package phrasebattle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "word_phrase")
public class WordPhrase {

    @Id
    @SequenceGenerator(name = "wordPhraseSeq", sequenceName = "word_phrase_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wordPhraseSeq")
    @Column(name = "word_phrase_id")
    private Long wordPhraseId;

    @Column(name = "phrase_id")
    private Long phraseId;

    @Column(name = "text")
    private String text;

    @Column(name = "letters")
    private Integer letters;

}
