package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by USER on 13-Jan-17.
 */
public class HomePage extends AbstractPageObject{
    @FindBy(name = "Get a QUICK QUOTE") private WebElement getAQuickQuoteButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnQuickQuote() throws Exception {
        try {
            getAQuickQuoteButton.click();
            System.out.println("Forms button was clicked");
        }catch(Exception ex){
            throw new Exception("There is an error clicking on quick quote button. Error : " + ex.getMessage());
        }
    }
}