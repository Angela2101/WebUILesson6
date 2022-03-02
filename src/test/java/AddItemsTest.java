import org.junit.jupiter.api.*;

public class AddItemsTest extends AbstractTest{
    @Test
    void AddItemTest() throws InterruptedException {

        new HappySushiMainPage(getWebDriver()).navigateToSet();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Happy Sushi"), "Cтраница входа недоступна");
        new HappySushiMainPage(getWebDriver()).selectSet();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Сет 4 Оранж"), "Другая страница");
        new ItemPage(getWebDriver()).addItemAndNavigateToCart();
    }

    @Test
    void AddDoubleItemTest() throws InterruptedException {

        new HappySushiMainPage(getWebDriver()).navigateToItem();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Happy Sushi"), "Cтраница входа недоступна");
        new HappySushiMainPage(getWebDriver()).selectItem();
        new ItemPage(getWebDriver()).navigateToCart();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Ваша корзина"), "Другая страница");
        new CartPage(getWebDriver()).plusItem();
        new CartPage(getWebDriver()).goToDesign();
    }

}
