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
    public By byNumberCalculator(String number){
        return By.id("num"+number+"Button");
    }
    public WebElement equalCalculator() throws InterruptedException {
        return getDriver().findElement(By.id("equalButton"));
    }
    public By byEqualCalculator(){
        return By.id("equalButton");
    }

    public WebElement operator(String operator) throws InterruptedException {
        return getDriver().findElement(By.id(operator+"Button"));
    }

    public By byOperator(String operator){
        return By.id(operator+"Button");
    }

    public WebElement results() throws InterruptedException {
        return getDriver().findElement(By.id("CalculatorResults"));
    }

    public By byResults(){
        return By.id("CalculatorResults");
    }

    public WebElement close() throws InterruptedException {
        return getDriver().findElement(By.id("Close"));
    }

    public By byClose(){
        return By.id("Close");
    }
}
