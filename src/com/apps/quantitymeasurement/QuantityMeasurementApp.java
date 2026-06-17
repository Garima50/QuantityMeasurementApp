package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // UC10 UPDATE
    // Generic equality demonstration

    public static <U extends IMeasurable>
    boolean demonstrateEquality(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {

        return quantity1.equals(
                quantity2
        );
    }

    // UC10 UPDATE
    // Generic comparison demonstration

    public static <U extends IMeasurable>
    boolean demonstrateComparison(
            double value1,
            U unit1,
            double value2,
            U unit2
    ) {

        Quantity<U> quantity1 =
                new Quantity<>(
                        value1,
                        unit1
                );

        Quantity<U> quantity2 =
                new Quantity<>(
                        value2,
                        unit2
                );

        boolean result =
                demonstrateEquality(
                        quantity1,
                        quantity2
                );

        if (result) {

            System.out.println(
                    "The two measurements are equal."
            );
        }
        else {

            System.out.println(
                    "The two measurements are not equal."
            );
        }

        return result;
    }

    // UC10 UPDATE
    // Generic conversion demonstration

    public static <U extends IMeasurable>
    Quantity<U> demonstrateConversion(
            double value,
            U fromUnit,
            U toUnit
    ) {

        Quantity<U> quantity =
                new Quantity<>(
                        value,
                        fromUnit
                );

        return quantity.convertTo(
                toUnit
        );
    }

    // UC10 UPDATE
    // Overloaded generic conversion

    public static <U extends IMeasurable>
    Quantity<U> demonstrateConversion(
            Quantity<U> quantity,
            U toUnit
    ) {

        return quantity.convertTo(
                toUnit
        );
    }

    // UC10 UPDATE
    // Generic addition demonstration

    public static <U extends IMeasurable>
    Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {

        if (
                quantity1 == null
                || quantity2 == null
        ) {

            throw new IllegalArgumentException(
                    "Quantities cannot be null"
            );
        }

        return quantity1.add(
                quantity2
        );
    }

    // UC10 UPDATE
    // Generic addition with target unit

    public static <U extends IMeasurable>
    Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit
    ) {

        if (
                quantity1 == null
                || quantity2 == null
        ) {

            throw new IllegalArgumentException(
                    "Quantities cannot be null"
            );
        }

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        return quantity1.add(
                quantity2,
                targetUnit
        );
    }

    public static void main(
            String[] args
    ) {

        System.out.println(
                "===== LENGTH TESTS ====="
        );

        Quantity<LengthUnit> foot =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES
                );

        System.out.println(
                demonstrateEquality(
                        foot,
                        inches
                )
        );

        System.out.println(
                demonstrateConversion(
                        foot,
                        LengthUnit.INCHES
                )
        );

        System.out.println(
                demonstrateAddition(
                        foot,
                        inches,
                        LengthUnit.FEET
                )
        );

        System.out.println();

        System.out.println(
                "===== WEIGHT TESTS ====="
        );

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM
                );

        System.out.println(
                demonstrateEquality(
                        kilogram,
                        gram
                )
        );

        System.out.println(
                demonstrateConversion(
                        kilogram,
                        WeightUnit.GRAM
                )
        );

        System.out.println(
                demonstrateAddition(
                        kilogram,
                        gram,
                        WeightUnit.KILOGRAM
                )
        );

                System.out.println();

        // UC11 UPDATE
        // Volume measurement demonstrations

        System.out.println(
                "===== VOLUME TESTS ====="
        );

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        System.out.println(
                demonstrateEquality(
                        litre,
                        millilitre
                )
        );

        System.out.println(
                demonstrateConversion(
                        litre,
                        VolumeUnit.MILLILITRE
                )
        );

        System.out.println(
                demonstrateAddition(
                        litre,
                        millilitre,
                        VolumeUnit.LITRE
                )
        );
    }
}