package fr.esgi.location.model.location;
/*
 * Copyright (c) 2022, Assets Japan and/or its affiliates.
 * All rights reserved.
 *
 * https://www.assetsjapan.com/
 *
 * Assets Japan, PROPRIETARY/CONFIDENTIAL.
 * Unauthorized reproduction, modification or communication is strictly prohibited.
 */

import java.time.LocalDate;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
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
