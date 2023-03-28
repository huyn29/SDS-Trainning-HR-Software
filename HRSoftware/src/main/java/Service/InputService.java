package Service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static  String InputPass(){
        String string = "";
        boolean cond = true;
        while (cond){
            string = scanner.nextLine();
            String pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(string);
            if( matcher.matches()==true){
                cond = false;
            }else {
                System.out.println("wrong format. Try again");
            }
        }
        return string;
    }
    public static  String InputEmail(){
        String string = "";
        boolean cond = true;
        while (cond){
            string = scanner.nextLine();
            String pattern = "^[\\w+\\-.]+@[a-z\\d\\-]+(\\.[a-z\\d\\-]+)*\\.[a-z]+$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(string);
            if( matcher.matches()==true){
                cond = false;
            }else {
                System.out.println("wrong format. Try again");
            }
        }
        return string;
    }
    public static  String InputUser(){
        String string = "";
        boolean cond = true;
        while (cond){
            string = scanner.nextLine();
            String pattern = "^.{1,10}$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(string);
            if( matcher.matches()==true){
                cond = false;
            }else {
                System.out.println("wrong format. Try again");
            }
        }
        return string;
    }
    public static  String InputPhone(){
        String string = "";
        boolean cond = true;
        while (cond){
            string = scanner.nextLine();
            String phoneNumberPattern = "^\\d{10}$";
            Pattern pattern = Pattern.compile(phoneNumberPattern);
            Matcher matcher = pattern.matcher(string);
            if( matcher.matches()==true){
                cond = false;
            }else {
                System.out.println("wrong format. Try again");
            }
        }
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
