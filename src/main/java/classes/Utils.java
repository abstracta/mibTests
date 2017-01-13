package classes;

import classes.Enums.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by USER on 13-Jan-17.
 */
public class Utils {

    public static By by(Locators locator, String _value){
        By by = null;
        try{
            switch (locator){
                case ID:
                    by = By.id(_value);
                    break;
                case NAME:
                    by = By.name(_value);
                    break;
                case CLASS_NAME:
                    by = By.className(_value);
                    break;
                case LINK_TEXT:
                    by = By.linkText(_value);
                    break;
                case PARTIAL_LINK_TEXT:
                    by = By.partialLinkText(_value);
                    break;
                case TAG_NAME:
                    by = By.tagName(_value);
                    break;
                case CSS:
                    by = By.cssSelector(_value);
                    break;
                case XPATH:
                    by = By.xpath(_value);
                    break;
                default:
                    break;
            }
        }
        catch (NoSuchElementException e){
            System.err.print(e.getMessage());
        }
        return by;
    }
}
