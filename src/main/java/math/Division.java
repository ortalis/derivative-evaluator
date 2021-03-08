package math;

public class Division extends BinaryOperation {

    public Division(Operation left, Operation right) {

        super(left, right);
    }

    public Operation getLeft(){

        return left;
    }

    public Operation getRight(){

        return right;
    }

    public Double getNumericValue(Double val) {

        return left.getNumericValue(val) / right.getNumericValue(val);
    }

    public Operation getDerivative() {
        Operation numerator = new Subtract(new Multiply(left.getDerivative(),right),new Multiply(left, right.getDerivative()));
        Operation denominator = new Power(right, new Constant("2"));
        return new Division(numerator,denominator);
    }

    public String toString(){

        return '('+left.toString() +'/'+ right.toString()+')';
    }
}
