package fr.esgi.location.infrastructure.location;

import fr.esgi.location.model.location.ContratLocation;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public interface ContratRepo {
    void save(ContratLocation contratLocation);
}
