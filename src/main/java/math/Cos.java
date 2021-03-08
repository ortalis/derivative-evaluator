package math;

public class Cos extends UnaryOperation {

    public Cos(Operation op) {

        super(op);
    }

    public Double getNumericValue(Double val) {

        return Math.cos(op.getNumericValue(val));
    }

    public Operation getDerivative() {
        return new Negate(new Multiply(new Sin(op), op.getDerivative()));
    }

    public String toString() {
        return "cos(" + op.toString() + ')';
    }

}