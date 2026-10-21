giimport java.util.List;
import java.util.Map;

public class Student {

    private int id;
    private String studentName;
    private int age;
    private Map<String, Double> courses;
    private List<String> skills;
    private boolean bonusApplied;

    public Student(int id,
                   String studentName,
                   int age,
                   Map<String, Double> courses,
                   List<String> skills) {

        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.courses = courses;
        this.skills = skills;
        this.bonusApplied = false;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public Map<String, Double> getCourses() {
        return courses;
    }

    public List<String> getSkills() {
        return skills;
    }

    public boolean isBonusApplied() {
        return bonusApplied;
    }

    public void setBonusApplied(boolean bonusApplied) {
        this.bonusApplied = bonusApplied;
    }

    public double calculateStipend() {
        return 0;
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Name='" + studentName + '\'' +
                ", Age=" + age +
                ", Courses=" + courses +
                ", Skills=" + skills;
    }
}