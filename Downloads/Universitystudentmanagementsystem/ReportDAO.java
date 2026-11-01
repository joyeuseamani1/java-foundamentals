import java.sql.*;

public class ReportDAO {

    private static final String URL =
            "jdbc:postgresql://localhost:12345/university";

    private static final String USER = "postgres";
    private static final String PASSWORD = "Rizikijeannette1@";

    public void viewStudentCourses() {

        String sql = """
                select s.name,
                       c.course_name
                from students s
                join enrollments e
                on s.id = e.student_id
                join courses c
                on c.id = e.course_id
                """;

        try (
                Connection conn =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                Statement stmt =
                        conn.createStatement();

                ResultSet rs =
                        stmt.executeQuery(sql)
        ) {

            while (rs.next()) {

                System.out.println(
                        rs.getString("name")
                                + " -> "
                                + rs.getString("course_name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
