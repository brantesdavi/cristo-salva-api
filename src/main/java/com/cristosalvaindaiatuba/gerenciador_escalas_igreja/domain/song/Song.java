
package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.tag.Tag;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.track.Track;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.Tune;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "songs")
public class Song {

    @Id
    private String id;

    private String title;
    private String artist;
    private Tune oTune;
    private String[] links;
    private int year;

    private Date createdAt;

    @DBRef
    private User createdBy;

    @DBRef
    private List<Track> tracks;

    private List<Tag> tags;


}