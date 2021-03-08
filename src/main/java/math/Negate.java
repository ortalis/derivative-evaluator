package math;

public class Negate extends UnaryOperation {

    public Negate(Operation op) {

        super(op);
    }

    public Double getNumericValue(Double val) {

        return -op.getNumericValue(val);
    }

    public Operation getDerivative() {
        return new Negate(op.getDerivative());
    }

    public String toString() {

        return "-" + op.toString();
    }
}
