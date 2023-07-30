package assignment1;

import java.sql.*;
import java.util.*;

public class Asgmt_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/stud";
            Connection con = DriverManager.getConnection(url, "root", "");

            // Use PreparedStatement for insert operation
            PreparedStatement ps = con.prepareStatement("INSERT INTO info (id, name, city) VALUES (?, ?, ?)");

            System.out.println("Enter Your ID : ");
            int id = sc.nextInt();
            System.out.println("Enter Your Name : ");
            String nm = sc.next();
            System.out.println("Enter Your City : ");
            String city = sc.next();

            // Set values for placeholders in the prepared statement
            ps.setInt(1, id);
            ps.setString(2, nm);
            ps.setString(3, city);

            // Execute the prepared statement
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert the data.");
            }

            // Close the resources
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
