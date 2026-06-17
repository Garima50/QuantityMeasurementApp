package com.apps.quantitymeasurement;

public class Quantity<U extends IMeasurable> {

    // UC10 UPDATE
    // Generic quantity supporting all measurable categories

    private final double value;
    private final U unit;

    public Quantity(
            double value,
            U unit
    ) {

        if (unit == null) {

            throw new IllegalArgumentException(
                    "Unit cannot be null"
            );
        }

        if (!Double.isFinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid numeric value"
            );
        }

        this.value = value;
        this.unit = unit;
    }

    // UC10 UPDATE
    // Generic conversion through IMeasurable

    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(
                value
        );
    }

    private boolean compare(
            Quantity<?> thatQuantity
    ) {

        return Double.compare(
                this.convertToBaseUnit(),
                thatQuantity.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public boolean equals(
            Object o
    ) {

        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Quantity<?> that =
                (Quantity<?>) o;

        // UC10 UPDATE
        // Prevent cross-category comparison

        if (
                this.unit.getClass()
                        != that.unit.getClass()
        ) {

            return false;
        }

        return this.compare(
                that
        );
    }

    @Override
    public int hashCode() {

        return Double.hashCode(
                convertToBaseUnit()
        );
    }

    // UC10 UPDATE
    // Generic conversion method

    public Quantity<U> convertTo(
            U targetUnit
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

        return new Quantity<>(
                convertedValue,
                targetUnit
        );
    }

    // UC10 UPDATE
    // Addition result returned in first operand unit

    public Quantity<U> add(
            Quantity<U> quantity
    ) {

        if (quantity == null) {

            throw new IllegalArgumentException(
                    "Quantity to add cannot be null"
            );
        }

        double thisQuantityInBaseUnit =
                this.convertToBaseUnit();

        double thatQuantityInBaseUnit =
                quantity.convertToBaseUnit();

        double sumInBaseUnit =
                thisQuantityInBaseUnit +
                thatQuantityInBaseUnit;

        double convertedSum =
                unit.convertFromBaseUnit(
                        sumInBaseUnit
                );

        return new Quantity<>(
                convertedSum,
                unit
        );
    }

    // UC10 UPDATE
    // Addition with explicit target unit

    public Quantity<U> add(
            Quantity<U> quantity,
            U targetUnit
    ) {

        if (quantity == null) {

            throw new IllegalArgumentException(
                    "Quantity to add cannot be null"
            );
        }

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        double thisQuantityInBaseUnit =
                this.convertToBaseUnit();

        double thatQuantityInBaseUnit =
                quantity.convertToBaseUnit();

        double sumInBaseUnit =
                thisQuantityInBaseUnit +
                thatQuantityInBaseUnit;

        double convertedSum =
                targetUnit.convertFromBaseUnit(
                        sumInBaseUnit
                );

        return new Quantity<>(
                convertedSum,
                targetUnit
        );
    }

    // UC12 UPDATE
    // Subtraction result returned in first operand unit

    public Quantity<U> subtract(
            Quantity<U> quantity
    ) {

        if (quantity == null) {

            throw new IllegalArgumentException(
                    "Quantity to subtract cannot be null"
            );
        }

        double thisQuantityInBaseUnit =
                this.convertToBaseUnit();

        double thatQuantityInBaseUnit =
                quantity.convertToBaseUnit();

        double differenceInBaseUnit =
                thisQuantityInBaseUnit -
                thatQuantityInBaseUnit;

        double convertedDifference =
                unit.convertFromBaseUnit(
                        differenceInBaseUnit
                );

        return new Quantity<>(
                convertedDifference,
                unit
        );
    }

    // UC12 UPDATE
    // Subtraction with explicit target unit

    public Quantity<U> subtract(
            Quantity<U> quantity,
            U targetUnit
    ) {

        if (quantity == null) {

            throw new IllegalArgumentException(
                    "Quantity to subtract cannot be null"
            );
        }

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        double thisQuantityInBaseUnit =
                this.convertToBaseUnit();

        double thatQuantityInBaseUnit =
                quantity.convertToBaseUnit();

        double differenceInBaseUnit =
                thisQuantityInBaseUnit -
                thatQuantityInBaseUnit;

        double convertedDifference =
                targetUnit.convertFromBaseUnit(
                        differenceInBaseUnit
                );

        return new Quantity<>(
                convertedDifference,
                targetUnit
        );
    }

    // UC12 UPDATE
    // Division returns a dimensionless ratio

    public double divide(
            Quantity<U> quantity
    ) {

        if (quantity == null) {

            throw new IllegalArgumentException(
                    "Quantity to divide cannot be null"
            );
        }

        double divisor =
                quantity.convertToBaseUnit();

        if (
                Double.compare(
                        divisor,
                        0.0
                ) == 0
        ) {

            throw new ArithmeticException(
                    "Cannot divide by zero"
            );
        }

        double dividend =
                this.convertToBaseUnit();

        return dividend /
                divisor;
    }

    @Override
    public String toString() {

        return String.format(
                "%.2f %s",
                value,
                unit
        );
    }
}