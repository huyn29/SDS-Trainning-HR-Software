package Model;

public class Employee {
    private int empID;
    private String empName;
    private String empPhone;
    private String email;
    private double salary;
    private int managerID;
    private int depID;

    public Employee(int empID, String empName, String empPhone, String email, double salary, int managerID, int depID) {
        this.empID = empID;
        this.empName = empName;
        this.empPhone = empPhone;
        this.email = email;
        this.salary = salary;
        this.managerID = managerID;
        this.depID = depID;
    }

    public Employee(String empName, String empPhone, String email, double salary) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.email = email;
        this.salary = salary;
    }

    public Employee(String empName, String empPhone, String email, double salary, int managerID) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.email = email;
        this.salary = salary;
        this.managerID = managerID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }
    public String printfInfor() {
        return String.format("Employee %-5d\tName: %-10s\tPhone: %-10s\tEmail: %-20s\tSalary: %-10s\tManager ID: %-5d\t Department ID: %-5d"
                            ,empID,empName,empPhone,email,salary,managerID,depID);
    }
    public double calculateTAX(double salary) {
        double realTax = 0;
        double[] taxLevel = {0, 0.05, 0.1, 0.15, 0.2, 0.25, 0.3}; // Các mức thuế
        double[] salaryLevel = {0, 5, 10, 18, 32, 52, 80}; // Các mức lương tương ứng

        double Tax = 0;

        // Tính số tiền thu nhập chịu thuế
        double salaryfortax = salary - 11;

        // Tính số tiền thuế phải nộp theo từng mức thuế
        for (int i = 1; i < taxLevel.length; i++) {
            if (salaryfortax > salaryLevel[i]) {
                Tax += (salaryLevel[i] - salaryLevel[i - 1]) * taxLevel[i];
            } else {
                Tax += (salaryfortax - salaryLevel[i - 1]) * taxLevel[i];
                break;
            }
        }

        // Tính số tiền thuế tổng cộng
        realTax = Tax;

        return realTax;
    }

}
