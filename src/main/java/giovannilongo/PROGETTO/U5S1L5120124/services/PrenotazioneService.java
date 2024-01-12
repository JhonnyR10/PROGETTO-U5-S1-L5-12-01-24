package giovannilongo.PROGETTO.U5S1L5120124.services;

import giovannilongo.PROGETTO.U5S1L5120124.entities.Postazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.Prenotazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.Utente;
import giovannilongo.PROGETTO.U5S1L5120124.exceptions.NotFoundException;
import giovannilongo.PROGETTO.U5S1L5120124.repositories.PrenotazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneDAO prenotazioneDAO;

    public List<Prenotazione> getAll() {
        return prenotazioneDAO.findAll();
    }

    public Prenotazione findById(long id) {
        return prenotazioneDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void save(Prenotazione prenotazione) {
        prenotazioneDAO.save(prenotazione);
    }

    public void findByIdAndDelete(long id) {
        Prenotazione prenotazione = this.findById(id);
        prenotazioneDAO.delete(prenotazione);
    }

    public List<Prenotazione> findPrenotazioniByUtenteAndData(Utente utente, LocalDate data) {
        return prenotazioneDAO.findPrenotazioniByUtenteAndData(utente, data);
    }

    public List<Prenotazione> findPrenotazioniByPostazione(Postazione postazione) {
        return prenotazioneDAO.findPrenotazioniByPostazione(postazione);
    }

}
