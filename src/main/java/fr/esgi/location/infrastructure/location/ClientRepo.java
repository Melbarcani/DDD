package fr.esgi.location.infrastructure.location;

import fr.esgi.location.model.location.Client;

import java.util.Optional;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/14/2022
 */
public interface ClientRepo {
    Client findClientById(String clientId);
}
