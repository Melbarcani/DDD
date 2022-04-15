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
import java.util.Objects;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/14/2022
 */
public class Client {
    private String clientId;
    private LocalDate dateDisponibilite;
    private int kilometrage;

    public LocalDate getDateDisponibilite() {
        return dateDisponibilite;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String nouveauClientId) {
        clientId = nouveauClientId;
    }

    public void setDateDisponibilite(LocalDate nouvelleDate) {
        dateDisponibilite = nouvelleDate;
    }

    public void setKilometrage(int km) {
        kilometrage = km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return kilometrage == client.kilometrage && Objects.equals(clientId, client.clientId) && Objects.equals(dateDisponibilite, client.dateDisponibilite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, dateDisponibilite, kilometrage);
    }
}
