import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.Set;

public class LoginTest extends AbstractTest{

     @Test
    void loginPositiveTest() throws InterruptedException {
        new HappySushiMainPage(getWebDriver()).goToAccountPage();
         Assertions.assertTrue(getWebDriver().getTitle().equals("Вход в личный кабинет"), "страница входа недоступна");
        new LoginPage(getWebDriver()).loginIn("lik.bobrova@yandex.ru","Angela21A");

        Thread.sleep(3000);
         Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//button[@class='tabs__nav-item active']")).getText().equals("Личный кабинет"), "Другая страница");
    }

    @Test
    void loginNegativeTest() throws InterruptedException {
        new HappySushiMainPage(getWebDriver()).goToAccountPage();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Вход в личный кабинет"), "страница входа недоступна");
        new LoginPage(getWebDriver()).loginIn("5555","Angela2221A");

        Thread.sleep(2000);
        Assertions.assertTrue(getWebDriver().getTitle().equals("Вход в личный кабинет"), "Другая страница");
    }

    @Test
    void AuthorizeCheckHistoryAndLogOutTest() throws InterruptedException {


        new HappySushiMainPage(getWebDriver()).goToAccountPage();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Вход в личный кабинет"), "страница входа недоступна");
        new LoginPage(getWebDriver()).loginIn("lik.bobrova@yandex.ru","Angela21A");

        Thread.sleep(2000);
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//button[@class='tabs__nav-item active']")).getText().equals("Личный кабинет"), "Другая страница");

        new LoginPage(getWebDriver()).clickHistory();
        Thread.sleep(2000);

        new LoginPage(getWebDriver()).logOut();
        Thread.sleep(2000);
        Assertions.assertTrue(getWebDriver().getTitle().equals("Вход в личный кабинет"), "страница входа недоступна");
    }


}
