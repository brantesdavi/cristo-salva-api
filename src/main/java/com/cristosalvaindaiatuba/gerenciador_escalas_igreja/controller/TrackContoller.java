package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.controller;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.Song;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.TrackListDTO;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track.RegisterTrack;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track.Track;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tracks")
public class TrackContoller {

    @Autowired
    private TrackService trackService;

    @PostMapping
    public ResponseEntity<TrackListDTO> registerTrack(@RequestBody RegisterTrack registerTrack) {
        Optional<TrackListDTO> savedTrack = trackService.registerTrack(registerTrack);
        return savedTrack.map(trackDTO -> ResponseEntity.ok().body(trackDTO))
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackListDTO> getTrackById(@PathVariable String id) {
        Optional<TrackListDTO> trackDTOOptional = trackService.getTrackById(id);
        return trackDTOOptional
                .map(trackDTO -> ResponseEntity.ok().body(trackDTO))
                .orElse(ResponseEntity.notFound().build());
    }
}
