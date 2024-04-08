package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@role='button']//span[@class='title'][normalize-space()='My account']")
    WebElement myAccount;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement register;



    public void clickMyAccount(){
        myAccount.click();
    }
    public RegisterPage clickRegister(){
        register.click();
        return new RegisterPage(driver);
    }





}
