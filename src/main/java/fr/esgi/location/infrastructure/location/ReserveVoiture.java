package fr.esgi.location.infrastructure.location;
import fr.esgi.location.model.location.Client;
import fr.esgi.location.model.location.Voiture;

import java.util.List;

/**
  * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
  * @since 4/15/2022
 */
public class ReserveVoiture {

    public Voiture findVoitureDisponible(Client client, VoitureRepo voitureRepo) {
        List<Voiture> voituresDisponibles = voitureRepo.findToutesLesVoitures();

        Voiture voitureDisponible = client.findVoitureDisponible(voituresDisponibles);

        return voitureRepo.reserver(voitureDisponible);
    }

}
