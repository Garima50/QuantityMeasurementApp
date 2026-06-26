package com.apps.quantitymeasurement.repository;

import java.util.List;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    // Save measurement
    void save(
            QuantityMeasurementEntity entity
    );

    // Retrieve all measurements
    List<QuantityMeasurementEntity> getAllMeasurements();

    // Retrieve measurements by operation
    List<QuantityMeasurementEntity> getMeasurementsByOperation(
            String operation
    );

    // Retrieve measurements by measurement type
    List<QuantityMeasurementEntity> getMeasurementsByType(
            String measurementType
    );

    // Total stored measurements
    int getTotalCount();

    // Delete all stored measurements
    void deleteAll();

    // Pool information
    String getPoolStatistics();

    // Cleanup resources
    void releaseResources();
}