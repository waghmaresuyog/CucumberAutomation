package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class LoginDemoSteps {
    public WebDriver driver;

    @Given(": open the browser")
    public void open_the_browser() {
        System.out.println("inside the given ");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @And(": user is on login page")
    public void user_is_on_login_page() {
        System.out.println("inside the And ");
        driver.navigate().to("https://example.testproject.io/web/");
    }
    @When(": user enter username and password")
    public void user_enter_username_and_password() throws InterruptedException {
        System.out.println("inside the when ");
        driver.findElement(By.id("name")).sendKeys("suyog");
        driver.findElement(By.id("password")).sendKeys("12345");
        System.out.println("Enter User Name and Password");
        Thread.sleep(2000);
    }

    @And(": user click on login button")
    public void user_click_on_login_button() {
        driver.findElement(By.id("login")).click();
        System.out.println("Click on login button");
    }

    @Then(": user navigate to home page")
    public void user_navigate_to_home_page() throws InterruptedException {
        driver.findElement(By.id("logout")).isDisplayed();
        System.out.println("logout button is displayed");
        Thread.sleep(2000);
        driver.close();
    }
}
