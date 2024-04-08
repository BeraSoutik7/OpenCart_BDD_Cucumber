package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

import java.util.HashMap;
import java.util.List;

public class LoginSteps {
    HomePage hp;
    LogInPage lp;
    MyAccountPage ma;
    @Given("the user navigates to login page")
    public void the_user_navigates_to_login_page() {
        BaseClass.getLogger().info("Goto my account-->");
        hp=new HomePage(BaseClass.getDriver());
        hp.clickMyAccount();
    }

    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp=new LogInPage(BaseClass.getDriver());
        lp.setTxtEmail(email);
        BaseClass.getLogger().info("Entered Email-->");
        lp.setTxtPassword(password);
        BaseClass.getLogger().info("Entered Password-->");

    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        lp.clickLogInBtn();
        BaseClass.getLogger().info("Clicks on the login button-->");
    }

    @Then("the user should be redirected to the MyAccount Page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
        ma=new MyAccountPage(BaseClass.getDriver());
        Assert.assertTrue(ma.isMyAccountPageExists());
    }

//    Data driven log in

    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel {string}")
    public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel(String rows)
    {
        List<HashMap<String, String>> datamap = DataReader.data(System.getProperty("user.dir") + "\\test-data\\OpenCart_Login_Data.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("Username");
        String pwd= datamap.get(index).get("Password");
        String exp_res= datamap.get(index).get("res");

        lp=new LogInPage(BaseClass.getDriver());
        lp.setTxtEmail(email);
        lp.setTxtPassword(pwd);

        lp.clickLogInBtn();
        ma=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=ma.isMyAccountPageExists();
            System.out.println("target page: "+ targetpage);
            if(exp_res.equals("valid"))
            {
                if(targetpage==true)
                {
                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                    myaccpage.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("invalid"))
            {
                if(targetpage==true)
                {
                    ma.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
    }

}
