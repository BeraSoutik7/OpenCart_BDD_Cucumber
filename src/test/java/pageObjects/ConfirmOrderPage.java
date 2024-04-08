package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmOrderPage extends BasePage{
    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='button-confirm']")
    WebElement confirmOrderBtn;
    @FindBy(xpath = "//h1[@class='page-title my-3']")
    public WebElement confirmationMsg;

    public void clickConfirmOrderBtn(){
        confirmOrderBtn.click();
    }

}
