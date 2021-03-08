package math;

public class Sin extends UnaryOperation {

    public Sin(Operation op) {

        super(op);
    }

    public Double getNumericValue(Double val) {

        return Math.sin(op.getNumericValue(val));
    }

    public Operation getDerivative() {
        return new Multiply(new Cos(op),op.getDerivative());
    }

    public String toString(){

        return "sin("+op.toString()+")";
    }
}
