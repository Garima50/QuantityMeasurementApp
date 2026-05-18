public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

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

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Inner class to represent Inches measurement
    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

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

            Inches other = (Inches) obj;

            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Method for Feet equality demo
    public static void demonstrateFeetEquality() {

        Feet value1 = new Feet(1.0);
        Feet value2 = new Feet(1.0);

        boolean result = value1.equals(value2);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }

    // Method for Inches equality demo
    public static void demonstrateInchesEquality() {

        Inches value1 = new Inches(1.0);
        Inches value2 = new Inches(1.0);

        boolean result = value1.equals(value2);

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    // Main method
    public static void main(String[] args) {

        demonstrateFeetEquality();

        System.out.println();

        demonstrateInchesEquality();
    }
}