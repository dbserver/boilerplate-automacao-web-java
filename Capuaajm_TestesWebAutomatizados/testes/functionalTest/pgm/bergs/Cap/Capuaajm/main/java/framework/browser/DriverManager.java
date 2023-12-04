package bergs.Cap.Capuaajm.main.java.framework.browser;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class DriverManager {
    private static WebDriver driver;
    private static final TipoBrowser TipoBrowserDefault = TipoBrowser.CHROME;

    public static WebDriver obterDriver() {
        if (DriverManager.driver == null) {
            DriverManager.montarDriver();
        }

        return DriverManager.driver;
    }

    public static void finalizarDriver() {
        if (DriverManager.driver == null)
            return;

        DriverManager.driver.quit();

        DriverManager.driver = null;
    }

    public static void montarDriver() {
        montarDriver(TipoBrowserDefault);
    }

    public static void montarDriver(TipoBrowser tipoBrowser) {
        switch (tipoBrowser) {
            case CHROME:
                DriverManager.driver = DriverGenerator.criarChromeDriver();
                break;
            case EDGE:
                DriverManager.driver = DriverGenerator.criarIEDriver();
                break;
            case HEADLESS:
            default:
                DriverManager.driver = DriverGenerator.criarChromeDriver();
        }
    }

    public static byte[] obterScreenShot() {
        return ((TakesScreenshot) DriverManager.driver).getScreenshotAs(OutputType.BYTES);
    }

}
