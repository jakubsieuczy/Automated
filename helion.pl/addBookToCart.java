import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addBookToCart {
    WebDriver webDriver;

    @Given("I open Chrome browser")
    public void iOpenChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "your/path/to/Webdrivers/chromedriver");
        webDriver = new ChromeDriver();
    }
    @And("I go to {string} page")
    public void iGoToPage(String arg0) {
        webDriver.get(arg0);
    }

    @And("I click <Rozumiem> at RODO message")
    public void iClickRozumiemAtRODOMessage() {
        webDriver.findElement(By.cssSelector("a[id='rodo-ok']")).click();
    }

    @And("I type {string} in search bar and click search button")
    public void iTypeInSearchBarAndClickSearchButton(String arg0) {
        webDriver.findElement(By.cssSelector("input[id='inputSearch']")).sendKeys(arg0);
        webDriver.findElement(By.cssSelector("button[class='button']")).click();
    }

    @When("I click button with price under a first book")
    public void iClickButtonWithPriceUnderAFirstBook() {
        webDriver.findElement(By.cssSelector("p[id='v70cpz']")).click();
    }

    @Then("Book is in the cart")
    public void bookIsInTheCart() {
        String expectedText = "Przejdziesz do formularza adresowego i wyboru płatności";
        String currentText = webDriver.findElement(By.cssSelector("p[class='note']")).getText();
        Assert.assertEquals(expectedText, currentText);
    }
    @After
    public void close() {
        webDriver.quit();
    }

}
