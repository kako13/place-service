package br.com.kaue.placeservice.domain;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PlaceService {

    private final PlaceRepository repository;

    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    public Mono<Place> create(Place place) {
        return repository.save(place);
    }
}
