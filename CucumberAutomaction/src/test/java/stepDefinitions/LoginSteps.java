package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    public WebDriver driver;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("inside step-browser is open");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @And("user is on google search page")
    public void user_is_on_google_search_page() throws InterruptedException {
        System.out.println("inside Step - user is on google search page");
        driver.navigate().to("https://www.google.com/");
    }

    @When("user enters a text in search box")
    public void user_enters_a_text_in_search_box() throws InterruptedException {
        System.out.println("inside step- user entera text in search box");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Scanner");
    }

    @And("hits enter")
    public void hits_enter() throws InterruptedException {
        System.out.println("inside step- hits enter");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
    }

    @Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() throws InterruptedException {
        System.out.println("inside step-user is navigated to search results");
        Thread.sleep(3000);
        driver.close();
    }
}