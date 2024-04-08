package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement msgHeadingMyAccount;
    @FindBy(xpath = "//h1[@class='page-title my-3']")
    WebElement mshHeadingLogOut;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutbtn;
    @FindBy(xpath = "//span[normalize-space()='Logout']")
    WebElement logOutBtnOfMyAc;
    @FindBy(xpath = "//div[@id='entry_217822']//input[@placeholder='Search For Products']")
    WebElement searchTxt;
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchBtn;

    public boolean isMyAccountPageExists(){
        try{
            return msgHeadingMyAccount.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public void clickLogout(){
        logoutbtn.click();
    }
    public void logOut(){
        HomePage homePage = new HomePage(driver);
        hoverOverElement(driver,homePage.myAccount);
        logOutBtnOfMyAc.click();
    }
    public boolean isLogoutTextExist(){
        try {
            return mshHeadingLogOut.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    public SearchPage setSearchTxt(){
        searchTxt.sendKeys(p.getProperty("searchProductName"));
        searchBtn.click();
        return new SearchPage(driver);
    }

    public SearchPage setSearchTxtNonEx() {
        searchTxt.sendKeys(p.getProperty("nonExistingProduct"));
        searchBtn.click();
        return new SearchPage(driver);
    }


}
