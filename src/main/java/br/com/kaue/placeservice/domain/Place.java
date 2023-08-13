package br.com.kaue.placeservice.domain;

import java.time.LocalDateTime;


public record Place(Long id, String name, String slug, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
