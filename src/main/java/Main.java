import parse.ExpressionTree;

public class Main {


    public static void main(String [] args){


        ExpressionTree t = new ExpressionTree("25*x^2");
        ExpressionTree t1 = new ExpressionTree("sin(x^2) - 5*x");
        ExpressionTree t2 = new ExpressionTree("x^3+5x-1");

        System.out.println(t.getOperationsTree().toString());
        System.out.println(t.getOperationsTree().getDerivative().toString());
        System.out.println(t.getOperationsTree().getDerivative().getNumericValue(2.0).toString());

        System.out.println(t1.getOperationsTree().toString());
        System.out.println(t1.getOperationsTree().getDerivative().toString());
        System.out.println(t1.getOperationsTree().getDerivative().getNumericValue(2.0).toString());

        System.out.println(t2.getOperationsTree().toString());
        System.out.println(t2.getOperationsTree().getDerivative().toString());
        System.out.println(t2.getOperationsTree().getDerivative().getNumericValue(3.0).toString());

    }
}
