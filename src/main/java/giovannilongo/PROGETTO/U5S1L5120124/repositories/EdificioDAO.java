package giovannilongo.PROGETTO.U5S1L5120124.repositories;

import giovannilongo.PROGETTO.U5S1L5120124.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioDAO extends JpaRepository<Edificio, Long> {

}
