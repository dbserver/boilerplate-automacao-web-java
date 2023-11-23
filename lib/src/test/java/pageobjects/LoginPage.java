package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInputUsuario() {
        return this.driver.findElement(By.id("usuario"));
    }

    public WebElement getInputSenha() {
        return this.driver.findElement(By.id("senha"));
    }

    public WebElement getButtonAcessar() {
        return this.driver.findElement(By.xpath("//form[@id='login-form']//button"));
    }

    public Alert getAlertFeedbackLogin() {
        return this.driver.switchTo().alert();
    }
}
