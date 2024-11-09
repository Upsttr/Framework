package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.XPathSelectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    private final ElementsCollection cartItems = $$x("//div[@class='cart_item']");

    private final SelenideElement checkoutButton = $x("//button[@id='checkout']");

    public void shouldHaveItemsInCart(int expectedCount) {
        cartItems.shouldHave(CollectionCondition.size(expectedCount));
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}


