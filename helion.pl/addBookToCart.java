import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addBookToCart {
    WebDriver webDriver;

    @Given("I open Chrome browser")
    public void iOpenChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/a1466/Webdrivers/chromedriver");
        webDriver = new ChromeDriver();
    }
    @And("I go to {string} page")
    public void iGoToPage(String arg0) {
        webDriver.get(arg0);
    }

    @And("I type {string} in search bar and click search button")
    public void iTypeInSearchBarAndClickSearchButton(String arg0) {
    }

    @When("I click button with price under a first book")
    public void iClickButtonWithPriceUnderAFirstBook() {
    }

    @Then("Book is in the cart")
    public void bookIsInTheCart() {
    }

//    @After
//    public void close() {
//        webDriver.quit();
//    }

}
