package fr.esgi.location.use_case.location;

import fr.esgi.location.infrastructure.location.ClientRepo;
import fr.esgi.location.infrastructure.location.ContratRepo;
import fr.esgi.location.infrastructure.location.VoitureRepo;
import fr.esgi.location.model.catalogue.Voiture;
import fr.esgi.location.model.location.Client;
import fr.esgi.location.model.location.ContratLocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Copyright (c) 2022, Assets Japan and/or its affiliates.
 * All rights reserved.
 *
 * https://www.assetsjapan.com/
 *
 * Assets Japan, PROPRIETARY/CONFIDENTIAL.
 * Unauthorized reproduction, modification or communication is strictly prohibited.
 */

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/14/2022
 */
class LouerUneVoitureTest {
    private ClientRepo clientRepo;
    private ContratRepo contratRepo;
    private VoitureRepo voitureRepo;

    @BeforeEach
    public void init() {
        clientRepo = new FakeClients();
        contratRepo = new FakeContractLocation();
        voitureRepo = new FakeVoitures();
    }

    @Test
    void louer() {
        var v1 = new Voiture();
        v1.setId("1");
        v1.setMaxKilometre(3000);
        v1.setDateDisponibilite(LocalDate.of(2022, 02, 02));
        v1.setEstDisponible(true);

        var client1 = new Client();
        client1.setClientId("1");
        client1.setDateDisponibilite(LocalDate.of(2022, 02, 02));
        client1.setKilometrage(3000);

        List<Voiture> voituresDisponibles = voitureRepo.findVoituresByDate(client1.getDateDisponibilite());

        var contratLocation = new LouerUneVoiture(voitureRepo, clientRepo, contratRepo).louer("1");

        var expectedResult = new ContratLocation(client1, voituresDisponibles);
        expectedResult.setVoiture(v1);
        expectedResult.setClient(client1);
        assertEquals(expectedResult.getVoiture().getId(), contratLocation.getVoiture().getId());
        assertEquals(expectedResult.getClient().getClientId(), contratLocation.getClient().getClientId());
    }
}