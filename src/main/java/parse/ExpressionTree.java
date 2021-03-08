package parse;

import exception.ParseTreeException;
import math.Operation;
import net.objecthunter.exp4j.tokenizer.FunctionToken;
import net.objecthunter.exp4j.tokenizer.NumberToken;
import net.objecthunter.exp4j.tokenizer.OperatorToken;
import net.objecthunter.exp4j.tokenizer.Token;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;


public class ExpressionTree {

    private String expression;
    private Node root;

    public ExpressionTree(String expression) {
        this.expression = expression;
        ExpressionConverter convert = new ExpressionConverter(expression);
        Token[] tokens = convert.createTokensTree();
        createTree(tokens);
    }

    public Operation getOperationsTree() {
        if (root == null)
            return null;
        return root.value;
    }

    /**
     * Build the operations tree based on the evaluated tokens
     * token is an array of evaluated mathematical expression in a postfix order
     *
     * @param tokens the operations in the tree expression
     * @return the ExpressionTree instance
     */
    private ExpressionTree createTree(Token[] tokens) {
        Stack<Node> stack = new Stack<Node>();
        Iterator<Token> it = Arrays.asList(tokens).iterator();
        Node newNode;
        try {
            while (it.hasNext()) {
                Token t = it.next();
                int type = t.getType();
                switch (type) {
                    case Token.TOKEN_NUMBER:
                        newNode = getSimpleOperation(String.valueOf(((NumberToken) t).getValue()));
                        stack.push(newNode);
                        break;

                    case Token.TOKEN_VARIABLE:
                        newNode = getSimpleOperation("x");
                        stack.push(newNode);
                        break;

                    case Token.TOKEN_OPERATOR:
                        Node ptr1 = stack.pop();
                        Node ptr2 = stack.pop();
                        newNode = getOperator(t, ptr2.value, ptr1.value);
                        newNode.left = ptr2;
                        newNode.right = ptr1;
                        stack.push(newNode);
                        break;

                    case Token.TOKEN_FUNCTION:
                        Node t1 = stack.pop();
                        newNode = getFunction(t, t1.value);
                        stack.push(newNode);
                        break;

                    default:
                        break;
                }
            }
            root = stack.pop();
        }catch (ParseTreeException ex){
          ex.printStackTrace();
        }
        return this;

    }


    private Node getSimpleOperation(String symbol) throws ParseTreeException {
        SimpleOperationArguments args = new SimpleOperationArguments(symbol);
        SimpleOperationFactory factory = new SimpleOperationFactory();
        Operation operation = factory.getOperation(args);
        if(operation == null)
            throw new ParseTreeException("Issue occurred while simple operation");
        return new Node(operation);
    }

    private Node getOperator(Token t, Operation op1, Operation op2) throws ParseTreeException {
        BinaryOperationArguments args = new BinaryOperationArguments(((OperatorToken) t).getOperator().getSymbol(), op1, op2);
        BinaryOperationFactory factory = new BinaryOperationFactory();
        Operation operation = factory.getOperation(args);
        if(operation == null)
            throw new ParseTreeException("Issue occurred while parsing operator operation");
        return new Node(operation);
    }

    private Node getFunction(Token t, Operation op) throws ParseTreeException {
        UnaryOperationArguments args = new UnaryOperationArguments(((FunctionToken) t).getFunction().getName(), op);
        UnaryOperationFactory factory = new UnaryOperationFactory();
        Operation operation = factory.getOperation(args);
        if(operation == null)
            throw new ParseTreeException("Issue occurred while parsing function operation");
        return new Node(operation);
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

