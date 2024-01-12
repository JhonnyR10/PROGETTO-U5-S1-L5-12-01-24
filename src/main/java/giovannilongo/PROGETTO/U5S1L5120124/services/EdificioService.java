package giovannilongo.PROGETTO.U5S1L5120124.services;

import giovannilongo.PROGETTO.U5S1L5120124.entities.Edificio;
import giovannilongo.PROGETTO.U5S1L5120124.exceptions.NotFoundException;
import giovannilongo.PROGETTO.U5S1L5120124.repositories.EdificioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    EdificioDAO edificioDAO;

    public List<Edificio> getAll() {
        return edificioDAO.findAll();
    }

    public Edificio findById(long id) {
        return edificioDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void save(Edificio edificio) {
        edificioDAO.save(edificio);
    }

    public void findByIdAndDelete(long id) {
        Edificio edificio = this.findById(id);
        edificioDAO.delete(edificio);
    }
}
