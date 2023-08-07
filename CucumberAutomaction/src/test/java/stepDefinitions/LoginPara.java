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

public class LoginPara {
    public WebDriver driver;

    @Given("Open the browser firefox")
    public void open_the_browser_firefox() {
        System.out.println("inside the given");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("user open URL {string}")
    public void user_open_url(String url) {
        System.out.println("The Url is " + url);
        driver.navigate().to(url);
    }

    @And("user is enters username as {string} and password as {string}")
    public void user_is_enters_username_as_and_password_as(String username, String password) throws InterruptedException {
        System.out.println("inside the and");
        System.out.println("user name is : " + username + "and password is " + password);
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
    }

    @And("user click on login button")
    public void user_click_on_login_button() {
        driver.findElement(By.id("login")).click();
        System.out.println("Click on login button");
    }

    @Then("user is go to home page")
    public void user_is_go_to_home_page() throws InterruptedException {
        System.out.println("inside the Home Page");
        Thread.sleep(2000);
        driver.close();
    }
}
