import java.sql.*;

public class CollegeManagementSystem {
    public static void main(String[] args) {
        // Use UCanAccess JDBC driver instead of ODBC
        String dbURL = "jdbc:ucanaccess://C:/webassign/collegeDB.accdb";  // Correct path to Access file

        try {
            // Load UCanAccess driver (this step is optional in newer versions)
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();

            // 🔹 Test Query: Retrieve all records from "Courses" table
            String testSQL = "SELECT * FROM Courses";
            ResultSet rs = stmt.executeQuery(testSQL);

            // 🔹 Print retrieved records
            System.out.println("Testing Database Connection: Courses Table Records");
            while (rs.next()) {
                System.out.println("CourseID: " + rs.getInt("CourseID") +
                        " | Name: " + rs.getString("Name") +
                        " | Credits: " + rs.getInt("Credits"));
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();  // Print any connection errors
        }
    }
}
