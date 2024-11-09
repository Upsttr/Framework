package db;


import api.AuthService;
import api.CompanyService;
import api.EmployeeService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


public class DBTests {
    private static String userToken;
    private static int companyId;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://x-clients-be.onrender.com";
        userToken = AuthService.authenticateAndGetUserToken();
        companyId = CompanyService.createCompanyAndGetId(userToken);
    }

    @Test
    @DisplayName("Добавление сотрудника и проверка его в базе по id")
    public void addEmployeeCheckDB() throws SQLException {
        int id = EmployeeService.addNewEmployee(userToken, companyId);
        boolean isEmployeeInDb = DatabaseHelper.isEmployeeInDatabase(id);
        assertTrue(isEmployeeInDb);

    }

    @Test
    @DisplayName("Смотрим в базе, что в компанию добавился сотрудник")
    public void checkEmployeeByCompany() throws SQLException {
        EmployeeService.addNewEmployee(userToken, companyId);
        boolean isEmployeeInCompany = DatabaseHelper.companyCheck(companyId);
        assertTrue(isEmployeeInCompany);
    }

    @Test
    @DisplayName("Создаем компанию и проверяем, что она пустая")
    public void isCompanyEmpty() throws SQLException {
        CompanyService.createCompanyAndGetId(userToken);
        boolean isEmployeeInCompany = DatabaseHelper.companyCheck(companyId);
        assertFalse(isEmployeeInCompany);
    }
}
