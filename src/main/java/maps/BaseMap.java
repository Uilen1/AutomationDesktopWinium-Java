package maps;

import static factory.DriverFactory.*;

import static factory.DriverFactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import winium.elements.desktop.DesktopElement;

public class BaseMap {
    public WebElement numberCalculator(String number){
        return getDriver().findElement(By.id("num"+number+"Button"));
    }
    public WebElement equalCalculator() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.id("equalButton"));
    }
    public WebElement operator(String operator) throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.id(operator+"Button"));
    }

    public WebElement results() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.id("CalculatorResults"));
    }
    public WebElement close() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.id("Close"));
    }
}
