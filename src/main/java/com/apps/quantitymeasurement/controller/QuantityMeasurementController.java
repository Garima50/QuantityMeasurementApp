package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.dto.QuantityDTO;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(
            IQuantityMeasurementService service
    ) {
        this.service = service;
    }

    // UC15 UPDATE
// Compare two quantities

public boolean compare(
        QuantityDTO firstQuantity,
        QuantityDTO secondQuantity
) {

    return service.compare(
            firstQuantity,
            secondQuantity
    );
}

// UC15 UPDATE
// Convert a quantity to another unit

public QuantityDTO convert(
        QuantityDTO sourceQuantity,
        QuantityDTO targetQuantity
) {

    return service.convert(
            sourceQuantity,
            targetQuantity
    );
}

// UC15 UPDATE
// Add two quantities

public QuantityDTO add(
        QuantityDTO firstQuantity,
        QuantityDTO secondQuantity
) {

    return service.add(
            firstQuantity,
            secondQuantity
    );
}

// UC15 UPDATE
// Add two quantities in target unit

public QuantityDTO add(
        QuantityDTO firstQuantity,
        QuantityDTO secondQuantity,
        QuantityDTO targetQuantity
) {

    return service.add(
            firstQuantity,
            secondQuantity,
            targetQuantity
    );
}

// UC15 UPDATE
// Subtract two quantities

public QuantityDTO subtract(
        QuantityDTO firstQuantity,
        QuantityDTO secondQuantity
) {

    return service.subtract(
            firstQuantity,
            secondQuantity
    );
}

// UC15 UPDATE
// Subtract two quantities in target unit

public QuantityDTO subtract(
        QuantityDTO firstQuantity,
        QuantityDTO secondQuantity,
        QuantityDTO targetQuantity
) {

    return service.subtract(
            firstQuantity,
            secondQuantity,
            targetQuantity
    );
}

// UC15 UPDATE
// Divide two quantities

public double divide(
        QuantityDTO firstQuantity,
        QuantityDTO secondQuantity
) {

    return service.divide(
            firstQuantity,
            secondQuantity
    );
}

}