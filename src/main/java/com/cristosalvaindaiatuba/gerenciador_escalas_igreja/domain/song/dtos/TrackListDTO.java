package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.Tune;

public record TrackListDTO(
        String id,
        String title,
        String artist,
        Tune tune,
        CreatedSong song

) {
}

