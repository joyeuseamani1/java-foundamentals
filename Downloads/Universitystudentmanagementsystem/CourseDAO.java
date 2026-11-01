import java.sql.*;

public class CourseDAO {

    private static final String URL =
            "jdbc:postgresql://localhost:12345/university";

    private static final String USER = "postgres";
    private static final String PASSWORD = "Rizikijeannette1@";


    public void addCourse(String courseName) {

        String sql =
                "insert into courses(course_name) values (?)";

        try (
                Connection conn =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, courseName);

            ps.executeUpdate();

            System.out.println("Course Added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getAllCourses() {

        String sql = "select * from courses";

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
                        rs.getInt("id") + " "
                                + rs.getString("course_name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteCourse(int id) {

        String sql =
                "delete from courses where id = ?";

        try (
                Connection conn =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Course Deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

