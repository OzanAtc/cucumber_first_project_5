package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.PaginationPage;
import pages.TechGlobalBasePage;
import pages.TechGlobal_FrontEndPage;
import utils.Driver;

import java.util.stream.IntStream;


public class TechGlobalSteps {

    WebDriver driver;
    TechGlobal_FrontEndPage techGlobalFrontendTestingHomePage;
    PaginationPage paginationPage;
    TechGlobalBasePage techGlobalBasePage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobal_FrontEndPage();
        paginationPage = new PaginationPage();
        techGlobalBasePage = new TechGlobalBasePage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user moves to Practices header dropdown")
    public void userMovesToHeaderDropdown() {
        techGlobalBasePage.dropdown_button.click();
    }

    @And("user clicks on Frontend Testing header dropdown option")
    public void userClicksOnFrontendTestingHeaderDropdownOption() {
        techGlobalFrontendTestingHomePage.getFrontEndTesting();
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("user clicks on {string} card")
    public void userClicksOnCard(String card) {
        techGlobalFrontendTestingHomePage.clickOnCard(card);
    }

    @And("user should see {string} heading")
    public void userShouldSeeHeading(String heading) {
        switch (heading) {
            case "Pagination":
                Assert.assertEquals(heading, paginationPage.headingText.getText());
                break;
            case "World City Populations 2022":
                Assert.assertEquals(heading, paginationPage.subHeading.getText());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @And("user should see {string} paragraph")
    public void userShouldSeeParagraph(String paragraph) {
        Assert.assertEquals(paragraph, paginationPage.contentText.getText());
    }

    @And("user should see {string} button is disabled")
    public void userShouldSeeButtonIsDisabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertFalse(paginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(paginationPage.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @And("user should see {string} button is enabled")
    public void userShouldSeeButtonIsEnabled(String button) {
        switch (button) {
            case "Previous":
                Assert.assertTrue(paginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(paginationPage.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @When("user clicks on Next button")
    public void userClicksOnButton() {
        paginationPage.nextButton.click();
    }

    @When("user clicks on Next button till it becomes disabled")
    public void userClicksOnButtonTillItBecomesDisabled() {
        while (paginationPage.nextButton.isEnabled()) {
            paginationPage.nextButton.click();
        }
    }


    @And("user should see Tokyo city with info below and an image")
    public void userShouldSeeTokyoCityWithInfoBelowAndAnImage(DataTable data) {

        Assert.assertTrue(paginationPage.images.isDisplayed());
        IntStream.range(0, data.asList().size()).forEach(i -> {
            Assert.assertEquals(data.asList().get(i),
                    paginationPage.cityInfo.get(i).getText());
        });

    }

    @And("user should see Delhi city with info below and an image")
    public void userShouldSeeDelhiCityWithInfoBelowAndAnImage(DataTable data) {
        Assert.assertTrue(paginationPage.images.isDisplayed());
        IntStream.range(0, data.asList().size()).forEach(i -> {
            Assert.assertEquals(data.asList().get(i),
                    paginationPage.cityInfo.get(i).getText());
        });
    }

    @And("user should see Shangai city with info below and an image")
    public void userShouldSeeShangaiCityWithInfoBelowAndAnImage(DataTable data) {
        Assert.assertTrue(paginationPage.images.isDisplayed());
        IntStream.range(0, data.asList().size()).forEach(i -> {
            Assert.assertEquals(data.asList().get(i),
                    paginationPage.cityInfo.get(i).getText());
        });
    }

    @And("user should see Sao Paulo city with info below and an image")
    public void userShouldSeeSaoPauloCityWithInfoBelowAndAnImage(DataTable data) {
        Assert.assertTrue(paginationPage.images.isDisplayed());
        IntStream.range(0, data.asList().size()).forEach(i -> {
            Assert.assertEquals(data.asList().get(i),
                    paginationPage.cityInfo.get(i).getText());
        });
    }

    @And("user should see Mexico City city with info below and an image")
    public void userShouldSeeMexicoCityCityWithInfoBelowAndAnImage(DataTable data) {
        Assert.assertTrue(paginationPage.images.isDisplayed());
        IntStream.range(0, data.asList().size()).forEach(i -> {
            Assert.assertEquals(data.asList().get(i),
                    paginationPage.cityInfo.get(i).getText());
        });
    }
}