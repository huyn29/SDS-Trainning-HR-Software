package Service;

import DAO.DepartmentDAO;
import DAO.EmployeeDAO;
import Model.Department;
import Model.Employee;

import java.util.ArrayList;
import java.util.List;


public class DepartmentService {
    List<Department> depList;

    public DepartmentService() {
        depList = new ArrayList<>();
    }

    public void addNewDep() {
        List<Department> temp = new ArrayList<>();
        temp = DepartmentDAO.getInstance().SelectAll();
        boolean x = false;
        System.out.println("Enter number department to add: ");
        int n = InputService.InputInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------------");
            System.out.printf("Enter department ID: ");
            int depid = InputService.InputInteger();
            System.out.printf("Enter department name: ");
            String name = InputService.InputString();
            System.out.printf("Enter number memeber: ");
            int number = InputService.InputInteger();
            System.out.println("--------------------------------");
            for (Department t : temp) {
                if (t.getDepID() == depid) {
                    x = true;
                }
            }
            if (x == false) {
                Department ex = new Department(depid, name, number);
                DepartmentDAO.getInstance().Insert(ex);
            } else {
                System.out.println("This id already exists. Try again");
            }
        }
    }

    public void updateDep() {
        boolean cond = true;
        List<Department> temp = new ArrayList<>();
        temp = DepartmentDAO.getInstance().SelectAll();
        System.out.printf("Type the department ID for update: ");
        int id = InputService.InputInteger();
        temp = DepartmentDAO.getInstance().selectByConditon("depID", id, 2);
        if (depList.size() != 0) {
            System.out.println(depList.get(0).printfInfor());
        } else {
            System.out.println("Department not exist");
            cond = false;
        }
        while (cond) {
            System.out.println("--------------------------------");
            System.out.println("1. Update the name.");
            System.out.println("2. Update the number member.");
            System.out.println("3. Update the manager.");
            System.out.println("4. Exit.");
            System.out.println("--------------------------------");
            System.out.printf("Your Choose: ");
            int choose = InputService.InputInteger();
            switch (choose) {
                case 1:
                    System.out.println("New name:");
                    String newName = InputService.InputString();
                    DepartmentDAO.getInstance().Update("depName", newName, id, 1);
                    break;
                case 2:
                    System.out.println("New number member: ");
                    int newNumber = InputService.InputInteger();
                    int num = EmployeeDAO.getNumberDep("empID", "depID", id);
                    if (newNumber > num) {
                        DepartmentDAO.getInstance().Update("numberMember", newNumber, id, 2);
                    } else {
                        System.out.println("The number is less than the current number employee. Try again");
                    }
                    break;
                case 3:
                    System.out.println("New manager: ");
                    int newManager = InputService.InputInteger();
                    DepartmentDAO.getInstance().Update("depManagerID", newManager, id, 2);
                    break;
                case 4:
                    System.out.println("Exit");
                    cond = false;
                    break;
                default:{
                    System.out.println("Wrong enter. Try again.");
                    continue;
                }
            }
        }
    }

    public void deleteDep() {
        boolean cond =true;
        while (cond){
            List<Department> temp = new ArrayList<>();
            System.out.println("--------------------------------");
            System.out.println("1: Delete by ID:");
            System.out.println("2: Delete by name");
            System.out.println("3: Exit");
            System.out.println("--------------------------------");
            System.out.printf("Your Choose: ");
            int i1 = InputService.InputInteger();
            switch (i1) {
                case 1: {
                    System.out.printf("Enter the ID: ");
                    int id = InputService.InputInteger();
                    temp = DepartmentDAO.getInstance().selectByConditon("depID", id, 2);
                    if (temp.size() != 0) {
                        System.out.println(temp.get(0).printfInfor());
                        System.out.println("--------------------------------");
                        System.out.println("Do you want delete - 1:yes/2:No");
                        System.out.println("--------------------------------");
                        System.out.printf("Your Choose: ");
                        int choose = InputService.InputInteger();
                        if (choose == 1) {
                            System.out.printf("Delete this department ");
                            DepartmentDAO.getInstance().Delete("depID", id, 2);
                            System.out.printf("Update status employee of this department ");
                            EmployeeDAO.getInstance().Update("depID", "", id, 4);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Department not exist");
                        break;
                    }
                }
                case 2: {
                    System.out.printf("Enter the name: ");
                    String name = InputService.InputString();
                    temp = DepartmentDAO.getInstance().selectByConditon("depName", name, 1);
                    int id = temp.get(0).getDepID();
                    if (temp.size() != 0) {
                        System.out.println(temp.get(0).printfInfor());
                        System.out.println("--------------------------------");
                        System.out.println("Do you want delete - 1:yes/2:No");
                        System.out.println("--------------------------------");
                        System.out.printf("Your Choose: ");
                        int choose = InputService.InputInteger();
                        if (choose == 1) {
                            System.out.printf("Delete this department ");
                            DepartmentDAO.getInstance().Delete("depName", name, 1);
                            System.out.printf("Update status employee of this department ");
                            EmployeeDAO.getInstance().Update("depID", "", id, 4);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Department not exist");
                        break;
                    }
                }
                case 3: {
                    cond =false;
                    break;
                }
                default:{
                    System.out.println("Wrong enter. Try again.");
                    continue;
                }
            }
        }
    }
}
