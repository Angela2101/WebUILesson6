import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{
    @FindBy(xpath = ".//div[@class='form-item__group form-item__username']/input")
    private WebElement login;

    @FindBy(xpath = ".//div[@class='form-item__group form-item__password']/input")
    private WebElement password;

    @FindBy(xpath = ".//div[@class='custom-tab__box custom-tab__one active']/form[@class='authorization-form']/div[@class='form-item form-item--btn']/button")
    private WebElement submit;

    @FindBy(xpath = ".//button[@class='tabs__nav-item']")
    private WebElement buttonHistory;

    @FindBy(xpath = ".//div[@class='btn-link']/a")
    private WebElement logOut;

    public LoginPage(WebDriver driver){

        super(driver);
    }


    public void loginIn(String login, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn.sendKeys(this.login,login)
                .sendKeys(this.password,password)
                .click(this.submit)
                .build()
                .perform();
    }

    public void clickHistory(){
        Actions clickOnButtonHistory = new Actions(getDriver());
        clickOnButtonHistory.click(this.buttonHistory)
                .build()
                .perform();
    }

    public void logOut(){
        Actions logOut = new Actions(getDriver());
        logOut.click(this.logOut)
                .build()
                .perform();
    }
}
