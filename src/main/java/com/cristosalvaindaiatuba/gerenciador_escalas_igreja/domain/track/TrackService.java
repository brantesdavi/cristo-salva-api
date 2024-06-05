package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.*;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.CreatedSong;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.TrackListDTO;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.User;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.UserRepository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    private final TrackRepository trackRepository;
    private final SongRepository songRepository;
    private final UserRepository userRepository;

    private TrackService(
            TrackRepository trackRepository,
            SongRepository songRepository,
            UserRepository userRepository
    ){
        this.trackRepository = trackRepository;
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    public Optional<TrackListDTO> registerTrack(RegisterTrack trackDTO) {
        Song song = songRepository.findById(trackDTO.songId())
                .orElseThrow(() -> new IllegalArgumentException("Song not found with ID: " + trackDTO.songId()));

        Track track = new Track();
        track.setSong(song);

        // Set tune
        if (trackDTO.tune() == null) {
            track.setTune(song.getOTune());
        } else {
            track.setTune(trackDTO.tune());
        }

        User user = userRepository.findById(trackDTO.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + trackDTO.userId()));

        track.setCreatedBy(user);

        track.setCreatedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        Track savedTrack = trackRepository.save(track);

        // Construa um TrackListSong para retornar
        CreatedSong trackListSong = new CreatedSong(
                savedTrack.getSong().getId(),
                savedTrack.getSong().getTitle(),
                savedTrack.getSong().getArtist(),
                savedTrack.getSong().getOTune()
        );

        // Construa um TrackListDTO para retornar
        TrackListDTO trackListDTO = new TrackListDTO(
                savedTrack.getId(),
                savedTrack.getSong().getTitle(),
                savedTrack.getSong().getArtist(),
                savedTrack.getTune(),

                trackListSong
        );

        return Optional.of(trackListDTO);
    }

    public Optional<TrackListDTO> getTrackById(String id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        return trackOptional.map(track -> {
            CreatedSong createdSong = new CreatedSong(
                    track.getSong().getId(),
                    track.getSong().getTitle(),
                    track.getSong().getArtist(),
                    track.getSong().getOTune()
            );

            TrackListDTO trackListDTO = new TrackListDTO(
                    track.getId(),
                    track.getSong().getTitle(),
                    track.getSong().getArtist(),
                    track.getTune(),

                    createdSong
            );

            return trackListDTO;
        });
    }


}
