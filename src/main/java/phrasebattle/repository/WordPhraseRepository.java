package phrasebattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phrasebattle.model.WordPhrase;

import java.util.List;

public interface WordPhraseRepository extends JpaRepository<WordPhrase, Long> {

    List<WordPhrase> findByPhraseId(Long phraseId);
}
