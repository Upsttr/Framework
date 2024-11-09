package pages;
import elements.XPathSelectors;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public LoginPage openPage() {
        open("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage enterUsername(String username) {
        XPathSelectors.USERNAME_FIELD.setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        XPathSelectors.PASSWORD_FIELD.setValue(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        XPathSelectors.LOGIN_BUTTON.click();
        return this;
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}


