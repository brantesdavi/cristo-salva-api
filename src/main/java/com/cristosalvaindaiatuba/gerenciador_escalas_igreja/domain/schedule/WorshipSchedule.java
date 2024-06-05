package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.schedule;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.musician.Musician;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "worship_schedule")
public class WorshipSchedule extends Schedule{

    @DBRef
    private Musician ministryLeader;

    @DBRef
    private List<Musician> band;

}