package project;
import java.util.Objects;
public class Employee extends Person {
    private String deptName;
    private static int numEmployees = 0;
    private int employeeID;

    public Employee() {
        super();
        this.deptName = "";
        this.employeeID = generateEmployeeID();
    }

    public Employee(String deptName) {
        super();
        this.deptName = deptName;
        this.employeeID = generateEmployeeID();
    }

    public Employee(String name, int birthYear, String deptName) {
        super(name, birthYear);
        this.deptName = deptName;
        this.employeeID = generateEmployeeID();
    }

    public String getDeptName() {
        return deptName;
    }

    public static int getNumEmployees() {
        return numEmployees;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return employeeID == employee.employeeID &&
                getBirthYear() == employee.getBirthYear() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(deptName, employee.deptName);
    }

    @Override
    public String toString() {
        return String.format("%s Employee: Department: %20s | Employee Number: %3d", super.toString(), deptName, employeeID);
    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.employeeID, ((Employee) p).employeeID);
    }

    private static int generateEmployeeID() {
        numEmployees++;
        return numEmployees;
    }
}