package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessPage {

    private final SelenideElement title = $x("//span[@data-test='title']");
    private final SelenideElement backHomeButton = $x("//button[@data-test='back-to-products']");

    public void verifySuccessMessage(String expectedMessage) {
        String actualMessage = title.getText().trim(); // Получаем текст из элемента и убираем лишние пробелы
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'");
        }
    }

    public void clickBackHome() {
        backHomeButton.click();
    }
}
