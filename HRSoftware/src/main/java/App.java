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
            System.out.println("Wellcome to HRSoftware");
            while (!condition) {
                if (LoginService.Login() == true) {
                    System.out.println("Login successfull");
                    System.out.println();
                    condition = true;
                }
            }
            while (condition) {
                System.out.println();
                System.out.println("* * * * * * * * * * * * MENU * * * * * * * * * * * *");
                System.out.println(" 1: Add/Update/Delete for information employees    *");
                System.out.println(" 2: Add/Update/Delete for information departments  *");
                System.out.println(" 3: Find employee                                  *");
                System.out.println(" 4: Add/delete employee in departmet               *");
                System.out.println(" 5: Choose department manager                      *");
                System.out.println(" 6: Move department for employee                   *");
                System.out.println(" 7: Calculate the tax                              *");
                System.out.println(" 8: Statiѕtic                                      *");
                System.out.println(" 9: Exit                                           *");
                System.out.println("* * * * * * * * * * * ** * * * * * * * * * * * * * *");
                System.out.println();
                System.out.printf("Your Choose: ");
                int i1 = InputService.InputInteger();
                switch (i1) {
                    case 1: {
                        System.out.println("--------------------------------");
                        System.out.println("1: Add new employee");
                        System.out.println("2: Update information");
                        System.out.println("3: Delete employee");
                        System.out.println("4: Exit");
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
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("--------------------------------");
                        System.out.println("1: Add new Department");
                        System.out.println("2: Update information");
                        System.out.println("3: Delete Department");
                        System.out.println("4: Exit");
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
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        emps.FindAll();
                        break;
                    }
                    case 4: {
                        emps.AddDeleteDepartment();
                        break;
                    }
                    case 5: {
                        emps.chooseDepManager();
                        break;
                    }
                    case 6: {
                        emps.MoveDepartment();
                        break;
                    }
                    case 7: {
                        emps.calculateTAX();
                        break;
                    }
                    case 8: {
                        emps.Statiѕtic();
                        break;
                    }
                    case 9: {
                        System.out.println("Exit");
                        condition = false;
                        break;
                    }
                    default:{
                        System.out.println("Wrong enter. Try again.");
                    }
                }
            }
        }
    }
}
