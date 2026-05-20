package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Generic method for equality demo
    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2
    ) {

        return length1.equals(length2);
    }

    // Feet equality
    public static void demonstrateFeetEquality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(1.0, Length.LengthUnit.FEET);

        boolean result =
                demonstrateLengthEquality(length1, length2);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }

    // Inches equality
    public static void demonstrateInchesEquality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length length2 =
                new Length(1.0, Length.LengthUnit.INCHES);

        boolean result =
                demonstrateLengthEquality(length1, length2);

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    // Feet and Inches comparison
    public static void demonstrateFeetInchesComparison() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        boolean result =
                demonstrateLengthEquality(length1, length2);

        System.out.println("Input: 1.0 ft and 12.0 inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    // UC4 UPDATE
    // Yards and Feet comparison
    public static void demonstrateYardFeetComparison() {

        Length yard =
                new Length(1.0, Length.LengthUnit.YARDS);

        Length feet =
                new Length(3.0, Length.LengthUnit.FEET);

        boolean result =
                demonstrateLengthEquality(yard, feet);

        System.out.println("Input: 1.0 yard and 3.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }

    // UC4 UPDATE
    // Yards and Inches comparison
    public static void demonstrateYardInchesComparison() {

        Length yard =
                new Length(1.0, Length.LengthUnit.YARDS);

        Length inches =
                new Length(36.0, Length.LengthUnit.INCHES);

        boolean result =
                demonstrateLengthEquality(yard, inches);

        System.out.println("Input: 1.0 yard and 36.0 inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    // UC4 UPDATE
    // Centimeters and Inches comparison
    public static void demonstrateCentimeterInchesComparison() {

        Length cm =
                new Length(1.0, Length.LengthUnit.CENTIMETERS);

        Length inches =
                new Length(0.393701, Length.LengthUnit.INCHES);

        boolean result =
                demonstrateLengthEquality(cm, inches);

        System.out.println("Input: 1.0 cm and 0.393701 inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    public static void main(String[] args) {

        demonstrateFeetEquality();

        System.out.println();

        demonstrateInchesEquality();

        System.out.println();

        demonstrateFeetInchesComparison();

        System.out.println();

        // UC4 UPDATE
        demonstrateYardFeetComparison();

        System.out.println();
        demonstrateYardInchesComparison();

        System.out.println();
        demonstrateCentimeterInchesComparison();
    }
}