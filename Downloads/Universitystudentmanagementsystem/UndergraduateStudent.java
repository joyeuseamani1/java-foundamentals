public class UndergraduateStudent extends Student {

    public UndergraduateStudent(int id, String name, double gpa) {
        super(id, name, gpa);
    }

    @Override
    public double calculateGPA() {
        return getGpa();
    }
}
