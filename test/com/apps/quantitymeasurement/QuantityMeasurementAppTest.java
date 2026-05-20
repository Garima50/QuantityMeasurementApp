package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------------- SAME UNIT TESTS ----------------

    @Test
    public void testFeetEquality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void testInchesEquality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length length2 =
                new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(length1.equals(length2));
    }

    // UC4 UPDATE
    @Test
    public void testYardsEquality() {

        Length yard1 =
                new Length(1.0, Length.LengthUnit.YARDS);

        Length yard2 =
                new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(yard1.equals(yard2));
    }

    // UC4 UPDATE
    @Test
    public void testCentimetersEquality() {

        Length cm1 =
                new Length(1.0, Length.LengthUnit.CENTIMETERS);

        Length cm2 =
                new Length(1.0, Length.LengthUnit.CENTIMETERS);

        assertTrue(cm1.equals(cm2));
    }

    // ---------------- CROSS UNIT TESTS ----------------

    @Test
    public void testFeetInchesComparison() {

        Length feet =
                new Length(1.0, Length.LengthUnit.FEET);

        Length inches =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    // UC4 UPDATE
    @Test
    public void testYardFeetComparison() {

        Length yard =
                new Length(1.0, Length.LengthUnit.YARDS);

        Length feet =
                new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    // UC4 UPDATE
    @Test
    public void testYardInchesComparison() {

        Length yard =
                new Length(1.0, Length.LengthUnit.YARDS);

        Length inches =
                new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    // UC4 UPDATE
    @Test
    public void testCentimeterInchesComparison() {

        Length cm =
                new Length(1.0, Length.LengthUnit.CENTIMETERS);

        Length inches =
                new Length(0.393701, Length.LengthUnit.INCHES);

        assertTrue(cm.equals(inches));
    }

    // ---------------- NULL TESTS ----------------

    @Test
    public void testNullComparison() {

        Length length =
                new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(length.equals(null));
    }

    @Test
    public void testNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(1.0, null)
        );
    }

    // ---------------- REFLEXIVE TEST ----------------

    @Test
    public void testSameReference() {

        Length length =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length.equals(length));
    }

    // ---------------- DIFFERENT CLASS TEST ----------------

    @Test
    public void testDifferentClass() {

        Length length =
                new Length(1.0, Length.LengthUnit.FEET);

        Object obj = "1.0";
        assertFalse(length.equals(obj));
    }
}