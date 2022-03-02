import io.cucumber.java.hu.Ha;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class OtherTest extends AbstractTest{

    @Test
    void Test() throws InterruptedException {

        new HappySushiMainPage(getWebDriver()).scrollDown();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Happy Sushi"), "Cтраница входа недоступна");
        new HappySushiMainPage(getWebDriver()).selectWriteToUs();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//form[@id='contact-form']/h3")).getText().equals("Оставьте свою заявку, и мы перезвоним вам в течение 5 минут!"), "Cтраница недоступна");
        new HappySushiMainPage(getWebDriver()).WriteToUs("Admin","Как можно быстрее");
    }
}
