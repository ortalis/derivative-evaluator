package math;

public class Subtract extends BinaryOperation {
    public Subtract(Operation left, Operation right) {
        super(left, right);
    }

    public Operation getLeft() {

        return left;
    }

    public Operation getRight() {

        return right;
    }

    public Double getNumericValue(Double val) {

        return left.getNumericValue(val) - right.getNumericValue(val);
    }

    public Operation getDerivative() {

        return new Subtract(left.getDerivative(), right.getDerivative());
    }

    public String toString() {

        return '(' + left.toString() + '-' + right.toString() + ')';
    }
}
