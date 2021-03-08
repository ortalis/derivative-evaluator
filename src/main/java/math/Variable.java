package math;

public class Variable implements Operation {

    public Double getNumericValue(Double val) {
        return val;
    }

    public Operation getDerivative() {
        return new Constant("1");
    }

    public String toString() {

        return "x";
    }
}
