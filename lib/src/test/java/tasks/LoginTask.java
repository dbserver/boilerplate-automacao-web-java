package tasks;

import pageobjects.LoginPage;
import validations.LoginValidation;

public class LoginTask {
    private LoginPage loginPage;
    private LoginValidation loginValidation;

    public LoginTask(LoginPage loginPage, LoginValidation loginValidation) {
        this.loginPage = loginPage;
        this.loginValidation = loginValidation;
    }

    public void efetuarLoginBemSucedido(String usuario, String senha) {
        this.efetuarLogin(usuario, senha);

        this.loginValidation.isLoginBemSucedido();

        this.loginPage.getAlertFeedbackLogin().accept();
    }

    public void efetuarLoginMalSucedido(String usuario, String senha) {
        this.efetuarLogin(usuario, senha);

        this.loginValidation.isLoginMalSucedido();

        this.loginPage.getAlertFeedbackLogin().accept();
    }

    private void efetuarLogin(String usuario, String senha) {
        this.loginPage.getInputUsuario().sendKeys(usuario);

        this.loginPage.getInputSenha().sendKeys(senha);

        this.loginPage.getButtonAcessar().click();
    }
}
