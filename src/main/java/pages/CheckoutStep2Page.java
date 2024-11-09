package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutStep2Page {

    private final SelenideElement totalLabel = $x("//div[@class='summary_total_label']");
    private final SelenideElement finishButton = $x("//button[@data-test='finish']");

    public void verifyTotalAmount(String expectedTotal) {
        String actualTotal = totalLabel.getText().trim(); // Получаем текст из элемента и убираем лишние пробелы
        if (!actualTotal.equals(expectedTotal)) {
            throw new AssertionError("Expected total: " + expectedTotal + ", but got: " + actualTotal);
        }
    }

    public void clickFinish() {
        finishButton.click();
    }
}
