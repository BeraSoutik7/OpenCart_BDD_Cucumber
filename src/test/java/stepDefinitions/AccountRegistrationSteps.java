package stepDefinitions;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import pageObjects.RegisterPage;

import java.util.Map;

public class AccountRegistrationSteps extends BaseClass{
    HomePage hp;
    RegisterPage rp;
    String pass = generatePassword();
    @When("the user clicks on Continue button to register")
    public void the_user_clicks_on_Continue_button_to_register(){
        hp = new HomePage(getDriver());
        hp.clickRegister();
    }
    @When("the user enters the details into below fields")
    public void the_user_enters_the_details_into_below_fields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class,String.class);

        rp = new RegisterPage(getDriver());
        rp.setTxtFirstName(dataMap.get("firstName")+generateName());
        rp.setTxtLastName(dataMap.get("lastName")+generateName());
        rp.setTxtEmail(generateEmail());
        rp.setTxtTelephone(dataMap.get("telephone"));
        rp.setTxtPassword(dataMap.get("password"));
        rp.setTxtConfirmPassword(dataMap.get("password"));



    }
    @When("the user selects Privacy Policy")
    public void the_user_selects_privacy_policy() {
        rp.clickCheckBox();
    }
    @When("the user clicks on Continue button")
    public void the_user_clicks_on_continue_button() {
        rp.pressButton();
    }
    @Then("the user account should get created successfully")
    public void the_user_account_should_get_created_successfully() {
        if(rp.getRegistrationMsg().equals("Your Account Has Been Created!")){

            Assert.assertTrue(true);
        }
        else {

            Assert.assertTrue(false);

        }
    }

}
