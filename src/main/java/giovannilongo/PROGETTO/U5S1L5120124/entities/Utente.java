package giovannilongo.PROGETTO.U5S1L5120124.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String nomeCompleto;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String nomeCompleto, String email, List<Prenotazione> prenotazioni) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.prenotazioni = prenotazioni;
    }
}
