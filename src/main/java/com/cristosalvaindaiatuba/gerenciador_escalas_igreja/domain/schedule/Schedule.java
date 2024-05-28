package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.schedule;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.tag.Tag;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "schedules")
public class Schedule {

    @Id
    private String id;
    private String title;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String obs;

    @DBRef
    private List<Tag> tags;

    private User createdBy;
    private Date createdAt;

    //private String location;
}