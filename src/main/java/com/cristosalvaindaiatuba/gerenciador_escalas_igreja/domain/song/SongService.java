package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.CreatedSong;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.ListSong;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.SongDTO;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.SuggestionSong;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongService {
    private final SongRepository songRepository;

    private SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public CreatedSong registerSong(SongDTO songDTO){

        Optional<Song> existingSong = songRepository
                .findByTitleAndArtist(
                        songDTO.title(),
                        songDTO.artist()
                );
        if(existingSong.isPresent()) {
            throw new IllegalArgumentException("Essa musica já foi adicionada");
        }
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        Song song = new Song(
                songDTO.title(),
                songDTO.artist(),
                songDTO.oTune(),
                songDTO.lyrics(),
                songDTO.links(),
                songDTO.year(),
                date
        );
        Song savedSong  = songRepository.save(song);

        return new CreatedSong(
                savedSong.getId(),
                savedSong.getTitle(),
                savedSong.getArtist(),
                savedSong.getOTune()
        );
    }

    public List<ListSong> getAllSongs(){
        List<Song> songs = songRepository.findAll();
        List<ListSong> songDTOs = new ArrayList<>();
        for (Song song: songs){
            ListSong songDTO = new ListSong(
                    song.getId(),
                    song.getTitle(),
                    song.getArtist(),
                    song.getOTune(),
                    song.getYear()
            );
            songDTOs.add(songDTO);
        }
        return songDTOs;
    }

    public Optional<Song> getSongById(String id){
        return songRepository.findById(id);
    }

    public List<SuggestionSong> getSuggestions(String query, int page, int size) {
        if(!query.isEmpty()){
            Pageable pageable = PageRequest.of(page, size);
            List<Song> suggestions = songRepository.findByTitleLikeIgnoreCaseOrArtistLikeIgnoreCase (
                    query, query, pageable
            );

            if(!suggestions.isEmpty()) return null;

            return suggestions.stream()
                    .map(song -> new SuggestionSong(
                            song.getId(),
                            song.getTitle(),
                            song.getArtist()
                    ))
                    .collect(Collectors.toList());

        }
        return null;
    }

}
