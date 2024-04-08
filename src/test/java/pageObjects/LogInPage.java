package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    static WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-password']")
    static WebElement txtPassword;
    @FindBy(xpath = "//input[@value='Login']")
    static WebElement logInBtn;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    static WebElement warningMsg;
    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    static WebElement forgetPassword;


    public  void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void clickLogInBtn(){
        logInBtn.click();
    }
    public boolean isWarningDisplayed(){
        return warningMsg.isDisplayed();
    }
    public void clickForgetPassword(){
        forgetPassword.click();
    }

    public String getPlaceHolderEmail(){
        return txtEmail.getAttribute("placeholder");
    }
    public String getPlaceHolderPassword(){
        return txtPassword.getAttribute("placeholder");
    }
    public  MyAccountPage logInWithValidCredentials() throws IOException {
        HomePage homePage = new HomePage(driver);
        FileReader file = new FileReader(".//src/test/java/resources/config.properties");
        p = new Properties();
        p.load(file);
        homePage.clickMyAccount();
        setTxtEmail(p.getProperty("email"));
        setTxtPassword(p.getProperty("password"));
        clickLogInBtn();
        return new MyAccountPage(driver);
    }

    public MyAccountPage logInWithValidCredentials(String email, String password) {
        HomePage homePage = new HomePage(driver);
        p = new Properties();
        homePage.clickMyAccount();
        setTxtEmail(email);
        setTxtPassword(password);
        clickLogInBtn();
        return new MyAccountPage(driver);
    }
}
