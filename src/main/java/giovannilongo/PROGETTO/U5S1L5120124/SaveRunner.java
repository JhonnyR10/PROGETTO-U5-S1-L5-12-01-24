package giovannilongo.PROGETTO.U5S1L5120124;

import giovannilongo.PROGETTO.U5S1L5120124.entities.Edificio;
import giovannilongo.PROGETTO.U5S1L5120124.entities.Postazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.TipoPostazione;
import giovannilongo.PROGETTO.U5S1L5120124.entities.Utente;
import giovannilongo.PROGETTO.U5S1L5120124.services.EdificioService;
import giovannilongo.PROGETTO.U5S1L5120124.services.PostazioneService;
import giovannilongo.PROGETTO.U5S1L5120124.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        try {
            Edificio edificio1 = new Edificio("edificio1", "via degli edifici", "Roma");
            Edificio edificio2 = new Edificio("edificio2", "via degli edifici nuovi", "Milano");
            edificioService.save(edificio1);
            edificioService.save(edificio2);
            Postazione postazione1 = new Postazione("000", "postazione piccola", TipoPostazione.SALA_RIUNIONI, 10, edificio1);
            Postazione postazione2 = new Postazione("001", "postazione grande", TipoPostazione.OPENSPACE, 50, edificio2);
            List<Postazione> postazioniEdificio1 = new ArrayList<>();
            postazioniEdificio1.add(postazione1);
            edificio1.setPostazioni(postazioniEdificio1);
            List<Postazione> postazioniEdificio2 = new ArrayList<>();
            postazioniEdificio2.add(postazione2);
            edificio1.setPostazioni(postazioniEdificio2);
            postazioneService.save(postazione1);
            Utente utente1 = new Utente("primoutente", "primo utente", "primoutente@gmail.com");
            Utente utente2 = new Utente("secondoutente", "secondo utente", "secondoutente@gmail.com");
            utenteService.save(utente1);
            utenteService.save(utente2);


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
