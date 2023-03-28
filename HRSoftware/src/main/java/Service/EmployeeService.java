package Service;

import DAO.DepartmentDAO;
import DAO.EmployeeDAO;
import Model.Department;
import Model.Employee;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeService {
    List<Employee> empList;
    List<Department> depList;

    public EmployeeService() {
        empList = new ArrayList<>();
        depList = new ArrayList<>();
    }

    public void detail(boolean cond1, boolean cond2) {

    }

    public void addNewEmp() {
        List<Employee> temp = new ArrayList<>();
        while (true) {
            boolean cond1 = false;
            boolean cond2 = false;
            System.out.println("--------------------------------");
            System.out.println("Enter number employee for add.");
            System.out.println("Enter 0 to Exit.");
            System.out.println("--------------------------------");
            System.out.printf("Your choose: ");
            int n = InputService.InputInteger();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                temp = EmployeeDAO.getInstance().SelectAll();
                System.out.println("--------------------------------");
                System.out.printf("Enter name: ");
                String name = InputService.InputString();
                System.out.printf("Enter phone: ");
                String phone = InputService.InputPhone();
                System.out.printf("Enter email: ");
                String email = InputService.InputEmail();
                System.out.printf("Enter salary: ");
                double salary = InputService.InputDouble();
                System.out.println("--------------------------------");
                for (Employee t : temp) {
                    if (t.getEmail().equals(email) == true) {
                        cond1 = true;
                    }
                    if (t.getEmpPhone().equals(phone) == true) {
                        cond2 = true;
                    }
                }
                if (cond1 == false && cond2 == false) {
                    Employee ex = new Employee(name, phone, email, salary);
                    EmployeeDAO.getInstance().Insert(ex);
                } else if (cond1 == true && cond2 == false) {
                    System.out.println("This email already exists. Try again");
                } else if (cond1 == false && cond2 == true) {
                    System.out.println("This phone already exists. Can not add employee");
                } else {
                    System.out.println("This phone and email already exists. Can not add employee");
                }
                temp.clear();
            }
        }
    }

    public void updateEmp() {
        List<Employee> temp = new ArrayList<>();
        boolean cond = true;
        boolean x = false;
        while (true) {
            empList = EmployeeDAO.getInstance().SelectAll();
            empList.forEach(e-> System.out.println(e.printfInfor()));
            empList.clear();
            System.out.println("--------------------------------");
            System.out.println("Enter employee ID for update");
            System.out.println("Enter 0 to Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your choose: ");
            int id = InputService.InputInteger();
            if (id == 0) {
                break;
            }
            temp = EmployeeDAO.getInstance().selectByConditon("empID", id, 2);
            empList = EmployeeDAO.getInstance().SelectAll();
            if (temp.size() != 0) {
                System.out.println(temp.get(0).printfInfor());
                cond = true;
            } else {
                System.out.println("Employee not exist");
                cond = false;
            }
            while (cond) {
                System.out.println("--------------------------------");
                System.out.println("1. Update the name.");
                System.out.println("2. Update the phone.");
                System.out.println("3. Update the email.");
                System.out.println("4. Update the salary.");
                System.out.println("5. Update the Manager.");
                System.out.println("6. Exit.");
                System.out.println("--------------------------------");
                System.out.printf("Your Choose: ");
                int choose = InputService.InputInteger();
                switch (choose) {
                    case 1:
                        System.out.printf("New name: ");
                        String newName = InputService.InputString();
                        EmployeeDAO.getInstance().Update("empName", newName, id, 1);
                        break;
                    case 2:
                        System.out.printf("New Phone: ");
                        String newPhone = InputService.InputPhone();
                        for (Employee t : empList) {
                            if (t.getEmpPhone().equals(newPhone) == true) {
                                x = true;
                            }
                        }
                        if (x == false) {
                            EmployeeDAO.getInstance().Update("empPhone", newPhone, id, 1);

                        } else {
                            System.out.println("This phone already exists. Try again");
                            x = false;
                        }
                        break;
                    case 3:
                        System.out.printf("New email: ");
                        String newEmail = InputService.InputEmail();
                        for (Employee t : empList) {
                            if (t.getEmail().equals(newEmail) == true) {
                                x = true;
                            }
                        }
                        if (x == false) {
                            EmployeeDAO.getInstance().Update("email", newEmail, id, 1);
                        } else {
                            System.out.println("This email already exists. Try again");
                            x = false;
                        }
                        break;
                    case 4:
                        System.out.printf("New salary: ");
                        double newSalary = InputService.InputDouble();
                        EmployeeDAO.getInstance().Update("salary", newSalary, id, 3);
                        break;
                    case 5:
                        System.out.printf("New Manager: ");
                        int newManagerID = InputService.InputInteger();
                        EmployeeDAO.getInstance().Update("managerID", newManagerID, id, 2);
                        break;
                    case 6: {
                        cond = false;
                        empList.clear();
                        break;
                    }
                    default: {
                        System.out.println("Wrong enter.Try again.");
                        continue;
                    }
                }
            }
        }
    }

    public void deleteEmp() {
        boolean cond = true;
        while (cond) {
            List<Employee> temp = new ArrayList<>();
            List<Department> temp2 = new ArrayList<>();
            System.out.println("--------------------------------");
            System.out.println("1: Delete by ID");
            System.out.println("2: Delete by name");
            System.out.println("3: Delete by phone");
            System.out.println("4: Delete by email");
            System.out.println("5: Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your Choose: ");
            int i1 = InputService.InputInteger();
            switch (i1) {
                case 1: {
                    empList = EmployeeDAO.getInstance().SelectAll();
                    empList.forEach(e-> System.out.println(e.printfInfor()));
                    empList.clear();
                    System.out.println("--------------------------------");
                    System.out.printf("Enter the ID: ");
                    int id = InputService.InputInteger();
                    System.out.println("--------------------------------");
                    temp = EmployeeDAO.getInstance().selectByConditon("empID", id, 2);
                    if (temp.size() != 0) {
                        int depID = temp.get(0).getDepID();
                        temp2 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                        System.out.println(temp.get(0).printfInfor());
                        System.out.println("--------------------------------");
                        System.out.println("Do you want delete - 1:yes/2:No");
                        System.out.println("--------------------------------");
                        System.out.printf("Your Choose: ");
                        int choose = InputService.InputInteger();
                        if (choose == 1) {
                            EmployeeDAO.getInstance().Delete("empID", id, 2);
                            if (temp2.size() != 0) {
                                System.out.println("This employee manager of " + temp2.get(0).getDepName() + " department");
                                DepartmentDAO.getInstance().Update("depManagerID", "", depID, 4);
                            }
                            temp.clear();
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Employee not exist");
                        break;
                    }
                }
                case 2: {
                    empList = EmployeeDAO.getInstance().SelectAll();
                    empList.forEach(e-> System.out.println(e.printfInfor()));
                    empList.clear();
                    System.out.println("--------------------------------");
                    System.out.printf("Enter the name: ");
                    String name = InputService.InputString();
                    System.out.println("--------------------------------");
                    temp = EmployeeDAO.getInstance().selectByConditon("empName", name, 1);
                    if (temp.size() != 0) {
                        int count = 0;
                        for (Employee em : temp) {
                            System.out.printf("Case %d:  ", count);
                            System.out.println(em.printfInfor());
                            count++;
                        }
                        System.out.printf("Enter number of case you want to delete: ");
                        int x = InputService.InputInteger();
                        if (x < count) {
                            int depID = temp.get(x).getDepID();
                            int id = temp.get(x).getEmpID();
                            temp2 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                            System.out.println("--------------------------------");
                            System.out.println("Do you want delete - 1:yes/2:No");
                            System.out.println("--------------------------------");
                            System.out.printf("Your Choose: ");
                            int choose = InputService.InputInteger();
                            if (choose == 1) {
                                EmployeeDAO.getInstance().Delete("empName", name, 1);
                                if (temp2.size() != 0) {
                                    System.out.println("This employee manager of " + temp2.get(0).getDepName() + " department");
                                    DepartmentDAO.getInstance().Update("depManagerID", "", depID, 4);
                                }
                                temp.clear();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("Unable to perform this action.You entered wrong. Try again.");
                            break;
                        }
                    } else {
                        System.out.println("Employee not exist");
                        break;
                    }
                }

                case 3: {
                    empList = EmployeeDAO.getInstance().SelectAll();
                    empList.forEach(e-> System.out.println(e.printfInfor()));
                    empList.clear();
                    System.out.println("--------------------------------");
                    System.out.printf("Enter the phone: ");
                    String phone = InputService.InputPhone();
                    System.out.println("--------------------------------");
                    temp = EmployeeDAO.getInstance().selectByConditon("empPhone", phone, 1);
                    if (temp.size() != 0) {
                        int depID = temp.get(0).getDepID();
                        int id = temp.get(0).getEmpID();
                        temp2 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                        System.out.println(temp.get(0).printfInfor());
                        System.out.println("--------------------------------");
                        System.out.println("Do you want delete - 1:yes/2:No");
                        System.out.println("--------------------------------");
                        System.out.printf("Your Choose: ");
                        int choose = InputService.InputInteger();
                        if (choose == 1) {
                            EmployeeDAO.getInstance().Delete("empPhone", phone, 1);
                            if (temp2.size() != 0) {
                                System.out.println("This employee manager of " + temp2.get(0).getDepName() + " department");
                                DepartmentDAO.getInstance().Update("depManagerID", "", depID, 4);
                            }
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Employee not exist");
                        break;
                    }
                }
                case 4: {
                    empList = EmployeeDAO.getInstance().SelectAll();
                    empList.forEach(e-> System.out.println(e.printfInfor()));
                    empList.clear();
                    System.out.println("--------------------------------");
                    System.out.printf("Enter the email: ");
                    String email = InputService.InputEmail();
                    System.out.println("--------------------------------");
                    temp = EmployeeDAO.getInstance().selectByConditon("email", email, 1);
                    if (temp.size() != 0) {
                        int depID = temp.get(0).getDepID();
                        int id = temp.get(0).getEmpID();
                        temp2 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                        System.out.println(temp.get(0).printfInfor());
                        System.out.println("--------------------------------");
                        System.out.println("Do you want delete - 1:yes/2:No");
                        System.out.println("--------------------------------");
                        System.out.printf("Your Choose: ");
                        int choose = InputService.InputInteger();
                        if (choose == 1) {
                            EmployeeDAO.getInstance().Delete("email", email, 1);
                            if (temp2.size() != 0) {
                                System.out.println("This employee manager of " + temp2.get(0).getDepName() + " department");
                                DepartmentDAO.getInstance().Update("depManagerID", "", depID, 4);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Employee not exist");
                        break;
                    }
                }
                case 5: {
                    cond = false;
                    break;
                }
                default: {
                    System.out.println("Wrong enter.Try again.");
                    continue;
                }
            }
        }
    }

    public void FindAll() {
        boolean cond = true;
        while (cond) {
            empList = EmployeeDAO.getInstance().SelectAll();
            List<Employee> chooseList = new ArrayList<>();
            int n = empList.size();
            System.out.println("--------------------------------");
            System.out.println("1: Find by ID");
            System.out.println("2: Find by name");
            System.out.println("3: Find by phone");
            System.out.println("4: Find by email");
            System.out.println("5: Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your Choose: ");
            int choose = InputService.InputInteger();
            switch (choose) {
                case 1: {
                    System.out.printf("Enter the ID: ");
                    int id = InputService.InputInteger();
                    chooseList = empList.stream().filter(e -> e.getEmpID() == id).collect(Collectors.toList());
                    if (chooseList.size() == 0) {
                        System.out.println("Employee not exist");
                    } else {
                        for (Employee temp : chooseList) {
                            System.out.println(temp.printfInfor());
                        }
                    }
                    chooseList.clear();
                    empList.clear();
                    break;
                }
                case 2: {
                    System.out.printf("Enter the name: ");
                    String Name = InputService.InputString();
                    chooseList = empList.stream().filter(e -> e.getEmpName().equals(Name) == true).collect(Collectors.toList());
                    if (chooseList.size() == 0) {
                        System.out.println("Employee not exist");
                    } else {
                        for (Employee temp : chooseList) {
                            System.out.println(temp.printfInfor());
                        }
                    }
                    chooseList.clear();
                    empList.clear();
                    break;
                }
                case 3: {
                    System.out.printf("Enter the phone: ");
                    String phone = InputService.InputString();
                    chooseList = empList.stream().filter(e -> e.getEmpPhone().equals(phone) == true).collect(Collectors.toList());
                    if (chooseList.size() == 0) {
                        System.out.println("Employee not exist");
                    } else {
                        for (Employee temp : chooseList) {
                            System.out.println(temp.printfInfor());
                        }
                    }
                    chooseList.clear();
                    empList.clear();
                    break;
                }
                case 4: {
                    System.out.printf("Enter the email: ");
                    String email = InputService.InputString();
                    chooseList = empList.stream().filter(e -> e.getEmail().equals(email) == true).collect(Collectors.toList());
                    if (chooseList.size() == 0) {
                        System.out.println("Employee not exist");
                    } else {
                        for (Employee temp : chooseList) {
                            System.out.println(temp.printfInfor());
                        }
                    }
                    chooseList.clear();
                    empList.clear();
                    break;
                }
                case 5: {
                    cond = false;
                    empList.clear();
                    break;
                }
                default: {
                    System.out.println("Error. Try again.");
                }
            }
        }
    }

    public void AddDeleteDepartment() {
        boolean cond = true;
        List<Employee> temp = new ArrayList<>();
        List<Department> temp1 = new ArrayList<>();
        boolean cond1 = true;
        boolean cond2 = true;
        while (true) {
            empList = EmployeeDAO.getInstance().SelectAll();
            empList.forEach(e-> System.out.println(e.printfInfor()));
            empList.clear();
            System.out.println("--------------------------------");
            System.out.println("Enter the employee ID for add/delete");
            System.out.println("Enter 0 to Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your choose: ");
            int ide = InputService.InputInteger();
            if (ide == 0) {
                break;
            }
            temp = EmployeeDAO.getInstance().selectByConditon("empID", ide, 2);
            if (temp.size() != 0) {
                int depID = temp.get(0).getDepID();
                System.out.println(temp.get(0).printfInfor());
                temp.clear();
                if (depID == 0) {
                    System.out.println("--------------------------------");
                    System.out.println("Employees who do not belong to any department");
                    System.out.println("--------------------------------");
                    cond1 = false;
                    cond2 = false;
                } else {
                    temp1 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                    System.out.println("--------------------------------");
                    System.out.println("Employee belong to " + temp1.get(0).getDepName());
                    System.out.println("--------------------------------");
                    cond1 = false;
                    cond2 = true;
                }
                while (!cond1) {
                    System.out.println("--------------------------------");
                    System.out.println("1: Add a employee to department");
                    System.out.println("2: Delete a employee out department");
                    System.out.println("3: Exit");
                    System.out.println("--------------------------------");
                    System.out.printf("Your Choose: ");
                    int choose = InputService.InputInteger();
                    switch (choose) {
                        case 1: {
                            if (cond2 == false) {
                                depList = DepartmentDAO.getInstance().SelectAll();
                                depList.forEach(e-> System.out.println(e.printfInfor()));
                                depList.clear();
                                System.out.println("--------------------------------");
                                System.out.printf("Enter the department ID for join: ");
                                int idd = InputService.InputInteger();
                                System.out.println("--------------------------------");
                                temp1 = DepartmentDAO.getInstance().selectByConditon("depID", idd, 2);
                                if (temp1.size() != 0) {
                                    int numberMax = temp1.get(0).getNumberMember();
                                    temp1.clear();
                                    int number = EmployeeDAO.getNumberDep("empID", "depID", idd);
                                    if (numberMax > number) {
                                        EmployeeDAO.getInstance().Update("depID", idd, ide, 2);
                                        cond1 = true;
                                        break;
                                    } else {
                                        System.out.println("This room is full");
                                        System.out.println("Unable to perform this action");
                                        temp1.clear();
                                        break;
                                    }
                                } else {
                                    System.out.println("Department not exist");
                                }

                            } else {
                                System.out.println("Unable to perform this action");
                                break;
                            }
                        }
                        case 2: {
                            if (cond2 == true) {
                                temp1 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                                EmployeeDAO.getInstance().Update("depID", "", ide, 4);
                                if (temp1.size() != 0) {
                                    if (temp1.get(0).getDepManagerID() != 0) {
                                        System.out.println("This employee is manager of " + temp1.get(0).getDepName() + " department");
                                        DepartmentDAO.getInstance().Update("depManagerID", "", depID, 4);
                                        temp1.clear();
                                    }
                                } else {
                                    System.out.println("Department not exist");
                                }
                                cond1 = true;
                                break;
                            } else {
                                System.out.println("Unable to perform this action");
                                break;
                            }
                        }
                        case 3: {
                            cond1 = true;
                            break;
                        }
                        default: {
                            System.out.println("Wrong enter.");
                        }
                    }
                }
            } else {
                System.out.println("Employee not exist");
                cond1 = false;
            }
        }
    }

    public void MoveDepartment() {
        List<Employee> temp = new ArrayList<>();
        List<Department> temp1 = new ArrayList<>();
        boolean cond = true;
        boolean cond2 = true;

        while (true) {
            empList = EmployeeDAO.getInstance().SelectAll();
            empList.forEach(e-> System.out.println(e.printfInfor()));
            empList.clear();
            System.out.println("--------------------------------");
            System.out.println("Enter the employee ID for move department");
            System.out.println("Enter 0 to Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your choose: ");
            int ide = InputService.InputInteger();
            if (ide == 0) {
                break;
            }
            temp = EmployeeDAO.getInstance().selectByConditon("empID", ide, 2);
            if (temp.size() != 0) {
                int depID = temp.get(0).getDepID();
                int managerID = 0;
                System.out.println(temp.get(0).printfInfor());
                if (depID == 0) {
                    System.out.println("--------------------------------");
                    System.out.println("Employees who do not belong to any department");
                    System.out.println("--------------------------------");
                    cond = false;
                    cond2 = false;
                } else {
                    temp1 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                    System.out.println("--------------------------------");
                    System.out.println("Employee belong to " + temp1.get(0).getDepName());
                    System.out.println("--------------------------------");
                    managerID = temp1.get(0).getDepManagerID();
                    temp1.clear();
                    cond = false;
                    cond2 = true;
                }
                while (!cond) {
                    if (cond2 == true) {
                        depList = DepartmentDAO.getInstance().SelectAll();
                        depList.forEach(e-> System.out.println(e.printfInfor()));
                        depList.clear();
                        System.out.println("--------------------------------");
                        System.out.printf("Enter the department ID for move: ");
                        int idd = InputService.InputInteger();
                        System.out.println("--------------------------------");
                        temp1 = DepartmentDAO.getInstance().selectByConditon("depID", idd, 2);
                        if (temp1.size() != 0) {
                            int numberMax = temp1.get(0).getNumberMember();
                            int number = EmployeeDAO.getNumberDep("empID", "depID", idd);
                            if (numberMax >= number) {
                                if (managerID == ide) {
                                    System.out.println("This employee is manager of " + temp1.get(0).getDepName() + " department");
                                    DepartmentDAO.getInstance().Update("depManagerID", "", ide, 4);
                                }
                                EmployeeDAO.getInstance().Update("depID", idd, ide, 2);
                            } else {
                                System.out.println("This room is full");
                                System.out.println("Unable to perform this action");
                                temp1.clear();
                                cond = true;
                            }
                            break;
                        } else {
                            System.out.println("Department not exist");
                        }
                    }
                    if (cond2 == false) {
                        System.out.println("Employee not exist department. Can not move.");
                        cond = true;
                    }
                }
            } else {
                System.out.println("Employee not exist");
            }
        }

    }

    public void chooseDepManager() {
        List<Employee> temp = new ArrayList<>();
        List<Department> temp1 = new ArrayList<>();
        List<Employee> temp2 = new ArrayList<>();
        boolean cond = true;
        while (true) {
            int depID = 0;
            int managerId = 0;
            empList = EmployeeDAO.getInstance().SelectAll();
            empList.forEach(e-> System.out.println(e.printfInfor()));
            empList.clear();
            System.out.println("--------------------------------");
            System.out.println("Enter the employee ID selected");
            System.out.println("Enter 0 to Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your choose: ");
            int ide = InputService.InputInteger();
            if (ide == 0) {
                break;
            }
            temp = EmployeeDAO.getInstance().selectByConditon("empID", ide, 2);
            if (temp.size() != 0) {
                depID = temp.get(0).getDepID();
                System.out.println(temp.get(0).printfInfor());
                if (depID == 0) {
                    System.out.println("--------------------------------");
                    System.out.println("Employees who do not belong to any department");
                    System.out.println("--------------------------------");
                    cond = false;
                } else {
                    temp1 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                    System.out.println("--------------------------------");
                    System.out.println("Employee belong to " + temp1.get(0).getDepName());
                    managerId = temp1.get(0).getDepManagerID();
                    System.out.println("--------------------------------");
                    cond = false;
                }

                while (!cond) {
                    boolean cond1 = true;
                    depList = DepartmentDAO.getInstance().SelectAll();
                    depList.forEach(e-> System.out.println(e.printfInfor()));
                    depList.clear();
                    System.out.println("--------------------------------");
                    System.out.printf("Enter the department ID: ");
                    int idd = InputService.InputInteger();
                    System.out.println("--------------------------------");
                    temp1 = DepartmentDAO.getInstance().selectByConditon("depID", idd, 2);
                    temp2 = EmployeeDAO.getInstance().selectByConditon("depID", idd, 2);
                    if (temp1.size() != 0) {
                        System.out.println(temp1.get(0).printfInfor());
                        System.out.println("--------------------------------");
                        if (temp2.size() != 0) {
                            System.out.println("Manager of this department is: " + temp2.get(0).getEmpName());
                        } else {
                            System.out.println("Department have not manager");
                        }
                        System.out.println("--------------------------------");

                        int number = EmployeeDAO.getNumberDep("empID", "depID", idd);
                        int numberMax = temp1.get(0).getNumberMember();
                        if (idd == depID) {
                            System.out.println("Do you want change department RM - 1:yes/2:No");
                            System.out.printf("Your choose: ");
                            int x = InputService.InputInteger();
                            if (x == 1) {
                                System.out.printf("Update employee become department manager ");
                                DepartmentDAO.getInstance().Update("depManagerID", ide, idd, 2);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("Do you want add department RM - 1:yes/2:No");
                            System.out.printf("Your choose: ");
                            int x = InputService.InputInteger();
                            if (x == 1) {
                                if (numberMax > number) {
                                    if (managerId == ide) {
                                        System.out.printf("This employee is manager of orther department");
                                        DepartmentDAO.getInstance().Update("depManagerID", "", ide, 4);
                                    }
                                    System.out.printf("Update employee department ");
                                    EmployeeDAO.getInstance().Update("depID", idd, ide, 2);
                                    System.out.printf("Update employee become department manager ");
                                    DepartmentDAO.getInstance().Update("depManagerID", ide, idd, 2);
                                    break;
                                } else {
                                    System.out.println("This room is full");
                                    System.out.println("Do you want change number memeber of this department - 1:yes/2:No");
                                    int choose = InputService.InputInteger();
                                    if (choose == 1) {
                                        System.out.printf("update number member ");
                                        DepartmentDAO.getInstance().Update("numberMember", (numberMax + 1), idd, 2);
                                        System.out.println("Try action again!!");
                                    }
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Department not exist");
                        break;
                    }
                }
            } else {
                System.out.println("Employee not exist");
            }
        }
    }

    public void calculateTAX() {
        boolean cond = true;
        while (cond) {
            empList = EmployeeDAO.getInstance().SelectAll();
            List<Employee> getSalaryList = new ArrayList<>();
            System.out.println("--------------------------------");
            System.out.println("1: calculate for all employee.");
            System.out.println("2: calculate for a employee.");
            System.out.println("3: Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your choose: ");
            int choose = InputService.InputInteger();
            switch (choose) {
                case 1: {
                    for (Employee emp : empList) {
                        double salary = emp.getSalary();
                        System.out.printf(emp.printfInfor());
                        System.out.printf("Tax: %.2f", emp.calculateTAX(salary));
                        System.out.println();
                    }
                    empList.clear();
                    break;
                }
                case 2: {
                    System.out.println("Enter the Id");
                    int id = InputService.InputInteger();
                    getSalaryList = empList.stream().filter(e -> (e.getEmpID() == id)).collect(Collectors.toList());
                    if (getSalaryList.size() != 0) {
                        double salary = getSalaryList.get(0).getSalary();
                        System.out.printf(getSalaryList.get(0).printfInfor());
                        System.out.printf("Tax: %2f", getSalaryList.get(0).calculateTAX(salary));
                    } else {
                        System.out.println("Employee not exists");
                    }
                    break;
                }
                case 3: {
                    cond = false;
                    break;
                }
                default: {
                    System.out.println("Error. Try again");
                    continue;
                }
            }
        }
    }

    public void Statiѕtic() {
        boolean cond = true;
        while (cond) {
            List<Employee> temp1 = EmployeeDAO.getInstance().SelectAll();
            List<Department> temp2 = DepartmentDAO.getInstance().SelectAll();
            System.out.println("--------------------------------");
            System.out.println("1: Show list all employee.");
            System.out.println("2: Show list all department.");
            System.out.println("3: Show list employee any department.");
            System.out.println("4: Employee arrangement");
            System.out.println("5: Employee have salary highest in department");
            System.out.println("6: Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your choose: ");
            int choose = InputService.InputInteger();
            switch (choose) {
                case 1: {
                    temp1.forEach(e -> System.out.println(e.printfInfor()));
                    break;
                }
                case 2: {
                    temp2.forEach(e -> System.out.println(e.printfInfor()));
                    break;
                }
                case 3: {
                    temp2.forEach(e -> System.out.println(e.printfInfor()));
                    System.out.println("--------------------------------");
                    System.out.printf("Choose a any department by id: ");
                    int id = InputService.InputInteger();
                    temp1.stream().filter(e -> e.getDepID() == id).forEach(e -> System.out.println(e.printfInfor()));
                }
                case 4: {
                    boolean cond4 = true;
                    while (cond4) {
                        System.out.println("--------------------------------");
                        System.out.println("1: Employee arrangement by name");
                        System.out.println("2: Employee arrangement by salary");
                        System.out.println("3: Exit");
                        System.out.println("--------------------------------");
                        System.out.printf("Your choose: ");
                        int x = InputService.InputInteger();
                        switch (x) {
                            case 1: {
                                System.out.println("--------------------------------");
                                System.out.println("1: Ascending");
                                System.out.println("2: Decrease");
                                System.out.println("--------------------------------");
                                System.out.printf("Your choose: ");
                                int x1 = InputService.InputInteger();
                                switch (x1) {
                                    case 1: {
                                        temp1.stream().sorted(Comparator.comparing(Employee::getEmpName)).forEach(e -> System.out.println(e.printfInfor()));
                                        break;
                                    }
                                    case 2: {
                                        temp1.stream().sorted(Comparator.comparing(Employee::getEmpName).reversed()).forEach(e -> System.out.println(e.printfInfor()));
                                        break;
                                    }
                                    default: {
                                        System.out.println("Error.Try again.");
                                        continue;
                                    }
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("--------------------------------");
                                System.out.println("1: Ascending");
                                System.out.println("2: Decrease");
                                System.out.println("--------------------------------");
                                System.out.printf("Your choose: ");
                                int x2 = InputService.InputInteger();
                                switch (x2) {
                                    case 1: {
                                        temp1.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(e -> System.out.println(e.printfInfor()));
                                        break;
                                    }
                                    case 2: {
                                        temp1.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(e -> System.out.println(e.printfInfor()));
                                        break;
                                    }
                                    default: {
                                        System.out.println("Error.Try again.");
                                        continue;
                                    }
                                }
                                break;
                            }
                            case 3: {
                                cond4 = false;
                                break;
                            }
                            default: {
                                System.out.println("Error.Try again.");
                                continue;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    for(Employee x:temp1){
                        if(x.getDepID() != 0){
                            Map<Integer, Employee> tempx =
                                    temp1.stream().collect(Collectors.groupingBy(Employee::getDepID,
                                            Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                                    Optional::get)));
                            tempx.forEach((depID, Employee) ->
                                    System.out.println("Department: " + depID + " is: Employee " + Employee.getEmpName() + " - Salary: " + Employee.getSalary()));
                        }
                    }
                }
                case 6: {
                    cond = false;
                    break;
                }
                default: {
                    System.out.println("Error. Try again");
                    continue;
                }
            }
        }
    }
}