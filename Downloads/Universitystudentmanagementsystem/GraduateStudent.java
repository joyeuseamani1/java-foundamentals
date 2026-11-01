public class GraduateStudent extends Student {

    public GraduateStudent(int id, String name, double gpa) {
        super(id, name, gpa);
    }

    @Override
    public double calculateGPA() {
        return getGpa() + 0.2;
    }
}
