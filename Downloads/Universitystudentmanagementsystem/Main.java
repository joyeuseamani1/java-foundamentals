import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {


        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Alice", 3.8));
        students.add(new GraduateStudent(2, "Bob", 3.5));

        Set<Course> courses = new HashSet<>();

        courses.add(new Course(101, "Java"));
        courses.add(new Course(102, "Database"));

        Map<String, Instructor> instructors = new HashMap<>();

        instructors.put(
                "Java",
                new Instructor(1, "John", "Computer Science")
        );

        instructors.put(
                "Database",
                new Instructor(2, "Mary", "Information Systems")
        );

        System.out.println("STUDENTS");

        for (Student s : students) {
            System.out.println(s);
            System.out.println("Calculated GPA: "
                    + s.calculateGPA());
        }

        System.out.println("\nCOURSES");

        for (Course c : courses) {
            System.out.println(c);
        }

        System.out.println("\nINSTRUCTORS");

        for (String course : instructors.keySet()) {
            System.out.println(
                    course + " -> "
                            + instructors.get(course).getName()
            );
        }



        StudentDAO dao = new StudentDAO();
        dao.addStudent(new Student(1, "Alice", 3.8)
        );

        System.out.println("\nALL STUDENTS");

        dao.getAllStudents();

        dao.updateStudent(1, 4.0);

        dao.deleteStudent(1);



        CourseDAO courseDAO = new CourseDAO();

        courseDAO.addCourse("Java");

        courseDAO.getAllCourses();



        EnrollmentDAO enrollmentDAO =
                new EnrollmentDAO();

        enrollmentDAO.enrollStudent(2, 1);



        ReportDAO reportDAO =
                new ReportDAO();

        reportDAO.viewStudentCourses();
    }
}
