package giovannilongo.PROGETTO.U5S1L5120124.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
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

    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;

    }

    public void addPrenotazione(Prenotazione prenotazione) {
        if (prenotazioni == null) {
            prenotazioni = new ArrayList<>();
        }
        prenotazioni.add(prenotazione);
        prenotazione.setUtente(this);
    }

}
