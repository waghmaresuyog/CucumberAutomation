package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageFactory.HomePagePF;
import pageFactory.LoginPagePF;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;


public class UserLoginStepsPF {
    public WebDriver driver;
    LoginPagePF login;
    HomePagePF home;

    @Given("user is open browser")
    public void user_is_open_browser() {
        System.out.println("inside the Open browser method");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("user open URL")
    public void user_open_url() {
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @And("user enters {string} and {string}")
    public void user_enters_and(String username, String password) throws InterruptedException {
        System.out.println("username is : " + username + "  and password is " + password);
        login = new LoginPagePF(driver);
        login.enterUserName(username);
        login.enterPassword(password);
        Thread.sleep(2000);


    }

    @And("user clicks the login button")
    public void user_clicks_the_login_button() {
        login.clickLogin();
        System.out.println("Click on login button");
    }

    @Then("the user should be on home page")
    public void the_user_should_be_on_home_page() throws InterruptedException {
        home = new HomePagePF(driver);
        home.checkLogout();
        Thread.sleep(2000);
        driver.close();
    }
}
