package br.com.kaue.placeservice.api;

import jakarta.validation.constraints.NotBlank;

public record PlaceRequest(@NotBlank String name,@NotBlank String state) {
}
