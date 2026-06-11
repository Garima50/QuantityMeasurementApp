package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// UC8 UPDATE
// Updated to use standalone LengthUnit enum

public class QuantityMeasurementAppTest {

    // ==================================================
    // SAME UNIT TESTS
    // ==================================================

    @Test
    public void testFeetEquality() {

        Length length1 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        1.0,
                        LengthUnit.FEET
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
                        LengthUnit.INCHES
                );

        Length length2 =
                new Length(
                        1.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        2.0,
                        LengthUnit.FEET
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
                        LengthUnit.INCHES
                );

        Length length2 =
                new Length(
                        2.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        10.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        36.0,
                        LengthUnit.INCHES
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
                        LengthUnit.YARDS
                );

        Length inches =
                new Length(
                        36.0,
                        LengthUnit.INCHES
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
                        LengthUnit.CENTIMETERS
                );

        Length inches =
                new Length(
                        39.37,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length yard =
                new Length(
                        1.0,
                        LengthUnit.YARDS
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
                        LengthUnit.CENTIMETERS
                );

        Length foot =
                new Length(
                        1.0,
                        LengthUnit.FEET
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
                        LengthUnit.YARDS
                );

        Length inches =
                new Length(
                        35.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
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
                        LengthUnit.FEET
                );

        assertFalse(
                equals(null)
        );
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length a =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length b =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length c =
                new Length(
                        1.0,
                        LengthUnit.FEET
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
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        6.0,
                        LengthUnit.FEET
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
                    LengthUnit.FEET
            );

    Object obj = "Length";

    assertFalse(
            equals(obj)
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
                                LengthUnit.FEET,
                                12.0,
                                LengthUnit.INCHES
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
                                LengthUnit.FEET,
                                LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        36.0,
                        LengthUnit.INCHES
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
                        LengthUnit.YARDS
                );

        Length converted =
                QuantityMeasurementApp
                        .demonstrateLengthConversion(
                                yards,
                                LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        72.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        2.0,
                        LengthUnit.FEET
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
                        LengthUnit.FEET
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
                        LengthUnit.INCHES
                );

        Length length2 =
                new Length(
                        6.0,
                        LengthUnit.INCHES
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
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
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
                        LengthUnit.INCHES
                );

        Length feet =
                new Length(
                        1.0,
                        LengthUnit.FEET
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
                        LengthUnit.INCHES
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
                        LengthUnit.YARDS
                );

        Length feet =
                new Length(
                        3.0,
                        LengthUnit.FEET
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
                        LengthUnit.YARDS
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
                        LengthUnit.CENTIMETERS
                );

        Length inch =
                new Length(
                        1.0,
                        LengthUnit.INCHES
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
                        LengthUnit.CENTIMETERS
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length result1 =
                feet.add(inches);

        Length result2 =
                inches.add(feet);

        assertEquals(
                24.0,
                result2.convertTo(
                        LengthUnit.INCHES
                ).convertTo(
                        LengthUnit.INCHES
                ).equals(
                        new Length(
                                24.0,
                                LengthUnit.INCHES
                        )
                ) ? 24.0 : 0.0
        );
    }


        @Test
    public void testAddition_WithZero() {

        Length feet =
                new Length(
                        5.0,
                        LengthUnit.FEET
                );

        Length zero =
                new Length(
                        0.0,
                        LengthUnit.INCHES
                );

        Length result =
                feet.add(zero);

        assertTrue(
                result.equals(
                        new Length(
                                5.0,
                                LengthUnit.FEET
                        )
                )
        );
    }


        @Test
    public void testAddition_NegativeValues() {

        Length length1 =
                new Length(
                        5.0,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        -2.0,
                        LengthUnit.FEET
                );

        Length result =
                length1.add(length2);

        assertTrue(
                result.equals(
                        new Length(
                                3.0,
                                LengthUnit.FEET
                        )
                )
        );
    }


        @Test
    public void testAddition_NullSecondOperand() {

        Length length =
                new Length(
                        1.0,
                        LengthUnit.FEET
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
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        1000000.0,
                        LengthUnit.FEET
                );

        Length result =
                length1.add(length2);

        assertTrue(
                result.equals(
                        new Length(
                                2000000.0,
                                LengthUnit.FEET
                        )
                )
        );
    }


        @Test
    public void testAddition_SmallValues() {

        Length length1 =
                new Length(
                        0.01,
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        0.02,
                        LengthUnit.FEET
                );

        Length result =
                length1.add(length2);

        assertTrue(
                result.equals(
                        new Length(
                                0.03,
                                LengthUnit.FEET
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                feet,
                                inches,
                                LengthUnit.FEET
                        );

        Length expected =
                new Length(
                        2.0,
                        LengthUnit.FEET
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                feet,
                                inches,
                                LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        24.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                feet,
                                inches,
                                LengthUnit.YARDS
                        );

        Length expected =
                new Length(
                        0.67,
                        LengthUnit.YARDS
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
                        LengthUnit.INCHES
                );

        Length inch2 =
                new Length(
                        1.0,
                        LengthUnit.INCHES
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                inch1,
                                inch2,
                                LengthUnit.CENTIMETERS
                        );

        Length expected =
                new Length(
                        5.08,
                        LengthUnit.CENTIMETERS
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
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
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCHES
                );

        Length result1 =
                feet.add(
                        inches,
                        LengthUnit.YARDS
                );

        Length result2 =
                inches.add(
                        feet,
                        LengthUnit.YARDS
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
                        LengthUnit.FEET
                );

        Length length2 =
                new Length(
                        -2.0,
                        LengthUnit.FEET
                );

        Length result =
                QuantityMeasurementApp
                        .demonstrateLengthAddition(
                                length1,
                                length2,
                                LengthUnit.INCHES
                        );

        Length expected =
                new Length(
                        36.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                result.equals(expected)
        );
    }

    // ==================================================
    // UC8 UPDATE
    // Standalone LengthUnit Tests
    // ==================================================

    @Test
    public void testFeetConversionFactor() {

        assertEquals(
                12.0,
                LengthUnit.FEET.getConversionFactor()
        );
    }

    @Test
    public void testInchesConversionFactor() {

        assertEquals(
                1.0,
                LengthUnit.INCHES.getConversionFactor()
        );
    }

        @Test
    public void testConvertToBaseUnit_Feet() {

        assertEquals(
                12.0,
                LengthUnit.FEET.convertToBaseUnit(
                        1.0
                )
        );
    }

    @Test
    public void testConvertToBaseUnit_Yards() {

        assertEquals(
                36.0,
                LengthUnit.YARDS.convertToBaseUnit(
                        1.0
                )
        );
    }

    @Test
    public void testConvertFromBaseUnit_Inches() {

        assertEquals(
                12.0,
                LengthUnit.INCHES.convertFromBaseUnit(
                        12.0
                )
        );
    }

    @Test
    public void testConvertFromBaseUnit_Feet() {

        assertEquals(
                1.0,
                LengthUnit.FEET.convertFromBaseUnit(
                        12.0
                )
        );
    }


        // ==================================================
    // UC9 UPDATE
    // WEIGHT EQUALITY TESTS
    // ==================================================

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {

        Weight weight1 =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight weight2 =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                weight1.equals(weight2)
        );
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {

        Weight weight1 =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight weight2 =
                new Weight(
                        2.0,
                        WeightUnit.KILOGRAM
                );

        assertFalse(
                weight1.equals(weight2)
        );
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight gram =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                kilogram.equals(gram)
        );
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {

        Weight gram =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                gram.equals(kilogram)
        );
    }

    @Test
    public void testEquality_PoundToPound_SameValue() {

        Weight weight1 =
                new Weight(
                        2.0,
                        WeightUnit.POUND
                );

        Weight weight2 =
                new Weight(
                        2.0,
                        WeightUnit.POUND
                );

        assertTrue(
                weight1.equals(weight2)
        );
    }

    @Test
    public void testEquality_KilogramToPound_EquivalentValue() {

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight pound =
                new Weight(
                        2.20462,
                        WeightUnit.POUND
                );

        assertTrue(
                kilogram.equals(pound)
        );
    }

    @Test
    public void testEquality_GramToPound_EquivalentValue() {

        Weight gram =
                new Weight(
                        453.592,
                        WeightUnit.GRAM
                );

        Weight pound =
                new Weight(
                        1.0,
                        WeightUnit.POUND
                );

        assertTrue(
                gram.equals(pound)
        );
    }

    @Test
    public void testEquality_NullComparison() {

        Weight weight =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertFalse(
                weight.equals(null)
        );
    }

    @Test
    public void testEquality_SameReference() {

        Weight weight =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                weight.equals(weight)
        );
    }

    @Test
    public void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Weight(
                        1.0,
                        null
                )
        );
    }

    @Test
    public void testEquality_ZeroValue() {

        Weight weight1 =
                new Weight(
                        0.0,
                        WeightUnit.KILOGRAM
                );

        Weight weight2 =
                new Weight(
                        0.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                weight1.equals(weight2)
        );
    }

    @Test
    public void testEquality_NegativeWeight() {

        Weight kilogram =
                new Weight(
                        -1.0,
                        WeightUnit.KILOGRAM
                );

        Weight gram =
                new Weight(
                        -1000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                kilogram.equals(gram)
        );
    }

    @Test
    public void testEquality_LargeWeightValue() {

        Weight gram =
                new Weight(
                        1000000.0,
                        WeightUnit.GRAM
                );

        Weight kilogram =
                new Weight(
                        1000.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                gram.equals(kilogram)
        );
    }

    @Test
    public void testEquality_SmallWeightValue() {

        Weight kilogram =
                new Weight(
                        0.001,
                        WeightUnit.KILOGRAM
                );

        Weight gram =
                new Weight(
                        1.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                kilogram.equals(gram)
        );
    }


        // ==================================================
    // UC9 UPDATE
    // WEIGHT CONVERSION TESTS
    // ==================================================

    @Test
    public void testConversion_PoundToKilogram() {

        Weight pound =
                new Weight(
                        2.20462,
                        WeightUnit.POUND
                );

        Weight converted =
                pound.convertTo(
                        WeightUnit.KILOGRAM
                );

        Weight expected =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_KilogramToPound() {

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight converted =
                kilogram.convertTo(
                        WeightUnit.POUND
                );

        Weight expected =
                new Weight(
                        2.20462,
                        WeightUnit.POUND
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_KilogramToGram() {

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight converted =
                kilogram.convertTo(
                        WeightUnit.GRAM
                );

        Weight expected =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_GramToKilogram() {

        Weight gram =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        Weight converted =
                gram.convertTo(
                        WeightUnit.KILOGRAM
                );

        Weight expected =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_SameUnit() {

        Weight weight =
                new Weight(
                        5.0,
                        WeightUnit.KILOGRAM
                );

        Weight converted =
                weight.convertTo(
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                converted.equals(weight)
        );
    }

    @Test
    public void testConversion_ZeroValue() {

        Weight kilogram =
                new Weight(
                        0.0,
                        WeightUnit.KILOGRAM
                );

        Weight converted =
                kilogram.convertTo(
                        WeightUnit.GRAM
                );

        Weight expected =
                new Weight(
                        0.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_NegativeValue() {

        Weight kilogram =
                new Weight(
                        -1.0,
                        WeightUnit.KILOGRAM
                );

        Weight converted =
                kilogram.convertTo(
                        WeightUnit.GRAM
                );

        Weight expected =
                new Weight(
                        -1000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_RoundTrip() {

        Weight original =
                new Weight(
                        1.5,
                        WeightUnit.KILOGRAM
                );

        Weight converted =
                original.convertTo(
                        WeightUnit.GRAM
                ).convertTo(
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                converted.equals(original)
        );
    }

    @Test
    public void testConversion_NullTargetUnit() {

        Weight weight =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> weight.convertTo(null)
        );
    }


        // ==================================================
    // UC9 UPDATE
    // WEIGHT ADDITION TESTS
    // ==================================================

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {

        Weight weight1 =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight weight2 =
                new Weight(
                        2.0,
                        WeightUnit.KILOGRAM
                );

        Weight result =
                QuantityMeasurementApp
                        .demonstrateWeightAddition(
                                weight1,
                                weight2
                        );

        Weight expected =
                new Weight(
                        3.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight gram =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        Weight result =
                QuantityMeasurementApp
                        .demonstrateWeightAddition(
                                kilogram,
                                gram
                        );

        Weight expected =
                new Weight(
                        2.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {

        Weight pound =
                new Weight(
                        2.20462,
                        WeightUnit.POUND
                );

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight result =
                QuantityMeasurementApp
                        .demonstrateWeightAddition(
                                pound,
                                kilogram
                        );

        Weight expected =
                new Weight(
                        4.40924,
                        WeightUnit.POUND
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Gram() {

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight gram =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        Weight result =
                QuantityMeasurementApp
                        .demonstrateWeightAddition(
                                kilogram,
                                gram,
                                WeightUnit.GRAM
                        );

        Weight expected =
                new Weight(
                        2000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight gram =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        Weight result =
                QuantityMeasurementApp
                        .demonstrateWeightAddition(
                                kilogram,
                                gram,
                                WeightUnit.KILOGRAM
                        );

        Weight expected =
                new Weight(
                        2.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Pound() {

        Weight pound =
                new Weight(
                        1.0,
                        WeightUnit.POUND
                );

        Weight gram =
                new Weight(
                        453.592,
                        WeightUnit.GRAM
                );

        Weight result =
                QuantityMeasurementApp
                        .demonstrateWeightAddition(
                                pound,
                                gram,
                                WeightUnit.POUND
                        );

        Weight expected =
                new Weight(
                        1.98,
                        WeightUnit.POUND
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testWeightAddition_Commutativity() {

        Weight kilogram =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight gram =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        Weight result1 =
                kilogram.add(
                        gram,
                        WeightUnit.KILOGRAM
                );

        Weight result2 =
                gram.add(
                        kilogram,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                result1.equals(result2)
        );
    }

    @Test
    public void testWeightAddition_WithZero() {

        Weight kilogram =
                new Weight(
                        5.0,
                        WeightUnit.KILOGRAM
                );

        Weight zero =
                new Weight(
                        0.0,
                        WeightUnit.GRAM
                );

        Weight result =
                kilogram.add(zero);

        assertTrue(
                result.equals(
                        new Weight(
                                5.0,
                                WeightUnit.KILOGRAM
                        )
                )
        );
    }

    @Test
    public void testWeightAddition_NegativeValues() {

        Weight weight1 =
                new Weight(
                        5.0,
                        WeightUnit.KILOGRAM
                );

        Weight weight2 =
                new Weight(
                        -2.0,
                        WeightUnit.KILOGRAM
                );

        Weight result =
                weight1.add(weight2);

        assertTrue(
                result.equals(
                        new Weight(
                                3.0,
                                WeightUnit.KILOGRAM
                        )
                )
        );
    }

    @Test
    public void testWeightAddition_NullSecondOperand() {

        Weight weight =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> weight.add(null)
        );
    }

    @Test
    public void testWeightAddition_LargeValues() {

        Weight weight1 =
                new Weight(
                        1000000.0,
                        WeightUnit.KILOGRAM
                );

        Weight weight2 =
                new Weight(
                        1000000.0,
                        WeightUnit.KILOGRAM
                );

        Weight result =
                weight1.add(weight2);

        assertTrue(
                result.equals(
                        new Weight(
                                2000000.0,
                                WeightUnit.KILOGRAM
                        )
                )
        );
    }

    @Test
    public void testWeightAddition_ExplicitTargetUnit_NullTargetUnit() {

        Weight weight1 =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Weight weight2 =
                new Weight(
                        1000.0,
                        WeightUnit.GRAM
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp
                        .demonstrateWeightAddition(
                                weight1,
                                weight2,
                                null
                        )
        );
    }

        // ==================================================
    // UC9 UPDATE
    // WEIGHT UNIT ENUM TESTS
    // ==================================================

    @Test
    public void testWeightUnit_KilogramConversionFactor() {

        assertEquals(
                1.0,
                WeightUnit.KILOGRAM
                        .getConversionFactor()
        );
    }

    @Test
    public void testWeightUnit_GramConversionFactor() {

        assertEquals(
                0.001,
                WeightUnit.GRAM
                        .getConversionFactor()
        );
    }

    @Test
    public void testWeightUnit_PoundConversionFactor() {

        assertEquals(
                0.453592,
                WeightUnit.POUND
                        .getConversionFactor()
        );
    }

    @Test
    public void testConvertToBaseUnit_Kilogram() {

        assertEquals(
                1.0,
                WeightUnit.KILOGRAM
                        .convertToBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testConvertToBaseUnit_Gram() {

        assertEquals(
                1.0,
                WeightUnit.GRAM
                        .convertToBaseUnit(
                                1000.0
                        )
        );
    }

    @Test
    public void testConvertToBaseUnit_Pound() {

        assertEquals(
                0.45,
                WeightUnit.POUND
                        .convertToBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testConvertFromBaseUnit_Kilogram() {

        assertEquals(
                1.0,
                WeightUnit.KILOGRAM
                        .convertFromBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testConvertFromBaseUnit_Gram() {

        assertEquals(
                1000.0,
                WeightUnit.GRAM
                        .convertFromBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testConvertFromBaseUnit_Pound() {

        assertEquals(
                2.20,
                WeightUnit.POUND
                        .convertFromBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testWeightEqualityDemonstrateMethod() {

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateWeightComparison(
                                1.0,
                                WeightUnit.KILOGRAM,
                                1000.0,
                                WeightUnit.GRAM
                        )
        );
    }

    @Test
    public void testWeightVsLength_Incompatible() {

        Weight weight =
                new Weight(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Length length =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        assertFalse(
                weight.equals(length)
        );
    }


}