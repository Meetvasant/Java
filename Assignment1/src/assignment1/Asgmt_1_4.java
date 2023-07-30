
package assignment1;

import java.sql.*;

public class Asgmt_1_4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/stud";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM info");

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            System.out.println("Column Properties:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + " Name: " + rsmd.getColumnName(i));
                System.out.println("Column " + i + " Type: " + rsmd.getColumnTypeName(i));
                System.out.println("Column " + i + " Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println("Column " + i + " Nullable: " + (rsmd.isNullable(i) == ResultSetMetaData.columnNullable ? "YES" : "NO"));
                System.out.println("----------------------------");
            }

            // Close the resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
