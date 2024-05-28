package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tags")
public class Tag {

    @Id
    private String id;

    private String name;
    private TagType tagType;
    private String color;

    public enum TagType {
        SONG,
        SCHEDULE
    }
}