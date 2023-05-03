package phrasebattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phrasebattle.model.Phrase;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {

}
