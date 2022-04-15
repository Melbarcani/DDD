package fr.esgi.location.model.location;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public class Client {
    private String clientId;
    private LocalDate dateDisponibilite;
    private int kilometrage;

    public LocalDate getDateDisponibilite() {
        return dateDisponibilite;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String nouveauClientId) {
        clientId = nouveauClientId;
    }

    public void setDateDisponibilite(LocalDate nouvelleDate) {
        dateDisponibilite = nouvelleDate;
    }

    public void setKilometrage(int km) {
        kilometrage = km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return kilometrage == client.kilometrage && Objects.equals(clientId, client.clientId) && Objects.equals(dateDisponibilite, client.dateDisponibilite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, dateDisponibilite, kilometrage);
    }
}
