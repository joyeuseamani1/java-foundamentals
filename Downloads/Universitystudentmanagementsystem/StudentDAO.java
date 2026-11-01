import java.sql.*;

public class StudentDAO {

    private static final String URL =
            "jdbc:postgresql://localhost:12345/university";

    private static final String USER = "postgres";
    private static final String PASSWORD = "Rizikijeannette1@";


    public void addStudent(Student student) {

        String sql =
                "insert into students(name, gpa) values (?, ?)";

        try (
                Connection conn =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, student.getName());
            ps.setDouble(2, student.getGpa());

            ps.executeUpdate();

            System.out.println("Student Added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getAllStudents() {

        String sql = "select * from students";

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
                        + rs.getString("name") + " "
                        + rs.getDouble("gpa")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateStudent(int id, double gpa) {

        String sql =
                "update students set gpa = ? where id = ?";

        try (
                Connection conn =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setDouble(1, gpa);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

if (rows > 0) {
    System.out.println("Student Updated Successfully");
} else {
    System.out.println("Student ID not found");
}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteStudent(int id) {

        String sql =
                "delete from students where id = ?";

        try (
                Connection conn =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

if (rows > 0) {
    System.out.println("Student Deleted Successfully");
} else {
    System.out.println("Student ID not found");
}

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
