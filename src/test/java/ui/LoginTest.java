package ui;

import com.codeborne.selenide.*;
import utils.ScreenshotMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends ScreenshotMaker {

    @Test
    @DisplayName("Авторизация")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .login("standard_user1", "secret_sauce");
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        webdriver().shouldHave(WebDriverConditions.url(expectedUrl));
    }

    @Test
    @DisplayName("Авторизация заблокированного пользователя")
    public void blockedUserLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .login("locked_out_user", "secret_sauce");
        $x("//*[@id='login_button_container']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    @DisplayName("Авторизация с неверным паролем")
    public void invalidPasswordLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .login("standard_user", "123456");
        $x("//*[@id='login_button_container']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    @DisplayName("Авторизация без логина")
    public void noLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .login("", "secret_sauce");
        $x("//*[@id='login_button_container']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Epic sadface: Username is required"));
    }

    @Test
    @DisplayName("Авторизация без пароля")
    public void noPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .login("standard_user", "");
        $x("//*[@id='login_button_container']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Epic sadface: Password is required"));
    }


}







