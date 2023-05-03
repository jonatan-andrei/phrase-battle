package phrasebattle.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import phrasebattle.model.WordPhrase;
import phrasebattle.repository.WordPhraseRepository;

import java.util.List;

@ApplicationScoped
public class WordPhraseService {

    @Inject
    WordPhraseRepository wordPhraseRepository;

    public List<WordPhrase> findByPhraseId(Long phraseId) {
        return wordPhraseRepository.findByPhraseId(phraseId);
    }

}
