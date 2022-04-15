package fr.esgi.location.model.location;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/13/2022
 */
public class Voiture {

    private VoitureId id;
    private VoitureDetails voitureDetails;
    private boolean estDisponible;

    public Voiture(String voitureId, LocalDate dateDisponibilite, int kilometrage) {
        this.id = new VoitureId(voitureId);
        this.voitureDetails = new VoitureDetails(kilometrage,dateDisponibilite);
    }
    
    public String getId() {
        return id.getVoitureId();
    }

    public int getMaxKilometre() {
        return voitureDetails.getMaxKilometrage();
    }

    public LocalDate getDateDisponibilite() {
        return voitureDetails.getDateDisponibilite();
    }

    public Boolean getDisponibilite() {
        return this.estDisponible;
    }

    public void setDisponibilite(boolean dispo){
        this.estDisponible = dispo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return estDisponible == voiture.estDisponible && Objects.equals(voitureDetails, voiture.voitureDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voitureDetails, estDisponible);
    }

    public boolean matchKilometrage(Integer kilometrage) {
        return voitureDetails.matchKilometrage(kilometrage);
    }

    public boolean matchParfaitement(Integer kilometrage) {
        return matchKilometrage(kilometrage) && estDisponible;
    }
}
