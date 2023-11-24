package validations;

import org.junit.jupiter.api.Assertions;

import framework.utils.simplereportbuilder.ReportBuilder;
import framework.utils.simplereportbuilder.TipoRegistro;
import pageobjects.LoginPage;

public class LoginValidation {
    private LoginPage loginPage;

    public LoginValidation(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void isLoginBemSucedido() {
        String feedback = this.loginPage.getModalFeedback().getText();

        Assertions.assertTrue(feedback.toLowerCase().contains("sucesso"));

        ReportBuilder.addRegistro(
                TipoRegistro.SUCESSO,
                "Login realizado com sucesso",
                this.loginPage.obterScreenshot());
    }

    public void isLoginMalSucedido() {
    	String feedback = this.loginPage.getModalFeedback().getText();

        Assertions.assertFalse(feedback.toLowerCase().contains("sucesso"));

        ReportBuilder.addRegistro(
                TipoRegistro.SUCESSO,
                "Login com credenciais inválidas impedido com sucesso",
                this.loginPage.obterScreenshot());
    }
}
