package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageBase;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputUsuario() {
        return this.obterDriver().findElement(By.id("usuario"));
    }

    public WebElement getInputSenha() {
        return this.obterDriver().findElement(By.id("senha"));
    }

    public WebElement getButtonAcessar() {
        return this.obterDriver().findElement(By.xpath("//form[@id='login-form']//button"));
    }

    public WebElement getModalFeedback() {
        return this.obterDriver().findElement(By.id("modal-text"));
    }

    public WebElement getModalFeedbackButtonFechar() {
        return this.obterDriver().findElement(By.xpath("//div[@id='modal']//button"));
    }
}
