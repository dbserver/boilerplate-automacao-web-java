package tasks;

import framework.utils.simplereportbuilder.ReportBuilder;
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
        ReportBuilder.addStep("Executando tentativa de acesso com credenciais válidas");

        this.efetuarLogin(usuario, senha);

        this.loginValidation.isLoginBemSucedido();

        this.loginPage.getModalFeedbackButtonFechar().click();
    }

    public void impedirLoginCredenciaisInvalidas(String usuario, String senha) {
        ReportBuilder.addStep("Executando tentativa de acesso com credenciais inválidas");

        this.efetuarLogin(usuario, senha);

        this.loginValidation.isLoginMalSucedido();

        this.loginPage.getModalFeedbackButtonFechar().click();
    }

    private void efetuarLogin(String usuario, String senha) {
        this.loginPage.getInputUsuario().sendKeys(usuario);

        this.loginPage.getInputSenha().sendKeys(senha);

        this.loginPage.getButtonAcessar().click();
    }
}
