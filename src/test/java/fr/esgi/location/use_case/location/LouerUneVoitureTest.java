package fr.esgi.location.use_case.location;

import fr.esgi.location.infrastructure.location.ClientRepo;
import fr.esgi.location.infrastructure.location.ContratRepo;
import fr.esgi.location.infrastructure.location.VoitureRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
        var contratLocation = new LouerUneVoiture(voitureRepo, clientRepo, contratRepo).louer("1");
        assertEquals(false, contratLocation.getVoiture().getDisponibilite());
        assertTrue(contratLocation.getVoiture().getMaxKilometre() <= contratLocation.getClient().getKilometrage());
        assertEquals("1", contratLocation.getVoiture().getId());
        assertEquals("1", contratLocation.getClient().getClientId());

        var contratLocation2 = new LouerUneVoiture(voitureRepo, clientRepo, contratRepo).louer("2");
        assertEquals(false, contratLocation2.getVoiture().getDisponibilite());
        assertTrue(contratLocation2.getVoiture().getMaxKilometre() <= contratLocation2.getClient().getKilometrage());
        assertEquals("2", contratLocation2.getVoiture().getId());
        assertEquals("2", contratLocation2.getClient().getClientId());

        var contratLocation3 = new LouerUneVoiture(voitureRepo, clientRepo, contratRepo);
        assertThrows(VoitureNotFountException.class, () -> contratLocation3.louer("3"));
    }
}