package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.musician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MusicianService {

    @Autowired
    private MusicianRepository musicianRepository;

    public ResponseEntity<Void> registerMusician(@RequestBody MusicianDTO musicianDTO) {
        Musician musician = new Musician(
                musicianDTO.username(),
                musicianDTO.email(),
                musicianDTO.birthday(),
                musicianDTO.password(),
                musicianDTO.ministry(),
                musicianDTO.instruments()
        );
        musicianRepository.save(musician);
        return ResponseEntity.ok().build();
    }

}
