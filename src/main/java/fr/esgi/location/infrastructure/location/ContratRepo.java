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

import fr.esgi.location.model.location.ContratLocation;

/**
 * Description
 *
 * @author Mohamed.ElBarcani
 * @since 4/14/2022
 */
public interface ContratRepo {
    void save(ContratLocation contratLocation);
}
