package br.com.kaue.placeservice.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {
}
