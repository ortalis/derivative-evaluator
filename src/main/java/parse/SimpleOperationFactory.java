package parse;

import math.Constant;
import math.Operation;
import math.Variable;

public class SimpleOperationFactory extends AbstractFactory{
    @Override
    Operation getOperation(OperationArguments args) {
        SimpleOperationArguments arg = (SimpleOperationArguments)args;
        String symbol = arg.symbol;
        if(symbol.equals("x"))
            return new Variable();
        else return new Constant(symbol);
    }


}
