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
    @FindBy(xpath = ".//*[@style = 'display: block;']//*[@class = 'prev']") private WebElement previousYear;

    public DatePickerPageObject(WebDriver driver){
        super(driver);
    }

    public void clickYear(String year) throws Exception {
        try {
            WebElement yearElement = getYearElement(year);
            if (yearElement != null) {
                yearElement.click();
            } else {
                boolean yearFound = false;

                while (!yearFound) {
                    previousYear.click();
                    yearElement = getYearElement(year);
                    if (yearElement != null) {
                        yearFound = true;
                        yearElement.click();
                    }
                }
            }
        }catch(Exception ex){
            throw new Exception("There is an error trying to select the year " + year + " on the calendar. Error : " + ex.getMessage());
        }
    }

    public void clickMonth(String month) throws Exception {
        try {
            WebElement monthElement = getMonthElement(month);
            monthElement.click();
        }catch(Exception ex){
            throw new Exception("There is an error trying to select the month " + month + " on the calendar. Error : " + ex.getMessage());
        }
    }

    public void clickDay(String day) throws Exception {
        try {
            WebElement dayElement = getDayElement(day);
            dayElement.click();
        }catch(Exception ex){
            throw new Exception("There is an error trying to select the day " + day + " on the calendar. Error : " + ex.getMessage());
        }
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
        return driver.findElement(By.xpath(".//*[@class='month'][text() = '"+month+"']"));
    }

    public WebElement getDayElement(String day){
        return driver.findElement(By.xpath(".//*[@class='day'][text() = '"+day+"']"));
    }

}
