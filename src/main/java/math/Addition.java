package math;

public class Addition extends BinaryOperation {

    public Addition(Operation left, Operation right) {
        super(left, right);
    }

    public Operation getLeft() {
        return left;
    }

    public Operation getRight() {
        return right;
    }

    public Double getNumericValue(Double val) {
        return left.getNumericValue(val) + right.getNumericValue(val);
    }

    public Operation getDerivative() {
        return new Addition(left.getDerivative(), right.getDerivative());
    }

    public String toString() {

        return '(' + left.toString() + '+' + right.toString() + ')';
    }
}
