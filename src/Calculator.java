import java.util.Scanner;
public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // This is a loop that runs until the user enters invalid input
        while (true) {
            // Message to user
            System.out.println("Enter an arithmetic expression with two or three numbers and one of the operators +, -, *, / ");
            // Stores the arithmetic expression the user entered into a string named input
            String input = scanner.nextLine();
            // Splits input into parts and stores them into an array named parts
            String[] parts = input.split(" ");
            // Checks if input consists of 2 or 3 numbers
            if (parts.length == 3 || parts.length == 5) {
                // Stores first number as an integer
                int num1 = Integer.parseInt(parts[0]);
                // Stores second number as an integer
                int num2 = Integer.parseInt(parts[2]);
                //Stores first operator into a char
                char op1 = parts[1].charAt(0);
                // Store third number or zero otherwise
                int num3 = parts.length == 5 ? Integer.parseInt(parts[4]) : 0;
                // Store second operator as a char or ' ' otherwise
                char op2 = parts.length == 5 ? parts[3].charAt(0) : ' ';
                // Stores the result of the operation
                int result = 0;
                // Checks if the numbers are between 1 and 10
                if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10 && (num3 == 0 || (num3 >= 1 && num3 <= 10))) {
                    // Checks if there is a third number and a second operator
                    if (num3 != 0 && op2 != ' ') {
                        // Checks if the first operator is addition or subtraction
                        if (op1 == '+' || op1 == '-') {
                            //Calculates first two numbers
                            result = calculate(num1, num2, op1);
                            //Calculates result with third number
                            result = calculate(result, num3, op2);
                            //Checks if the first operator is multiplication or division
                        } else if (op1 == '*' || op1 == '/') {
                            //Calculates with the second two numbers and the second operator
                            result = calculate(num2, num3, op2);
                            //Calculates the first number and the result with the first operator
                            result = calculate(num1, result, op1);
                            //If first operator not valid
                        } else {
                            System.out.println("Invalid operator: " + op1);
                            System.exit(0);
                        }
                        //No third number, no second operator
                    } else {
                        result = calculate(num1, num2, op1);
                    }
                    //Prints result
                    System.out.println("The result is " + result);
                    // When the numbers are not between 1 and 10
                } else {
                    System.out.println("Invalid numbers: " + num1 + ", " + num2 + ", " + num3);
                    System.exit(0);
                }
                //When the input does not have two or three numbers
            } else {
                // This is a message that prints an error to the console
                System.out.println("Invalid input: " + input);
                System.exit(0);
                scanner.close();
            }
        }
    }

    // For two numbers
    public static int calculate(int num1, int num2, char operator) {
        // This is an int variable that stores the result of the operation
        int result = 0;
        //Performs different operations based on the operator
        switch (operator) {
            //Addition operation
            case '+':
                result = num1 + num2;
                break;
            //Subtraction operation
            case '-':
                result = num1 - num2;
                break;
            //Multiplication operation
            case '*':
                result = num1 * num2;
                break;
            //Division operation
            case '/':
                result = num1 / num2;
                break;
            //When the operator is not valid
            default:
                System.out.println("Invalid operator: " + operator);
                System.exit(0);
        }
        //Result
        return result;
    }


}