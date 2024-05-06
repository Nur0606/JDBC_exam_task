package peaksoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbs_db {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_exam",
                    "postgres",
                    "1234");

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
