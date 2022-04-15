package fr.esgi.location.model.location;

import fr.esgi.location.model.catalogue.Voiture;
import fr.esgi.location.use_case.location.VoitureNotFountException;

import java.util.List;
import java.util.Objects;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/14/2022
 */

public class ContratLocation {
    private Client client;
    private Voiture voiture;

    public ContratLocation(Client client, List<Voiture> voituresDisponibles) {
        this.client = client;
        this.voiture = voituresDisponibles.stream().filter(
                        voitureDisponible -> voitureDisponible.getMaxKilometre() >= client.getKilometrage())
                .findFirst().orElseThrow(VoitureNotFountException::new);


    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Client getClient() {
        return client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratLocation that = (ContratLocation) o;
        return Objects.equals(client, that.client) && Objects.equals(voiture, that.voiture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, voiture);
    }
}
