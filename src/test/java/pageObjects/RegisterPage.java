package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    WebDriver driver;
    public RegisterPage(WebDriver driver) {

        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement txtFirstName;
    @FindBy(id = "input-lastname")
    private WebElement txtLastName;
    @FindBy(id = "input-email")
    private WebElement txtEmail;
    @FindBy(id = "input-telephone")
    private WebElement txtTelephone;
    @FindBy(id = "input-password")
    private WebElement txtPassword;
    @FindBy(id = "input-confirm")
    private WebElement txtConfirmPassword;
    @FindBy(xpath = "//label[@for='input-agree']")
    private WebElement chkboxAgree;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;

//    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
//    private WebElement confirmMsg;
    @FindBy(xpath = "//h1[@class='page-title my-3']")
    private WebElement registrationMsg;

    public void setTxtFirstName(String name){
        txtFirstName.sendKeys(name);
    }
    public void setTxtLastName(String lname){
        txtLastName.sendKeys(lname);
    }
    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTxtTelephone(String phn){
        txtTelephone.sendKeys(phn);
    }
    public void setTxtPassword(String pass){
        txtPassword.sendKeys(pass);
    }
    public void setTxtConfirmPassword(String cpass){
        txtConfirmPassword.sendKeys(cpass);
    }
    public void clickCheckBox(){
        chkboxAgree.click();
    }
    public void pressButton(){
        btnContinue.click();
    }
//    public String getConfirmationMsg(){
//        try{
//            return confirmMsg.getText();
//        }
//        catch (Exception e){
//            return e.getMessage();
//        }
//    }
    public String getRegistrationMsg(){
        try {
            return registrationMsg.getText();
        }
        catch (Exception e ){
            return "Registration Unsuccessful    "+e.getMessage();
        }
    }
}
