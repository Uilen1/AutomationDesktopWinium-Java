package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static factory.DriverFactory.getDriver;

public class Utils {


    public void clicar(WebElement element){
        element.click();
    }

    public void screenShot() throws Exception {
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss_SSS");
            File screenShot = getDriver().getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot,new File("evidencias/screenShots/"+ sdf.format(date)+".png"));
        }catch (Exception e){
            throw  new Exception("Não foi possível tirar o screeShot da tela");
        }
    }

    public void maximizeWindow() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_WINDOWS);
        r.keyPress(KeyEvent.VK_UP);
        r.keyRelease(KeyEvent.VK_UP);
        r.keyRelease(KeyEvent.VK_WINDOWS);
    }
}
