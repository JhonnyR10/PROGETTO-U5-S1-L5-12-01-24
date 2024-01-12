package giovannilongo.PROGETTO.U5S1L5120124.repositories;

import giovannilongo.PROGETTO.U5S1L5120124.entities.Postazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {

    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
    List<Postazione> findPostazioniByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

    @Query("SELECT p FROM Postazione p WHERE p NOT IN (SELECT pr.postazione FROM Prenotazione pr WHERE pr.data = :data)")
    List<Postazione> findFreePostazioniForDate(LocalDate data);

}
