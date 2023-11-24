package testcases;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import framework.TestBase;
import framework.utils.FileOperations;
import framework.utils.simplereportbuilder.ReportBuilder;
import framework.utils.simplereportbuilder.TipoRegistro;
import pageobjects.LoginPage;
import tasks.LoginTask;
import validations.LoginValidation;

public class RealizarLogin extends TestBase {
    private LoginPage loginPage;
    private LoginTask loginTask;

    public RealizarLogin() {
        this.loginPage = new LoginPage(this.obterDriver());

        this.loginTask = new LoginTask(this.loginPage, new LoginValidation(this.loginPage));
    }

    @Test
    public void realizarLoginBemSucedido() {
        try {
            ReportBuilder.criar("Login-sucesso", "Realizar login bem sucedido com credenciais válidas");

            Properties contasProps = FileOperations.getProperties("contas_config");
            String usuario = contasProps.getProperty("conta1_usuario");
            String senha = contasProps.getProperty("conta1_senha");

            this.loginTask.efetuarLoginBemSucedido(usuario, senha);
        } catch (AssertionFailedError e) {
            ReportBuilder.addRegistro(
                    TipoRegistro.FALHA,
                    String.format("Login falhou: %s", e.getMessage()),
                    this.loginPage.obterScreenshot());

            throw e;
        }
    }

    @Test
    public void realizarLoginMalSucedido() {
        try {
            ReportBuilder.criar("Login-insucesso", "Impedir realização de login com credenciais inválidas");

            Properties contasProps = FileOperations.getProperties("contas_config");
            String usuario = contasProps.getProperty("conta3_usuario");
            String senha = contasProps.getProperty("conta3_senha");

            this.loginTask.impedirLoginCredenciaisInvalidas(usuario, senha);
        } catch (AssertionFailedError e) {
            ReportBuilder.addRegistro(
                    TipoRegistro.FALHA,
                    String.format("Impedimento de login falhou: %s", e.getMessage()),
                    this.loginPage.obterScreenshot());

            throw e;
        }
    }
}
