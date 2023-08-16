package br.com.kaue.placeservice.domain;

import br.com.kaue.placeservice.api.PlaceRequest;
import com.github.slugify.Slugify;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaceService {

    private final PlaceRepository repository;
    private final Slugify slg;

    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest place) {
        return repository.save(new Place(
                null,
                place.name(),
                this.slg.slugify(place.name()),
                place.state(),
                null,
                null
        ));
    }

    public Mono<Place> find(Long id) {
        return repository.findById(id);
    }

    public Flux<Place> list() {
        return repository.findAll();
    }

    public Mono<Place> update(Long id, PlaceRequest request) {
        return repository.findById(id)
                .flatMap(existingPlace -> repository.save(new Place(
                        existingPlace.id(),
                        request.name(),
                        this.slg.slugify(request.name()),
                        request.state(),
                        existingPlace.createdAt(),
                        null
                )));
    }

    public Mono<Void> delete(Long id) {
        return repository.findById(id)
                .flatMap(repository::delete);
    }
}
