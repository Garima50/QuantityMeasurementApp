package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// UC8 UPDATE
// Updated to use standalone LengthUnit enum

public class QuantityMeasurementAppTest {

    // ==================================================
    // UC10 UPDATE
    // SAME UNIT TESTS USING GENERIC QUANTITY
    // ==================================================

    @Test
    public void testFeetEquality() {

        Quantity<LengthUnit> length1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> length2 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(
                length1.equals(length2)
        );
    }

    @Test
    public void testInchesEquality() {

        Quantity<LengthUnit> length1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.INCHES
                );

        Quantity<LengthUnit> length2 =
                new Quantity<>(
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

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                feet.equals(inches)
        );
    }

    @Test
    public void testFeetInequality() {

        Quantity<LengthUnit> length1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> length2 =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET
                );

        assertFalse(
                length1.equals(length2)
        );
    }

    @Test
    public void testInchesInequality() {

        Quantity<LengthUnit> length1 =
                new Quantity<>(
                        1.0,
                        LengthUnit.INCHES
                );

        Quantity<LengthUnit> length2 =
                new Quantity<>(
                        2.0,
                        LengthUnit.INCHES
                );

        assertFalse(
                length1.equals(length2)
        );
    }

    @Test
    public void testCrossUnitInequality() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        10.0,
                        LengthUnit.INCHES
                );

        assertFalse(
                feet.equals(inches)
        );
    }

    @Test
    public void testMultipleFeetComparison() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        3.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
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

        Quantity<LengthUnit> yard =
                new Quantity<>(
                        1.0,
                        LengthUnit.YARDS
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        36.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                yard.equals(inches)
        );
    }

    @Test
    public void centimeterEquals39Point3701Inches() {

        Quantity<LengthUnit> cm =
                new Quantity<>(
                        100.0,
                        LengthUnit.CENTIMETERS
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        39.37,
                        LengthUnit.INCHES
                );

        assertTrue(
                cm.equals(inches)
        );
    }

    @Test
    public void threeFeetEqualsOneYard() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        3.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> yard =
                new Quantity<>(
                        1.0,
                        LengthUnit.YARDS
                );

        assertTrue(
                feet.equals(yard)
        );
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {

        Quantity<LengthUnit> cm =
                new Quantity<>(
                        30.48,
                        LengthUnit.CENTIMETERS
                );

        Quantity<LengthUnit> foot =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(
                cm.equals(foot)
        );
    }

    @Test
    public void yardNotEqualToInches() {

        Quantity<LengthUnit> yard =
                new Quantity<>(
                        1.0,
                        LengthUnit.YARDS
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
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

        Quantity<LengthUnit> length =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(
                length.equals(length)
        );
    }

    @Test
    public void equalsReturnsFalseForNull() {

        Quantity<LengthUnit> length =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertFalse(
                length.equals(null)
        );
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Quantity<LengthUnit> a =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> b =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES
                );

        Quantity<LengthUnit> c =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {

        Quantity<LengthUnit> length1 =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> length2 =
                new Quantity<>(
                        6.0,
                        LengthUnit.FEET
                );

        assertFalse(
                length1.equals(length2)
        );
    }

    @Test
    public void testDifferentClass() {

        Quantity<LengthUnit> length =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
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
                        .demonstrateComparison(
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

        Quantity<LengthUnit> converted =
                QuantityMeasurementApp
                        .demonstrateConversion(
                                3.0,
                                LengthUnit.FEET,
                                LengthUnit.INCHES
                        );

        Quantity<LengthUnit> expected =
                new Quantity<>(
                        36.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {

        Quantity<LengthUnit> yards =
                new Quantity<>(
                        2.0,
                        LengthUnit.YARDS
                );

        Quantity<LengthUnit> converted =
                QuantityMeasurementApp
                        .demonstrateConversion(
                                yards,
                                LengthUnit.INCHES
                        );

        Quantity<LengthUnit> expected =
                new Quantity<>(
                        72.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                converted.equals(expected)
        );
    }

@Test
public void testAddition_SameUnit_FeetPlusFeet() {

    Quantity<LengthUnit> length1 =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> length2 =
            new Quantity<>(
                    2.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            length1,
                            length2
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    3.0,
                    LengthUnit.FEET
            );

    assertTrue(
            result.equals(expected)
    );
}

@Test
public void testAddition_SameUnit_InchPlusInch() {

    Quantity<LengthUnit> length1 =
            new Quantity<>(
                    6.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> length2 =
            new Quantity<>(
                    6.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            length1,
                            length2
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    assertTrue(
            result.equals(expected)
    );
}

@Test
public void testAddition_CrossUnit_FeetPlusInches() {

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> inches =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            feet,
                            inches
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    2.0,
                    LengthUnit.FEET
            );

    assertTrue(
            result.equals(expected)
    );
}

@Test
public void testAddition_CrossUnit_InchPlusFeet() {

    Quantity<LengthUnit> inches =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            inches,
                            feet
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    24.0,
                    LengthUnit.INCHES
            );

    assertTrue(
            result.equals(expected)
    );
}


@Test
public void testAddition_CrossUnit_YardPlusFeet() {

    Quantity<LengthUnit> yard =
            new Quantity<>(
                    1.0,
                    LengthUnit.YARDS
            );

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    3.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            yard,
                            feet
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    2.0,
                    LengthUnit.YARDS
            );

    assertTrue(
            result.equals(expected)
    );
}


@Test
public void testAddition_CrossUnit_CentimeterPlusInch() {

    Quantity<LengthUnit> cm =
            new Quantity<>(
                    2.54,
                    LengthUnit.CENTIMETERS
            );

    Quantity<LengthUnit> inch =
            new Quantity<>(
                    1.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            cm,
                            inch
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    5.08,
                    LengthUnit.CENTIMETERS
            );

    assertTrue(
            result.equals(expected)
    );
}


@Test
public void testAddition_Commutativity() {

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> inches =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result1 =
            feet.add(
                    inches,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result2 =
            inches.add(
                    feet,
                    LengthUnit.INCHES
            );

    assertTrue(
            result1.equals(result2)
    );
}


@Test
public void testAddition_WithZero() {

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    5.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> zero =
            new Quantity<>(
                    0.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result =
            feet.add(zero);

    assertTrue(
            result.equals(
                    new Quantity<>(
                            5.0,
                            LengthUnit.FEET
                    )
            )
    );
}


@Test
public void testAddition_NegativeValues() {

    Quantity<LengthUnit> length1 =
            new Quantity<>(
                    5.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> length2 =
            new Quantity<>(
                    -2.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> result =
            length1.add(length2);

    assertTrue(
            result.equals(
                    new Quantity<>(
                            3.0,
                            LengthUnit.FEET
                    )
            )
    );
}

    // ==================================================
    // UC7 UPDATE
    // Addition with explicit target unit specification
    // ==================================================

// UC10 UPDATE
// Addition with explicit target unit specification

@Test
public void testAddition_ExplicitTargetUnit_Feet() {

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> inches =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            feet,
                            inches,
                            LengthUnit.FEET
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    2.0,
                    LengthUnit.FEET
            );

    assertTrue(
            result.equals(expected)
    );
}

@Test
public void testAddition_ExplicitTargetUnit_Inches() {

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> inches =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            feet,
                            inches,
                            LengthUnit.INCHES
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    24.0,
                    LengthUnit.INCHES
            );

    assertTrue(
            result.equals(expected)
    );
}

@Test
public void testAddition_ExplicitTargetUnit_Yards() {

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> inches =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            feet,
                            inches,
                            LengthUnit.YARDS
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    0.67,
                    LengthUnit.YARDS
            );

    assertTrue(
            result.equals(expected)
    );
}

@Test
public void testAddition_ExplicitTargetUnit_Centimeters() {

    Quantity<LengthUnit> inch1 =
            new Quantity<>(
                    1.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> inch2 =
            new Quantity<>(
                    1.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            inch1,
                            inch2,
                            LengthUnit.CENTIMETERS
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
                    5.08,
                    LengthUnit.CENTIMETERS
            );

    assertTrue(
            result.equals(expected)
    );
}

@Test
public void testAddition_ExplicitTargetUnit_NullTargetUnit() {

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> inches =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    assertThrows(
            IllegalArgumentException.class,
            () -> QuantityMeasurementApp
                    .demonstrateAddition(
                            feet,
                            inches,
                            null
                    )
    );
}

@Test
public void testAddition_ExplicitTargetUnit_Commutativity() {

    Quantity<LengthUnit> feet =
            new Quantity<>(
                    1.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> inches =
            new Quantity<>(
                    12.0,
                    LengthUnit.INCHES
            );

    Quantity<LengthUnit> result1 =
            feet.add(
                    inches,
                    LengthUnit.YARDS
            );

    Quantity<LengthUnit> result2 =
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

    Quantity<LengthUnit> length1 =
            new Quantity<>(
                    5.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> length2 =
            new Quantity<>(
                    -2.0,
                    LengthUnit.FEET
            );

    Quantity<LengthUnit> result =
            QuantityMeasurementApp
                    .demonstrateAddition(
                            length1,
                            length2,
                            LengthUnit.INCHES
                    );

    Quantity<LengthUnit> expected =
            new Quantity<>(
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
// UC10 UPDATE
// WEIGHT EQUALITY TESTS USING GENERIC QUANTITY
// ==================================================

@Test
public void testEquality_KilogramToKilogram_SameValue() {

    Quantity<WeightUnit> weight1 =
            new Quantity<>(
                    1.0,
                    WeightUnit.KILOGRAM
            );

    Quantity<WeightUnit> weight2 =
            new Quantity<>(
                    1.0,
                    WeightUnit.KILOGRAM
            );

    assertTrue(
            weight1.equals(weight2)
    );
}

@Test
public void testEquality_KilogramToKilogram_DifferentValue() {

    Quantity<WeightUnit> weight1 =
            new Quantity<>(
                    1.0,
                    WeightUnit.KILOGRAM
            );

    Quantity<WeightUnit> weight2 =
            new Quantity<>(
                    2.0,
                    WeightUnit.KILOGRAM
            );

    assertFalse(
            weight1.equals(weight2)
    );
}

@Test
public void testEquality_KilogramToGram_EquivalentValue() {

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

    assertTrue(
            kilogram.equals(gram)
    );
}

@Test
public void testEquality_GramToKilogram_EquivalentValue() {

    Quantity<WeightUnit> gram =
            new Quantity<>(
                    1000.0,
                    WeightUnit.GRAM
            );

    Quantity<WeightUnit> kilogram =
            new Quantity<>(
                    1.0,
                    WeightUnit.KILOGRAM
            );

    assertTrue(
            gram.equals(kilogram)
    );
}

@Test
public void testEquality_PoundToPound_SameValue() {

    Quantity<WeightUnit> weight1 =
            new Quantity<>(
                    2.0,
                    WeightUnit.POUND
            );

    Quantity<WeightUnit> weight2 =
            new Quantity<>(
                    2.0,
                    WeightUnit.POUND
            );

    assertTrue(
            weight1.equals(weight2)
    );
}

@Test
public void testEquality_KilogramToPound_EquivalentValue() {

    Quantity<WeightUnit> kilogram =
            new Quantity<>(
                    1.0,
                    WeightUnit.KILOGRAM
            );

    Quantity<WeightUnit> pound =
            new Quantity<>(
                    2.20462,
                    WeightUnit.POUND
            );

    assertTrue(
            kilogram.equals(pound)
    );
}

@Test
public void testEquality_GramToPound_EquivalentValue() {

    Quantity<WeightUnit> gram =
            new Quantity<>(
                    453.592,
                    WeightUnit.GRAM
            );

    Quantity<WeightUnit> pound =
            new Quantity<>(
                    1.0,
                    WeightUnit.POUND
            );

    assertTrue(
            gram.equals(pound)
    );
}

@Test
public void testEquality_NullComparison() {

    Quantity<WeightUnit> weight =
            new Quantity<>(
                    1.0,
                    WeightUnit.KILOGRAM
            );

    assertFalse(
            weight.equals(null)
    );
}

@Test
public void testEquality_SameReference() {

    Quantity<WeightUnit> weight =
            new Quantity<>(
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
            () -> new Quantity<>(
                    1.0,
                    null
            )
    );
}

@Test
public void testEquality_ZeroValue() {

    Quantity<WeightUnit> weight1 =
            new Quantity<>(
                    0.0,
                    WeightUnit.KILOGRAM
            );

    Quantity<WeightUnit> weight2 =
            new Quantity<>(
                    0.0,
                    WeightUnit.GRAM
            );

    assertTrue(
            weight1.equals(weight2)
    );
}

@Test
public void testEquality_NegativeWeight() {

    Quantity<WeightUnit> kilogram =
            new Quantity<>(
                    -1.0,
                    WeightUnit.KILOGRAM
            );

    Quantity<WeightUnit> gram =
            new Quantity<>(
                    -1000.0,
                    WeightUnit.GRAM
            );

    assertTrue(
            kilogram.equals(gram)
    );
}

@Test
public void testEquality_LargeWeightValue() {

    Quantity<WeightUnit> gram =
            new Quantity<>(
                    1000000.0,
                    WeightUnit.GRAM
            );

    Quantity<WeightUnit> kilogram =
            new Quantity<>(
                    1000.0,
                    WeightUnit.KILOGRAM
            );

    assertTrue(
            gram.equals(kilogram)
    );
}

@Test
public void testEquality_SmallWeightValue() {

    Quantity<WeightUnit> kilogram =
            new Quantity<>(
                    0.001,
                    WeightUnit.KILOGRAM
            );

    Quantity<WeightUnit> gram =
            new Quantity<>(
                    1.0,
                    WeightUnit.GRAM
            );

    assertTrue(
            kilogram.equals(gram)
    );
}

    @Test
    public void testConversion_KilogramToGram() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> converted =
                kilogram.convertTo(
                        WeightUnit.GRAM
                );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_GramToKilogram() {

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM
                );

        Quantity<WeightUnit> converted =
                gram.convertTo(
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_SameUnit() {

        Quantity<WeightUnit> weight =
                new Quantity<>(
                        5.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> converted =
                weight.convertTo(
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                converted.equals(weight)
        );
    }

    @Test
    public void testConversion_ZeroValue() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        0.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> converted =
                kilogram.convertTo(
                        WeightUnit.GRAM
                );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        0.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_NegativeValue() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        -1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> converted =
                kilogram.convertTo(
                        WeightUnit.GRAM
                );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        -1000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_RoundTrip() {

        Quantity<WeightUnit> original =
                new Quantity<>(
                        1.5,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> converted =
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

        Quantity<WeightUnit> weight =
                new Quantity<>(
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

        Quantity<WeightUnit> weight1 =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> weight2 =
                new Quantity<>(
                        2.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> result =
                QuantityMeasurementApp.demonstrateAddition(
                                weight1,
                                weight2
                        );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        3.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {

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

        Quantity<WeightUnit> result =
                QuantityMeasurementApp.
                       demonstrateAddition(
                                kilogram,
                                gram
                        );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        2.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {

        Quantity<WeightUnit> pound =
                new Quantity<>(
                        2.20462,
                        WeightUnit.POUND
                );

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                pound,
                                kilogram
                        );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        4.40924,
                        WeightUnit.POUND
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Gram() {

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

        Quantity<WeightUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                kilogram,
                                gram,
                                WeightUnit.GRAM
                        );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        2000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {

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

        Quantity<WeightUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                kilogram,
                                gram,
                                WeightUnit.KILOGRAM
                        );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        2.0,
                        WeightUnit.KILOGRAM
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Pound() {

        Quantity<WeightUnit> pound =
                new Quantity<>(
                        1.0,
                        WeightUnit.POUND
                );

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        453.592,
                        WeightUnit.GRAM
                );

        Quantity<WeightUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                pound,
                                gram,
                                WeightUnit.POUND
                        );

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        1.98,
                        WeightUnit.POUND
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testWeightAddition_Commutativity() {

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

        Quantity<WeightUnit> result1 =
                kilogram.add(
                        gram,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> result2 =
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

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        5.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> zero =
                new Quantity<>(
                        0.0,
                        WeightUnit.GRAM
                );

        Quantity<WeightUnit> result =
                kilogram.add(zero);

        assertTrue(
                result.equals(
                        new Quantity<>(
                                5.0,
                                WeightUnit.KILOGRAM
                        )
                )
        );
    }

    @Test
    public void testWeightAddition_NegativeValues() {

        Quantity<WeightUnit> weight1 =
                new Quantity<>(
                        5.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> weight2 =
                new Quantity<>(
                        -2.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> result =
                weight1.add(weight2);

        assertTrue(
                result.equals(
                        new Quantity<>(
                                3.0,
                                WeightUnit.KILOGRAM
                        )
                )
        );
    }

    @Test
    public void testWeightAddition_NullSecondOperand() {

        Quantity<WeightUnit> weight =
                new Quantity<>(
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

        Quantity<WeightUnit> weight1 =
                new Quantity<>(
                        1000000.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> weight2 =
                new Quantity<>(
                        1000000.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> result =
                weight1.add(weight2);

        assertTrue(
                result.equals(
                        new Quantity<>(
                                2000000.0,
                                WeightUnit.KILOGRAM
                        )
                )
        );
    }

    @Test
    public void testWeightAddition_ExplicitTargetUnit_NullTargetUnit() {

        Quantity<WeightUnit> weight1 =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> weight2 =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp
                        .demonstrateAddition(
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
                        .demonstrateComparison(
                                1.0,
                                WeightUnit.KILOGRAM,
                                1000.0,
                                WeightUnit.GRAM
                        )
        );
    }

    @Test
    public void testWeightVsLength_Incompatible() {

        Quantity<WeightUnit> weight =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<LengthUnit> length =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertFalse(
                weight.equals(length)
        );
    }

    @Test
public void testGenericQuantity_InvalidValue() {

    assertThrows(
            IllegalArgumentException.class,
            () -> new Quantity<>(
                    Double.NaN,
                    LengthUnit.FEET
            )
    );
}

@Test
public void testGenericQuantity_NullUnit() {

    assertThrows(
            IllegalArgumentException.class,
            () -> new Quantity<>(
                    1.0,
                    null
            )
    );
}

    // ==================================================
    // UC11 UPDATE
    // VOLUME EQUALITY TESTS
    // ==================================================

    @Test
    public void testEquality_LitreToLitre_SameValue() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        assertTrue(
                volume1.equals(volume2)
        );
    }

    @Test
    public void testEquality_LitreToLitre_DifferentValue() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(
                        2.0,
                        VolumeUnit.LITRE
                );

        assertFalse(
                volume1.equals(volume2)
        );
    }

    @Test
    public void testEquality_LitreToMillilitre_EquivalentValue() {

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

        assertTrue(
                litre.equals(millilitre)
        );
    }

    @Test
    public void testEquality_MillilitreToLitre_EquivalentValue() {

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        assertTrue(
                millilitre.equals(litre)
        );
    }

    @Test
    public void testEquality_GallonToGallon_SameValue() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON
                );

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON
                );

        assertTrue(
                volume1.equals(volume2)
        );
    }

    @Test
    public void testEquality_VolumeVsLength_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<LengthUnit> length =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertFalse(
                volume.equals(length)
        );
    }

    @Test
    public void testEquality_VolumeVsWeight_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<WeightUnit> weight =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        assertFalse(
                volume.equals(weight)
        );
    }

    @Test
    public void testEquality_VolumeSameReference() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        assertTrue(
                volume.equals(volume)
        );
    }

    @Test
    public void testEquality_VolumeNullComparison() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        assertFalse(
                volume.equals(null)
        );
    }

    @Test
    public void testEquality_VolumeZeroValue() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(
                        0.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(
                        0.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                volume1.equals(volume2)
        );
    }

    @Test
    public void testEquality_VolumeNegativeValue() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        -1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        -1000.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                litre.equals(millilitre)
        );
    }

    @Test
    public void testEquality_VolumeLargeValue() {

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        1000000.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.LITRE
                );

        assertTrue(
                millilitre.equals(litre)
        );
    }

    @Test
    public void testVolumeEqualityDemonstrateMethod() {

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateComparison(
                                1.0,
                                VolumeUnit.LITRE,
                                1000.0,
                                VolumeUnit.MILLILITRE
                        )
        );
    }

        // ==================================================
    // UC11 UPDATE
    // VOLUME CONVERSION TESTS
    // ==================================================

    @Test
    public void testConversion_LitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> converted =
                litre.convertTo(
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_MillilitreToLitre() {

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> converted =
                millilitre.convertTo(
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_GallonToLitre() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON
                );

        Quantity<VolumeUnit> converted =
                gallon.convertTo(
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        3.79,
                        VolumeUnit.LITRE
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_LitreToGallon() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        3.79,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> converted =
                litre.convertTo(
                        VolumeUnit.GALLON
                );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_SameUnit_Volume() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> converted =
                volume.convertTo(
                        VolumeUnit.LITRE
                );

        assertTrue(
                converted.equals(volume)
        );
    }

    @Test
    public void testConversion_ZeroValue_Volume() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        0.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> converted =
                litre.convertTo(
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        0.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_NegativeValue_Volume() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        -1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> converted =
                litre.convertTo(
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        -1000.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                converted.equals(expected)
        );
    }

    @Test
    public void testConversion_RoundTrip_Volume() {

        Quantity<VolumeUnit> original =
                new Quantity<>(
                        1.5,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> converted =
                original.convertTo(
                        VolumeUnit.MILLILITRE
                ).convertTo(
                        VolumeUnit.LITRE
                );

        assertTrue(
                converted.equals(original)
        );
    }

    @Test
    public void testConversion_NullTargetUnit_Volume() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> volume.convertTo(null)
        );
    }

        // ==================================================
    // UC11 UPDATE
    // VOLUME ADDITION TESTS
    // ==================================================

    @Test
    public void testAddition_SameUnit_LitrePlusLitre() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(
                        2.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                volume1,
                                volume2
                        );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        3.0,
                        VolumeUnit.LITRE
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_SameUnit_MillilitrePlusMillilitre() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(
                        500.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(
                        500.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                volume1,
                                volume2
                        );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_CrossUnit_LitrePlusMillilitre() {

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

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                litre,
                                millilitre
                        );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        2.0,
                        VolumeUnit.LITRE
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_CrossUnit_MillilitrePlusLitre() {

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                millilitre,
                                litre
                        );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        2000.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_CrossUnit_GallonPlusLitre() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(
                        1.0,
                        VolumeUnit.GALLON
                );

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        3.79,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                gallon,
                                litre
                        );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        2.0,
                        VolumeUnit.GALLON
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Litre() {

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

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                litre,
                                millilitre,
                                VolumeUnit.LITRE
                        );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        2.0,
                        VolumeUnit.LITRE
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Millilitre() {

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

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                litre,
                                millilitre,
                                VolumeUnit.MILLILITRE
                        );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        2000.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Gallon() {

        Quantity<VolumeUnit> litre1 =
                new Quantity<>(
                        3.79,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> litre2 =
                new Quantity<>(
                        3.79,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> result =
                QuantityMeasurementApp
                        .demonstrateAddition(
                                litre1,
                                litre2,
                                VolumeUnit.GALLON
                        );

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        2.0,
                        VolumeUnit.GALLON
                );

        assertTrue(
                result.equals(expected)
        );
    }

    @Test
    public void testVolumeAddition_Commutativity() {

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

        Quantity<VolumeUnit> result1 =
                litre.add(
                        millilitre,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> result2 =
                millilitre.add(
                        litre,
                        VolumeUnit.LITRE
                );

        assertTrue(
                result1.equals(result2)
        );
    }

    @Test
    public void testVolumeAddition_WithZero() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> zero =
                new Quantity<>(
                        0.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> result =
                litre.add(zero);

        assertTrue(
                result.equals(
                        new Quantity<>(
                                5.0,
                                VolumeUnit.LITRE
                        )
                )
        );
    }

    @Test
    public void testVolumeAddition_NegativeValues() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(
                        -2.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> result =
                volume1.add(volume2);

        assertTrue(
                result.equals(
                        new Quantity<>(
                                3.0,
                                VolumeUnit.LITRE
                        )
                )
        );
    }

    @Test
    public void testVolumeAddition_NullSecondOperand() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> volume.add(null)
        );
    }

    @Test
    public void testVolumeAddition_ExplicitTargetUnit_NullTargetUnit() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp
                        .demonstrateAddition(
                                volume1,
                                volume2,
                                null
                        )
        );
    }

        // ==================================================
    // UC11 UPDATE
    // VOLUME UNIT ENUM TESTS
    // ==================================================

    @Test
    public void testVolumeUnit_LitreConversionFactor() {

        assertEquals(
                1.0,
                VolumeUnit.LITRE
                        .getConversionFactor()
        );
    }

    @Test
    public void testVolumeUnit_MillilitreConversionFactor() {

        assertEquals(
                0.001,
                VolumeUnit.MILLILITRE
                        .getConversionFactor()
        );
    }

    @Test
    public void testVolumeUnit_GallonConversionFactor() {

        assertEquals(
                3.78541,
                VolumeUnit.GALLON
                        .getConversionFactor()
        );
    }

    @Test
    public void testConvertToBaseUnit_Litre() {

        assertEquals(
                1.0,
                VolumeUnit.LITRE
                        .convertToBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testConvertToBaseUnit_Millilitre() {

        assertEquals(
                1.0,
                VolumeUnit.MILLILITRE
                        .convertToBaseUnit(
                                1000.0
                        )
        );
    }

    @Test
    public void testConvertToBaseUnit_Gallon() {

        assertEquals(
                3.79,
                VolumeUnit.GALLON
                        .convertToBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testConvertFromBaseUnit_Litre() {

        assertEquals(
                1.0,
                VolumeUnit.LITRE
                        .convertFromBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testConvertFromBaseUnit_Millilitre() {

        assertEquals(
                1000.0,
                VolumeUnit.MILLILITRE
                        .convertFromBaseUnit(
                                1.0
                        )
        );
    }

    @Test
    public void testConvertFromBaseUnit_Gallon() {

        assertEquals(
                1.0,
                VolumeUnit.GALLON
                        .convertFromBaseUnit(
                                3.79
                        )
        );
    }

    @Test
    public void testGenericQuantity_VolumeOperations_Consistency() {

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

        assertTrue(
                litre.equals(
                        millilitre
                )
        );

        assertTrue(
                litre.add(
                        millilitre
                ).equals(
                        new Quantity<>(
                                2.0,
                                VolumeUnit.LITRE
                        )
                )
        );
    }

    @Test
    public void testScalability_VolumeIntegration() {

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateComparison(
                                1.0,
                                VolumeUnit.LITRE,
                                1000.0,
                                VolumeUnit.MILLILITRE
                        )
        );
    }

}