package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage {

    private final SelenideElement firstNameInput = $x("//input[@data-test='firstName']");
    private final SelenideElement lastNameInput = $x("//input[@data-test='lastName']");
    private final SelenideElement postalCodeInput = $x("//input[@data-test='postalCode']");

    private final SelenideElement continueButton = $x("//input[@data-test='continue']");

    public void enterPersonalInfo(String firstName, String lastName, String postalCode) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        postalCodeInput.setValue(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
