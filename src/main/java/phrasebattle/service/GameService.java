package phrasebattle.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import phrasebattle.dto.TablePositionDto;
import phrasebattle.model.WordPhrase;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GameService {

    @Inject
    WordPhraseService wordPhraseService;

    @Inject
    TablePositionService tablePositionService;

    public List<TablePositionDto> hideWords(Long userGameId, Long phraseId) {
        List<WordPhrase> words = wordPhraseService.findByPhraseId(phraseId);
        //return tablePositionService.hideWords(userGameId, words);
        return new ArrayList<>();
    }
}