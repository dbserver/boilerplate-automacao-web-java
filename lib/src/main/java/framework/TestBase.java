package framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import framework.browser.DriverManager;
import framework.browser.TipoBrowser;
import framework.utils.FileOperations;
import framework.utils.simplereportbuilder.ReportBuilder;

public class TestBase {
    private static final String UrlWebsiteAlvo = FileOperations
            .getProperties("website_config")
            .getProperty("url");

    public WebDriver obterDriver() {
        return DriverManager.obterDriver(TipoBrowser.CHROME);
    }

    @BeforeEach
    public void setup() {
        this.obterDriver().get(TestBase.UrlWebsiteAlvo);
    }

    @AfterEach
    public void finalizar() {
        DriverManager.finalizarDriver();

        ReportBuilder.concluir();
    }
}
