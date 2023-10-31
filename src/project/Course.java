package project;

public class Course {
    private boolean isGraduateCourse;
    private int courseNum;
    private String courseDept;
    private int numCredits;

    public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
        this.isGraduateCourse = isGraduateCourse;
        this.courseNum = courseNum;
        this.courseDept = courseDept;
        this.numCredits = numCredits;
    }

    public boolean isGraduateCourse() {
        return isGraduateCourse;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseDept() {
        return courseDept;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public String getCourseName() {
        if (isGraduateCourse) {
            return "G" + courseDept + courseNum;
        } else {
            return "U" + courseDept + courseNum;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Course)) {
            return false;
        }
        Course other = (Course) obj;
        return isGraduateCourse == other.isGraduateCourse &&
                courseNum == other.courseNum &&
                numCredits == other.numCredits &&
                courseDept.equals(other.courseDept);
    }

    @Override
    public String toString() {
        String courseType;
        if (isGraduateCourse) {
            courseType = "Graduate";
        } else {
            courseType = "Undergraduate";
        }

        return String.format("Course: %3s-%3d | Number of Credits: %02d | %s",
                courseDept, courseNum, numCredits, courseType);
    }

    public int compareTo(Course c) {
        return Integer.compare(this.courseNum, c.courseNum);
    }
}