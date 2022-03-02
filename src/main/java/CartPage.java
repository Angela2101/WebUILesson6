import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage{

    @FindBy(xpath = ".//div[@class='product-counter product-counter--big']/button[@class='product-counter--plus product-counter-btn']")
    private WebElement plusItem;
    @FindBy(xpath = ".//div[@class='basket-btn']/a")
    private WebElement goToDesign;

    public CartPage(WebDriver driver){

        super(driver);
    }

    public void plusItem(){
        plusItem.click();
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.urlContains("happy-sushi.ru/cart"));
    }

    public void goToDesign() throws InterruptedException {

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView();", this.goToDesign);

        Thread.sleep(10000);
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.urlContains("happy-sushi.ru/cart"));
        goToDesign.click();

    }
}
