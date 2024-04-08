package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparePage extends BasePage{
    public ProductComparePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//strong[normalize-space()='iMac']")
    WebElement productCompareName;
    @FindBy(xpath = "//a[@class='btn btn-danger btn-block']")
    WebElement removeMsg;

    public boolean isProductExist(){
        try{
            return productCompareName.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    public void removeProductFromProductCompare(){
        removeMsg.click();
    }

}
