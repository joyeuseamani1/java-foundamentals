import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistryManager {

    private List<Student> students = new ArrayList<>();

    public void loadStudentsFromFile(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double gpa = Double.parseDouble(data[2].trim());
                String major = data[3].trim();

                Student student = new Student(id, name, gpa, major);

                students.add(student);
            }

            System.out.println("Students loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void displayAllStudents() {

        System.out.println("\nALL STUDENTS");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void groupStudentsByMajor() {

        Map<String, List<String>> groupedStudents = new HashMap<>();

        for (Student student : students) {

            String major = student.getMajor();

            if (!groupedStudents.containsKey(major)) {
                groupedStudents.put(major, new ArrayList<>());
            }

            groupedStudents.get(major).add(student.getName());
        }

        System.out.println("\nSTUDENTS GROUPED BY MAJOR");

        for (String major : groupedStudents.keySet()) {
            System.out.println("\n" + major + ":");

            for (String name : groupedStudents.get(major)) {
                System.out.println(name);
            }
        }
    }
}
    

