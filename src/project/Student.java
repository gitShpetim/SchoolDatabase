package project;

import java.util.Objects;
import java.util.Arrays;

public class Student extends Person {
    private static int numStudents = 0;
    private int studentID;
    private Course[] coursesTaken;
    private int numCoursesTaken;
    private boolean isGraduate;
    private String major;

    public Student() {
        super();
        this.studentID = generateStudentID();
        this.coursesTaken = new Course[50];
        this.numCoursesTaken = 0;
        this.isGraduate = false;
        this.major = "undeclared";
    }

    public Student(boolean isGraduate) {
        super();
        this.studentID = generateStudentID();
        this.coursesTaken = new Course[50];
        this.numCoursesTaken = 0;
        this.isGraduate = isGraduate;
        this.major = "undeclared";
    }

    public Student(String major, boolean isGraduate) {
        super();
        this.studentID = generateStudentID();
        this.coursesTaken = new Course[50];
        this.numCoursesTaken = 0;
        this.isGraduate = isGraduate;
        this.major = major;
    }

    public Student(String name, int birthYear, String major, boolean isGraduate) {
        super(name, birthYear);
        this.studentID = generateStudentID();
        this.coursesTaken = new Course[50];
        this.numCoursesTaken = 0;
        this.isGraduate = isGraduate;
        this.major = major;
    }

    public boolean isGraduate() {
        return isGraduate;
    }

    public int getNumCoursesTaken() {
        return numCoursesTaken;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setIsGraduate(boolean isGraduate) {
        this.isGraduate = isGraduate;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addCourseTaken(Course course) {
        if (numCoursesTaken < 50) {
            coursesTaken[numCoursesTaken] = course;
            numCoursesTaken++;
        }
    }

    public void addCoursesTaken(Course[] courses) {
        int remainingSpace = 50 - numCoursesTaken;
        int coursesToAdd = Math.min(courses.length, remainingSpace);
        System.arraycopy(courses, 0, coursesTaken, numCoursesTaken, coursesToAdd);
        numCoursesTaken += coursesToAdd;
    }

    public Course getCourseTaken(int index) {
        if (index >= 0 && index < numCoursesTaken) {
            return coursesTaken[index];
        }
        return null;
    }

    public String getCourseTakenAsString(int index) {
        Course course = getCourseTaken(index);
        if (course != null) {
            return course.getCourseDept() + "-" + course.getCourseNum();
        }
        return "";
    }

    public String getAllCoursesTakenAsString() {
        StringBuilder courseList = new StringBuilder();
        for (int i = 0; i < numCoursesTaken; i++) {
            if (i > 0) {
                courseList.append(", ");
            }
            courseList.append(getCourseTakenAsString(i));
        }
        return courseList.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return studentID == student.studentID &&
                numCoursesTaken == student.numCoursesTaken &&
                isGraduate == student.isGraduate &&
                Objects.equals(major, student.major) &&
                Arrays.equals(coursesTaken, student.coursesTaken);
    }

    @Override
    public String toString() {
        String studentType = isGraduate ? "Graduate" : "Undergraduate";
        return String.format("%s Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
                super.toString(), studentID, major, studentType, numCoursesTaken, getAllCoursesTakenAsString());
    }

    @Override
    public int compareTo(Person p) {
        if (p instanceof Student) {
            Student student = (Student) p;
            return Integer.compare(this.numCoursesTaken, student.numCoursesTaken);
        }
        return super.compareTo(p);
    }

    private static int generateStudentID() {
        numStudents++;
        return numStudents;
    }
}