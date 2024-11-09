package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

    private final String firstProductAddToCartButtonXpath = "//button[@id='add-to-cart-sauce-labs-backpack']";
    private final String secondProductAddToCartButtonXpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']";
    private final String thirdProductAddToCartButtonXpath = "//button[@id='add-to-cart-sauce-labs-onesie']";
    private final SelenideElement cartBadge = $x("//span[@data-test='shopping-cart-badge']");

    public void addFirstProductToCart() {
        $x(firstProductAddToCartButtonXpath).click();
    }

    public void addSecondProductToCart() {
        $x(secondProductAddToCartButtonXpath).click();
    }

    public void addThirdProductToCart() {
        $x(thirdProductAddToCartButtonXpath).click();
    }

    public void addFirstThreeProductsToCart() {
        addFirstProductToCart();
        addSecondProductToCart();
        addThirdProductToCart();
    }


    public void shouldHaveCartItemCount(int expectedCount) {
        cartBadge.shouldHave(Condition.text(String.valueOf(expectedCount)));
    }

    public void goToCart() {
        cartBadge.click();

    }
}
