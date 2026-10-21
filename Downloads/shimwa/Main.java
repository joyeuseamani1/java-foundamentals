public class Main {

    public static void main(String[] args) {

        RegistryManager manager = new RegistryManager();

        manager.loadStudentsFromFile("students.txt");

        manager.displayAllStudents();

        manager.groupStudentsByMajor();
    }
}
