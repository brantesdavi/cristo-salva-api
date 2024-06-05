package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.musician;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class Musician extends User {

    @Field("instruments")
    private List<String> instruments;

    public Musician(String username, String email, LocalDate birthday, String password, String ministry, List<String> instruments) {
        super(username, email, birthday, password, ministry);
        this.instruments = instruments;
    }
}