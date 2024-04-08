package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage{
    public ProductDisplayPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[normalize-space()='Compare this Product']")
    WebElement compareThisProMsg;
    @FindBy(xpath = "/p[contains(text(),'Success: You have added')]")
    WebElement successCompPro;
    @FindBy(xpath = "//a[@class='btn btn-secondary btn-block']")
    WebElement productCompareBtn;
    @FindBy(xpath = "//div[@id='entry_216842']//button[@title='Add to Cart'][normalize-space()='Add to Cart']")
    WebElement addToCart;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-block']")
    WebElement viewCart;
    @FindBy(xpath = "//button[@title='Buy now']")
    WebElement buyNow;


    public String getTextCompareThisProMsg(){
        try {
            return compareThisProMsg.getText();
        }
        catch (Exception e){
            return null;
        }
    }
    public String getTextSuccessComp(){
        return successCompPro.getText();
    }
    public ProductComparePage clickProductCompare(){
        productCompareBtn.click();
        return new ProductComparePage(driver);
    }
//    public ProductComparePage clickProductCompare1(){
//        driver.navigate().back();
//        productCompareBtn.click();
//        return new ProductComparePage(driver);
//    }
    public void clickCompareThisProduct(){
        compareThisProMsg.click();
    }
    public void clickAddToCartBtn(){
        addToCart.click();
    }
    public ShoppingCartPage clickViewCart(){
        viewCart.click();
        return new ShoppingCartPage(driver);
    }
    public CheckOutPage clickBuyNow(){
        buyNow.click();
        return new CheckOutPage(driver);
    }

}
