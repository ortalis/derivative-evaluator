package math;

public class Power extends BinaryOperation {

    public Power(Operation left, Operation right) {
        super(left, right);
    }

    public Operation getLeft() {
        return left;
    }

    public Operation getRight() {
        return right;
    }

    public Double getNumericValue(Double val) {
        return Math.pow(left.getNumericValue(val), right.getNumericValue(val));
    }

    public Operation getDerivative() {

        return new Multiply(new Multiply(right, new Power(left, new Constant(String.valueOf(Double.valueOf(right.toString()) - 1)))), left.getDerivative());
    }

    public String toString() {

        return '(' + left.toString() + ")^(" + right.toString() + ')';
    }
}
