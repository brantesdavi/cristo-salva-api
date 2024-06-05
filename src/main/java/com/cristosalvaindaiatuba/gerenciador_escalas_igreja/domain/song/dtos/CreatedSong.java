package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.Tune;

public record CreatedSong(
        String id,
        String artist,
        String title,
        Tune oTune
) {
}
