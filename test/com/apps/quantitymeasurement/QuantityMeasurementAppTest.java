package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// to run tests:
// javac -cp "lib/*" *.java 
// java -jar lib/junit-platform-console-standalone-1.10.2.jar --class-path . --scan-class-path

public class QuantityMeasurementAppTest {

    // ---------------- FEET TESTS ----------------

    @Test
    public void testFeetEquality_SameValue() {

        Feet value1 = new Feet(1.0);

        Feet value2 = new Feet(1.0);

        assertTrue(value1.equals(value2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {

        Feet value1 =
                new Feet(1.0);

        Feet value2 =
                new Feet(2.0);

        assertFalse(value1.equals(value2));
    }

    @Test
    public void testFeetEquality_NullComparison() {

        Feet value1 =
                new Feet(1.0);

        assertFalse(value1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {

        Feet value1 =
                new Feet(1.0);

        Object obj = "1.0";

        assertFalse(value1.equals(obj));
    }

    @Test
    public void testFeetEquality_SameReference() {

        Feet value1 =
                new Feet(1.0);

        assertTrue(value1.equals(value1));
    }

    // ---------------- INCHES TESTS ----------------

    @Test
    public void testInchesEquality_SameValue() {

        Inches value1 =
                new Inches(1.0);

        Inches value2 =
                new Inches(1.0);

        assertTrue(value1.equals(value2));
    }

    @Test
    public void testInchesEquality_DifferentValue() {

        Inches value1 =
                new Inches(1.0);

        Inches value2 =
                new Inches(2.0);

        assertFalse(value1.equals(value2));
    }

    @Test
    public void testInchesEquality_NullComparison() {

        Inches value1 =
                new Inches(1.0);

        assertFalse(value1.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {

        Inches value1 =
                new Inches(1.0);

        Object obj = "1.0";

        assertFalse(value1.equals(obj));
    }

    @Test
    public void testInchesEquality_SameReference() {

        Inches value1 =
                new Inches(1.0);

        assertTrue(value1.equals(value1));
    }
}