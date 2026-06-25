import java.util.List;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        int option;
        boolean status = true;

        System.out.println("""
                ---------------------------------------------------
                ----Welcome to Student Result Management System----
                ---------------------------------------------------""");
        while (status) {

            System.out.print("""
                \n1. Add Student.
                2. View All Student.
                3. Search Student.
                4. Remove Student.
                5. Show Best Student.
                6. Show Average Score.
                7. Exit
                Input between (1-7):\s""");
            option = input.nextInt();

            switch (option) {
                case 1 -> addStudent(studentManager);
                case 2 -> viewAllStudent(studentManager);
                case 3 -> searchStudent(studentManager);
                case 4 -> removeStudent(studentManager);
                case 5 -> bestStudent(studentManager);
                case 6 -> averageScore(studentManager);
                case 7 -> {
                    System.out.println("Thank you for using the Product! See you later!");
                    status = false;
                }
                default -> System.out.println("Invalid Option!");
            }


        }

    }

    private static void addStudent(StudentManager studentManager) {
        int studentId;
        String studentName;
        String studentCourse;
        int studentScore;
        Student student;

        System.out.print("\nEnter Student Id No: ");
        studentId = input.nextInt();

        input.nextLine();
        System.out.print("Enter Student FullName: ");
        studentName = input.nextLine();

        System.out.print("Enter Student Course: ");
        studentCourse = input.nextLine();

        System.out.print("Enter Student Score: ");
        studentScore = input.nextInt();

        student = new Student(studentId, studentName, studentCourse, studentScore);

        studentManager.addStudent(student);
        System.out.println("Student registered!");
    }

    private static void viewAllStudent(StudentManager studentManager) {

        if (studentManager.getAllStudent() == null) {
            System.out.println("No Student has been Added!");
        } else {
            System.out.println("\nStudent list: ");
            List<Student> allStudents = studentManager.getAllStudent();
            int i = 1;
            for (Student student: allStudents) {
                System.out.println(i + ". " + student.getName());
                i +=1;
        }


        }
    }

    private static void searchStudent(StudentManager studentManager) {

        int studentId;
        Student student;
        String grade;

        System.out.print("Enter StudentId: ");
        studentId = input.nextInt();

        try {
            student = studentManager.findStudentById(studentId);
            grade = studentManager.gradeCalc(student.getScore());
            System.out.printf("%n%-20s %d" +
                              "%n%-20s %s" +
                              "%n%-20s %s" +
                              "%n%-20s %d",
                              "StudentID: ", studentId,
                              "Student Name: ", student.getName(),
                              "Student Course: ", student.getCourse(),
                              "Student Score: ", student.getScore(),
                              "Student Grade: ", grade);
        } catch (StudentNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }
        input.nextLine();
    }

    private static void removeStudent(StudentManager studentManager) {

        int studentId;
        String studentName;

        System.out.print("Enter StudentId: ");
        studentId = input.nextInt();

        studentName = studentManager.findStudentById(studentId).getName();
        studentManager.removeStudent(studentId);
        System.out.println(studentName + " has been removed!");

    }

    private static void bestStudent(StudentManager studentManager)  {

        System.out.println("The Name of the Best student is " + studentManager.getBestStudent().getName());
    }

    private static void averageScore(StudentManager studentManager) {

        System.out.println("The average score of all students is " + studentManager.calculateAverageScore());
    }
}