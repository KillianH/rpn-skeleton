package rpn;

import rpn.exceptions.InvalidOperation;
import rpn.exceptions.InvalidOperator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static void main(String[] args) throws InvalidOperation, InvalidOperator {
        if(args.length == 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your RPN expression :");
            String expression = sc.nextLine();
            process(expression);
        }else if(args.length == 1 && args[0].compareTo("--help") != 0){
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

                String line;
                while ((line = br.readLine()) != null) {
                    process(line);
                }

            } catch (IOException e) {
                System.out.println("Error trying to parse the file specified");
                e.printStackTrace();
            }
        }else if(args.length == 1 && args[0].compareTo("--help") == 0){
            System.out.println(
                    "RPN Expression evaluator\n" +
                            "Without arguments you will be prompted to enter an expression\n" +
                            "--help - show this explanation text\n" +
                            "randomfile.txt - evaluate each line of the file\n" +
                            "3 5 + - evaluate the given expression"
            );
        }else{
            process(Stream.of(args).collect(Collectors.joining(" ")));
        }
    }

    private static void process(String expression) throws InvalidOperator, InvalidOperation {
        System.out.println("About to evaluate '" + expression + "'");
        Calculator calculator = new Calculator();
        String result = calculator.calculate(expression);
        System.out.println("> " + result);
    }
}