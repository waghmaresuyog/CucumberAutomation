package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF {

    @FindBy(id = "name")
    WebElement txtUserName;
    @FindBy(id="password")
    WebElement txtPassword;

    @FindBy(id="login")
    WebElement btnLogin;

    WebDriver driver;
    public LoginPagePF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String username){
        txtUserName.sendKeys(username);
    }

    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void clickLogin(){
        btnLogin.click();
    }
}