package fr.esgi.location.use_case.location;

import fr.esgi.location.infrastructure.location.ClientRepo;
import fr.esgi.location.infrastructure.location.ContratRepo;
import fr.esgi.location.infrastructure.location.VoitureRepo;
import fr.esgi.location.model.catalogue.Voiture;
import fr.esgi.location.model.location.Client;
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

    private final VoitureRepo voitureRepo;
    private final ClientRepo clientRepo;
    private final ContratRepo contratRepo;

    public LouerUneVoiture(VoitureRepo voitureRepo, ClientRepo clientRepo, ContratRepo contratRepo) {
        this.voitureRepo = voitureRepo;
        this.clientRepo = clientRepo;
        this.contratRepo = contratRepo;
    }

    public ContratLocation louer(String clientId) {
        var client = clientRepo.findClientById(clientId);
        List<Voiture> voituresDisponibles = voitureRepo.findVoituresByDate(client.getDateDisponibilite());

        ContratLocation contratLocation = new ContratLocation(client, voituresDisponibles);
        contratLocation.setClient(client);

        voitureRepo.reserver(contratLocation.getVoiture());
        contratRepo.save(contratLocation);

        return contratLocation;

    }
}
