package phrasebattle.service;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import phrasebattle.model.TablePosition;
import phrasebattle.model.WordPhrase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestTransaction
public class TablePositionServiceTest extends AbstractServiceTest {

    @Inject
    TablePositionService tablePositionService;

    @Test
    public void hideWords_ThankYou() {
        // Arrange
        List<WordPhrase> words = new ArrayList<>();
        words.add(WordPhrase.builder()
                .text("THANK")
                .letters(5)
                .build());
        words.add(WordPhrase.builder()
                .text("YOU")
                .letters(3)
                .build());

        // Act
        List<TablePosition> result = tablePositionService.hideWords(1L, words)
                .stream().flatMap(List::stream)
                .collect(Collectors.toList());

        // Assert
        TablePosition letterT = result.stream().filter(r -> r.getLetter() != null && 'T' == r.getLetter()).findFirst().orElse(null);
        assertTrue(letterT != null);
    }

}
