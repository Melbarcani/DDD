package fr.esgi.location.use_case.location;

import fr.esgi.location.infrastructure.location.ClientRepo;
import fr.esgi.location.infrastructure.location.ContratRepo;
import fr.esgi.location.infrastructure.location.VoitureFinder;
import fr.esgi.location.infrastructure.location.VoitureRepo;
import fr.esgi.location.model.catalogue.Voiture;
import fr.esgi.location.model.location.ContratLocation;

import java.util.List;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
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

        Voiture voiture = new VoitureFinder().findVoitureDisponible(client, voituresDisponibles, voitureRepo);
        ContratLocation contratLocation = new ContratLocation(client, voiture);

        contratRepo.save(contratLocation);
        return contratLocation;
    }
}
