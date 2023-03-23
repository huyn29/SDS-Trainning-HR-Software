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
        return String.format("Employee %-5d\tName: %-10s\tPhone: %-10s\tEmail: %-10s\tSalary: %-10s\tManager ID: %-5d\t Department ID: %-5d"
                            ,empID,empName,empPhone,email,salary,managerID,depID);
    }
    public void calculateTAX(double salary){
        double realitySalary;
        if(salary > 10 && salary <20){
            realitySalary = salary*(1-(0.1));
            System.out.println("Employee: "+empID+" - The Tax of you is 20% - Reality salary is: "+realitySalary);
        } else if (salary>20) {
            realitySalary = salary*(1-(0.2));
            System.out.println("Employee: "+empID+" - The Tax of you is 10% - Reality salary is: "+realitySalary);
        }else {
            System.out.println("Employee: "+empID+" - The Tax of you is  0% - Reality salary is: "+salary);
        }
    }
}
