package com.apps.quantitymeasurement;

public class Weight {

    // Instance variables

    // Value object semantics
    private double value;
    private WeightUnit unit;

    // Constructor

    public Weight(
            double value,
            WeightUnit unit
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
    // UC9 UPDATE
    // Delegate conversion to standalone WeightUnit

    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(
                value
        );
    }

    // Private helper method

    private boolean compare(
            Weight thatWeight
    ) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatWeight.convertToBaseUnit()
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

        // UC9 UPDATE
        // Prevent comparison across categories

        if (getClass() != o.getClass()) {
            return false;
        }

        Weight that =
                (Weight) o;

        return this.compare(that);
    }

    @Override
    public int hashCode() {

        return Double.hashCode(
                convertToBaseUnit()
        );
    }

    // Conversion Feature

    public Weight convertTo(
            WeightUnit targetUnit
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

        return new Weight(
                convertedValue,
                targetUnit
        );
    }

    // Addition of two weight measurements
    // Result returned in unit of first operand

    public Weight add(
            Weight thatWeight
    ) {

        if (thatWeight == null) {

            throw new IllegalArgumentException(
                    "Weight to add cannot be null"
            );
        }

        double thisWeightInBaseUnit =
                this.convertToBaseUnit();

        double thatWeightInBaseUnit =
                thatWeight.convertToBaseUnit();

        double sumInBaseUnit =
                thisWeightInBaseUnit +
                thatWeightInBaseUnit;

        double convertedSum =
                convertFromBaseToTargetUnit(
                        sumInBaseUnit,
                        this.unit
                );

        return new Weight(
                convertedSum,
                this.unit
        );
    }

    // Addition with explicit target unit specification

    public Weight add(
            Weight weight,
            WeightUnit targetUnit
    ) {

        if (weight == null) {

            throw new IllegalArgumentException(
                    "Weight to add cannot be null"
            );
        }

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        return addAndConvert(
                weight,
                targetUnit
        );
    }

    // ==================================================
    // UC9 UPDATE
    // Delegate conversion responsibility to WeightUnit
    // ==================================================

    private Weight addAndConvert(
            Weight weight,
            WeightUnit targetUnit
    ) {

        double thisWeightInBaseUnit =
                this.convertToBaseUnit();

        double thatWeightInBaseUnit =
                weight.convertToBaseUnit();

        double sumInBaseUnit =
                thisWeightInBaseUnit +
                thatWeightInBaseUnit;

        double convertedSum =
                targetUnit.convertFromBaseUnit(
                        sumInBaseUnit
                );

        return new Weight(
                convertedSum,
                targetUnit
        );
    }

    // Reusable helper for converting

    // ==================================================
    // UC9 UPDATE
    // Delegate conversion to WeightUnit
    // ==================================================

    private double convertFromBaseToTargetUnit(
            double weightInKilograms,
            WeightUnit targetUnit
    ) {

        return targetUnit.convertFromBaseUnit(
                weightInKilograms
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

        Weight kilograms =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight grams =
                kilograms.convertTo(
                        WeightUnit.GRAM
                );

        System.out.println(
                "1 kilogram = " + grams
        );

        Weight pounds =
                new Weight(
                        2.0,
                        WeightUnit.POUND
                );

        System.out.println(
                "2 pounds = "
                + pounds.convertTo(
                        WeightUnit.GRAM
                )
        );
    }
}