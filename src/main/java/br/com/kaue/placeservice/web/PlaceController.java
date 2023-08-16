package br.com.kaue.placeservice.web;

import br.com.kaue.placeservice.api.PlaceRequest;
import br.com.kaue.placeservice.api.PlaceResponse;
import br.com.kaue.placeservice.domain.PlaceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService service;

    public PlaceController(PlaceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request) {
        var placeResponse = service.create(request).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<PlaceResponse>> find(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.find(id).map(PlaceMapper::fromPlaceToResponse));
    }

    @GetMapping
    public ResponseEntity<Flux<PlaceResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(service.list().map(PlaceMapper::fromPlaceToResponse));
    }
}
