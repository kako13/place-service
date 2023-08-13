package br.com.kaue.placeservice.web;

import br.com.kaue.placeservice.domain.Place;
import br.com.kaue.placeservice.domain.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService service;

    public PlaceController(PlaceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Mono<Place>> create(@RequestBody Place place) {
        var createPlace = service.create(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPlace);
    }
}
