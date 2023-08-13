package br.com.kaue.placeservice.config;

import br.com.kaue.placeservice.domain.PlaceRepository;
import br.com.kaue.placeservice.domain.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {

    @Bean
    public PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);
    }
}
