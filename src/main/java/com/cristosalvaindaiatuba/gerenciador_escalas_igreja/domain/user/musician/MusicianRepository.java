package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.musician;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicianRepository extends MongoRepository<Musician, String>{
}
