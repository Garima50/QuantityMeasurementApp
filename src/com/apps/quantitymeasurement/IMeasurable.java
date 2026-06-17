package com.apps.quantitymeasurement;

public interface IMeasurable {

    double getConversionFactor();

    // UC10 UPDATE
    // Common contract for converting any unit to its base unit

    double convertToBaseUnit(
            double value
    );

    // UC10 UPDATE
    // Common contract for converting from base unit to target unit

    double convertFromBaseUnit(
            double baseValue
    );
}