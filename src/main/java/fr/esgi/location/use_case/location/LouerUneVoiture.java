package fr.esgi.location.use_case.location;

import fr.esgi.location.infrastructure.location.ClientRepo;
import fr.esgi.location.infrastructure.location.ContratRepo;
import fr.esgi.location.infrastructure.location.VoitureRepo;
import fr.esgi.location.model.catalogue.Voiture;
import fr.esgi.location.model.location.ContratLocation;

import java.util.List;
import java.util.Optional;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/14/2022
 */
public class LouerUneVoiture {

    private VoitureRepo voitureRepo;
    private ClientRepo clientRepo;
    private ContratRepo contratRepo;

    public LouerUneVoiture(VoitureRepo voitureRepo, ClientRepo clientRepo, ContratRepo contratRepo) {
        this.voitureRepo = voitureRepo;
        this.clientRepo = clientRepo;
        this.contratRepo = contratRepo;
    }

    public ContratLocation louer(String clientId) {
        var client = clientRepo.findClientById(clientId);
        List<Voiture> voituresDisponibles = voitureRepo.findVoituresByDate(client.getDateDisponibilite());
        Optional<Voiture> voitureTrouvee = voituresDisponibles.stream().filter(
                        voitureDisponible -> voitureDisponible.getMaxKilometre() >= client.getKilometrage())
                .findFirst();

        Voiture voiture = voitureTrouvee.orElseThrow(VoitureNotFountException::new);
        voitureRepo.reserver(voiture);

        ContratLocation contratLocation = new ContratLocation();
        contratLocation.setClient(client);
        contratLocation.setVoiture(voiture);

        contratRepo.save(contratLocation);

        return contratLocation;

    }
}
