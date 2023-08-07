package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class UserLoginSteps {

    public WebDriver driver;
    @Given("the user is open browser")
    public void the_user_is_open_browser() {
        System.out.println("inside the Open browser method");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) throws InterruptedException {
        driver.navigate().to("https://example.testproject.io/web/");
        System.out.println("username is : " +username+"  and password is "+password);
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        driver.findElement(By.id("login")).click();
        System.out.println("Click on login button");
    }

    @Then("the user should be {string}")
    public void theUserShouldBeLoginStatus(String expectedStatus) throws InterruptedException {
        driver.findElement(By.id("logout")).isDisplayed();
        System.out.println("logout button is displayed" +expectedStatus);
        Thread.sleep(2000);
        driver.close();
    }
}
