import java.util.*;

public class InfixExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an arithmetic expression: ");
        String input = scanner.nextLine();
        List<String> tokens = tokenizeExpression(input);

        // evaluate the expression
        Map<String, Integer> variables = new HashMap<>();
        int result = evaluateExpression(tokens, variables);

        System.out.println("Result of the expression: " + result);
        scanner.close();
    }

    // tokenize the Expression
    public static List<String> tokenizeExpression(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                currentToken.append(c);
            } else if (Character.isLetter(c)) {
                // treat letters as variable names
                currentToken.append(c);
            } else {
                // operators or other characters
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }

        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        return tokens;
    }

    // evaluate the expression
    public static int evaluateExpression(List<String> tokens, Map<String, Integer> variables) {
        Stack<Integer> values = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                values.push(Integer.parseInt(token));
            } else if (isVariable(token)) {
                if (variables.containsKey(token)) {
                    values.push(variables.get(token));
                } else {
                    throw new IllegalArgumentException("Variable '" + token + "' not defined.");
                }
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && hasHigherPrecedence(operators.peek(), token)) {
                    evaluateTop(values, operators);
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            evaluateTop(values, operators);
        }

        if (values.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return values.pop();
    }

    public static boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    public static boolean isVariable(String token) {
        return token.matches("[a-zA-Z]+");
    }

    public static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    public static boolean hasHigherPrecedence(String op1, String op2) {
        int precedence1 = getPrecedence(op1);
        int precedence2 = getPrecedence(op2);
        return precedence1 >= precedence2;
    }

    public static int getPrecedence(String operator) {
        if ("+-".contains(operator)) {
            return 1;
        } else if ("*/".contains(operator)) {
            return 2;
        }
        return 0;
    }

    public static void evaluateTop(Stack<Integer> values, Stack<String> operators) {
        if (values.size() < 2 || operators.isEmpty() || !isOperator(operators.peek())) {
            throw new IllegalArgumentException("Invalid expression");
        }

        int operand2 = values.pop();
        int operand1 = values.pop();
        String operator = operators.pop();

        int result;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        values.push(result);
    }
}
