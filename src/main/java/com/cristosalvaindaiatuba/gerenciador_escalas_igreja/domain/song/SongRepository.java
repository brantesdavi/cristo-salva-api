package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends MongoRepository<Song, String> {
    List<Song> findByTitleLikeIgnoreCaseOrArtistLikeIgnoreCase (
            String title,
            String artist,
            Pageable pageable
    );

    Optional<Song> findByTitleAndArtist(String title, String artist);

}
