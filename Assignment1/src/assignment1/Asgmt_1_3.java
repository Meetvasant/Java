package assignment1;

import java.sql.*;
import java.util.Scanner;

public class Asgmt_1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/stud";
            Connection con = DriverManager.getConnection(url, "root", "");

            // Prepare the stored procedure call
            String callProcedure = "{call insert_info(?, ?, ?, ?)}";
            CallableStatement cstmt = con.prepareCall(callProcedure);

            // Input data from the user
            System.out.println("Enter Your ID : ");
            int id = sc.nextInt();
            System.out.println("Enter Your Name : ");
            String nm = sc.next();
            System.out.println("Enter Your City : ");
            String city = sc.next();

            // Set values for stored procedure parameters
            cstmt.setInt(1, id);
            cstmt.setString(2, nm);
            cstmt.setString(3, city);

            // Register the OUT parameters (index 4) as INTEGER
            cstmt.registerOutParameter(4, Types.INTEGER);

            // Execute the stored procedure
            cstmt.execute();

            // Get the OUT parameter value
            int outParameter = cstmt.getInt(4);
            if (outParameter == 1) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert the data.");
            }

            // Close the resources
            cstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
