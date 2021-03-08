package parse;

import math.Operation;

public abstract class AbstractFactory {
    abstract Operation getOperation(OperationArguments args) ;

}
