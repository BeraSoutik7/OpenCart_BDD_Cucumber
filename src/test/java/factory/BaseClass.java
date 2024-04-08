package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class BaseClass {
    static WebDriver driver;
    static Properties p;
    static Logger logger;

    public static WebDriver initilizeBrowser() throws IOException
    {
        if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            //os
            if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS..");
            }
            //browser
            switch (getProperties().getProperty("browser").toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                default:
                    System.out.println("No matching browser");
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

        }
        else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
        {
            switch(getProperties().getProperty("browser").toLowerCase())
            {
                case "chrome":
                    driver=new ChromeDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                default:
                    System.out.println("No matching browser");
                    driver=null;
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProperties() throws IOException
    {
        FileReader file=new FileReader(".//src/test/java/resources/config.properties");

        p=new Properties();
        p.load(file);
        return p;
    }

    public static Logger getLogger()
    {
        logger= LogManager.getLogger(); //Log4j
        return logger;
    }



    public static String generateName() {
        // Get today's date
        LocalDate today = LocalDate.now();

        // Format the date
        String formattedDate = today.toString();

        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(1000); // Change 1000 to your desired upper limit
        StringBuilder randomAlphabets = new StringBuilder();
        for (int i = 0; i < 3; i++) { // Change 3 to the desired length of random alphabets
            char randomChar = (char) ('A' + random.nextInt(26)); // Generate a random uppercase alphabet
            randomAlphabets.append(randomChar);
        }
        // Combine the date and random number into a string
        String result = formattedDate + "-" + randomNumber+randomAlphabets;

        return result;
    }
    public static String generatePhnNum(){
        // Get today's date
        LocalDate today = LocalDate.now();

        // Format the date
        String formattedDate = today.toString();

        // Generate a random number
        Random random = new Random();
        int randomNumber = random.nextInt(100); // Change 1000 to your desired upper limit

        // Combine the date and random number into a string
        String result = formattedDate  + randomNumber;

        return result;
    }
    public static String generateEmail(){
        return generateName()+"@yopmail.com";
    }
    public static String generatePassword(){
        return generatePhnNum();
    }

    public String captureScreen(String tname) throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }

    public static void pressTab() {
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
    }
    public static void pressEnter() {
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }
    public static void pressBack(){
        //driver.navigate().back();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.go(-1)");
    }
    public static String getTitle(){
        return driver.getTitle();
    }

    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", ""); // Scrolls down by 250 pixels
    }
}
