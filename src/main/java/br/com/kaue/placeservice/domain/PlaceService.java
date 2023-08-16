package br.com.kaue.placeservice.domain;

import br.com.kaue.placeservice.api.PlaceRequest;
import com.github.slugify.Slugify;
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
}
