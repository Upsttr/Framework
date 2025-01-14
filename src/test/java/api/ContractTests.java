package api;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractTests {


    private static String userToken;
    private static int companyId;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = ConfigManager.getBaseUrl();
        userToken = AuthService.authenticateAndGetUserToken();
        companyId = CompanyService.createCompanyAndGetId(userToken);
    }

    @Test
    @DisplayName("Авторизация и получение токена")
    public void authCheck() {
        AuthService.authenticateAndGetUserToken();
        System.out.println("Администратор авторизован");
    }

    @Test
    @DisplayName("Запрашиваем список сотрудников")
    public void employeeListCheck() {
        EmployeeService.getEmployeesByCompanyId(companyId);
    }

    @Test
    @DisplayName("Добавление сотрудника")
    public void addEmployeeCheck() {
        int id = EmployeeService.addNewEmployee(userToken, companyId);
    }

    @Test
    @DisplayName("Создание компании")
    public void addCompanyCheck() {
        int companyId = CompanyService.createCompanyAndGetId(userToken);
    }

    @Test
    @DisplayName("Редактирование данных сотрудника")
    public void employeeEditCheck() {
        int id = EmployeeService.addNewEmployee(userToken, companyId);
        Response response = EmployeeService.editEmployee(userToken, id);
        assertEquals(200, response.statusCode());
    }

    @Test
    @DisplayName("Получение данных сотрудника")
    public void getEmployeeInfo() {
        int id = EmployeeService.addNewEmployee(userToken, companyId);
        EmployeeService.getEmpInfo(id);
    }
}
