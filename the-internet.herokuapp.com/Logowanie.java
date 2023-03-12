package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Logowanie {

    WebDriver driver;
    final String URL = "https://the-internet.herokuapp.com/";

    @Before
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
        driver = new ChromeDriver(options);
    }

    @After
    public void close() {
        driver.quit();
    }

    @Given("Uzytkownik jest na stronie logowania")
    public void uzytkownik_jest_na_stronie_logowania() {
        System.out.println("Krok 1");
        driver.navigate().to(URL + "login");
    }
    @When("Uzytkownik wpisze {string} jako nazwe uzytkownika")
    public void uzytkownikWpiszeJakoNazweUzytkownika(String login) {
        System.out.println("Krok 2");
        driver.findElement(By.id("username")).sendKeys(login);
    }
    @And("Uzytkownik wpisze {string} jako haslo")
    public void uzytkownikWpiszeJakoHaslo(String password) {
        System.out.println("Krok 3");
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("Uzytkownik kliknie w przycisk Login")
    public void uzytkownik_kliknie_w_przycisk_login() {
        System.out.println("Krok 4");
        driver.findElement(By.tagName("button")).click();
    }

    @Then("Uzytkownik zostal poprawnie zalogowany")
    public void uzytkownik_zostal_poprawnie_zalogowany() {
        System.out.println("Krok 5");
        Assert.assertEquals(URL + "secure", driver.getCurrentUrl());
    }

    @Then("Uzytkownik niezostal poprawnie zalogowany")
    public void uzytkownik_niezostl_poprawnie_zalogowany() {
        System.out.println("Krok 5");
        String expectedText = "Your password is invalid!";
        verifyText(expectedText);
        Assert.assertEquals(URL + "login", driver.getCurrentUrl());
    }

    private void verifyText(String expectedText) {
        String realText = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(realText.contains(expectedText));
    }

}