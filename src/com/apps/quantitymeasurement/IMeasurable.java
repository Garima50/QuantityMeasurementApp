package com.apps.quantitymeasurement;

@FunctionalInterface
interface SupportsArithmetic {

    boolean isSupported();
}

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

    // UC14 UPDATE
    // Default arithmetic support for measurable units

    SupportsArithmetic supportsArithmetic =
            () -> true;

    // UC14 UPDATE
    // Returns whether arithmetic operations are supported

    default boolean supportsArithmetic() {

        return supportsArithmetic
                .isSupported();
    }

    // UC14 UPDATE
    // Default validation allows all arithmetic operations

    default void validateOperationSupport(
            String operation
    ) {

        // Subclasses may override
    }
}