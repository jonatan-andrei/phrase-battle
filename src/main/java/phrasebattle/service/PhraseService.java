package phrasebattle.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import phrasebattle.model.Phrase;
import phrasebattle.repository.PhraseRepository;

@ApplicationScoped
public class PhraseService {

    @Inject
    PhraseRepository phraseRepository;

    public Phrase findById(Long phraseId) {
        return phraseRepository.findById(phraseId)
                .orElseThrow(() -> new NotFoundException("Phrase id " + phraseId + " does not exist"));
    }

}
