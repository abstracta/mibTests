package pageObjects;

import classes.Enums.IntendedUseVehicle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 18-Jan-17.
 */
public class DatePickerPageObject extends CommonPageObject {
    @FindBy(className = "prev") private WebElement previousYear;

    public DatePickerPageObject(WebDriver driver){
        super(driver);
    }

    public void clickYear(String year){
        WebElement yearElement = getYearElement(year);
        if (yearElement != null){
            yearElement.click();
        }else{
            boolean yearFound = false;

            while(!yearFound) {
                previousYear.click();
                yearElement = getYearElement(year);
                if (yearElement != null) {
                    yearFound = true;
                    yearElement.click();
                }
            }
        }
    }

    public void clickMonth(String month){
        WebElement monthElement = getMonthElement(month);
        monthElement.click();
    }

    public void clickDay(String day){
        WebElement dayElement = getDayElement(day);
        dayElement.click();
    }

    public WebElement getYearElement(String year){
        WebElement yearElement = null;
        try{
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            yearElement = driver.findElement(By.xpath(".//*[@class='year'][text() = "+year+"]"));
        }catch(Exception ex){
            return null;
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return yearElement;
    }

    public WebElement getMonthElement(String month){
        return driver.findElement(By.xpath(".//*[@class='month'][text() = "+month+"]"));
    }

    public WebElement getDayElement(String day){
        return driver.findElement(By.xpath(".//*[@class='day'][text() = "+day+"]"));
    }

}
