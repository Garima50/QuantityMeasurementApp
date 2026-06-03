package com.apps.quantitymeasurement;

public class Length {

    // Instance variables

    // UC5 UPDATE
    // Value object semantics
    private double value;
    private LengthUnit unit;

    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),

        // UC5 UPDATE
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor

    public Length(
            double value,
            LengthUnit unit
    ) {

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null"
            );
        }

        // UC5 UPDATE
        // Validate numeric value

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Invalid numeric value"
            );
        }

        this.value = value;
        this.unit = unit;
    }

    // UC5 UPDATE
    // Utility method
    // Convert to base unit (inches)

    private double convertToBaseUnit() {

        double baseValue =
                value *
                unit.getConversionFactor();

        return Math.round(
                baseValue * 100.0
        ) / 100.0;
    }

    // UC5 UPDATE
    // Private helper method

    private boolean compare(
            Length thatLength
    ) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public boolean equals(
            Object o
    ) {

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

        Length that =
                (Length) o;

        return this.compare(that);
    }

    @Override
    public int hashCode() {

        return Double.hashCode(
                convertToBaseUnit()
        );
    }

    // UC5 UPDATE
    // Conversion Feature

    public Length convertTo(
            LengthUnit targetUnit
    ) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        double baseValue =
                convertToBaseUnit();

        double convertedValue =
                baseValue /
                targetUnit.getConversionFactor();

        convertedValue =
                Math.round(
                        convertedValue * 100.0
                ) / 100.0;

        return new Length(
                convertedValue,
                targetUnit
        );
    }

    // UC5 UPDATE
    // Human readable output

    @Override
    public String toString() {

        return String.format(
                "%.2f %s",
                value,
                unit
        );
    }

    // UC5 UPDATE
    // Standalone testing

    public static void main(
            String[] args
    ) {

        Length feet =
                new Length(
                        3.0,
                        LengthUnit.FEET
                );

        Length inches =
                feet.convertTo(
                        LengthUnit.INCHES
                );

        System.out.println(
                "3 feet = " + inches
        );

        Length yards =
                new Length(
                        2.0,
                        LengthUnit.YARDS
                );

        System.out.println(
                "2 yards = "
                + yards.convertTo(
                        LengthUnit.INCHES
                )
        );
    }
}