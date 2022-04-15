package fr.esgi.location.model.catalogue;

import lombok.Builder;

import java.util.List;
import java.util.Optional;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/13/2022
 */

public class Prospect {
    private Integer kilo;
    private boolean isControleTechniqueExist;
    private List<String> photosUrls;

    public Integer getKilometers() {
        return kilo;
    }

    public boolean getControleTechnique() {
        return isControleTechniqueExist;
    }

    public boolean photoEnvoyee() {
        return photosUrls.size() > 5;
    }
}
