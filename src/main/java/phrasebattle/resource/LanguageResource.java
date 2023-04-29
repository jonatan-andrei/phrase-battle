package phrasebattle.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import phrasebattle.dto.LanguageResponseDto;
import phrasebattle.service.LanguageService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@Path("/language")
@ApplicationScoped
public class LanguageResource {

    @Inject
    LanguageService languageService;

    @GET
    public List<LanguageResponseDto> getLanguages() {
        return languageService.findAll();
    }

}
