package parse;

import math.Cos;
import math.Operation;
import math.Sin;

public class UnaryOperationFactory extends AbstractFactory {
    @Override
    Operation getOperation(OperationArguments args) {
        UnaryOperationArguments arg = (UnaryOperationArguments) args;
        String symbol = arg.symbol;
        if(symbol.equalsIgnoreCase("sin"))
             return new Sin(arg.op);
        else if (symbol.equalsIgnoreCase("cos"))
            return new Cos(arg.op);
        return null;
    }
}
