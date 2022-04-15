package fr.esgi.location.use_case.location;

import fr.esgi.location.infrastructure.location.VoitureRepo;
import fr.esgi.location.model.location.Voiture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * * @author Mohamed.ElBarcani - Nicolas Fernandes - Steven Heddadj - Jamal Sidikou
 * @since 4/14/2022
 */
public class FakeVoitures implements VoitureRepo {

    private final List<Voiture> voitures;

    public FakeVoitures(){
        voitures = new ArrayList<>();

        Voiture v1 = new Voiture("1",LocalDate.of(2022, 02, 02),3000);
        v1.setDisponibilite(true);
        voitures.add(v1);

        Voiture v2 = new Voiture("2",LocalDate.of(2022, 02, 03),3000);
        v2.setDisponibilite(true);
        voitures.add(v2);

        Voiture v3 = new Voiture("3",LocalDate.of(2022, 02, 02),3000);
        v3.setDisponibilite(true);
        voitures.add(v3);
    }

    @Override
    public Optional<Voiture> save(Voiture voiture){
        voitures.add(voiture);
        return Optional.of(voiture);
    }

    @Override
    public List<Voiture> findVoituresByDate(LocalDate availability) {
        return voitures.stream().filter(v -> v.getDateDisponibilite().equals(availability)).toList();
    }

    @Override
    public Voiture reserver(Voiture voiture) {
        Voiture v =  voitures.stream().filter(vo-> vo.getId().equals(voiture.getId()))
                .findFirst().orElseThrow(VoitureNotFountException::new);
        v.setDisponibilite(false);
        return v;
    }

    @Override
    public List<Voiture> findToutesLesVoitures() {
        return voitures;
    }

}
