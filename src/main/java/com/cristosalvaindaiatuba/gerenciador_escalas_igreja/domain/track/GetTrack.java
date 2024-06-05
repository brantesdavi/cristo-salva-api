package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos.TrackListDTO;

public record GetTrack(
        String id,
        TrackListDTO song,
        String tune
) {
}
