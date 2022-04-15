package fr.esgi.location.use_case.location;

import fr.esgi.location.infrastructure.location.ClientRepo;
import fr.esgi.location.model.location.Client;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public class FakeClients implements ClientRepo {
    Map<String, Client> clientMap;

    public FakeClients() {
        clientMap = new HashMap<>();

        Client client1 = new Client();
        client1.setClientId("1");
        client1.setDateDisponibilite(LocalDate.of(2022, 02, 02));
        client1.setKilometrage(3000);

        clientMap.put(client1.getClientId(), client1);

        Client client2 = new Client();
        client2.setClientId("2");
        client2.setDateDisponibilite(LocalDate.of(2022, 02, 03));
        client2.setKilometrage(3000);

        clientMap.put(client2.getClientId(), client2);

    }

    @Override
    public Client findClientById(String candidateId) {
            return clientMap.get(candidateId);
        }
}
