package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class BasePage {
    static WebDriver driver;
    public static Properties p;
    public BasePage(WebDriver driver){

        //driver=new ChromeDriver();

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
