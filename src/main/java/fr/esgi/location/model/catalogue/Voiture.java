package fr.esgi.location.model.catalogue;
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
import java.util.Objects;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/13/2022
 */
public class Voiture {

    private String id;
    private int maxKilometre;
    private LocalDate dateDisponibilite;

    public Boolean getEstDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(Boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    private Boolean estDisponible;

    public String getId() {
        return id;
    }

    public void setId(String nouvelId) {
        id = nouvelId;
    }

    public void setMaxKilometre(int nouveauMaxKilometre) {
        maxKilometre = nouveauMaxKilometre;
    }

    public int getMaxKilometre() {
        return maxKilometre;
    }

    public LocalDate getDateDisponibilite() {
        return dateDisponibilite;
    }

    public void setDateDisponibilite(LocalDate nouvelleDate) {
        dateDisponibilite = nouvelleDate;
    }

    public Boolean getDisponibilite() {
        return estDisponible;
    }

    public void setDisponibilite(Boolean disponibilite) {
        estDisponible = disponibilite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return maxKilometre == voiture.maxKilometre && Objects.equals(id, voiture.id) && Objects.equals(dateDisponibilite, voiture.dateDisponibilite) && Objects.equals(estDisponible, voiture.estDisponible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxKilometre, dateDisponibilite, estDisponible);
    }
}
