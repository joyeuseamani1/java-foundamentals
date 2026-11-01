import java.sql.*;

public class EnrollmentDAO {

    private static final String URL =
            "jdbc:postgresql://localhost:12345/university";

    private static final String USER = "postgres";
    private static final String PASSWORD = "Rizikijeannette1@";

    public void enrollStudent(int studentId, int courseId) {

        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?) ON CONFLICT DO NOTHING";

        try (
                Connection conn =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();

            System.out.println("Student Enrolled");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}