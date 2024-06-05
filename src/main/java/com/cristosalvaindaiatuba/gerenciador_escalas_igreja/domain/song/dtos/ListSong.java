package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.dtos;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.Tune;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public record ListSong(
        String id,
        String title,
        String artist,
        Tune otune,
        int year
) {
}
