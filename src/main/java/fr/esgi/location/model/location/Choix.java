package fr.esgi.location.model.location;

import fr.esgi.location.use_case.location.VoitureNotFountException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Choix choix = (Choix) o;
        return Objects.equals(dateDisponibilite, choix.dateDisponibilite) && Objects.equals(kilometrage, choix.kilometrage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDisponibilite, kilometrage);
    }
}
