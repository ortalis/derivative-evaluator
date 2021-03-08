package parse;

import math.*;

public class BinaryOperationFactory extends AbstractFactory {
    @Override
    Operation getOperation(OperationArguments args) {
        BinaryOperationArguments arg = (BinaryOperationArguments) args;
            String symbol = arg.symbol;
            if(symbol.equals("+"))
                return new Addition(arg.left,arg.right);
            else if (symbol.equals("-"))
                return new Subtract(arg.left,arg.right);
            else if(symbol.equals("*"))
                return new Multiply(arg.left,arg.right);
            else if(symbol.equals("/"))
                return new Division(arg.left,arg.right);
            else if(symbol.equals("^"))
                return new Power(arg.left,arg.right);
            return null;
        }
}
