package phrasebattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phrasebattle.model.Language;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    List<Language> findAll();

}
