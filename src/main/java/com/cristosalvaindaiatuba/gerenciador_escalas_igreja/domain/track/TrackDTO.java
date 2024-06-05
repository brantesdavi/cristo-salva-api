package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.Tune;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.Song;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.User;

import java.util.Date;
import java.util.Optional;

public record TrackDTO(
        Song song,
        Optional<Tune> tune,
        Date createdAt,
        User createdBy
) {
}
