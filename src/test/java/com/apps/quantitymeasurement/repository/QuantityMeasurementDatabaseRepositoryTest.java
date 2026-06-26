package com.apps.quantitymeasurement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.enums.LengthUnit;
import com.apps.quantitymeasurement.model.QuantityModel;

class QuantityMeasurementDatabaseRepositoryTest {

    private QuantityMeasurementDatabaseRepository repository;

     // UC16 UPDATE
    // Initialize database repository before every test
    @BeforeEach
    void setUp() {

        repository =
            QuantityMeasurementDatabaseRepository.getInstance();
            repository.deleteAll();
    }

    // UC16 UPDATE
// Test saving a measurement in the database
@Test
void testSave() {

    QuantityModel<LengthUnit> oneFoot =
        new QuantityModel<>(
                1.0,
                LengthUnit.FEET
        );

QuantityModel<LengthUnit> twelveInches =
        new QuantityModel<>(
                12.0,
                LengthUnit.INCHES
        );

QuantityMeasurementEntity entity =
        new QuantityMeasurementEntity(
                oneFoot,
                twelveInches,
                "COMPARE",
                1.0
        );

repository.save(entity);

assertEquals(
        1,
        repository.getTotalCount()
);

}


// UC16 UPDATE
// Test fetching all saved measurements
@Test
void testGetAllMeasurements() {

    QuantityModel<LengthUnit> oneFoot =
            new QuantityModel<>(
                    1.0,
                    LengthUnit.FEET
            );

    QuantityModel<LengthUnit> twelveInches =
            new QuantityModel<>(
                    12.0,
                    LengthUnit.INCHES
            );

    QuantityMeasurementEntity entity =
            new QuantityMeasurementEntity(
                    oneFoot,
                    twelveInches,
                    "COMPARE",
                    1.0
            );

    repository.save(entity);

    List<QuantityMeasurementEntity> measurements =
            repository.getAllMeasurements();

    assertEquals(
            1,
            measurements.size()
    );
}

}