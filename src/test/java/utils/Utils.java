package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import winium.elements.desktop.DesktopElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    public void waitElementAppear(By by) throws Exception {
        Boolean notPresent = true;
        int timeouts = 0;
        try {
            while (notPresent){
                if(!isPresent(by)){
                    Thread.sleep(500L);
                    timeouts += 1;
                    notPresent = true;
                    if(timeouts == 10){
                        throw new Exception();
                    }
                } else {
                    notPresent = false;
                }
            }
        }catch (Exception e){
            throw new Exception("Não foi possível esperar o elemento timeout: " + timeouts);
        }
    }

    public Boolean isPresent (By by) throws Exception {
        Boolean isPresent = null;
        try {
            if(getDriver().findElements(by).size() > 0 ){
                isPresent = true;
                return isPresent;
            }else{
                isPresent = false;
                return isPresent;
            }
        }catch (Exception e){
            throw new Exception("Não foi possivel verificar se o elemento está presente");
        }
    }

    public void switchToWindowApplication(String name ){
        WebElement newWindow = getDriver().findElement(By.name(name));
        String newWindowHandle = newWindow.getAttribute("NativeWindowHandle");
        getDriver().switchTo().window(newWindowHandle);
    }
}
