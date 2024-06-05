


package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username;
    private String email;
    private LocalDate birthday;
    private String password;
    private Date createdAt;
    private String ministry;

    public User(String username, String email, LocalDate birthday, String password, String ministry) {
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.ministry = ministry;
    }
    //private List<GrantedAuthority> authorities;

}
