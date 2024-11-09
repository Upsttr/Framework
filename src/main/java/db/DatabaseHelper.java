package db;

import config.ConfigManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    public static boolean isEmployeeInDatabase(int id) {
        String connectionString = ConfigManager.getDbConnectionString();
        String username = ConfigManager.getDbUsername();
        String password = ConfigManager.getDbPassword();

        try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
            String query = "SELECT * FROM employee WHERE id = " + id;
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean companyCheck(int companyId) {
        String connectionString = ConfigManager.getDbConnectionString();
        String username = ConfigManager.getDbUsername();
        String password = ConfigManager.getDbPassword();

        try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
            String query = "SELECT * FROM employee WHERE company_id = " + companyId;
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet.next();  // Возвращает true, если существует запись с заданным company_id
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
