package utils;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import winium.elements.desktop.DesktopElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static factory.DriverFactory.getDriver;

public class Utils {

    Properties properties = new Properties();


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
        switchToWindowApplication(getProperties("nameOfApplication"));
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_WINDOWS);
        r.keyPress(KeyEvent.VK_UP);
        r.keyRelease(KeyEvent.VK_UP);
        r.keyRelease(KeyEvent.VK_WINDOWS);
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

    public void waitVisibilityBy(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitLoad(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Integer.parseInt(getProperties("timeout")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
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

    public String getProperties(String propertie) {
        try {
            InputStream inputStream = new FileInputStream("setup.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(propertie);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Erro ao carregar propriedade");
            return "";
        }
    }

    public static void setProperties(String propertie, String valor) {
        try {
            FileInputStream in = new FileInputStream("setup.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream("setup.properties");
            props.setProperty(propertie, valor);
            props.store(out, "Configurações Essenciais");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Erro ao carregar propriedade");
        }
    }

    public void killProcess(String process) {
        try {
            Process p = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while((line = input.readLine()) != null) {
                if (!line.trim().equals("") && line.substring(1, line.indexOf("\"", 1)).equalsIgnoreCase(process)) {
                    Runtime.getRuntime().exec("taskkill /F /IM " + line.substring(1, line.indexOf("\"", 1)));
                }
            }

            input.close();
        } catch (Exception var4) {
            System.out.println(var4.getMessage());
        }

    }
}
