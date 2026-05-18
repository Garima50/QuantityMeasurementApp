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

    public static void main(String[] args) {

        demonstrateFeetEquality();

        System.out.println();

        demonstrateInchesEquality();

        System.out.println();

        demonstrateFeetInchesComparison();
    }
}