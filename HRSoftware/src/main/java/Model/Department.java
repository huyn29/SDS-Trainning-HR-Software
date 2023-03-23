package Model;

public class Department {
    private int depID;
    private String depName;
    private int numberMember;
    private int depManagerID;

    public Department(int depID, String depName, int numberMember) {
        this.depID = depID;
        this.depName = depName;
        this.numberMember = numberMember;
    }

    public Department(int depID, String depName, int numberMember, int depManagerID) {
        this.depID = depID;
        this.depName = depName;
        this.numberMember = numberMember;
        this.depManagerID = depManagerID;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getNumberMember() {
        return numberMember;
    }

    public void setNumberMember(int numberMember) {
        this.numberMember = numberMember;
    }

    public int getDepManagerID() {
        return depManagerID;
    }

    public void setDepManagerID(int depManagerID) {
        this.depManagerID = depManagerID;
    }
    public String printfInfor() {
        return String.format("Department %-5d\tName: %-10s\tNumber member: %-5d\tManager: %-5d"
                ,depID,depName,numberMember,depManagerID);
    }

}
