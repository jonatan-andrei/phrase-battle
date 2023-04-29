package phrasebattle.factory;

import phrasebattle.dto.LanguageResponseDto;
import phrasebattle.model.Language;

public class LanguageFactory {

    public static LanguageResponseDto newLanguageResponseDto(Language language) {
        return LanguageResponseDto.builder()
                .languageId(language.getLanguageId())
                .name(language.getName())
                .build();
    }
}
