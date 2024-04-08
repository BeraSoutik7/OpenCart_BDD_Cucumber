package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties p;

    @Before
    public void setup() throws IOException
    {
        driver= BaseClass.initilizeBrowser();

        p=BaseClass.getProperties();
        driver.get("https://ecommerce-playground.lambdatest.io/");
        driver.manage().window().maximize();


    }


    @After
    public void tearDown(Scenario scenario) {

        driver.close();

    }


    @AfterStep
    public void addScreenshot(Scenario scenario) {

        // this is for cucumber junit report
        if(scenario.isFailed()) {

            TakesScreenshot ts=(TakesScreenshot) driver;
            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());

        }

    }
}
