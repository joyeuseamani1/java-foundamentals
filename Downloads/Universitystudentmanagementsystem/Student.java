public class Student extends Person {

    private double gpa;

    public Student(int id, String name, double gpa) {
        super(id, name);
        this.gpa = gpa;
    }

    public double calculateGPA() {
        return gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", GPA: " + gpa;
    }
}
