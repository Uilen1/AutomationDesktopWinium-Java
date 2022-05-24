package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Test {

    @org.junit.Test
    public void main() throws MalformedURLException, InterruptedException {
        DesktopOptions options;
        WiniumDriverService service;
        WiniumDriver driver;

            options = new DesktopOptions();
            options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
            File driverPath = new File(System.getProperty("user.dir")+"/exec/Winium.Desktop.Driver/Winium.Desktop.Driver.exe");
            service = new WiniumDriverService.Builder().
                    usingDriverExecutable(driverPath).
                    usingPort(9999).
                    withVerbose(true).
                    withSilent(false).
                    buildDesktopService();
            try {
                service.start();
            } catch (IOException e) {
                System.out.println("Exception while starting WINIUM service");
                e.printStackTrace();
            }
            driver = new WiniumDriver(service,options);

            Thread.sleep(3000);
            driver.findElement(By.id("num8Button")).click();
            driver.findElement(By.id("multiplyButton")).click();
            driver.findElement(By.id("num9Button")).click();
            driver.findElement(By.id("equalButton")).click();
            String results = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
            System.out.println("Result is: "+ results);
            driver.findElement(By.id("Close")).click();

        service.stop();
    }
    }
