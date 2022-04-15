package fr.esgi.location.use_case.location;

import fr.esgi.location.infrastructure.location.ClientRepo;
import fr.esgi.location.infrastructure.location.ContratRepo;
import fr.esgi.location.infrastructure.location.VoitureRepo;
import fr.esgi.location.model.catalogue.Voiture;
import fr.esgi.location.model.location.Client;
import fr.esgi.location.model.location.ContratLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
class LouerUneVoitureTest {
    private ClientRepo clientRepo;
    private ContratRepo contratRepo;
    private VoitureRepo voitureRepo;

    @BeforeEach
    public void init() {
        clientRepo = new FakeClients();
        contratRepo = new FakeContractLocation();
        voitureRepo = new FakeVoitures();
    }

    @Test
    void louer() {
        var expectedVoiture1 = new Voiture();
        expectedVoiture1.setId("1");
        expectedVoiture1.setMaxKilometre(3000);
        expectedVoiture1.setDateDisponibilite(LocalDate.of(2022, 02, 02));
        expectedVoiture1.setDisponibilite(false);

        var client1 = new Client();
        client1.setClientId("1");
        client1.setDateDisponibilite(LocalDate.of(2022, 02, 02));
        client1.setKilometrage(3000);

        List<Voiture> voituresDisponibles = voitureRepo.findVoituresByDate(client1.getDateDisponibilite());

        var contratLocation = new LouerUneVoiture(voitureRepo, clientRepo, contratRepo).louer("1");

        var expectedResult = new ContratLocation(client1, expectedVoiture1);
        expectedResult.setVoiture(expectedVoiture1);
        expectedResult.setClient(client1);
        assertEquals(expectedResult.getVoiture().getId(), contratLocation.getVoiture().getId());
        assertEquals(expectedResult.getClient().getClientId(), contratLocation.getClient().getClientId());

       /* var expectedVoiture2 = new Voiture();
        expectedVoiture2.setId("2");
        expectedVoiture2.setMaxKilometre(3000);
        expectedVoiture2.setDateDisponibilite(LocalDate.of(2022, 02, 03));
        expectedVoiture2.setDisponibilite(false);

        var client2 = new Client();
        client2.setClientId("2");
        client2.setDateDisponibilite(LocalDate.of(2022, 02, 03));
        client2.setKilometrage(3000);

        List<Voiture> voituresDisponibles2 = voitureRepo.findVoituresByDate(client2.getDateDisponibilite());

        var contratLocation2 = new LouerUneVoiture(voitureRepo, clientRepo, contratRepo).louer("2");

        var expectedResult2 = new ContratLocation(client2, voituresDisponibles2, voitureRepo);
        expectedResult2.setVoiture(expectedVoiture2);
        expectedResult2.setClient(client2);
        assertEquals(expectedResult2.getVoiture().getId(), contratLocation2.getVoiture().getId());
        assertEquals(expectedResult2.getClient().getClientId(), contratLocation2.getClient().getClientId());*/
    }
}