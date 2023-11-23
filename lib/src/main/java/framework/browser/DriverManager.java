package framework.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver obterDriver(TipoBrowser tipoBrowser) {
        if (DriverManager.driver == null)
            DriverManager.driver = DriverManager.montarDriver(tipoBrowser);

        return DriverManager.driver;
    }

    public static void finalizarDriver() {
        if (DriverManager.driver == null)
            return;

        DriverManager.driver.quit();

        DriverManager.driver = null;
    }

    private static WebDriver montarDriver(TipoBrowser tipoBrowser) {
        switch (tipoBrowser) {
            case CHROME:
                return DriverManager.montarDriverChrome();
            case FIREFOX:
                return DriverManager.montarDriverFirefox();
            case EDGE:
                return DriverManager.montarDriverEdge();
            case HEADLESS:
            default:
                return DriverManager.montarDriverHeadless();
        }
    }

    private static ChromeDriver montarDriverChrome() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions opcoes = new ChromeOptions()
                .addArguments("--start-maximized")
                .addArguments("--incognito")
                .addArguments("--remote-allow-origins=*");

        return new ChromeDriver(opcoes);
    }

    private static FirefoxDriver montarDriverFirefox() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions opcoes = new FirefoxOptions()
                .addArguments("--start-maximized")
                .addArguments("--incognito")
                .addArguments("--remote-allow-origins=*");

        return new FirefoxDriver(opcoes);
    }

    private static EdgeDriver montarDriverEdge() {
        WebDriverManager.edgedriver().setup();

        EdgeOptions opcoes = new EdgeOptions()
                .addArguments("--start-maximized")
                .addArguments("--incognito")
                .addArguments("--remote-allow-origins=*");

        return new EdgeDriver(opcoes);
    }

    private static ChromeDriver montarDriverHeadless() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions opcoes = new ChromeOptions()
                .addArguments("--headless")
                .addArguments("--window-size(1366,768)")
                .addArguments("--remote-allow-origins=*");

        return new ChromeDriver(opcoes);
    }
}
