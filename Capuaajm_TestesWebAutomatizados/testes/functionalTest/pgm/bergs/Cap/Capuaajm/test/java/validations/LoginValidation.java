package bergs.Cap.Capuaajm.test.java.validations;

import org.junit.jupiter.api.Assertions;

import bergs.Cap.Capuaajm.main.java.framework.browser.DriverManager;
import bergs.Cap.Capuaajm.main.java.framework.utils.simplereportbuilder.ReportBuilder;
import bergs.Cap.Capuaajm.main.java.framework.utils.simplereportbuilder.TipoRegistro;
import bergs.Cap.Capuaajm.test.java.pageobjects.LoginPage;

public class LoginValidation {
    private final LoginPage loginPage;

    public LoginValidation() {
        this.loginPage = new LoginPage();
    }

    public void isLoginBemSucedido() {
        String mensagemEsperada = "Usuário conectado com sucesso";
        String mensagemObtida = this.loginPage.getModalFeedback().getText();

        Assertions.assertEquals(mensagemEsperada, mensagemObtida);

        ReportBuilder.addRegistro(
                TipoRegistro.SUCESSO,
                "Login realizado com sucesso!",
                DriverManager.obterScreenShot());
    }

    public void isLoginMalSucedido() {
        String mensagemEsperada = "Usuário não encontrado";

        String mensagemObtida = this.loginPage.getModalFeedback().getText();

        Assertions.assertEquals(mensagemEsperada, mensagemObtida);

        ReportBuilder.addRegistro(
                TipoRegistro.SUCESSO,
                "Login com credenciais inválidas impedido com sucesso!",
                DriverManager.obterScreenShot());
    }
}
