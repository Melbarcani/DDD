package fr.esgi.location.use_case.location;
/*
 * Copyright (c) 2022, Assets Japan and/or its affiliates.
 * All rights reserved.
 *
 * https://www.assetsjapan.com/
 *
 * Assets Japan, PROPRIETARY/CONFIDENTIAL.
 * Unauthorized reproduction, modification or communication is strictly prohibited.
 */

import fr.esgi.location.infrastructure.location.VoitureRepo;
import fr.esgi.location.model.catalogue.Voiture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/14/2022
 */
public class FakeVoitures implements VoitureRepo {

    List<Voiture> voitures;

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
    public void reserver(Voiture voiture) {
        voitures.stream().filter(v -> v.getId().equals(voiture.getId()))
                .findFirst()
                .ifPresent(v -> v.setDisponibilite(false));
    }

    public FakeVoitures(){
        voitures = new ArrayList<>();

        Voiture v1 = new Voiture();
        v1.setId("1");
        v1.setMaxKilometre(3000);
        v1.setDateDisponibilite(LocalDate.of(2022,02,02));
        v1.setEstDisponible(true);
        voitures.add(v1);

        Voiture v2 = new Voiture();
        v2.setId("2");
        v2.setMaxKilometre(3000);
        v2.setDateDisponibilite(LocalDate.of(2022,02,02));
        voitures.add(v2);

        Voiture v3 = new Voiture();
        v3.setId("3");
        v3.setMaxKilometre(3000);
        v3.setDateDisponibilite(LocalDate.of(2022,02,02));
        voitures.add(v3);
    }

}
