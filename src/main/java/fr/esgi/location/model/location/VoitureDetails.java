package fr.esgi.location.model.location;

import java.time.LocalDate;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/15/2022
 */
public class VoitureDetails {
    private final int maxKilometrage;
    private final LocalDate dateDisponibilite;

    public VoitureDetails(int kilometrage, LocalDate date) {
        this.maxKilometrage = kilometrage;
        this.dateDisponibilite = date;
    }

    public int getMaxKilometrage() {
        return this.maxKilometrage;
    }

    public LocalDate getDateDisponibilite() {
        return this.dateDisponibilite;
    }

    public boolean matchKilometrage(Integer kilometrage) {
        return maxKilometrage <= kilometrage;
    }
}
