package ui;

import utils.ScreenshotMaker;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.RandomDataGenerator;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class EndToEndTest extends ScreenshotMaker {

    @Test
    @DisplayName("E2E тест для standard_user")
    public void testEndToEndStandardUser() {
        successfulLogin("standard_user", "secret_sauce");
        addItemsToCart();
        goToCart();
        cartCheck();
        checkout();
        fillTheForms();
        checkTotals();
        successCheck();
        backHome();
    }

    @Test
    @DisplayName("E2E тест для performance_glitch_user")
    public void testEndToEndPerformanceGlitchUser() {
        successfulLogin("performance_glitch_user", "secret_sauce");
        addItemsToCart();
        goToCart();
        cartCheck();
        checkout();
        fillTheForms();
        checkTotals();
        successCheck();
        backHome();
    }

    @Step("Авторизация")
    public void successfulLogin(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage().login(username, password);
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        webdriver().shouldHave(url(expectedUrl));
    }

    @Step("Добавление товаров в корзину")
    public void addItemsToCart() {
        ProductsPage productsPage = new ProductsPage();
        productsPage.addFirstThreeProductsToCart();
        productsPage.shouldHaveCartItemCount(3);
    }

    @Step("Переход в корзину")
    public void goToCart() {
        ProductsPage productsPage = new ProductsPage();
        productsPage.goToCart();
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        webdriver().shouldHave(url(expectedUrl));
    }

    @Step("Проверка товаров в корзине")
    public void cartCheck() {
        CartPage cartPage = new CartPage();
        cartPage.shouldHaveItemsInCart(3);
    }

    @Step("Переход к оплате")
    public void checkout() {
        CartPage cartPage = new CartPage();
        cartPage.proceedToCheckout();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        webdriver().shouldHave(url(expectedUrl));
    }

    @Step("Заполнение информации")
    public void fillTheForms() {
        CheckoutPage checkoutPage = new CheckoutPage();
        String firstName = RandomDataGenerator.generateRandomFirstName();
        String lastName = RandomDataGenerator.generateRandomLastName();
        String postalCode = RandomDataGenerator.generateZipCode();
        checkoutPage.enterPersonalInfo(firstName, lastName, postalCode);
        checkoutPage.clickContinue();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        webdriver().shouldHave(url(expectedUrl));
    }

    @Step("Проверка суммы")
    public void checkTotals() {
        CheckoutStep2Page checkoutStep2Page = new CheckoutStep2Page();
        checkoutStep2Page.verifyTotalAmount("Total: $58.299");
        checkoutStep2Page.clickFinish();
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        webdriver().shouldHave(url(expectedUrl));
    }

    @Step("Проверка успешной оплаты")
    public void successCheck() {
        SuccessPage successPage = new SuccessPage();
        successPage.verifySuccessMessage("Checkout: Complete!");
    }

    @Step("Возврат в магазин")
    public void backHome() {
        SuccessPage successPage = new SuccessPage();
        successPage.clickBackHome();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        webdriver().shouldHave(url(expectedUrl));
    }
}
