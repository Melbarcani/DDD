package fr.esgi.location.model.location;

import java.util.Objects;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou * @since 4/15/2022
 */
public class ClientId {
    private final String clientId;

    public ClientId(String clientId) {
        this. clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientId clientId1 = (ClientId) o;
        return Objects.equals(clientId, clientId1.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}
