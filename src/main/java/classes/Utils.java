package classes;

import classes.Enums.Locators;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by USER on 13-Jan-17.
 */
public class Utils {

    ClassLoader resourceFolder;

    public Utils(){
        resourceFolder = this.getClass().getClassLoader();
    }

    public JsonObject readJsonFromResources(String fileName) throws Exception {
        try {
            InputStream file = resourceFolder.getResourceAsStream(fileName);
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject)jsonParser.parse(
                    new InputStreamReader(file, "UTF-8"));

            return jsonObject;
        } catch(Exception ex){
            throw new Exception("Error trying to read Json file " + ex.getMessage());
        }
    }

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
