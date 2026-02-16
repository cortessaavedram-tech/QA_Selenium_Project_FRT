package pages;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    private static WebDriver driver;
    private static WebDriverWait wait;
    
    //Driver configuration (from Hooks class)

    public static void setupBrowser() {
        if (driver ==null) {

            //Create and configure headless options
            ChromeOptions options = new ChromeOptions();

            //Essential arguments for running in CI environments
            //options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            //Driver is configurated using WebDriverManager
            WebDriverManager.chromedriver().setup();

            //The "driver" static variable is initialized
            driver = new ChromeDriver(options);

            //WebDriverWait is initialized then the driver exists
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    //Returns driver instance for Page Objects to use it
    public static WebDriver getDriver() {
        return driver;
    }

    //Static method to close the driver instance
    public static void closeBrowser(){
        if (driver != null){
            driver.quit();
            driver = null; //Reset the driver
            wait = null; //Reset the wait
        }
    }

    //To navigate to an URL
    public static void navigateTo(String url) {
        getDriver().get(url);
    }

    //To wait for an element to be visible
    public static void waitForElement(String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    //Finds and returns a web element
    protected WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

   public String getElementText(String locator) {
    return Find(locator).getText();
   }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String keysToSend){
        WebElement element = Find(locator);
        element.clear();
        element.sendKeys(keysToSend);
    }

    //Returns actual URL
    public String getCurrentPageUrl() {
        return getDriver().getCurrentUrl();
    }

    //Dropdowns methods
    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }
    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public List<String> getDropdownValues(String locator) {
         Select dropdown = new Select(Find(locator));
         List<WebElement> dropdownOptions = dropdown.getOptions();
         List<String> values = new ArrayList<>();
         for (WebElement option : dropdownOptions) {
            values.add(option.getText());
         }
         return values;

    }

}