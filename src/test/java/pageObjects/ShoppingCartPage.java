package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//td[@class='text-left']//a[contains(text(),'iMac')]")
    WebElement iMacProduct;//for validation of shoping cart
    @FindBy(xpath = "//i[@class='fas fa-times-circle']")
    WebElement removeFromCartBtn;
    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    WebElement emptyMsg;

    public String txtMsgShoppingCartProduct(){
        return iMacProduct.getText();
    }
    public void removeProductFromCart(){
        removeFromCartBtn.click();
    }
    public String txtEmptyMsg(){
        return emptyMsg.getText();
    }

}
