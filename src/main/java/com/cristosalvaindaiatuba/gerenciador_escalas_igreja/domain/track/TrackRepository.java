package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackRepository extends MongoRepository<Track, String> {
}
