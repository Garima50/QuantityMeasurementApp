package com.apps.operationservice.service;

import java.util.List;

import com.apps.operationservice.dto.QuantityDTO;
import com.apps.operationservice.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    boolean compare(QuantityDTO firstQuantity, QuantityDTO secondQuantity);

    QuantityDTO convert(QuantityDTO quantity, QuantityDTO targetQuantity);

    QuantityDTO add(QuantityDTO firstQuantity, QuantityDTO secondQuantity);

    QuantityDTO add(QuantityDTO firstQuantity,
                    QuantityDTO secondQuantity,
                    QuantityDTO targetUnit);

    QuantityDTO subtract(QuantityDTO firstQuantity, QuantityDTO secondQuantity);

    QuantityDTO subtract(QuantityDTO firstQuantity,
                         QuantityDTO secondQuantity,
                         QuantityDTO targetUnit);

    double divide(QuantityDTO firstQuantity, QuantityDTO secondQuantity);

    // UC20 UPDATE
    // Return past operations, most recent first

    List<QuantityMeasurementEntity> getHistory();
}