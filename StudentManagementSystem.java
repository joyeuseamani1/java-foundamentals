import java.util.*;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student By ID");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudentById();
                    break;
                case 4:
                filterPassingStudents();
                break;

                case 5:

                filterFailingStudents();

                break;


                case 6:

                searchStudentsByName();

                break;


                case 7:

                sortStudentsByName();

                break;


                case 8:

                sortStudentsByAverage();

                break;


                case 9:

                displayAllCourses();

                break;


                case 10:

                displayUniqueCourses();

                break;


                case 11:

                searchStudentsByCourse();

                break;


                case 12:

                displayUniqueSkills();

                break;


                case 13:

                groupStudentsByCourse();

                break;


                case 14:

                performanceStatistics();

                break;


                case 15:

                bestPerformingStudent();

                break;


                case 16:

                topThreeStudents();

                break;


                case 17:

                applyBonusMarks();

                break;


                case 18:

                finalRanking();

                break;
            

                case 0:   

                System.out.println("Program Closed");
                

                break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 0);
    }

    public static void registerStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = students.stream()
                .anyMatch(s -> s.getId() == id);

        if (found) {
            System.out.println("ID Already Exists");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        Map<String, Double> courses = new HashMap<>();

        System.out.print("Number Of Courses: ");
        int courseCount = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= courseCount; i++) {

            System.out.print("Course Name: ");
            String course = sc.nextLine();

            System.out.print("Mark: ");
            double mark = sc.nextDouble();
            sc.nextLine();

            courses.put(course, mark);
        }

        List<String> skills = new ArrayList<>();

        System.out.print("Number Of Skills: ");
        int skillCount = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= skillCount; i++) {

            System.out.print("Skill: ");
            skills.add(sc.nextLine());
        }

        Student student =
                new Student(id, name, age, courses, skills);

        students.add(student);

        System.out.println("Student Registered Successfully");
    }

    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Registered");
            return;
        }

        students.forEach(System.out::println);
    }

    public static void searchStudentById() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (student == null) {
            System.out.println("Student Not Found");
        } else {
            System.out.println(student);
        }
    
    }
    public static double calculateAverage(Student student) {

    return student.getCourses()
            .values()
            .stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0);
}
public static void filterPassingStudents() {

    students.stream()
            .filter(student -> calculateAverage(student) >= 65)
            .forEach(System.out::println);
}
public static void filterFailingStudents() {

    students.stream()
            .filter(Student -> calculateAverage(Student) < 65)
            .forEach(System.out::println);
}
public static void searchStudentsByName() {

    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    students.stream()
            .filter(student ->
                    student.getStudentName()
                            .toLowerCase()
                            .contains(name.toLowerCase()))
            .forEach(System.out::println);
}
public static void sortStudentsByName() {

    students.stream()
            .sorted(Comparator.comparing(Student::getStudentName))
            .forEach(System.out::println);
}
public static void sortStudentsByAverage() {

    students.stream()
            .sorted((s1, s2) ->
                    Double.compare(
                            calculateAverage(s2),
                            calculateAverage(s1)))
            .forEach(System.out::println);
}
public static void displayAllCourses() {

    students.stream()
            .flatMap(student ->
                    student.getCourses()
                            .keySet()
                            .stream())
            .forEach(System.out::println);
}
public static void displayUniqueCourses() {

    students.stream()
            .flatMap(student ->
                    student.getCourses()
                            .keySet()
                            .stream())
            .distinct()
            .forEach(System.out::println);
}
public static void searchStudentsByCourse() {

    System.out.print("Enter Course: ");
    String course = sc.nextLine();

    students.stream()
            .filter(student ->
                    student.getCourses().containsKey(course))
            .forEach(System.out::println);
}
public static void displayUniqueSkills() {

    students.stream()
            .flatMap(student ->
                    student.getSkills().stream())
            .distinct()
            .forEach(System.out::println);
}
public static void groupStudentsByCourse() {

    students.forEach(student -> {

        student.getCourses().keySet().forEach(course -> {

            System.out.println(course + " : "
                    + student.getStudentName());

        });

    });
}
public static void performanceStatistics() {

students.forEach(student -> {

double highest = student.getCourses()
.values()
.stream()
.mapToDouble(Double::doubleValue)
.max()
.orElse(0);

double lowest = student.getCourses()
.values()
.stream()
.mapToDouble(Double::doubleValue)
.min()
.orElse(0);

double sum = student.getCourses()
.values()
.stream()
.mapToDouble(Double::doubleValue)
.sum();

System.out.println("\nStudent: "
+ student.getStudentName());

System.out.println("Average = "
+ calculateAverage(student));

System.out.println("Highest = "
+ highest);

System.out.println("Lowest = "
+ lowest);

System.out.println("Total = "
+ sum);

System.out.println("Courses = "
+ student.getCourses().size());
});
}
public static void bestPerformingStudent() {

    Student best = students.stream()
            .max(Comparator.comparingDouble(
                    StudentManagementSystem::calculateAverage))
            .orElse(null);

    if(best != null){
        System.out.println(best);
    }
}
public static void topThreeStudents() {

    students.stream()
            .sorted((s1, s2) ->
                    Double.compare(
                            calculateAverage(s2),
                            calculateAverage(s1)))
            .limit(3)
            .forEach(System.out::println);
}
public static void applyBonusMarks() {

students.stream()
.filter(student ->
calculateAverage(student) > 50
&& !student.isBonusApplied())
.forEach(student -> {

student.getCourses()
.replaceAll((course, mark)
-> Math.min(mark + 10, 100));

student.setBonusApplied(true);
});

System.out.println("Bonus Applied");
}
public static void finalRanking() {

    students.stream()
            .sorted((s1, s2) ->
                    Double.compare(
                            calculateAverage(s2),
                            calculateAverage(s1)))
            .forEach(student ->
                    System.out.println(
                            student.getStudentName()
                                    + " = "
                                    + calculateAverage(student)));
}
}

