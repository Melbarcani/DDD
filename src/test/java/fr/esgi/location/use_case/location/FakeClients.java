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
    private final Map<String, Client> clientMap;

    public FakeClients() {
        clientMap = new HashMap<>();
        Client client1 = new Client("1").setChoix(LocalDate.of(2022, 2, 2), 3000);
        Client client2 = new Client("2").setChoix(LocalDate.of(2022, 2, 3), 3000);
        Client client3 = new Client("3").setChoix(LocalDate.of(2022, 2, 1), 1000);

        clientMap.put(client1.getClientId(), client1);
        clientMap.put(client2.getClientId(), client2);
        clientMap.put(client3.getClientId(), client3);

    }

    @Override
    public Client findClientById(String candidateId) {
            return clientMap.get(candidateId);
        }
}
