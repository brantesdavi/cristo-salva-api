package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.Tune;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.tag.Tag;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track.Track;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public record SongDTO(
        String title,
        String artist,
        Tune oTune,
        String lyrics,
        String[] links,
        int year
)
{
}
