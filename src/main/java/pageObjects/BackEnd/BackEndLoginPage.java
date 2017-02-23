package pageObjects.BackEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.CommonPageObject;

/**
 * Created by USER on 13-Jan-17.
 */
public class BackEndLoginPage extends CommonPageObject {
    @FindBy(xpath = ".//input[@ng-model='user.username']") private WebElement usernameTextBox;
    @FindBy(xpath = ".//input[@ng-model='user.password']") private WebElement passwordTextBox;
    @FindBy(xpath = ".//button[@ng-click='postLogin(user)']") private WebElement loginButton;

    public BackEndLoginPage(WebDriver driver){
        super(driver);
    }

    public BackEndHomePage login(String username, String password) throws Exception {
        try {
            usernameTextBox.sendKeys(username);
            passwordTextBox.sendKeys(password);
            loginButton.click();
            System.out.println("Login succesful");
            waitLoadingMessageBackEnd();
            return new BackEndHomePage(driver);
        }catch(Exception ex){
            throw new Exception("There is an error trying to login to the Backend. Error : " + ex.getMessage());
        }
    }
}
