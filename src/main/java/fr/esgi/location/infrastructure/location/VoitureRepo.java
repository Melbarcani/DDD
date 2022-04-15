package fr.esgi.location.infrastructure.location;
/*
 * Copyright (c) 2022, Assets Japan and/or its affiliates.
 * All rights reserved.
 *
 * https://www.assetsjapan.com/
 *
 * Assets Japan, PROPRIETARY/CONFIDENTIAL.
 * Unauthorized reproduction, modification or communication is strictly prohibited.
 */

import fr.esgi.location.model.catalogue.Voiture;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/14/2022
 */
public interface VoitureRepo {
    Optional<Voiture> save(Voiture voiture);

    List<Voiture> findVoituresByDate(LocalDate availability);

    void reserver(Voiture voiture);
}
