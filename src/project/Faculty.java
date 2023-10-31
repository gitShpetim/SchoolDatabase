package project;

import java.util.Objects;
import java.util.Arrays;

public class Faculty extends Employee {
    private Course[] coursesTaught;
    private int numCoursesTaught;
    private boolean isTenured;

    public Faculty() {
        super();
        this.coursesTaught = new Course[100];
        this.numCoursesTaught = 0;
        this.isTenured = false;
    }

    public Faculty(boolean isTenured) {
        super();
        this.coursesTaught = new Course[100];
        this.numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String deptName, boolean isTenured) {
        super(deptName);
        this.coursesTaught = new Course[100];
        this.numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
        super(name, birthYear, deptName);
        this.coursesTaught = new Course[100];
        this.numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public boolean isTenured() {
        return isTenured;
    }

    public int getNumCoursesTaught() {
        return numCoursesTaught;
    }

    public void setIsTenured(boolean isTenured) {
        this.isTenured = isTenured;
    }

    public void addCourseTaught(Course course) {
        if (numCoursesTaught < 100) {
            coursesTaught[numCoursesTaught] = course;
            numCoursesTaught++;
        }
    }

    public void addCoursesTaught(Course[] courses) {
        int remainingSpace = 100 - numCoursesTaught;
        int coursesToAdd = Math.min(courses.length, remainingSpace);
        System.arraycopy(courses, 0, coursesTaught, numCoursesTaught, coursesToAdd);
        numCoursesTaught += coursesToAdd;
    }

    public Course getCourseTaught(int index) {
        if (index >= 0 && index < numCoursesTaught) {
            return coursesTaught[index];
        }
        return null;
    }

    public String getCourseTaughtAsString(int index) {
        Course course = getCourseTaught(index);
        if (course != null) {
            return course.getCourseDept() + "-" + course.getCourseNum();
        }
        return "";
    }

    public String getAllCoursesTaughtAsString() {
        StringBuilder courseList = new StringBuilder();
        for (int i = 0; i < numCoursesTaught; i++) {
            if (i > 0) {
                courseList.append(", ");
            }
            courseList.append(getCourseTaughtAsString(i));
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
        if (!super.equals(obj)) {
            return false;
        }
        Faculty faculty = (Faculty) obj;
        return numCoursesTaught == faculty.numCoursesTaught &&
                isTenured == faculty.isTenured &&
                Arrays.equals(coursesTaught, faculty.coursesTaught);
    }

    @Override
    public String toString() {
        String facultyStatus;
        if (isTenured) {
            facultyStatus = "Is Tenured";
        } else {
            facultyStatus = "Not Tenured";
        }

        return String.format("%s Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",
                super.toString(), facultyStatus, numCoursesTaught, getAllCoursesTaughtAsString());
    }

    @Override
    public int compareTo(Person p) {
        if (p instanceof Faculty) {
            Faculty faculty = (Faculty) p;
            int compareCourses = Integer.compare(this.numCoursesTaught, faculty.numCoursesTaught);

            if (compareCourses != 0) {
                return compareCourses;
            }

            return Boolean.compare(this.isTenured, faculty.isTenured);
        }

        return super.compareTo(p);
    }

    public boolean teachesCourse(Course course) {
        // TODO Auto-generated method stub
        return false;
    }

    public Course[] getCoursesTaught() {
        // TODO Auto-generated method stub
        return null;
    }
}