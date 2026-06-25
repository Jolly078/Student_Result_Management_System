
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int score;

    Student(int studentId, String name, String course, int score) {

        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this. score = score;
    }

    //Getters
    int getStudentId () {
        return studentId;
    }

    String getName() {
        return name;
    }

    String getCourse() {
        return course;
    }

    int getScore() {
        return score;
    }

    //Setters
    void setStudentId(int studentId){
        this.studentId = studentId;
    }

    void setName (String name) {
        this.name = name;
    }

    void setCourse(String course) {
        this.course = course;
    }

    void setScore (int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
