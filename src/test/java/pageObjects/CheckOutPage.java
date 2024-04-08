package pageObjects;

import factory.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//label[@for='input-agree']")
    WebElement termsCond;

    @FindBy(xpath = "//button[@id='button-save']")
    WebElement continuebtn;

    @FindBy(xpath = "//label[@for='input-payment-address-new']")
    WebElement newAdd;
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement addressLine;
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;
    @FindBy(xpath = "//*[@id='input-payment-country']/option[105]")
    WebElement country;
    @FindBy(xpath = "//select[@id='input-payment-zone']/option[1506]")
    WebElement state;

    public void clickTermCond(){
        termsCond.click();
    }
    public ConfirmOrderPage clickOnContinueBtn(){
        continuebtn.click();
        return new ConfirmOrderPage(driver);
    }
    public void clickNewAdd(){
        newAdd.click();
    }
    public void provideDetails(){
        firstName.sendKeys(BaseClass.generateName());
        lastName.sendKeys(BaseClass.generateName());
        addressLine.sendKeys(BaseClass.generateName());
        city.sendKeys(p.getProperty("city"));
        BaseClass.scrollDown(driver);

//        country.click();
//        state.click();
    }



}
