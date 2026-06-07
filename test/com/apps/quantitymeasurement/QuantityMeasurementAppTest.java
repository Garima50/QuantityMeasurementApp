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

        @Test
    public void testAddition_SameUnit_FeetPlusFeet() {

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

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                length1,
                                length2
                        );

        Length expected =
                new Length(
                        3.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(
                result.equals(expected)
        );
    }

        @Test
    public void testAddition_SameUnit_InchPlusInch() {

        Length length1 =
                new Length(
                        6.0,
                        Length.LengthUnit.INCHES
                );

        Length length2 =
                new Length(
                        6.0,
                        Length.LengthUnit.INCHES
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                length1,
                                length2
                        );

        Length expected =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                result.equals(expected)
        );
    }

        @Test
    public void testAddition_CrossUnit_FeetPlusInches() {

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

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                feet,
                                inches
                        );

        Length expected =
                new Length(
                        2.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(
                result.equals(expected)
        );
    }


        @Test
    public void testAddition_CrossUnit_InchPlusFeet() {

        Length inches =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES
                );

        Length feet =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                inches,
                                feet
                        );

        Length expected =
                new Length(
                        24.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                result.equals(expected)
        );
    }


        @Test
    public void testAddition_CrossUnit_YardPlusFeet() {

        Length yard =
                new Length(
                        1.0,
                        Length.LengthUnit.YARDS
                );

        Length feet =
                new Length(
                        3.0,
                        Length.LengthUnit.FEET
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                yard,
                                feet
                        );

        Length expected =
                new Length(
                        2.0,
                        Length.LengthUnit.YARDS
                );

        assertTrue(
                result.equals(expected)
        );
    }


        @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {

        Length cm =
                new Length(
                        2.54,
                        Length.LengthUnit.CENTIMETERS
                );

        Length inch =
                new Length(
                        1.0,
                        Length.LengthUnit.INCHES
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                cm,
                                inch
                        );

        Length expected =
                new Length(
                        5.08,
                        Length.LengthUnit.CENTIMETERS
                );

        assertTrue(
                result.equals(expected)
        );
    }


        @Test
    public void testAddition_Commutativity() {

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

        Length result1 =
                feet.add(inches);

        Length result2 =
                inches.add(feet);

        assertEquals(
                24.0,
                result2.convertTo(
                        Length.LengthUnit.INCHES
                ).convertTo(
                        Length.LengthUnit.INCHES
                ).equals(
                        new Length(
                                24.0,
                                Length.LengthUnit.INCHES
                        )
                ) ? 24.0 : 0.0
        );
    }


        @Test
    public void testAddition_WithZero() {

        Length feet =
                new Length(
                        5.0,
                        Length.LengthUnit.FEET
                );

        Length zero =
                new Length(
                        0.0,
                        Length.LengthUnit.INCHES
                );

        Length result =
                feet.add(zero);

        assertTrue(
                result.equals(
                        new Length(
                                5.0,
                                Length.LengthUnit.FEET
                        )
                )
        );
    }


        @Test
    public void testAddition_NegativeValues() {

        Length length1 =
                new Length(
                        5.0,
                        Length.LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        -2.0,
                        Length.LengthUnit.FEET
                );

        Length result =
                length1.add(length2);

        assertTrue(
                result.equals(
                        new Length(
                                3.0,
                                Length.LengthUnit.FEET
                        )
                )
        );
    }


        @Test
    public void testAddition_NullSecondOperand() {

        Length length =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> length.add(null)
        );
    }


        @Test
    public void testAddition_LargeValues() {

        Length length1 =
                new Length(
                        1000000.0,
                        Length.LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        1000000.0,
                        Length.LengthUnit.FEET
                );

        Length result =
                length1.add(length2);

        assertTrue(
                result.equals(
                        new Length(
                                2000000.0,
                                Length.LengthUnit.FEET
                        )
                )
        );
    }


        @Test
    public void testAddition_SmallValues() {

        Length length1 =
                new Length(
                        0.01,
                        Length.LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        0.02,
                        Length.LengthUnit.FEET
                );

        Length result =
                length1.add(length2);

        assertTrue(
                result.equals(
                        new Length(
                                0.03,
                                Length.LengthUnit.FEET
                        )
                )
        );
    }

        // ==================================================
    // UC7 UPDATE
    // Addition with explicit target unit specification
    // ==================================================

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {

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

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                feet,
                                inches,
                                Length.LengthUnit.FEET
                        );

        Length expected =
                new Length(
                        2.0,
                        Length.LengthUnit.FEET
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {

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

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                feet,
                                inches,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        24.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {

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

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                feet,
                                inches,
                                Length.LengthUnit.YARDS
                        );

        Length expected =
                new Length(
                        0.67,
                        Length.LengthUnit.YARDS
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {

        Length inch1 =
                new Length(
                        1.0,
                        Length.LengthUnit.INCHES
                );

        Length inch2 =
                new Length(
                        1.0,
                        Length.LengthUnit.INCHES
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                inch1,
                                inch2,
                                Length.LengthUnit.CENTIMETERS
                        );

        Length expected =
                new Length(
                        5.08,
                        Length.LengthUnit.CENTIMETERS
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {

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

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                feet,
                                inches,
                                null
                        )
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {

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

        Length result1 =
                feet.add(
                        inches,
                        Length.LengthUnit.YARDS
                );

        Length result2 =
                inches.add(
                        feet,
                        Length.LengthUnit.YARDS
                );

        assertTrue(
                result1.equals(result2)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {

        Length length1 =
                new Length(
                        5.0,
                        Length.LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        -2.0,
                        Length.LengthUnit.FEET
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                length1,
                                length2,
                                Length.LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        36.0,
                        Length.LengthUnit.INCHES
                );

        assertTrue(
                result.equals(expected)
        );
    }


}