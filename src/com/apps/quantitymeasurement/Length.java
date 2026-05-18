package com.apps.quantitymeasurement;

public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Enum for units and conversion factors
    // Base unit = inches
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {

        return value * unit.getConversionFactor();
    }

    // Compare two Length objects
    public boolean compare(Length thatLength) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public boolean equals(Object o) {

        // Same reference
        if (this == o) {
            return true;
        }

        // Null check
        if (o == null) {
            return false;
        }

        // Type check
        if (getClass() != o.getClass()) {
            return false;
        }

        Length that = (Length) o;

        return this.compare(that);
    }

    @Override
    public int hashCode() {

        return Double.hashCode(convertToBaseUnit());
    }
}