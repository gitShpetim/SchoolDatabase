package project;

import java.util.Objects;

public class GeneralStaff extends Employee {
    private String duty;

    public GeneralStaff() {
        super();
        this.duty = "";
    }

    public GeneralStaff(String duty) {
        super();
        this.duty = duty;
    }

    public GeneralStaff(String deptName, String duty) {
        super(deptName);
        this.duty = duty;
    }

    public GeneralStaff(String name, int birthYear, String deptName, String duty) {
        super(name, birthYear, deptName);
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        GeneralStaff staff = (GeneralStaff) obj;
        return Objects.equals(duty, staff.duty);
    }

    @Override
    public String toString() {
        return String.format("%s GeneralStaff: Duty: %10s", super.toString(), duty);
    }
}