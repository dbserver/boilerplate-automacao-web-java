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
    private LoginTask loginTask;

    public RealizarLogin() {
        LoginPage loginPage = new LoginPage(this.obterDriver());

        LoginValidation loginValidation = new LoginValidation(loginPage);

        this.loginTask = new LoginTask(loginPage, loginValidation);
    }

    @Test
    public void realizarLoginBemSucedido() {
        try {
            ReportBuilder.criar("login-sucesso", "Realizar login com sucesso");

            Properties contasProps = FileOperations.getProperties("contas_config");
            String usuario = contasProps.getProperty("conta1_usuario");
            String senha = contasProps.getProperty("conta1_senha");

            ReportBuilder.addStep("Executando tentativa de acesso com as credenciais");

            this.loginTask.efetuarLoginBemSucedido(usuario, senha);

            ReportBuilder.addRegistro(TipoRegistro.SUCESSO, "Login realizado com sucesso");
        } catch (AssertionFailedError e) {
            ReportBuilder.addRegistro(TipoRegistro.FALHA, "Login falhou: " + e.getMessage());

            throw e;
        }
    }

    @Test
    public void realizarLoginMalSucedido() {
        try {
            ReportBuilder.criar("login-insucesso", "Impedir realização de login com credenciais inválidas");

            Properties contasProps = FileOperations.getProperties("contas_config");
            String usuario = contasProps.getProperty("conta3_usuario");
            String senha = contasProps.getProperty("conta3_senha");

            ReportBuilder.addStep("Executando tentativa de acesso com as credenciais inválidas");

            this.loginTask.impedirLoginCredenciaisInvalidas(usuario, senha);

            ReportBuilder.addRegistro(TipoRegistro.SUCESSO, "Login impedido com credenciais inválidas");
        } catch (AssertionFailedError e) {
            ReportBuilder.addRegistro(TipoRegistro.FALHA, "Impedimento de login falhou: " + e.getMessage());

            throw e;
        }
    }
}
