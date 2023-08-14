package br.com.kaue.placeservice.domain;

import br.com.kaue.placeservice.api.PlaceRequest;
import reactor.core.publisher.Mono;

public class PlaceService {

    private final PlaceRepository repository;

    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    public Mono<Place> create(PlaceRequest place) {
        return repository.save(new Place(
                    null,
                    place.name(),
                    place.slug(),
                    place.state(),
                    place.createdAt(),
                    place.updatedAt()
                    ));
    }
}
