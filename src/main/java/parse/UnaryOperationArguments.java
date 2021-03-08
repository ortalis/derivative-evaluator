package parse;

import math.Operation;

public class UnaryOperationArguments implements OperationArguments {

    protected String symbol;
    protected Operation op;

    public UnaryOperationArguments(String symbol, Operation op){
        this.symbol = symbol;
        this.op = op;
    }
}
