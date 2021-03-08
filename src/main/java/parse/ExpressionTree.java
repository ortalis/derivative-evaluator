package parse;

import math.*;
import net.objecthunter.exp4j.tokenizer.FunctionToken;
import net.objecthunter.exp4j.tokenizer.NumberToken;
import net.objecthunter.exp4j.tokenizer.OperatorToken;
import net.objecthunter.exp4j.tokenizer.Token;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;


public class ExpressionTree {

    private String expression;
    private Node root;

    public ExpressionTree(String expression){
        this.expression = expression;
        ExpressionConverter convert  = new ExpressionConverter(expression);
        Token [] tokens = convert.createTokensTree();
        createTree(tokens);
    }

    public Operation getOperationsTree(){
        if(root == null)
            return null;
        return root.value;
    }

    /**
     * Build the operations tree based on the evaluated tokens
     * token is an array of evaluated mathematical expression in a postfix order
     * @param tokens the operations in the tree expression
     * @return the ExpressionTree instance
     * */
    private ExpressionTree createTree(Token [] tokens) {
        Stack<Node> stack = new Stack<Node>();
        Iterator<Token> it = Arrays.asList(tokens).iterator();
        Node newNode;
        try {
            while (it.hasNext()) {
                Token t = it.next();
                int type = t.getType();
                switch (type) {
                    case Token.TOKEN_NUMBER:
                        newNode = new Node(new Constant("" + ((NumberToken) t).getValue()));
                        stack.push(newNode);
                        break;

                    case Token.TOKEN_VARIABLE:
                        newNode = new Node(new Variable());
                        stack.push(newNode);
                        break;

                    case Token.TOKEN_OPERATOR:
                        Node ptr1 = stack.pop();
                        Node ptr2 = stack.pop();
                        newNode = getOperator(t, ptr2, ptr1);
                        newNode.left = ptr2;
                        newNode.right = ptr1;
                        stack.push(newNode);
                        break;

                    case Token.TOKEN_FUNCTION:
                        Node t1 = stack.pop();
                        newNode = getFunction(t, t1);
                        stack.push(newNode);
                        break;

                    default:
                        break;
                }
            }
            root = stack.pop();
        }catch (ParseTreeException e){
                e.printStackTrace();
        }
        return this;
    }

    private Node getOperator(Token t, Node t1, Node t2) throws ParseTreeException {
        switch (((OperatorToken)t).getOperator().getSymbol()) {
            case "+":	return new Node(new Addition(t1.value, t2.value));
            case "-":	return new Node(new Subtract(t1.value, t2.value));
            case "*":	return new Node(new Multiply(t1.value, t2.value));
            case "/":	return new Node( new Division(t1.value, t2.value));
            case "^":	return new Node(new Power(t1.value, t2.value));
            default: throw new ParseTreeException("Illegal operator token found");
        }
    }

    private Node getFunction(Token t, Node t1) throws ParseTreeException {
        switch (((FunctionToken)t).getFunction().getName()) {
            case "sin":	return new Node(new Sin(t1.value));
            case "cos":	return new Node(new Cos(t1.value));
            default: throw new ParseTreeException("Illegal Function token found");
        }
    }

}
class Node {
    Operation value;
    Node left, right;

    Node(Operation item) {
        value = item;
        left = right = null;
    }
}

