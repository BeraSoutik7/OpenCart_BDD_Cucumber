package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import pageObjects.*;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

public class AddToCartSteps extends BaseClass {
    HomePage hp;
    LogInPage lp;
    MyAccountPage ma;

    SearchPage searchPage;
    ShoppingCartPage sp;
    ProductDisplayPage pd;
    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();
    @When("the user login with valid credentials")
    public void the_user_login_with_valid_credentials() throws IOException {
        lp= new LogInPage(getDriver());
        ma=lp.logInWithValidCredentials();

    }
    @When("the user search product as <{string}> in searchbar")
    public void the_user_search_product_as_in_searchbar(String string) {
         searchPage = ma.setSearchTxt();
    }
    @When("the user clicked on product")
    public void the_user_clicked_on_product() {
        pd = searchPage.clickProduct();
    }
    @When("the user clicked on add to cart button")
    public void the_user_clicked_on_add_to_cart_button() {
        pd.clickAddToCartBtn();
    }
    @When("the user clicked on view cart button")
    public void the_user_clicked_on_view_cart_button() {
       sp = pd.clickViewCart();
    }
    @Then("the user should see the product added on cart")
    public void the_user_should_see_the_product_added_on_cart() {

        if(sp.txtMsgShoppingCartProduct().equalsIgnoreCase("imac")){
            errorCollector.checkThat(true,equalTo(true));
        }
        else{
            errorCollector.checkThat(true,equalTo(false));
        }
    }
    @When("the user removes the product from cart")
    public void the_user_removes_the_product_from_cart() {
        sp.removeProductFromCart();
    }
    @Then("the user should see the empty cart message")
    public void the_user_should_see_the_empty_cart_message(){
        if(sp.txtEmptyMsg().equalsIgnoreCase("Your shopping cart is empty!")){
            errorCollector.checkThat(true,equalTo(true));
        }
        else{
            errorCollector.checkThat(true,equalTo(false));
        }
    }

}
