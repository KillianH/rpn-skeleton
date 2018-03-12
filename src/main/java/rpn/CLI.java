package rpn;

import rpn.exceptions.InvalidExpression;
import rpn.exceptions.WrongOperatorException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static void main(String[] args) throws WrongOperatorException, InvalidExpression {
        if(args.length == 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your RPN expression :");
            args = sc.nextLine().split(" ");
            process(args);
        }else if(args.length == 1 && args[0].compareTo("--help") != 0){
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

                String line;
                while ((line = br.readLine()) != null) {
                    process(line.split(" "));
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
            process(args);
        }
    }

    private static void process(String[] array) throws InvalidExpression, WrongOperatorException {
        String expression = Stream.of(array).collect(Collectors.joining(" "));
        System.out.println("About to evaluate '" + expression + "'");
        Evaluator evaluator = new Evaluator();
        double result = evaluator.evaluate(array);
        System.out.println("> " + result);
    }
}
