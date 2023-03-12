import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class LoginSteps {

    WebDriver webdriver;

    @Given("I open browser")
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "your path to webdriver");
        webdriver = new ChromeDriver();
    }

    @And("I go to login page")
    public void iGoToLoginPage() {
        webdriver.get("https://poczta.interia.pl/logowanie/");
    }

    @And("I click <Przejdz do serwisu>")
    public void iClickPrzejdzDoSerwisu() {
        webdriver.findElement(By.cssSelector("button[class='rodo-popup-agree']")).click();
    }

    @When("I type {string} as login")
    public void iTypeAsLogin(String login) {
        webdriver.findElement(By.cssSelector("input[name='email']")).sendKeys(login);
    }

    @And("I type {string} as password")
    public void iTypeAsPassword(String password) {
        webdriver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        webdriver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        String expectedText = "Nowa wiadomość";
        String currentText = webdriver.findElement(By.cssSelector("span[class='navigation__new__text']")).getText();
        Assert.assertEquals(expectedText, currentText);
    }

    @Then("I am NOT logged in")
    public void iAmNOTLoggedIn() {
        String expectedText = "Błędny e-mail lub hasło";
        String currentText = webdriver.findElement(By.cssSelector("span[class='form__error']")).getText();
        Assert.assertEquals(expectedText, currentText);
    }

    @After
    public void close() {
        webdriver.quit();
    }
}
