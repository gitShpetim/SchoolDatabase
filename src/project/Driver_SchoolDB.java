package project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// video link:  https://youtu.be/CUbDE1BPQME

public class Driver_SchoolDB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        // Create arrays to store objects
        Course[] courses = new Course[10];
        Faculty[] faculties = new Faculty[10];
        GeneralStaff[] generalStaffs = new GeneralStaff[10];
        Student[] students = new Student[10];
        
        int nextAvailableCourseIndex = 0; // Initialize to 0

        int option;

        do {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Create 3 new Course objects based on input");
            System.out.println("2. Create 3 new Faculty objects based on input");
            System.out.println("3. Create 3 new GeneralStaff objects based on input");
            System.out.println("4. Create 3 new Student objects based on input");
            System.out.println("5. Add 2 new Courses to a Faculty object");
            System.out.println("6. Add 2 new Courses to a Student object");
            System.out.println("7. Add an array of 2 Courses to a Faculty object");
            System.out.println("8. Add an array of 2 Courses to a Student object");
            System.out.println("9. Get the Course at index (valid and invalid indexes) from a Faculty object");
            System.out.println("10. Get the Course at index (valid and invalid indexes) from a Student object");
            System.out.println("11. Query a Faculty object for Courses");
            System.out.println("12. Determine which Faculty teaches the most and least courses");
            System.out.println("13. Determine which Course is the minimum of all Course objects in the catalog");
            System.out.println("14. Determine which Course is the maximum of all Course objects in the catalog");
            System.out.println("15. Determine which Student has the most and least credits");
            System.out.println("16. Display all the Objects using toString on the console");
            System.out.println("17. Write all of the Object details to a plain text output file");
            System.out.println("18. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
            case 1:
                // Create 3 new Course objects based on input
                for (int i = 0; i < 3; i++) {
                    System.out.println("Enter Course details:");
                    System.out.print("Is it a graduate course? (true/false): ");
                    boolean isGraduateCourse = scanner.nextBoolean();
                    System.out.print("Course Number: ");

                    int courseNum = 0;
                    boolean validCourseNum = false;

                    while (!validCourseNum) {
                        try {
                            courseNum = scanner.nextInt();
                            validCourseNum = true; // If input is valid, exit the loop
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid course number.");
                            scanner.nextLine(); // Consume the invalid input
                            System.out.print("Course Number: "); // Ask the question again
                        }
                    }

                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Course Department: ");
                    String courseDept = scanner.nextLine();
                    System.out.print("Number of Credits: ");
                    int numCredits = scanner.nextInt();
                    
                    // Add the new course to the next available index in the courses array
                    if (nextAvailableCourseIndex < courses.length) {
                        courses[nextAvailableCourseIndex] = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
                        nextAvailableCourseIndex++;
                    } else {
                        System.out.println("The courses array is full. Cannot add more courses.");
                        break;
                    }
                }
                break;

                case 2:
                    // Create 3 new Faculty objects based on input
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Enter Faculty details:");
                        System.out.print("Is the Faculty tenured? (true/false): ");
                        boolean isTenured = scanner.nextBoolean();
                        System.out.print("Enter faculty name: ");
                        String name = scanner.next();
                        
                        int birthYear = 0;
                        boolean validBirthYear = false;
                        while (!validBirthYear) {
                            try {
                                System.out.print("Enter faculty birth year: ");
                                birthYear = scanner.nextInt();
                                validBirthYear = true; // If input is valid, exit the loop
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid birth year.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                        }
                        
                        System.out.print("Enter Department: ");
                        String deptName = scanner.next();
                        
                        faculties[i] = new Faculty(name, birthYear, deptName, isTenured);
                        
                        // Add courses taught for the faculty
                        int numCoursesTaught = 0;
                        boolean validNumCourses = false;
                        while (!validNumCourses) {
                            try {
                                System.out.print("Enter the number of courses taught: ");
                                numCoursesTaught = scanner.nextInt();
                                validNumCourses = true; // If input is valid, exit the loop
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number of courses.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                        }

                        for (int j = 0; j < numCoursesTaught; j++) {
                            System.out.print("Enter course department for course " + (j + 1) + ": ");
                            String courseDept = scanner.next();
                            
                            int courseNum = 0;
                            boolean validCourseNum = false;
                            
                            while (!validCourseNum) {
                                try {
                                    System.out.print("Enter course number for course " + (j + 1) + ": ");
                                    courseNum = scanner.nextInt();
                                    validCourseNum = true; // If input is valid, exit the loop
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid course number.");
                                    scanner.nextLine(); // Consume the invalid input
                                }
                            }
                            
                            faculties[i].addCourseTaught(new Course(false, courseNum, courseDept, 3));
                        }
                    }
                    break;
                    
                case 3:
                    // Create 3 new GeneralStaff objects based on input
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Enter general staff information for General Staff " + (i + 1));
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        
                        int birthYear = 0;
                        boolean validBirthYear = false;
                        while (!validBirthYear) {
                            try {
                                System.out.print("Enter birth year: ");
                                birthYear = scanner.nextInt();
                                validBirthYear = true; // If input is valid, exit the loop
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid birth year.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                        }
                        
                        System.out.print("Enter department: ");
                        String deptName = scanner.next();
                        System.out.print("Enter duty: ");
                        String duty = scanner.next();
                        
                        generalStaffs[i] = new GeneralStaff(name, birthYear, deptName, duty);
                    }
                    break;

                case 4:
                    // Create 3 new Student objects based on input
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Enter student information for Student " + (i + 1));
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        
                        int birthYear = 0;
                        boolean validBirthYear = false;
                        while (!validBirthYear) {
                            try {
                                System.out.print("Enter birth year: ");
                                birthYear = scanner.nextInt();
                                validBirthYear = true; // If input is valid, exit the loop
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid birth year.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                        }
                        
                        System.out.print("Is the student a graduate (true/false)? ");
                        boolean isGraduate = scanner.nextBoolean();
                        
                        // Use scanner.nextLine() to read the entire line for the major
                        System.out.print("Enter major: ");
                        scanner.nextLine(); // Consume the newline character left by nextBoolean()
                        String major = scanner.nextLine();
                        
                        System.out.print("Enter the number of courses taken: ");
                        int numCoursesTaken = scanner.nextInt();
                        students[i] = new Student(name, birthYear, major, isGraduate);
                        for (int j = 0; j < numCoursesTaken; j++) {
                            System.out.print("Enter course department for course " + (j + 1) + ": ");
                            String courseDept = scanner.next();
                            System.out.print("Enter course number for course " + (j + 1) + ": ");
                            int courseNum = scanner.nextInt();
                            students[i].addCourseTaken(new Course(false, courseNum, courseDept, 3));
                        }
                    }
                    break;

                case 5:
                    // Add 2 new Courses to a Faculty object and store them in the courses array
                    int facultyIndex1 = selectObject("Faculty", faculties);
                    if (facultyIndex1 >= 0 && facultyIndex1 < faculties.length) {
                        Faculty faculty1 = faculties[facultyIndex1];
                        
                        for (int i = 0; i < 2; i++) { // Loop twice to add two courses
                            System.out.println("Enter details for Course " + (i + 1) + ":");
                            System.out.print("Is it a graduate course? (true/false): ");
                            boolean isGraduateCourse = scanner.nextBoolean();
                            System.out.print("Course Number: ");
                            int courseNum = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            System.out.print("Course Department: ");
                            String courseDept = scanner.nextLine();
                            System.out.print("Number of Credits: ");
                            int numCredits = scanner.nextInt();

                            // Add the new course to the next available index in the courses array
                            if (nextAvailableCourseIndex < courses.length) {
                                courses[nextAvailableCourseIndex] = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
                                nextAvailableCourseIndex++;
                            } else {
                                System.out.println("The courses array is full. Cannot add more courses.");
                                break; // Exit the loop if the courses array is full
                            }
                            
                            faculty1.addCourseTaught(courses[nextAvailableCourseIndex - 1]);
                        }
                    } else {
                        System.out.println("Invalid faculty index.");
                    }
                    break;

                case 6:
                    // Add 2 new Courses to a Student object and store them in the courses array
                    int studentIndex1 = selectObject("Student", students);
                    if (studentIndex1 >= 0 && studentIndex1 < students.length) {
                        Student student1 = students[studentIndex1];
                        Course[] coursesToAdd2 = new Course[2];
                        for (int i = 0; i < 2; i++) {
                            System.out.println("Enter details for Course " + (i + 1));
                            System.out.print("Is it a graduate course? (true/false): ");
                            boolean isGraduateCourse = scanner.nextBoolean();
                            System.out.print("Course Number: ");
                            int courseNum = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            System.out.print("Course Department: ");
                            String courseDept = scanner.nextLine();
                            System.out.print("Number of Credits: ");
                            int numCredits = scanner.nextInt();
                            Course newCourse = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
                            
                            // Store the new course in the courses array
                            courses[nextAvailableCourseIndex] = newCourse;
                            nextAvailableCourseIndex++;

                            // Add the new course to the student's list of courses
                            student1.addCourseTaken(newCourse);
                        }
                    } else {
                        System.out.println("Invalid student index.");
                    }
                    break;

                case 7:
                    // Add an array of 2 Courses to a Faculty object
                    int facultyIndex2 = selectObject("Faculty", faculties);
                    if (facultyIndex2 >= 0 && facultyIndex2 < faculties.length) {
                        Faculty faculty2 = faculties[facultyIndex2];
                        Course[] coursesToAdd3 = new Course[2];
                        for (int i = 0; i < 2; i++) {
                            System.out.print("Enter the index of Course " + (i + 1) + " to add: ");
                            int courseIndex = scanner.nextInt();
                            if (courseIndex >= 0 && courseIndex < courses.length) {
                                coursesToAdd3[i] = courses[courseIndex];
                            } else {
                                System.out.println("Invalid course index. Course not added.");
                            }
                        }
                        faculty2.addCoursesTaught(coursesToAdd3);
                    } else {
                        System.out.println("Invalid faculty index.");
                    }
                    break;

                case 8:
                    // Add an array of 2 Courses to a Student object
                    int studentIndex2 = selectObject("Student", students);
                    if (studentIndex2 >= 0 && studentIndex2 < students.length) {
                        Student student2 = students[studentIndex2];
                        Course[] coursesToAdd4 = new Course[2];
                        for (int i = 0; i < 2; i++) {
                            System.out.print("Enter the index of Course " + (i + 1) + " to add: ");
                            int courseIndex = scanner.nextInt();
                            if (courseIndex >= 0 && courseIndex < courses.length) {
                                coursesToAdd4[i] = courses[courseIndex];
                            } else {
                                System.out.println("Invalid course index. Course not added.");
                            }
                        }
                        student2.addCoursesTaken(coursesToAdd4);
                    } else {
                        System.out.println("Invalid student index.");
                    }
                    break;

                case 9:
                    // Get the Course at an index from a Faculty object
                    int facultyIndex3 = selectObject("Faculty", faculties);
                    if (facultyIndex3 >= 0 && facultyIndex3 < faculties.length) {
                        Faculty faculty3 = faculties[facultyIndex3];
                        System.out.print("Enter the index of the Course to retrieve: ");
                        int courseIndex = scanner.nextInt();
                        Course retrievedCourse = faculty3.getCourseTaught(courseIndex);
                        if (retrievedCourse != null) {
                            System.out.println("Retrieved Course: " + retrievedCourse.toString());
                        } else {
                            System.out.println("Invalid course index.");
                        }
                    } else {
                        System.out.println("Invalid faculty index.");
                    }
                    break;

                case 10:
                    // Get the Course at an index from a Student object
                    int studentIndex3 = selectObject("Student", students);
                    if (studentIndex3 >= 0 && studentIndex3 < students.length) {
                        Student student3 = students[studentIndex3];
                        System.out.print("Enter the index of the Course to retrieve: ");
                        int courseIndex = scanner.nextInt();
                        Course retrievedCourse = student3.getCourseTaken(courseIndex);
                        if (retrievedCourse != null) {
                            System.out.println("Retrieved Course: " + retrievedCourse.toString());
                        } else {
                            System.out.println("Invalid course index.");
                        }
                    } else {
                        System.out.println("Invalid student index.");
                    }
                    break;

                case 11:
                    // Get the Course at an index from a Faculty object
                    int facultyIndex31 = selectObject("Faculty", faculties);
                    if (facultyIndex31 >= 0 && facultyIndex31 < faculties.length && faculties[facultyIndex31] != null) {
                        Faculty faculty3 = faculties[facultyIndex31];
                        System.out.print("Enter the index of the Course to retrieve: ");
                        int courseIndex = scanner.nextInt();
                        if (courseIndex >= 0 && courseIndex < faculty3.getNumCoursesTaught()) {
                            Course retrievedCourse = faculty3.getCourseTaught(courseIndex);
                            if (retrievedCourse != null) {
                                System.out.println("Retrieved Course: " + retrievedCourse.toString());
                            } else {
                                System.out.println("Invalid course index.");
                            }
                        } else {
                            System.out.println("Invalid course index.");
                        }
                    } else {
                        System.out.println("Invalid faculty index or faculty not found.");
                    }
                    break;

                case 12:
                    // Determine which Faculty teaches the most and least courses
                    Faculty mostTeaches = null;
                    Faculty leastTeaches = null;

                    int mostCoursesCount = -1;
                    int leastCoursesCount = Integer.MAX_VALUE;

                    for (Faculty faculty : faculties) {
                        if (faculty != null) {
                            int numCoursesTaught = faculty.getNumCoursesTaught();
                            
                            if (numCoursesTaught > mostCoursesCount) {
                                mostCoursesCount = numCoursesTaught;
                                mostTeaches = faculty;
                            }
                            
                            if (numCoursesTaught < leastCoursesCount) {
                                leastCoursesCount = numCoursesTaught;
                                leastTeaches = faculty;
                            }
                        }
                    }
                    
                    if (mostTeaches != null && leastTeaches != null) {
                        System.out.println("Faculty who teaches the most courses: " + mostTeaches.toString());
                        System.out.println("Faculty who teaches the least courses: " + leastTeaches.toString());
                    } else {
                        System.out.println("No Faculty objects found.");
                    }
                    break;
                    
                    
                    

                case 13:
                    // Determine which Course is the minimum of all Course objects in the catalog
                    Course minCourse = null;
                    for (Course course : courses) {
                        if (course != null) {
                            if (minCourse == null || course.compareTo(minCourse) < 0) {
                                minCourse = course;
                            }
                        }
                    }
                    if (minCourse != null) {
                        System.out.println("Course with the minimum course number: " + minCourse.toString());
                    } else {
                        System.out.println("No Course objects found.");
                    }
                    break;

                case 14:
                    // Determine which Course is the maximum of all Course objects in the catalog
                    Course maxCourse = null;
                    for (Course course : courses) {
                        if (course != null) {
                            if (maxCourse == null || course.compareTo(maxCourse) > 0) {
                                maxCourse = course;
                            }
                        }
                    }
                    if (maxCourse != null) {
                        System.out.println("Course with the maximum course number: " + maxCourse.toString());
                    } else {
                        System.out.println("No Course objects found.");
                    }
                    break;

                case 15:
                    // Determine which Student has the most and least credits
                    Student mostCreditsStudent = null;
                    Student leastCreditsStudent = null;
                    for (Student student : students) {
                        if (student != null) {
                            if (mostCreditsStudent == null || student.getNumCoursesTaken() > mostCreditsStudent.getNumCoursesTaken()) {
                                mostCreditsStudent = student;
                            }
                            if (leastCreditsStudent == null || student.getNumCoursesTaken() < leastCreditsStudent.getNumCoursesTaken()) {
                                leastCreditsStudent = student;
                            }
                        }
                    }
                    if (mostCreditsStudent != null && leastCreditsStudent != null) {
                        System.out.println("Student with the most credits: " + mostCreditsStudent.toString());
                        System.out.println("Student with the least credits: " + leastCreditsStudent.toString());
                    } else {
                        System.out.println("No Student objects found.");
                    }
                    break;

                case 16:
                    // Display all objects using toString
                    System.out.println("Courses:");
                    for (Course course : courses) {
                        if (course != null) {
                            System.out.println(course.toString());
                        }
                    }
                    System.out.println("Faculties:");
                    for (Faculty faculty : faculties) {
                        if (faculty != null) {
                            System.out.println(faculty.toString());
                        }
                    }
                    System.out.println("GeneralStaff:");
                    for (GeneralStaff generalStaff : generalStaffs) {
                        if (generalStaff != null) {
                            System.out.println(generalStaff.toString());
                        }
                    }
                    System.out.println("Students:");
                    for (Student student : students) {
                        if (student != null) {
                            System.out.println(student.toString());
                        }
             
                    }
                    break;
            
                    case 17:
                      break;  

            case 18:
                        // Exit the program
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }

            } while (option != 18);
    
    }
        // Helper method to select an object from an array
        private static int selectObject(String objectType, Object[] objects) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Select a " + objectType + " (Enter index): ");
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] != null) {
                    System.out.println(i + ". " + objects[i].toString());
                }
            }
        
            return scanner.nextInt();
        }
    
    
private static int selectObject1(String objectType, Object[] objects) {
    Scanner scanner = new Scanner(System.in);
    int selectedIndex = -1; // Initialize to an invalid index

    while (true) {
        System.out.print("Select a " + objectType + " (Enter index): ");
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                System.out.println(i + ". " + objects[i].toString());
            }
        }

        try {
            selectedIndex = scanner.nextInt();
            // Check if the selected index is valid
            if (selectedIndex >= 0 && selectedIndex < objects.length) {
                break; // Exit the loop if a valid index is provided
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid index.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    return selectedIndex;
}
}