package validations;

import org.junit.jupiter.api.Assertions;

import pageobjects.LoginPage;

public class LoginValidation {
    private LoginPage loginPage;

    public LoginValidation(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void isLoginBemSucedido() {
        String feedback = this.loginPage.getAlertFeedbackLogin().getText();

        Assertions.assertTrue(feedback.toLowerCase().contains("sucesso"));

        // TODO: Report Test
    }

    public void isLoginMalSucedido() {
        String feedback = this.loginPage.getAlertFeedbackLogin().getText();

        Assertions.assertFalse(feedback.toLowerCase().contains("sucesso"));

        // TODO: Report Test
    }
}
