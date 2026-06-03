package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ==================================================
    // SAME UNIT TESTS
    // ==================================================

    @Test
    public void testFeetEquality() {

        Length length1 =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(
                length1.equals(length2)
        );
    }

    @Test
    public void testInchesEquality() {

        Length length1 =
                new Length(
                        1.0,
                        Length.LengthUnit.INCHES
                );

        Length length2 =
                new Length(
                        1.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                length1.equals(length2)
        );
    }

    // ==================================================
    // CROSS UNIT TESTS
    // ==================================================

    @Test
    public void testFeetInchesComparison() {

        Length feet =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                feet.equals(inches)
        );
    }

    @Test
    public void testFeetInequality() {

        Length length1 =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        2.0,
                        Length.LengthUnit.FEET
                );

        assertFalse(
                length1.equals(length2)
        );
    }

    @Test
    public void testInchesInequality() {

        Length length1 =
                new Length(
                        1.0,
                        Length.LengthUnit.INCHES
                );

        Length length2 =
                new Length(
                        2.0,
                        Length.LengthUnit.INCHES
                );

        assertFalse(
                length1.equals(length2)
        );
    }

    @Test
    public void testCrossUnitInequality() {

        Length feet =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        Length inches =
                new Length(
                        10.0,
                        Length.LengthUnit.INCHES
                );

        assertFalse(
                feet.equals(inches)
        );
    }

    @Test
    public void testMultipleFeetComparison() {

        Length feet =
                new Length(
                        3.0,
                        Length.LengthUnit.FEET
                );

        Length inches =
                new Length(
                        36.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                feet.equals(inches)
        );
    }

    // ==================================================
    // UC5 UPDATE
    // YARDS AND CENTIMETERS
    // ==================================================

    @Test
    public void yardEquals36Inches() {

        Length yard =
                new Length(
                        1.0,
                        Length.LengthUnit.YARDS
                );

        Length inches =
                new Length(
                        36.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                yard.equals(inches)
        );
    }

    @Test
    public void centimeterEquals39Point3701Inches() {

        Length cm =
                new Length(
                        100.0,
                        Length.LengthUnit.CENTIMETERS
                );

        Length inches =
                new Length(
                        39.37,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                cm.equals(inches)
        );
    }

    @Test
    public void threeFeetEqualsOneYard() {

        Length feet =
                new Length(
                        3.0,
                        Length.LengthUnit.FEET
                );

        Length yard =
                new Length(
                        1.0,
                        Length.LengthUnit.YARDS
                );

        assertTrue(
                feet.equals(yard)
        );
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {

        Length cm =
                new Length(
                        30.48,
                        Length.LengthUnit.CENTIMETERS
                );

        Length foot =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(
                cm.equals(foot)
        );
    }

    @Test
    public void yardNotEqualToInches() {

        Length yard =
                new Length(
                        1.0,
                        Length.LengthUnit.YARDS
                );

        Length inches =
                new Length(
                        35.0,
                        Length.LengthUnit.INCHES
                );

        assertFalse(
                yard.equals(inches)
        );
    }

    // ==================================================
    // OBJECT CONTRACT TESTS
    // ==================================================

    @Test
    public void referenceEqualitySameObject() {

        Length length =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(
                length.equals(length)
        );
    }

    @Test
    public void equalsReturnsFalseForNull() {

        Length length =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        assertFalse(
                length.equals(null)
        );
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        Length b =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES
                );

        Length c =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {

        Length length1 =
                new Length(
                        5.0,
                        Length.LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        6.0,
                        Length.LengthUnit.FEET
                );

        assertFalse(
                length1.equals(length2)
        );
    }

    @Test
    public void testDifferentClass() {

    Length length =
            new Length(
                    1.0,
                    Length.LengthUnit.FEET
            );

    Object obj = "Length";

    assertFalse(
            length.equals(obj)
    );
}

    // ==================================================
    // APP METHOD TESTS
    // ==================================================

    @Test
    public void crossUnitEqualityDemonstrateMethod() {

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthComparison(
                                1.0,
                                Length.LengthUnit.FEET,
                                12.0,
                                Length.LengthUnit.INCHES
                        )
        );
    }

    // ==================================================
    // UC5 CONVERSION TESTS
    // ==================================================

    @Test
    public void convertFeetToInches() {

        Length converted =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                3.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        36.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {

        Length yards =
                new Length(
                        2.0,
                        Length.LengthUnit.YARDS
                );

        Length converted =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                yards,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        72.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                converted.equals(expected)
        );
    }
}