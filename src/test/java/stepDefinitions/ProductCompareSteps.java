package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;

import static org.hamcrest.CoreMatchers.equalTo;

public class ProductCompareSteps extends BaseClass {
    ProductDisplayPage productDisplayPage;
    ProductComparePage productComparePage;
    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @When("the user clicked on compare product button")
    public void the_user_clicked_on_compare_product_button() {
        productDisplayPage = new ProductDisplayPage(getDriver());
        productDisplayPage.clickCompareThisProduct();
    }
    @When("the user clicked on product compare and redirected to product compare page")
    public void the_user_clicked_on_product_compare_and_redirected_to_product_compare_page() {
        SearchPage searchPage = new SearchPage(getDriver());
        productComparePage = searchPage.clickProductCompare1();
    }
    @Then("the user should see the product and remove the product from product compare")
    public void the_user_should_see_the_product_and_remove_the_product_from_product_compare() {
        if (productComparePage.isProductExist()){
            productComparePage.removeProductFromProductCompare();
            errorCollector.checkThat(true,equalTo(true));
        }
        else {
            errorCollector.checkThat(true,equalTo(false));
        }
    }

}
