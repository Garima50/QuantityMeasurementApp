package com.apps.quantitymeasurement.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.enums.LengthUnit;
import com.apps.quantitymeasurement.model.QuantityModel;
//import com.apps.quantitymeasurement.repository.QuantityMeasurementCacheRepository;

public class QuantityMeasurementCacheRepositoryTest {

    
    @Test
void shouldSaveEntity() {

    QuantityMeasurementCacheRepository repository =
            QuantityMeasurementCacheRepository.getInstance();

    QuantityMeasurementEntity entity =
            new QuantityMeasurementEntity(
                    new QuantityModel<>(
                            1,
                            LengthUnit.FEET
                    ),
                    new QuantityModel<>(
                            12,
                            LengthUnit.INCHES
                    ),
                    "COMPARE",
                    1.0
            );

    repository.save(entity);

    assertFalse(
            repository.getAllMeasurements().isEmpty()
    );
}

@Test
void shouldReturnStoredEntities() {

    QuantityMeasurementCacheRepository repository =
            QuantityMeasurementCacheRepository.getInstance();

    assertNotNull(
            repository.getAllMeasurements()
    );
}

@Test
void shouldReturnSameRepositoryInstance() {

    QuantityMeasurementCacheRepository repository1 =
            QuantityMeasurementCacheRepository.getInstance();

    QuantityMeasurementCacheRepository repository2 =
            QuantityMeasurementCacheRepository.getInstance();

    assertSame(
            repository1,
            repository2
    );
}




}
