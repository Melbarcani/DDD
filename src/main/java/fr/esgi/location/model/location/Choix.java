package fr.esgi.location.model.location;

import java.time.LocalDate;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public class Choix {

    public LocalDate dateDisponibilite;
    public Integer kilometrage;

    public LocalDate getDateDisponibilite() {
        return dateDisponibilite;
    }

    public Integer getMaxKilometre() {
        return kilometrage;
    }
}
