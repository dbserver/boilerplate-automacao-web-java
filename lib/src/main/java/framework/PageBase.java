package framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class PageBase {
    private WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver obterDriver() {
        return this.driver;
    }

    public byte[] obterScreenshot() {
        return ((TakesScreenshot) this.obterDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
