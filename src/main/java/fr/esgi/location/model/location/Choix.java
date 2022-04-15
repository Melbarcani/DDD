package fr.esgi.location.model.location;

import fr.esgi.location.use_case.location.VoitureNotFountException;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public class Choix {

    public final LocalDate dateDisponibilite;
    public final Integer kilometrage;

    public Choix(LocalDate dateDisponibilite, Integer kilometrage) {
        this.dateDisponibilite = dateDisponibilite;
        this.kilometrage = kilometrage;
    }

    public LocalDate getDateDisponibilite() {
        return dateDisponibilite;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public Voiture findVoitureDisponible(List<Voiture> voitures) {
        return voitures.stream().filter(voiture -> voiture.matchParfaitement(kilometrage))
                .findFirst().orElseThrow(VoitureNotFountException::new);
    }

}
