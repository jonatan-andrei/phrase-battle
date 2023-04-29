package phrasebattle.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import phrasebattle.dto.LanguageResponseDto;
import phrasebattle.factory.LanguageFactory;
import phrasebattle.repository.LanguageRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LanguageService {

    @Inject
    LanguageRepository languageRepository;

    public List<LanguageResponseDto> findAll() {
        return languageRepository.findAll()
                .stream().map(LanguageFactory::newLanguageResponseDto)
                .collect(Collectors.toList());
    }
}
