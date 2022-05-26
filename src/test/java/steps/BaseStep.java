package steps;

import maps.BaseMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;
import winium.elements.desktop.DesktopElement;

import java.awt.*;

public class BaseStep extends Utils {

    public BaseMap baseMap = new BaseMap();

    public void appWithFocus() throws AWTException {
        maximizeWindow();
    }

    public void selectedNumber(String number) throws Exception{
        waitVisibilityBy(baseMap.byNumberCalculator(number));
        WebElement element = baseMap.numberCalculator(number);
        clicar(element);
    }
    public void selectedOperator(String operator) throws Exception{
        waitVisibilityBy(baseMap.byOperator(operator));
        clicar(baseMap.operator(operator));
    }
    public void selectedEquals() throws Exception{
        waitVisibilityBy(baseMap.byEqualCalculator());
        clicar(baseMap.equalCalculator());
    }
    public void selectedClose() throws Exception{
        waitVisibilityBy(baseMap.byClose());
        clicar(baseMap.close());
    }
    public void validatableResult(String expectedResult) throws Exception{
        Boolean aux;
        waitVisibilityBy(baseMap.byResults());
        String result = baseMap.results().getAttribute("Name");
        if(result.contains(expectedResult)){
            aux = true;
        }else{
            aux = false;
        }
        Assert.assertTrue(aux);
    }
}
