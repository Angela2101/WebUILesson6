import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HappySushiMainPage extends AbstractPage{

    @FindBy(xpath = ".//div[@id='mixit-block']/div[@class='mixitBlock-menu']/button[@data-btn='cat17']")
    private WebElement selectSet;

    @FindBy(xpath = ".//div[@class='user-log-in']/a")
    private WebElement signIn;

    @FindBy(xpath = ".//form[@id='ms_form_137']")
    private WebElement set;

    @FindBy(xpath = ".//form[@id='ms_form_137']/a")
    private WebElement item;

    @FindBy(xpath = ".//form[@id='ms_form_147']")
    private WebElement item2;

    @FindBy(xpath = ".//form[@id='ms_form_147']/button")
    private WebElement selectItem2;

    @FindBy(css = "body")
    private WebElement body;

    @FindBy(xpath = ".//button[@class='page-btn2']")
    private WebElement writeToUs;

    @FindBy(xpath = ".//form[@id='contact-form']/div[@class='form-group']/input[@class='required form-control2']")
    private WebElement name;

    @FindBy(xpath = ".//div[@class='form-group']/textarea[@class='form-control2']")
    private WebElement comment;

    @FindBy(xpath = ".//div[@class='form-group']/input[@class='page-btn2']")
    private WebElement sendToUs;

    public HappySushiMainPage(WebDriver driver){
        super(driver);

    }

    public void goToAccountPage(){
        signIn.click();
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.urlContains("happy-sushi.ru/avtorizacziya"));

    }

    public void navigateToSet() throws InterruptedException {
        selectSet.click();
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView();", set);
        Thread.sleep(10000);
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.urlContains("happy-sushi.ru"));
    }

    public void selectSet() throws InterruptedException {
        Actions selectItem = new Actions(getDriver());
        selectItem.click(this.item)
                .build()
                .perform();
        Thread.sleep(2000);
    }

    public void navigateToItem() throws InterruptedException {
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView();", item2);
        Thread.sleep(2000);
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.urlContains("happy-sushi.ru"));

    }
    public void selectItem() throws InterruptedException {
        selectItem2.click();
        Thread.sleep(12000);
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.urlContains("happy-sushi.ru"));
    }

    public void scrollDown() throws InterruptedException {
        Actions scrollDown = new Actions(getDriver());
        scrollDown.sendKeys(this.body, Keys.CONTROL, Keys.END)
                .build()
                .perform();
        Thread.sleep(2000);
    }

    public void selectWriteToUs() throws InterruptedException {
        writeToUs.click();
        Thread.sleep(2000);
    }

    public void WriteToUs(String name, String comment){
        Actions writeToUs = new Actions(getDriver());
        writeToUs.sendKeys(this.name, name)
                .sendKeys(this.comment,comment)
                .click(this.sendToUs)
                .build()
                .perform();
    }

}
