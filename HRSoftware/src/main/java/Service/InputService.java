package Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputService {
    static Scanner scanner = new Scanner(System.in);

    public static int InputInteger() {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number < 0) {
                    throw new Exception("Input number must be greater than 0. Try again.");
                }
                validInput = true;
            } catch (NumberFormatException e1) {
                System.out.println("Input must be an integer. Try again.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return number;
    }
    public static String InputString(){
        String string = "";
        string = scanner.nextLine();
        return string;
    }
    public static double InputDouble() {
        double number = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number <= 0) {
                    System.out.println("*************************************");
                    throw new Exception("Input number must be greater than 0.");
                }
                validInput = true;
            } catch (NumberFormatException e1) {
                System.out.println("*************************************");
                System.out.println("Input must be an double");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return number;
    }
}
