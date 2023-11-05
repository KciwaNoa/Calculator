import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("throws Exception");
        }
    }

    public static String calc(String input) throws Exception {
        String[] tokens = input.split("\\s+");
        if (tokens.length != 3) {
            throw new Exception("Invalid input");
        }

        int operand1;
        int operand2;
        try {
            operand1 = Integer.parseInt(tokens[0]);
            operand2 = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid numbers");
        }
        if (operand1 < 1 || operand2 > 10 || operand2 < 1 || operand1 > 10) {
            throw new Exception("Numbers out of range");
        }
        String operator = tokens[1];
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
                    throw new Exception("Division by zero");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new Exception("Invalid operator");
        }

        return String.valueOf(result);
    }
}