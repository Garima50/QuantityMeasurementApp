package com.apps.quantitymeasurement.repository;

import java.util.List;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    // UC15 UPDATE
    // Stores a quantity measurement operation

    void save(
            QuantityMeasurementEntity entity
    );

    // UC15 UPDATE
    // Returns all stored quantity measurement operations

    List<QuantityMeasurementEntity> getAllMeasurements();
}