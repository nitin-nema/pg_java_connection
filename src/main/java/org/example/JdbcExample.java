package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) {
        try {
            // Load PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            String url = "jdbc:postgresql://localhost:5432/jdbcdatabase";
            String user = "postgres"; // Replace with your PostgreSQL username
            String password = "postgres"; // Replace with your PostgreSQL password
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create a Statement
            Statement stmt = conn.createStatement();

            // Create Table (Example)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Employees (id SERIAL PRIMARY KEY, name VARCHAR(50))";
            stmt.execute(createTableSQL);

            // Insert Data
            String insertSQL = "INSERT INTO Employees (name) VALUES ('Nivedita')";
            stmt.executeUpdate(insertSQL);

            // Read Data
            String selectSQL = "SELECT * FROM Employees";

            // Result set
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Update Data
            String updateSQL = "UPDATE Employees SET name = 'Madhuri' WHERE id = 1";
            stmt.executeUpdate(updateSQL);

            // Delete Data
            String deleteSQL = "DELETE FROM Employees WHERE id = 1";
            stmt.executeUpdate(deleteSQL);

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
