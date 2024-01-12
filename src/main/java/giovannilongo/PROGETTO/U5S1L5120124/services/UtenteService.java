package giovannilongo.PROGETTO.U5S1L5120124.services;

import giovannilongo.PROGETTO.U5S1L5120124.entities.Prenotazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.Utente;
import giovannilongo.PROGETTO.U5S1L5120124.exceptions.NotFoundException;
import giovannilongo.PROGETTO.U5S1L5120124.repositories.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UtenteService {
    @Autowired
    UtenteDAO utenteDAO;

    public List<Utente> getAll() {
        return utenteDAO.findAll();
    }

    public Utente findById(long id) {
        return utenteDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void save(Utente utente) {
        utenteDAO.save(utente);
    }

    public void findByIdAndDelete(long id) {
        Utente utente = this.findById(id);
        utenteDAO.delete(utente);
    }

    public boolean hasPrenotazioneForDate(Utente utente, LocalDate data) {
        List<Prenotazione> prenotazioniUtente = utente.getPrenotazioni();
        return prenotazioniUtente != null && prenotazioniUtente.stream().anyMatch(p -> p.getData().equals(data));
    }
}
