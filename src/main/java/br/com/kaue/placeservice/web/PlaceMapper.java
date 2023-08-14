package br.com.kaue.placeservice.web;

import br.com.kaue.placeservice.api.PlaceResponse;
import br.com.kaue.placeservice.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place) {
        return new PlaceResponse(
                place.name(),
                place.slug(),
                place.state(),
                place.createdAt(),
                place.updatedAt());
    }
}
