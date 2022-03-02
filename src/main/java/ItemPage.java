import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends AbstractPage{

    @FindBy(xpath = ".//form[@id='product-form']/div[@class='product-page__content']/div[@class='row']/div[@class='col-lg-7 col-xl-6']/div[@class='product-set']/div[@class='product-set__footer']/div[@class='total-amount']/button")
    private WebElement addItem;

    @FindBy(xpath = ".//div[@id='msMiniCart']/div[@class='not_empty text-center']/a")
    private WebElement goToCart;
    public ItemPage(WebDriver driver){

        super(driver);
    }

    public void addItemAndNavigateToCart() throws InterruptedException {
        Actions selectItem = new Actions(getDriver());
        selectItem.click(this.addItem)
                .build()
                .perform();
        Thread.sleep(10000);
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.urlContains("happy-sushi.ru/menu/rollyi/set-4-oranzh"));

        goToCart.click();
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.urlContains("happy-sushi.ru/cart"));
    }
    public void navigateToCart() throws InterruptedException {
        Actions selectItem = new Actions(getDriver());
        selectItem.click(this.goToCart)
                .build()
                .perform();
        Thread.sleep(2000);
    }
}
