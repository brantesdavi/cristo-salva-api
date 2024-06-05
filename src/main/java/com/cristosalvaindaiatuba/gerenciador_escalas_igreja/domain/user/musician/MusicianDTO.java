package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.musician;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public record MusicianDTO(
        String username,
        String email,
        LocalDate birthday,
        String password,
        String ministry,
        List<String> instruments
) {}
