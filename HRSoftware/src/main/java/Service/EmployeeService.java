package Service;

import DAO.DepartmentDAO;
import DAO.EmployeeDAO;
import Model.Department;
import Model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    List<Employee> empList;

    public EmployeeService() {
        empList = new ArrayList<>();
    }

    public void addNewEmp() {
        System.out.printf("Enter number of employee for add: ");
        int n = InputService.InputInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------------");
            System.out.printf("Enter name: ");
            String name = InputService.InputString();
            System.out.printf("Enter phone: ");
            String phone = InputService.InputString();
            System.out.printf("Enter email: ");
            String email = InputService.InputString();
            System.out.printf("Enter salary: ");
            double salary = InputService.InputDouble();
            System.out.printf("Enter managerID: ");
            int rmID = InputService.InputInteger();
            System.out.println("--------------------------------");
            Employee ex = new Employee(name, phone, email, salary, rmID);
            empList.add(ex);
        }
        EmployeeDAO.getInstance().Insert(n, (ArrayList<Employee>) empList);
        empList.clear();
    }

    public void updateEmp() {
        boolean cond = true;
        System.out.printf("Enter employee ID for update: ");
        int id = InputService.InputInteger();
        empList = EmployeeDAO.getInstance().SelectAll();
        if (empList.size() > id) {
            System.out.println(empList.get(id).printfInfor());
        } else {
            System.out.println("Employee not exist");
            cond = false;
        }
        empList.clear();

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
                    String newPhone = InputService.InputString();
                    EmployeeDAO.getInstance().Update("empPhone", newPhone, id, 1);
                    break;
                case 3:
                    System.out.printf("New email: ");
                    String newEmail = InputService.InputString();
                    EmployeeDAO.getInstance().Update("email", newEmail, id, 1);
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
                case 6:
                    System.out.println("Exit");
                    cond = false;
                    break;
            }
        }
    }

    public void deleteEmp() {
        List<Employee> temp = new ArrayList<>();
        System.out.println("--------------------------------");
        System.out.println("1: Delete by ID:");
        System.out.println("2: Delete by name");
        System.out.println("3: Delete by phone");
        System.out.println("4: Delete by email");
        System.out.println("5: Exit");
        System.out.println("--------------------------------");
        System.out.printf("Your Choose: ");
        int i1 = InputService.InputInteger();
        switch (i1) {
            case 1: {
                System.out.printf("Enter the ID: ");
                int id = InputService.InputInteger();
                temp = EmployeeDAO.getInstance().selectByConditon("empID", id, 2);
                if (temp.size() != 0) {
                    System.out.println(temp.get(0).printfInfor());
                    System.out.println("--------------------------------");
                    System.out.println("Do you want delete - 1:yes/2:No");
                    System.out.println("--------------------------------");
                    System.out.printf("Your Choose: ");
                    int choose = InputService.InputInteger();
                    if (choose == 1) {
                        EmployeeDAO.getInstance().Delete("empID", id, 2);
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
                System.out.printf("Enter the name: ");
                String name = InputService.InputString();
                temp = EmployeeDAO.getInstance().selectByConditon("empName", name, 1);
                if (temp.size() != 0) {
                    System.out.println(temp.get(0).printfInfor());
                    System.out.println("--------------------------------");
                    System.out.println("Do you want delete - 1:yes/2:No");
                    System.out.println("--------------------------------");
                    System.out.printf("Your Choose: ");
                    int choose = InputService.InputInteger();
                    if (choose == 1) {
                        EmployeeDAO.getInstance().Delete("empName", name, 1);
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

            case 3: {
                System.out.printf("Enter the phone: ");
                String phone = InputService.InputString();
                temp = EmployeeDAO.getInstance().selectByConditon("empPhone", phone, 1);
                if (temp.size() != 0) {
                    System.out.println(temp.get(0).printfInfor());
                    System.out.println("--------------------------------");
                    System.out.println("Do you want delete - 1:yes/2:No");
                    System.out.println("--------------------------------");
                    System.out.printf("Your Choose: ");
                    int choose = InputService.InputInteger();
                    if (choose == 1) {
                        EmployeeDAO.getInstance().Delete("empPhone", phone, 1);
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
                System.out.printf("Enter the email");
                String email = InputService.InputString();
                temp = EmployeeDAO.getInstance().selectByConditon("empPhone", email, 1);
                if (temp.size() != 0) {
                    System.out.println(temp.get(0).printfInfor());
                    System.out.println("--------------------------------");
                    System.out.println("Do you want delete - 1:yes/2:No");
                    System.out.println("--------------------------------");
                    System.out.printf("Your Choose: ");
                    int choose = InputService.InputInteger();
                    if (choose == 1) {
                        EmployeeDAO.getInstance().Delete("empPhone", email, 1);
                        break;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Employee not exist");
                    break;
                }
            }
            case 5: {
                break;
            }
        }
    }

    public void FindAll() {
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
                empList.clear();
                break;
            }
        }
    }

    public void AddDeleteDepartment() {
        List<Employee> temp = new ArrayList<>();
        List<Department> temp1 = new ArrayList<>();
        boolean cond = true;
        boolean cond2 = true;
        int depID = 0;
        /***********************************************************/
        System.out.printf("Enter the employee ID for add/delete: ");
        int ide = InputService.InputInteger();
        temp = EmployeeDAO.getInstance().selectByConditon("empID", ide, 2);
        if (temp.size() != 0) {
            depID = temp.get(0).getDepID();
            System.out.println(temp.get(0).printfInfor());
            temp.clear();
        } else {
            System.out.println("Employee not exist");
            cond = false;
        }
        while (cond) {
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
                cond = false;
                cond2 = true;
            }
        }
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
                    System.out.printf("Enter the department ID for join: ");
                    int idd = InputService.InputInteger();
                    temp1 = DepartmentDAO.getInstance().selectByConditon("depID", idd, 2);
                    int numberMax = temp1.get(0).getNumberMember();
                    temp1.clear();
                    int number = EmployeeDAO.getNumberDep("empID", "depID", idd);
                    if (numberMax >= number) {
                        EmployeeDAO.getInstance().Update("depID", idd, ide, 2);
                        break;
                    } else {
                        System.out.println("This room is full");
                        System.out.println("Unable to perform this action");
                        temp1.clear();
                        break;
                    }
                } else {
                    System.out.println("Unable to perform this action");
                    break;
                }
            }
            case 2: {
                if (cond2 == true) {
                    EmployeeDAO.getInstance().Update("depID", "", ide, 4);
                } else {
                    System.out.println("Unable to perform this action");
                    break;
                }
            }
            case 3: {
                break;
            }
        }

    }

    public void MoveDepartment() {
        List<Employee> temp = new ArrayList<>();
        List<Department> temp1 = new ArrayList<>();
        boolean cond = true;
        boolean cond2 = true;
        int depID = 0;
        System.out.printf("Enter the employee ID for change department: ");
        int ide = InputService.InputInteger();
        temp = EmployeeDAO.getInstance().selectByConditon("empID", ide, 2);

        if (temp.size() != 0) {
            depID = temp.get(0).getDepID();
            System.out.println(temp.get(0).printfInfor());
        } else {
            System.out.println("Employee not exist");
            cond = false;
        }
        while (cond) {
            if (depID == 0) {
                System.out.println("--------------------------------");
                System.out.println("Employees who do not belong to any department");
                System.out.println("--------------------------------");
                cond = false;
                cond2 = false;
                break;
            } else {
                temp1 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                System.out.println("--------------------------------");
                System.out.println("Employee belong to " + temp1.get(0).getDepName());
                System.out.println("--------------------------------");
                cond = false;
                cond2 = true;
            }
        }
        if (cond2 == true) {
            System.out.printf("Enter the department ID for move: ");
            int idd = InputService.InputInteger();
            temp1 = DepartmentDAO.getInstance().selectByConditon("depID", idd, 2);
            int managerID = temp.get(0).getManagerID();
            int numberMax = temp1.get(0).getNumberMember();
            int number = EmployeeDAO.getNumberDep("empID", "depID", idd);
            if (numberMax >= number) {
                if (managerID != 0) {
                    DepartmentDAO.getInstance().Update("depManagerID", "", ide, 4);
                }
                EmployeeDAO.getInstance().Update("depID", idd, ide, 2);
            } else {
                System.out.println("This room is full");
                System.out.println("Unable to perform this action");
                temp1.clear();
            }
        } else {
            System.out.println("Unable to perform this action");
        }
    }

    public void chooseDepManager() {
        List<Employee> temp = new ArrayList<>();
        List<Department> temp1 = new ArrayList<>();
        List<Employee> temp2 = new ArrayList<>();
        boolean cond = true;
        boolean cond2 = true;
        int depID = 0;
        System.out.printf("Enter the employee ID selected: ");
        int ide = InputService.InputInteger();
        temp = EmployeeDAO.getInstance().selectByConditon("empID", ide, 2);

        if (temp.size() != 0) {
            depID = temp.get(0).getDepID();
            System.out.println(temp.get(0).printfInfor());
        } else {
            System.out.println("Employee not exist");
            cond = false;
        }
        while (cond) {
            if (depID == 0) {
                System.out.println("--------------------------------");
                System.out.println("Employees who do not belong to any department");
                System.out.println("--------------------------------");
                cond = false;
                break;
            } else {
                temp1 = DepartmentDAO.getInstance().selectByConditon("depID", depID, 2);
                System.out.println("--------------------------------");
                System.out.println("Employee belong to " + temp1.get(0).getDepName());
                System.out.println("--------------------------------");
                cond = false;
            }
        }
        while (!cond) {
            System.out.printf("Enter the department ID: ");
            int idd = InputService.InputInteger();
            temp1 = DepartmentDAO.getInstance().selectByConditon("depID", idd, 2);
            temp2 = EmployeeDAO.getInstance().selectByConditon("depID", idd, 2);
            if (temp1.size() != 0) {
                System.out.println(temp1.get(0).printfInfor());
                System.out.println("--------------------------------");
                System.out.println("Manager of this depart is: " + temp2.get(0).getEmpName());
                System.out.println("--------------------------------");
            } else {
                System.out.println("Department not exist");
                break;
            }
            int number = EmployeeDAO.getNumberDep("empID", "depID", idd);
            int numberMax = temp1.get(0).getNumberMember();
            int managerID = temp1.get(0).getDepManagerID();
            if (idd == temp.get(0).getEmpID()) {
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
                System.out.println("Do you want change department RM - 1:yes/2:No");
                System.out.printf("Your choose: ");
                int x = InputService.InputInteger();
                if (x == 1) {
                    if (numberMax > number) {
                        if(temp2.get(0).getDepID() !=0){
                            System.out.printf("Update delete employee old department ");
                            EmployeeDAO.getInstance().Update("depID", "", ide, 4);
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

        }
    }

    public void calculateTAX() {
        empList = EmployeeDAO.getInstance().SelectAll();
        List<Employee> getSalaryList = new ArrayList<>();
        System.out.println("Choose");
        System.out.println("1: calculate for all employee:");
        System.out.println("2: calculate for a employee:");
        int choose = InputService.InputInteger();
        switch (choose) {
            case 1: {
                for (Employee emp : empList) {
                    double salary = emp.getSalary();
                    emp.calculateTAX(salary);
                }
                break;
            }
            case 2: {
                System.out.println("Enter the Id");
                int id = InputService.InputInteger();
                getSalaryList = empList.stream().filter(e -> (e.getEmpID() == id)).collect(Collectors.toList());
                for (Employee emp : getSalaryList) {
                    double salary = emp.getSalary();
                    emp.calculateTAX(salary);
                }
                break;
            }
        }

    }
}