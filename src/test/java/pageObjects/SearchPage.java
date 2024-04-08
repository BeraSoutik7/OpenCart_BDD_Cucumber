package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='row']//div[1]//div[1]//div[2]//h4[1]//a[1]")
    WebElement imac;
    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    WebElement nonExProductTxt;
    @FindBy(xpath = "//button[contains(@class,'btn btn-compare compare-41')]//i[@class='fas fa-sync-alt']")
    WebElement compareProduct;
    @FindBy(xpath = "//a[@id='mz-product-grid-image-41-212469']//div[@class='carousel-item active']//img[@title='iMac']")
    WebElement product;
    @FindBy(xpath = "//a[@class='compare-total btn btn-link']")
    WebElement productCompare;
    @FindBy(xpath = "//button[contains(@class,'btn btn-wishlist wishlist-41')]//i[@class='fas fa-heart']")
    WebElement wishListbtn;
    @FindBy(xpath = "//a[@class='btn btn-secondary btn-block']")
    WebElement wishListOpen;

    public boolean isProductiMacExists(){
        try {
            return imac.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean isNonExProductTxtExist(){
        try{
            return nonExProductTxt.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    public void clickCompareProduct(){
        hoverOverElement(driver,product);
        compareProduct.click();
    }
    public ProductComparePage clickProductCompare(){
        productCompare.click();
        return new ProductComparePage(driver);
    }
    public ProductComparePage clickProductCompare1(){
        driver.navigate().back();
        productCompare.click();
        return new ProductComparePage(driver);
    }
    public ProductDisplayPage clickProduct(){
        product.click();
        return new ProductDisplayPage(driver);
    }
    public void clickWishlist(){
        hoverOverElement(driver,product);
        wishListbtn.click();
    }
    public MyWishListPage openWishList(){

        wishListOpen.click();
        return new MyWishListPage(driver);
    }

}
