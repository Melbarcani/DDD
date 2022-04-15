package fr.esgi.location.infrastructure.location;

import fr.esgi.location.model.catalogue.Voiture;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public interface VoitureRepo {
    Optional<Voiture> save(Voiture voiture);

    List<Voiture> findVoituresByDate(LocalDate availability);

    Voiture reserver(Voiture voiture);
}
