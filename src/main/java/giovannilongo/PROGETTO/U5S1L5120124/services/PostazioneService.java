package giovannilongo.PROGETTO.U5S1L5120124.services;

import giovannilongo.PROGETTO.U5S1L5120124.entities.Postazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.Prenotazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.TipoPostazione;
import giovannilongo.PROGETTO.U5S1L5120124.exceptions.NotFoundException;
import giovannilongo.PROGETTO.U5S1L5120124.repositories.PostazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    PostazioneDAO postazioneDAO;

    public List<Postazione> getAll() {
        return postazioneDAO.findAll();
    }

    public Postazione findById(long id) {
        return postazioneDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void save(Postazione postazione) {
        postazioneDAO.save(postazione);
    }

    public void findByIdAndDelete(long id) {
        Postazione postazione = this.findById(id);
        postazioneDAO.delete(postazione);
    }

    public List<Postazione> findPostazioniByTipoAndCitta(TipoPostazione tipo, String citta) {
        return postazioneDAO.findPostazioniByTipoAndEdificio_Citta(tipo, citta);
    }

    public List<Postazione> findFreePostazioniForDate(LocalDate data) {
        return postazioneDAO.findFreePostazioniForDate(data);
    }

    public boolean isPostazioneFreeForDate(Postazione postazione, LocalDate data) {
        List<Prenotazione> prenotazioniPostazione = postazione.getPrenotazioni();
        return prenotazioniPostazione == null || prenotazioniPostazione.stream().noneMatch(p -> p.getData().equals(data));
    }
}
