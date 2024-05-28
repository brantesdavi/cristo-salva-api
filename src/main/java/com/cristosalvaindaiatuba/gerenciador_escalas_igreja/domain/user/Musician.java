package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Musician extends User {

    private List<String> instruments;
}