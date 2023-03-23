package Service;

import DAO.DepartmentDAO;
import DAO.EmployeeDAO;
import Model.Department;
import Model.Employee;

import java.util.ArrayList;
import java.util.List;


public class DepartmentService {
    List<Department> depList;
    public DepartmentService(){
        depList = new ArrayList<>();
    }
    public void addNewDep() {
        System.out.printf("Type the number department for add: ");
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
            Department ex = new Department(depid,name ,number);
            depList.add(ex);
        }
        DepartmentDAO.getInstance().Insert(n, (ArrayList<Department>) depList);
        depList.clear();
    }
    public void updateDep(){
        boolean cond = true;
        System.out.printf("Type the department ID for update: ");
        int id = InputService.InputInteger();
        depList = DepartmentDAO.getInstance().selectByConditon("depID",id,2);
        if(depList.size() != 0){
            System.out.println(depList.get(0).printfInfor());
            depList.clear();
        }else {
            System.out.println("Department not exist");
            cond = false;
        }
        while (cond){
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
                    DepartmentDAO.getInstance().Update("depName", newName, id,1);
                    break;
                case 2:
                    System.out.println("New number member: ");
                    int newNumber = InputService.InputInteger();
                    DepartmentDAO.getInstance().Update("numberMember", newNumber, id,2);
                    break;
                case 3:
                    System.out.println("New manager: ");
                    int newManager = InputService.InputInteger();
                    DepartmentDAO.getInstance().Update("depManagerID", newManager, id,2);
                    break;
                case 4:
                    System.out.println("Exit");
                    cond = false;
                    break;
            }
        }
    }
    public void deleteDep(){
        System.out.println("--------------------------------");
        System.out.println("1: Delete by ID:");
        System.out.println("2: Delete by name");
        System.out.println("3: Delete by phone");
        System.out.println("--------------------------------");
        System.out.printf("Your Choose: ");
        int i1 = InputService.InputInteger();
        switch (i1){
            case 1:
                System.out.printf("Enter the ID: ");
                int id = InputService.InputInteger();
                DepartmentDAO.getInstance().Delete("depID", id,2);
                break;
            case 2:
                System.out.printf("Enter the name: ");
                String name = InputService.InputString();
                DepartmentDAO.getInstance().Delete("depName",name,2);
                break;
            case 3:
                System.out.println("Exit");
                break;
        }
    }
}
