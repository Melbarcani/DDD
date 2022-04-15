package fr.esgi.location.infrastructure.location;

import fr.esgi.location.model.location.Client;

import java.util.Optional;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public interface ClientRepo {
    Client findClientById(String clientId);
}
