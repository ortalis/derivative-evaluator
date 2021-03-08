package parse;

import net.objecthunter.exp4j.operator.Operator;
import net.objecthunter.exp4j.shuntingyard.ShuntingYard;
import net.objecthunter.exp4j.function.*;
import net.objecthunter.exp4j.tokenizer.Token;

import java.util.*;


public class ExpressionConverter {

    private String expression;
    private Map<String, Function> functions;
    private Map<String, Operator> operators;
    private Set<String> variableNames;


    public ExpressionConverter(String expression){
        this.expression = expression;
        this.operators = new HashMap<String, Operator>(4);
        this.functions = new HashMap<String, Function>(4);
        this.variableNames = new HashSet<String>(Arrays.asList("x"));
    }

    public Token [] createTokensTree(){
        Token[] tokens = ShuntingYard.convertToRPN(expression, functions, operators,
                variableNames, true);
        return tokens;

    }
}
