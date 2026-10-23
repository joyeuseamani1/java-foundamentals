import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        RegistryManager manager = new RegistryManager();

        manager.loadStudentsFromFile("students.txt");

        manager.displayAllStudents();

        manager.groupStudentsByMajor();

        try {
            FileWriter writer = new FileWriter("student.txt");

            writer.write("Students loaded successfully.\n");
            writer.write("Student records displayed.\n");

            writer.close();

            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
