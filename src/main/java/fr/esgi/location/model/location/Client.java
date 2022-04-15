package fr.esgi.location.model.location;

import fr.esgi.location.infrastructure.location.VoitureRepo;
import fr.esgi.location.use_case.location.VoitureNotFountException;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public class Client {
    private final ClientId clientId;
    private Choix choix;

    public Client(String clientId) {
        this.clientId = new ClientId(clientId);
    }

    public Client setChoix(LocalDate dateDisponibilite, Integer kilometrage) {
        this.choix = new Choix(dateDisponibilite, kilometrage);
        return this;
    }

    public String getClientId() {
        return clientId.getClientId();
    }

    public LocalDate getDateDisponibilite() {
        return choix.getDateDisponibilite();
    }

    public int getKilometrage(){
        return choix.getKilometrage();
    }

    public Voiture findVoitureDisponible(List<Voiture> voitures) {
        return choix.findVoitureDisponible(voitures);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return this.getKilometrage() == client.getKilometrage() && Objects.equals(clientId, client.clientId) && Objects.equals(this.getDateDisponibilite(), client.getDateDisponibilite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, choix.getDateDisponibilite(), choix.getKilometrage());
    }
}
