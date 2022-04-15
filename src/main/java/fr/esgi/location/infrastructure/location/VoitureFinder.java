package fr.esgi.location.infrastructure.location;

import fr.esgi.location.model.catalogue.Voiture;
import fr.esgi.location.model.location.Client;
import fr.esgi.location.use_case.location.VoitureNotFountException;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/15/2022
 */
public class VoitureFinder extends Voiture {

    public Voiture findVoitureDisponible(
            Client client, List<Voiture> voituresDisponibles, VoitureRepo voitureRepo) {

        Voiture voitureDisponible = voituresDisponibles.stream().filter(
                        vDisponible -> vDisponible.getMaxKilometre() >= client.getKilometrage()
                                && vDisponible.getDisponibilite())
                .findFirst().orElseThrow(VoitureNotFountException::new);

        return voitureRepo.reserver(voitureDisponible);
    }
}
