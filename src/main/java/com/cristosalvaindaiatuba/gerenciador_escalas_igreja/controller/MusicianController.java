package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.controller;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.musician.Musician;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.musician.MusicianService;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.musician.MusicianDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicians")
public class MusicianController {

    @Autowired
    private MusicianService musicianService;

    @PostMapping
    public ResponseEntity<Musician> registerMusician(@RequestBody MusicianDTO musicianDTO) {
        musicianService.registerMusician(musicianDTO);
        return ResponseEntity.ok().build();
    }
}
