package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmOrderPage;
import pageObjects.ProductDisplayPage;

public class ProductOrderSteps extends BaseClass {
    //h1[@class='page-title my-3']
    ProductDisplayPage productDisplayPage;
    CheckOutPage checkOutPage;
    ConfirmOrderPage confirmOrderPage;
    @When("the user clicked on buy now button")
    public void the_user_clicked_on_buy_now_button() {
        productDisplayPage = new ProductDisplayPage(getDriver());
        checkOutPage = productDisplayPage.clickBuyNow();
    }
    @When("the user clicked on check box")
    public void the_user_clicked_on_check_box() {
        checkOutPage.clickTermCond();
    }
    @When("the user clicked on continue button and goto confirmation page")
    public void the_user_clicked_on_continue_button_and_goto_confirmation_page() {
       confirmOrderPage = checkOutPage.clickOnContinueBtn();
    }
    @When("the user clicked on confirm order button")
    public void the_user_clicked_on_confirm_order_button() {
        confirmOrderPage.clickConfirmOrderBtn();
    }
    @Then("the user should see the confirmation message")
    public void the_user_should_see_the_confirmation_message() {
        if(confirmOrderPage.confirmationMsg.isDisplayed()){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @When("the user clicked on I want to use new address")
    public void the_user_clicked_on_i_want_to_use_new_address() {
        checkOutPage.clickNewAdd();
    }
    @When("the user entered the address")
    public void the_user_entered_the_address() {
        checkOutPage.provideDetails();
    }
}
