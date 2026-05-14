import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
//tests
    @Test
    public void testFeetEquality_SameValue() {

        QuantityMeasurementApp.Feet value1 =
                new QuantityMeasurementApp.Feet(1.0);

        QuantityMeasurementApp.Feet value2 =
                new QuantityMeasurementApp.Feet(1.0);

        assertTrue(value1.equals(value2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {

        QuantityMeasurementApp.Feet value1 =
                new QuantityMeasurementApp.Feet(1.0);

        QuantityMeasurementApp.Feet value2 =
                new QuantityMeasurementApp.Feet(2.0);

        assertFalse(value1.equals(value2));
    }

    @Test
    public void testFeetEquality_NullComparison() {

        QuantityMeasurementApp.Feet value1 =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(value1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {

        QuantityMeasurementApp.Feet value1 =
                new QuantityMeasurementApp.Feet(1.0);

        Object obj = "1.0";
        assertFalse(value1.equals(obj));
    }

    @Test
    public void testFeetEquality_SameReference() {

        QuantityMeasurementApp.Feet value1 =
                new QuantityMeasurementApp.Feet(1.0);

        assertTrue(value1.equals(value1));
    }
}