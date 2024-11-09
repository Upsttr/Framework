package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public final class XPathSelectors {

    private XPathSelectors() {

    }

    public static final SelenideElement LOGIN_BUTTON = $(By.xpath("//input[@id='login-button']"));
    public static final SelenideElement USERNAME_FIELD = $(By.xpath("//input[@id='user-name']"));
    public static final SelenideElement PASSWORD_FIELD = $(By.xpath("//input[@id='password']"));
    public static final SelenideElement PROFILE_ICON = $(By.xpath("//div[@class='profile-icon']"));
    private static final ElementsCollection CART_ITEMS = $$(String.valueOf(By.xpath("//div[@class='cart_item']")));
    private static final SelenideElement CHECKOUT_BUTTON = $(By.xpath("//button[@id='checkout']"));

}
