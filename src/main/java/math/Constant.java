package math;

public class Constant implements Operation {
    private String c;

    public Constant(String c) {

        this.c = c;
    }

    public String toString() {

        return c;
    }

    public Double getNumericValue(Double val) {

        return Double.parseDouble(c);
    }

    public Operation getDerivative() {
        return new Constant("0");
    }
}
