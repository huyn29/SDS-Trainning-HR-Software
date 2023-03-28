import Service.DepartmentService;
import Service.EmployeeService;
import Service.InputService;
import Service.LoginService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EmployeeService emps = new EmployeeService();
        DepartmentService deps = new DepartmentService();
        boolean condition = false;
        while (true) {
            System.out.println("* * * * * * * * * * * ** * * * * * * * * * * * * * *");
            System.out.println("              Wellcome to HRSoftware");
            System.out.println("* * * * * * * * * * * ** * * * * * * * * * * * * * *");
            while (!condition) {
                // Chuôi có nhiều nhất 10 kí tự
                System.out.printf("Enter your user: ");
                String userType = InputService.InputUser();
                System.out.println();
                // Tối thiểu tám ký tự, ít nhất một chữ cái và một số
                System.out.printf("Enter your password: ");
                String passType = InputService.InputPass();
                if (LoginService.Login(userType, passType)) {
                    System.out.println("* * * * * * * * * * * ** * * * * * * * * * * * * * *");
                    System.out.println("*                Login successfull                 *");
                    System.out.println("* * * * * * * * * * * ** * * * * * * * * * * * * * *");
                    System.out.println();
                    condition = true;
                } else {
                    System.out.println("* * * * * * * * * * * ** * * * * * * * * * * * * * *");
                    System.out.println("*           Wrong account. Try again.              *");
                    System.out.println("* * * * * * * * * * * ** * * * * * * * * * * * * * *");
                }
            }
            while (condition) {
                System.out.println();
                System.out.println("* * * * * * * * * * * * MENU * * * * * * * * * * * *");
                System.out.println(" 1:  Managenrment Employees                        *");
                System.out.println(" 2:  Managenrment Department                       *");
                System.out.println(" 3:  Statiѕtic                                     *");
                System.out.println(" 4:  Logout                                        *");
                System.out.println("* * * * * * * * * * * ** * * * * * * * * * * * * * *");
                System.out.println();
                System.out.printf("Your Choose: ");
                int i1 = InputService.InputInteger();
                switch (i1) {
                    case 1: {
                        while (true){
                            System.out.println("--------------------------------");
                            System.out.println("1: Add new employee");
                            System.out.println("2: Update information");
                            System.out.println("3: Delete employee");
                            System.out.println("4: Find employees");
                            System.out.println("5: Calculate the tax");
                            System.out.println("6: Exit");
                            System.out.println("--------------------------------");
                            System.out.printf("Your Choose: ");
                            int i2 = InputService.InputInteger();
                            switch (i2) {
                                case 1: {
                                    emps.addNewEmp();
                                    break;
                                }
                                case 2: {
                                    emps.updateEmp();
                                    break;
                                }
                                case 3: {
                                    emps.deleteEmp();
                                    break;
                                }
                                case 4: {
                                    emps.FindAll();
                                    break;
                                }
                                case  5:{
                                    emps.calculateTAX();
                                    break;
                                }
                                case  6:{
                                    break;
                                }
                                default: {
                                    System.out.println("Wrong enter. Try again");
                                    continue;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    case 2: {
                        while (true){
                            System.out.println("--------------------------------");
                            System.out.println("1: Add new Department");
                            System.out.println("2: Update information");
                            System.out.println("3: Delete Department");
                            System.out.println("4: Add/delete employee in departmet");
                            System.out.println("5: Choose department manager");
                            System.out.println("6: Move department for employee");
                            System.out.println("7: Exit");
                            System.out.println("--------------------------------");
                            System.out.printf("Your Choose: ");
                            int i2 = InputService.InputInteger();
                            switch (i2) {
                                case 1: {
                                    deps.addNewDep();
                                    break;
                                }
                                case 2: {
                                    deps.updateDep();
                                    break;
                                }
                                case 3: {
                                    deps.deleteDep();
                                    break;
                                }
                                case 4: {
                                    emps.AddDeleteDepartment();
                                    break;
                                }
                                case 5:{
                                    emps.chooseDepManager();
                                    break;
                                }
                                case 6:{
                                    emps.MoveDepartment();
                                    break;
                                }
                                case 7:{
                                    break;
                                }
                                default: {
                                    System.out.println("Wrong enter. Try again");
                                    continue;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    case 3: {
                        emps.Statiѕtic();
                        break;
                    }
                    case 4: {
                        System.out.println("Exit");
                        condition = false;
                        break;
                    }
                    default: {
                        System.out.println("Wrong enter. Try again.");
                        continue;
                    }
                }
            }
        }
    }
}
