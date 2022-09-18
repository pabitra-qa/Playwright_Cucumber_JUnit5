package stepdefinitions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import utils.Log;

import java.io.ByteArrayInputStream;
import java.util.HashSet;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static factory.PlaywrightFactory.*;
import static io.qameta.allure.Allure.addAttachment;
import static utils.ConfigReader.getPropertyValue;

public class stepDef {
    Page page = getPage();

    @When("User is on Google")
    public void userIsOnGoogle() {
        page.navigate("https://www.google.com/");
        Log.info("Navigated to google.com");
    }

    @Then("Search bar should be visible")
    public void searchBarShouldBeVisible() {
        page.locator("//input[@name='q']").isVisible();
        Log.info("Search Bar is Visible");
    }

    @And("User types {string} in the search bar")
    public void userTypesInTheSearchBar(String searchValue) {
        page.locator("//input[@name='q']").fill(searchValue);
        Log.info("Typed into Search Bar");
    }

    @And("User clicks search icon")
    public void userClicksSearchIcon() {
        page.keyboard().down("Enter");
        Log.info("Clicked on Search Button");
    }

    @Then("Search Result should load")
    public void searchResultShouldLoad() {
        Locator locator = page.locator("div#result-stats");
        assertThat(locator).isVisible();
        Log.info("Currently on Search Result Page");
    }

    @When("User is on Facebook")
    public void userIsOnFacebook() {
        page.navigate("https://www.facebook.com/");
        Log.info("Navigated to facebook.com");
    }

    @Then("Login button should be visible")
    public void loginButtonShouldBeVisible() {
        Locator locator = page.locator("//button[contains(text(),'Log in')]");
        assertThat(locator).isVisible();
        Log.info("Login button is visible");
    }

    @Then("Create Account button should be visible")
    public void createAccountButtonShouldBeVisible() {
        Locator locator = page.locator("//a[contains(text(),'Create New Account')]");
        assertThat(locator).isVisible();
        Log.info("Create New Account button is visible");
    }

    @When("User is on LinkedIn")
    public void userIsOnLinkedIn() {
        page.navigate("https://in.linkedin.com/");
        Log.info("Navigated to linkedin.com");
    }

    @Then("Sign in button should be visible")
    public void signInButtonShouldBeVisible() {
        Locator locator = page.locator("//a[contains(text(),'Join now')]");
        assertThat(locator).isVisible();
        Log.info("Sign in button is visible");
    }

    @Then("Join now button should be visible")
    public void joinNowButtonShouldBeVisible() {
        Locator locator = page.locator("//a[contains(text(),'Join now')]");
        assertThat(locator).isVisible();
        Log.info("Join now button is visible");
    }

    @When("User is on Wikipedia")
    public void userIsOnWikipedia() {
        page.navigate("https://www.wikipedia.org/");
        Log.info("Navigated to wikipedia.org");
    }

    @Then("Page heading should say Wikipedia")
    public void pageHeadingShouldSayWikipedia() {
        Locator locator = page.locator("//span[contains(text(),'Wikipedia')]").first();
        assertThat(locator).isVisible();
        Log.info("Wiki Heading is available");
    }

    @Then("Wiki search bar should be visible")
    public void wikiSearchBarShouldBeVisible() {
        Locator locator = page.locator("input#searchInput");
        assertThat(locator).isVisible();
        Log.info("Search Bar is Visible");
    }
}
