package phrasebattle.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import phrasebattle.dto.TablePositionDto;
import phrasebattle.service.GameService;

import java.util.List;

@Path("/game")
@ApplicationScoped
public class GameResource {

    @Inject
    GameService gameService;

    @GET
    @Path("/{userGameId}/{phraseId}")
    public List<TablePositionDto> hideWords(Long userGameId, Long phraseId) {
        return gameService.hideWords(userGameId, phraseId);
    }
}
