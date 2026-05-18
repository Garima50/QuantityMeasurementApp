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

    // ---------------- CROSS UNIT TESTS ----------------

    @Test
    public void testFeetInchesComparison() {

        Length feet =
                new Length(1.0, Length.LengthUnit.FEET);

        Length inches =
                new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testInchesFeetComparison() {

        Length inches =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length feet =
                new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(inches.equals(feet));
    }

    // ---------------- NEGATIVE TESTS ----------------

    @Test
    public void testFeetInequality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void testInchesInequality() {

        Length length1 =
                new Length(1.0, Length.LengthUnit.INCHES);

        Length length2 =
                new Length(2.0, Length.LengthUnit.INCHES);

        assertFalse(length1.equals(length2));
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

        String obj = "1.0";

        assertFalse(length.equals(obj));
    }
}