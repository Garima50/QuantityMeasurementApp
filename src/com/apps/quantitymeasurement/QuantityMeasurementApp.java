
package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {

        // Immutable value
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        /**
         * Override equals() method to compare Feet objectss
         */
        @Override
        public boolean equals(Object obj) {

            // Reference check
            if (this == obj) {
                return true;
            }

            // Null check
            if (obj == null) {
                return false;
            }

            // Type check
            if (getClass() != obj.getClass()) {
                return false;
            }

            // Safe casting
            Feet other = (Feet) obj;

            // Compare double values safely
            return Double.compare(this.value, other.value) == 0;
        }

        /**
         * Override hashCode() for consistency with equals()
         */
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method
    public static void main(String[] args) {

        Feet value1 = new Feet(1.0);
        Feet value2 = new Feet(1.0);

        boolean result = value1.equals(value2);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }
}