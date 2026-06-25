import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentManager {

    //ArrayList<Student> studentList = new ArrayList<>();
    HashMap<Integer, Student> studentList = new HashMap<>();

    void addStudent(Student student) {

        if (studentList.containsKey(student.getStudentId())) {
            throw new StudentNotFound("Student with Id " + student.getStudentId() + " already Exists");
        } else {
            studentList.put(student.getStudentId(), student);
        }
    }

    Student findStudentById(int studentId) {

        Student student = studentList.get(studentId);

        if (student == null) {
            throw new StudentNotFound("Student with Id " + studentId + " was not found");
        }
        return student;
    }

    void removeStudent(int studentId) {

        studentList.remove(studentId);
    }

    List<Student> getAllStudent () {

        if (studentList == null || studentList.isEmpty()){
            return null;
        }
        return new ArrayList<>(studentList.values());
    }

    double calculateAverageScore() {
        int totalScore = 0;
        int size = studentList.size();
        for(Student student: studentList.values()) {
            totalScore += student.getScore();
        }

        return ((double) totalScore / size);
    }

    Student getBestStudent() {
        if (studentList == null || studentList.isEmpty()) {

            return null;
        }
            Student bestStudent = null;
        for (Student currentStudent: studentList.values()){

            if (bestStudent == null || currentStudent.getScore() > bestStudent.getScore()) {

                bestStudent = currentStudent;
            }
        }

        return bestStudent;
    }

    String gradeCalc(int score) {
        String grade = null;
        if (score <= 100 && score >= 70) {
            grade = "A";
        } else if (score < 70 && score >= 60) {
            grade = "B";
        } else if (score < 60 && score >= 50) {
            grade = "C";
        } else if (score < 50 && score >= 45) {
            grade = "D";
        } else if (score < 45) {
            grade = "F";
        } else {
            grade = "Invalid Score!";
        }

        return grade;
    }
}
