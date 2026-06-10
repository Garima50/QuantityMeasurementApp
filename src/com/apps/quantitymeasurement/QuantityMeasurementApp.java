package com.apps.quantitymeasurement;


public class QuantityMeasurementApp {


    // UC9 UPDATE
    // New Methods for Weight Functionality

    public static boolean demonstrateWeightEquality(
            Weight weight1,
            Weight weight2
    ) {

        return weight1.equals(weight2);
    }

    // Demonstrate comparison

    public static boolean demonstrateWeightComparison(
            double value1,
            WeightUnit unit1,
            double value2,
            WeightUnit unit2
    ) {

        Weight weight1 =
                new Weight(
                        value1,
                        unit1
                );

        Weight weight2 =
                new Weight(
                        value2,
                        unit2
                );

        boolean result =
                demonstrateWeightEquality(
                        weight1,
                        weight2
                );

        if (result) {

            System.out.println(
                    "The two weight measurements are equal."
            );
        }
        else {

            System.out.println(
                    "The two weight measurements are not equal."
            );
        }

        return result;
    }

    // UC9 UPDATE
    // Conversion Method

    public static Weight demonstrateWeightConversion(
            double value,
            WeightUnit fromUnit,
            WeightUnit toUnit
    ) {

        Weight weight =
                new Weight(
                        value,
                        fromUnit
                );

        return weight.convertTo(
                toUnit
        );
    }

    // UC9 UPDATE
    // Overloaded Conversion Method

    public static Weight demonstrateWeightConversion(
            Weight weight,
            WeightUnit toUnit
    ) {

        return weight.convertTo(
                toUnit
        );
    }

    // UC9 UPDATE
    // Demonstrate addition of two weight measurements

    public static Weight demonstrateWeightAddition(
            Weight weight1,
            Weight weight2
    ) {

        if (weight1 == null || weight2 == null) {

            throw new IllegalArgumentException(
                    "Weights cannot be null"
            );
        }

        return weight1.add(
                weight2
        );
    }

    // UC9 UPDATE
    // Demonstrate addition with explicit target unit

    public static Weight demonstrateWeightAddition(
            Weight weight1,
            Weight weight2,
            WeightUnit targetUnit
    ) {

        if (weight1 == null || weight2 == null) {

            throw new IllegalArgumentException(
                    "Weights cannot be null"
            );
        }

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        return weight1.add(
                weight2,
                targetUnit
        );
    }

    // LengthUnit extracted as standalone enum
    // Existing Equality Method

    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2
    ) {

        return length1.equals(length2);
    }

    // Demonstrate comparison

    public static boolean demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2
    ) {

        Length length1 =
                new Length(
                        value1,
                        unit1
                );

        Length length2 =
                new Length(
                        value2,
                        unit2
                );

        boolean result =
                demonstrateLengthEquality(
                        length1,
                        length2
                );

        if (result) {

            System.out.println(
                    "The two length measurements are equal."
            );
        }
        else {

            System.out.println(
                    "The two length measurements are not equal."
            );
        }

        return result;
    }

    // Conversion Method

    public static Length demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit
    ) {

        Length length =
                new Length(
                        value,
                        fromUnit
                );

        return length.convertTo(
                toUnit
        );
    }


    // Demonstrate addition of two length measurements

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2
    ) {

        if (length1 == null || length2 == null) {

            throw new IllegalArgumentException(
                    "Lengths cannot be null"
            );
        }

        return length1.add(
                length2
        );
    }


// Demonstrate addition with explicit target unit

public static Length demonstrateLengthAddition(
        Length length1,
        Length length2,
        LengthUnit targetUnit
) {

    if (length1 == null || length2 == null) {

        throw new IllegalArgumentException(
                "Lengths cannot be null"
        );
    }

    if (targetUnit == null) {

        throw new IllegalArgumentException(
                "Target unit cannot be null"
        );
    }

    return length1.add(
            length2,
            targetUnit
    );
}


    // Overloaded Conversion Method

    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit
    ) {

        return length.convertTo(
                toUnit
        );
    }


    public static void main (String[] args) {


                System.out.println(
                "===== UC9 WEIGHT EQUALITY TESTS ====="
        );

        demonstrateWeightComparison(
                1.0,
                WeightUnit.KILOGRAM,
                1000.0,
                WeightUnit.GRAM
        );

        demonstrateWeightComparison(
                1.0,
                WeightUnit.POUND,
                453.59,
                WeightUnit.GRAM
        );

        System.out.println();

        System.out.println(
                "===== UC9 WEIGHT CONVERSION TESTS ====="
        );

        Weight weightInGrams =
                demonstrateWeightConversion(
                        1.0,
                        WeightUnit.KILOGRAM,
                        WeightUnit.GRAM
                );

        System.out.println(
                "1 KILOGRAM -> "
                + weightInGrams
        );

        Weight pounds =
                new Weight(
                        2.0,
                        WeightUnit.POUND
                );

        Weight convertedWeight =
                demonstrateWeightConversion(
                        pounds,
                        WeightUnit.KILOGRAM
                );

        System.out.println(
                "2 POUNDS -> "
                + convertedWeight
        );

        System.out.println();

        System.out.println(
                "===== UC9 WEIGHT ADDITION TESTS ====="
        );

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight grams =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        System.out.println(
                "1 KG + 1000 G = "
                + demonstrateWeightAddition(
                        kilogram,
                        grams
                )
        );

        Weight pound =
                new Weight(
                        1.0,
                        WeightUnit.POUND
                );

        Weight gram =
                new Weight(
                        453.59,
                        WeightUnit.GRAM
                );

        System.out.println(
                "1 POUND + 453.59 G = "
                + demonstrateWeightAddition(
                        pound,
                        gram
                )
        );

        System.out.println();

        System.out.println(
                "===== UC9 WEIGHT ADDITION WITH TARGET UNIT ====="
        );

        System.out.println(
                "1 KG + 1000 G IN GRAMS = "
                + demonstrateWeightAddition(
                        kilogram,
                        grams,
                        WeightUnit.GRAM
                )
        );

        System.out.println(
                "1 POUND + 453.59 G IN POUNDS = "
                + demonstrateWeightAddition(
                        pound,
                        gram,
                        WeightUnit.POUND
                )
        );

        System.out.println();

        System.out.println(
                "===== EQUALITY TESTS ====="
        );

        demonstrateLengthComparison(
                1.0,
                LengthUnit.FEET,
                1.0,
                LengthUnit.FEET
        );

        demonstrateLengthComparison(
                1.0,
                LengthUnit.INCHES,
                1.0,
                LengthUnit.INCHES
        );

        demonstrateLengthComparison(
                1.0,
                LengthUnit.FEET,
                12.0,
                LengthUnit.INCHES
        );

        demonstrateLengthComparison(
                1.0,
                LengthUnit.YARDS,
                36.0,
                LengthUnit.INCHES
        );

        demonstrateLengthComparison(
                30.48,
                LengthUnit.CENTIMETERS,
                1.0,
                LengthUnit.FEET
        );

        System.out.println();

        System.out.println(
                "===== CONVERSION TESTS ====="
        );

        Length lengthInInches =
                demonstrateLengthConversion(
                        3.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                );

        System.out.println(
                "3 FEET -> "
                + lengthInInches
        );

        Length lengthInYards =
                new Length(
                        2.0,
                        LengthUnit.YARDS
                );

        Length converted =
                demonstrateLengthConversion(
                        lengthInYards,
                        LengthUnit.INCHES
                );

        System.out.println(
                "2 YARDS -> "
                + converted
        );

        Length cmConversion =
                demonstrateLengthConversion(
                        30.48,
                        LengthUnit.CENTIMETERS,
                        LengthUnit.FEET
                );

        System.out.println(
                "30.48 CM -> "
                + cmConversion
        );

                System.out.println();

        System.out.println(
                "===== UC6 ADDITION TESTS ====="
        );

        Length feet =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        System.out.println(
                "1 FEET + 12 INCHES = "
                + demonstrateLengthAddition(
                        feet,
                        inches
                )
        );

        Length yard =
                new Length(
                        1.0,
                        LengthUnit.YARDS
                );

        Length threeFeet =
                new Length(
                        3.0,
                        LengthUnit.FEET
                );

        System.out.println(
                "1 YARD + 3 FEET = "
                + demonstrateLengthAddition(
                        yard,
                        threeFeet
                )
        );

        Length cm =
                new Length(
                        2.54,
                        LengthUnit.CENTIMETERS
                );

        Length oneInch =
                new Length(
                        1.0,
                        LengthUnit.INCHES
                );

        System.out.println(
                "2.54 CM + 1 INCH = "
                + demonstrateLengthAddition(
                        cm,
                        oneInch
                )
        );
    }
}