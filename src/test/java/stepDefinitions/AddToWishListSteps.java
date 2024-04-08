package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.MyWishListPage;
import pageObjects.SearchPage;

public class AddToWishListSteps extends BaseClass {
    SearchPage searchPage;
    MyWishListPage myWishListPage;
    @When("the user clicked on add to wish list")
    public void the_user_clicked_on_add_to_wish_list(){
        searchPage = new SearchPage(getDriver());
        searchPage.clickWishlist();
    }
    @When("the user clicked on the wishlist button")
    public void the_user_clicked_on_the_wishlist_button(){
        myWishListPage = searchPage.openWishList();
    }
    @When("the user should see the product displayed on the wishlist and remove the product from wish list")
    public void the_user_should_see_the_product_displayed_on_the_wishlist_and_remove_the_product_from_wish_list(){
        if(myWishListPage.txtProductMyWishList().equalsIgnoreCase("imac")){
            Assert.assertTrue(true);
            myWishListPage.removeProductFromList();
        }
        else {
            Assert.assertTrue(false);
        }
    }
}
