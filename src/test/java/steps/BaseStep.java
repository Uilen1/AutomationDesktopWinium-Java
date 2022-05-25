package steps;

import maps.BaseMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;
import winium.elements.desktop.DesktopElement;

public class BaseStep extends Utils {

    public BaseMap baseMap = new BaseMap();

    public void selectedNumber(String number) throws Exception{
        waitElementAppear(baseMap.byNumberCalculator(number));
        WebElement element = baseMap.numberCalculator(number);
        clicar(element);
    }
    public void selectedOperator(String operator) throws Exception{
        waitElementAppear(baseMap.byOperator(operator));
        clicar(baseMap.operator(operator));
    }
    public void selectedEquals() throws Exception{
        waitElementAppear(baseMap.byEqualCalculator());
        clicar(baseMap.equalCalculator());
    }
    public void selectedClose() throws Exception{
        waitElementAppear(baseMap.byClose());
        clicar(baseMap.close());
    }
    public void validatableResult(String expectedResult) throws Exception{
        Boolean aux;
        waitElementAppear(baseMap.byResults());
        String result = baseMap.results().getAttribute("Name");
        if(result.contains(expectedResult)){
            aux = true;
        }else{
            aux = false;
        }
        Assert.assertTrue(aux);
    }
}
