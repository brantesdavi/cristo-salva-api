package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.Tune;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song.Song;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tracks")
public class Track {

    @Id
    private String id;

    @DBRef
    private Song song;
    private Optional<Tune> tune;
    private Date createdAt;

    @DBRef
    private User createdBy;

}