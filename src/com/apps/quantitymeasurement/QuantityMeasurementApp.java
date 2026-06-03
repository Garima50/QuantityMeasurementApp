package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ==================================================
    // Existing Equality Method
    // ==================================================

    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2
    ) {

        return length1.equals(length2);
    }

    // ==================================================
    // UC5 UPDATE
    // Demonstrate comparison
    // ==================================================

    public static boolean demonstrateLengthComparison(
            double value1,
            Length.LengthUnit unit1,
            double value2,
            Length.LengthUnit unit2
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

    // ==================================================
    // UC5 UPDATE
    // Conversion Method
    // ==================================================

    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit
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

    // ==================================================
    // UC5 UPDATE
    // Overloaded Conversion Method
    // ==================================================

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit
    ) {

        return length.convertTo(
                toUnit
        );
    }

    // ==================================================
    // UC5 UPDATE
    // Main Method
    // ==================================================

    public static void main(
            String[] args
    ) {

        System.out.println(
                "===== EQUALITY TESTS ====="
        );

        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.FEET,
                1.0,
                Length.LengthUnit.FEET
        );

        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.INCHES,
                1.0,
                Length.LengthUnit.INCHES
        );

        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.FEET,
                12.0,
                Length.LengthUnit.INCHES
        );

        demonstrateLengthComparison(
                1.0,
                Length.LengthUnit.YARDS,
                36.0,
                Length.LengthUnit.INCHES
        );

        demonstrateLengthComparison(
                30.48,
                Length.LengthUnit.CENTIMETERS,
                1.0,
                Length.LengthUnit.FEET
        );

        System.out.println();

        System.out.println(
                "===== CONVERSION TESTS ====="
        );

        Length lengthInInches =
                demonstrateLengthConversion(
                        3.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES
                );

        System.out.println(
                "3 FEET -> "
                + lengthInInches
        );

        Length lengthInYards =
                new Length(
                        2.0,
                        Length.LengthUnit.YARDS
                );

        Length converted =
                demonstrateLengthConversion(
                        lengthInYards,
                        Length.LengthUnit.INCHES
                );

        System.out.println(
                "2 YARDS -> "
                + converted
        );

        Length cmConversion =
                demonstrateLengthConversion(
                        30.48,
                        Length.LengthUnit.CENTIMETERS,
                        Length.LengthUnit.FEET
                );

        System.out.println(
                "30.48 CM -> "
                + cmConversion
        );
    }
}