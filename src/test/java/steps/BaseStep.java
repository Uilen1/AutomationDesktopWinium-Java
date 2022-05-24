package steps;

import maps.BaseMap;
import org.junit.Assert;
import utils.Utils;

public class BaseStep extends Utils {

    public BaseMap baseMap = new BaseMap();

    public void selectedNumber(String number) throws Exception{
        clicar(baseMap.numberCalculator(number));
    }
    public void selectedOperator(String operator) throws Exception{
        clicar(baseMap.operator(operator));
    }
    public void selectedEquals() throws Exception{
        clicar(baseMap.equalCalculator());
    }
    public void selectedClose() throws Exception{
        clicar(baseMap.close());
    }
    public void validatableResult(String expectedResult) throws Exception{
        Boolean aux;
        String result = baseMap.results().getAttribute("Name");
        if(result.contains(expectedResult)){
            aux = true;
        }else{
            aux = false;
        }
        Assert.assertTrue(aux);
    }
}
