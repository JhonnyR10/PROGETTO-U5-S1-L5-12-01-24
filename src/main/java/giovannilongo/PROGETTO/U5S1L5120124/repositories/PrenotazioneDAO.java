package giovannilongo.PROGETTO.U5S1L5120124.repositories;

import giovannilongo.PROGETTO.U5S1L5120124.entities.Postazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.Prenotazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {
    @Query("SELECT p FROM Prenotazione p WHERE p.utente = :utente AND p.data = :data")
    List<Prenotazione> findPrenotazioniByUtenteAndData(@Param("utente") Utente utente, @Param("data") LocalDate data);

    @Query("SELECT p FROM Prenotazione p WHERE p.postazione = :postazione")
    List<Prenotazione> findPrenotazioniByPostazione(@Param("postazione") Postazione postazione);
}
