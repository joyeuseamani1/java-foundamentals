public class Main {
public static void main(String[] args) {

Student student1 = new UndergraduateStudent(3.8);
Student student2 = new GraduateStudent(20, 6000);

System.out.println("Undergraduate Stipend: $" +
student1.calculateStipend());

System.out.println("Graduate Stipend: $" +
student2.calculateStipend());
}
}
