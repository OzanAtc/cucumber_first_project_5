package steps;


import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class Hook {


    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario = " + scenario.getName() + "\nStatus = " + scenario.getStatus());

        try {
            if(scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
            }catch(Exception e) {
            e.printStackTrace();
        } finally {
            Driver.quitDriver();
        }
    }

}
