package factory;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.io.File;
import java.io.IOException;

public class DriverFactory {

    public static final org.slf4j.Logger log = LoggerFactory.getLogger(DriverFactory.class);
    private static Utils utils = new Utils();
    private static WiniumDriver driver = null;
    private static DesktopOptions options;
    private static WiniumDriverService service;

    public static WiniumDriver getDriver(){
        if (driver == null){
            log.info("Criando o driver da Sessão");
            createDriver();
        }
        return driver;
    }

    public static void createDriver() {
        try {
            options = new DesktopOptions();
            options.setApplicationPath(utils.getProperties("pathApplication"));
            File driverPath = new File(System.getProperty("user.dir")+utils.getProperties("pathToDriver"));
            service = new WiniumDriverService.Builder().
                    usingDriverExecutable(driverPath).
                    usingPort(9999).
                    withVerbose(false).
                    withSilent(false).
                    buildDesktopService();
            try {
                service.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            driver = new WiniumDriver(service,options);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void killDriver(){
        if(driver != null){
            service.stop();
            driver = null;
        }
    }

}
