package com.apps.quantitymeasurement;

public class Length {

    // Instance variables

    // Value object semantics
    private double value;
    private LengthUnit unit;

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

        // Validate numeric value

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Invalid numeric value"
            );
        }

        this.value = value;
        this.unit = unit;
    }


    // Utility method
    // UC8 UPDATE
    // Delegate conversion to standalone LengthUnit

    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(
                value
        );
    }


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
                targetUnit.convertFromBaseUnit(
                        baseValue
                );

        return new Length(
                convertedValue,
                targetUnit
        );
    }

    // Addition of two length measurements
    // Result returned in unit of first operand

    public Length add(

            Length thatLength
    ) {
        if (thatLength == null) {
            throw new IllegalArgumentException(
                    "Length to add cannot be null"
            );
        }

        // Convert both lengths to base unit (inches)

        double thisLengthInBaseUnit =
                this.convertToBaseUnit();
        double thatLengthInBaseUnit =
                thatLength.convertToBaseUnit();

        // Add base unit values

        double sumInBaseUnit =
                thisLengthInBaseUnit +
                thatLengthInBaseUnit;

        // Convert sum back to unit of first operand

        double convertedSum =
                convertFromBaseToTargetUnit(
                        sumInBaseUnit,
                        this.unit
                );

        // Return new Length object (immutability)

        return new Length(
                convertedSum,
                this.unit

        );

    }

    // Addition with explicit target unit specification

    public Length add(
            Length length,
            LengthUnit targetUnit
    ) {

        if (length == null) {

            throw new IllegalArgumentException(
                    "Length to add cannot be null"
            );
        }

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        return addAndConvert(
                length,
                targetUnit
        );
    }


    // ==================================================
    // UC8 UPDATE
    // Delegate conversion responsibility to LengthUnit
    // ==================================================

    private Length addAndConvert(
            Length length,
            LengthUnit targetUnit
    ) {

        double thisLengthInBaseUnit =
                this.convertToBaseUnit();

        double thatLengthInBaseUnit =
                length.convertToBaseUnit();

        double sumInBaseUnit =
                thisLengthInBaseUnit +
                thatLengthInBaseUnit;

        double convertedSum =
                targetUnit.convertFromBaseUnit(
                        sumInBaseUnit
                );

        return new Length(
                convertedSum,
                targetUnit
        );
    }

    // Reusable helper for converting

     // ==================================================
     // UC8 UPDATE
     // Delegate conversion to LengthUnit
     // ==================================================

    private double convertFromBaseToTargetUnit(
            double lengthInInches,
            LengthUnit targetUnit
    ) {

        return targetUnit.convertFromBaseUnit(
                lengthInInches
        );
    }


    // Human readable output

    @Override
    public String toString() {

        return String.format(
                "%.2f %s",
                value,
                unit
        );
    }

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