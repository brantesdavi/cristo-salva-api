
package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.song;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.Tune;
import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

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
    private String lyrics;
    private String[] links;
    private int year;
    private Date createdAt;
    private Tag tag;

    /*@DBRef
    private User createdBy;

    @DBRef
    private List<Track> tracks;

    private List<Tag> tags;*/

    public Song(
            String title,
            String artist,
            Tune otune,
            String lyrics,
            String[] links,
            int year,
            Date createdAt
            /*,User createdBy,
            List<Track> tracks,
            List<Tag> tags */
    ) {

        this.title = title;
        this.artist= artist;
        this.oTune = otune;
        this.lyrics = lyrics;
        this.links=links;
        this.year=year;
        this.createdAt = createdAt;
        /*this.createdBy = createdBy;
        this.tracks = tracks;
        this.tags = tags;*/

    }
}