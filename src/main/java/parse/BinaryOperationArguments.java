package parse;

import math.Operation;

public class BinaryOperationArguments implements OperationArguments {
    protected String symbol;
    protected Operation left;
    protected Operation right;

    public BinaryOperationArguments(String symbol, Operation left, Operation right){
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }
}
