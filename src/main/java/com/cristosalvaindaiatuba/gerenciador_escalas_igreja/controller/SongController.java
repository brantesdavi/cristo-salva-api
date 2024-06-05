package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.controller;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.CreatedSong;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.ListSong;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.Song;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.SongService;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.SongDTO;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.SuggestionSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<CreatedSong> registerSong(@RequestBody SongDTO songDTO){
        try{
            CreatedSong createdSong = songService.registerSong(songDTO);
            return ResponseEntity.ok(createdSong);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<ListSong>> getAllSongs() {
        List<ListSong> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/suggestions")
    public ResponseEntity<List<SuggestionSong>> getSuggestions(
            @RequestParam String query,
            @RequestParam int page,
            @RequestParam int size
    ) {
        List<SuggestionSong> suggestions = songService.getSuggestions(query, page, size);
        return ResponseEntity.ok(suggestions);
    }


}
