package com.apps.quantitymeasurement;

public enum WeightUnit {

    // UC9 UPDATE
    // Weight units with conversion factor relative to base unit (kilogram)

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // UC9 UPDATE
    // Convert value in this unit to base unit (kilogram)

    public double convertToBaseUnit(
            double value
    ) {

        double baseValue =
                value * conversionFactor;

        return Math.round(
                baseValue * 100.0
        ) / 100.0;
    }

    // UC9 UPDATE
    // Convert base unit (kilogram) to this unit

    public double convertFromBaseUnit(
            double baseValue
    ) {

        double convertedValue =
                baseValue / conversionFactor;

        return Math.round(
                convertedValue * 100.0
        ) / 100.0;
    }
}