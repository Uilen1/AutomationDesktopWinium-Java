package model;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import maps.BaseMap;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.net.MalformedURLException;

public class BaseModel extends Utils{
    public static final Logger log = LoggerFactory.getLogger(BaseModel.class);
    public BaseMap baseMap =  new BaseMap();

    @Dado("que estou com o aplicativo iniciado")
    public void queEstouComOAplicativoIniciado() throws MalformedURLException {
        try {
            log.info("Dado que estou com o aplicativo iniciado");
        }catch (Exception e){
            log.error("Falha ao inciar o aplicativo",e);
        }
    }

    @Quando("seleciono o numero {string}")
    public void selecionoONumeroE(String number1) throws MalformedURLException {
        try {
            log.info("Quando seleciono o numero {}",number1);
            Thread.sleep(3000);
            clicar(baseMap.numberCalculator(number1));
        }catch (Exception e){
            log.error("Falha ao selecionar os numeros number1:{} e number2: {}",number1,e);
        }
    }

    @Quando("seleciono para obter o resultado")
    public void selecionoONumeroE() throws MalformedURLException {
        try {
            log.info("Quando seleciono para obter o resultado");
            Thread.sleep(3000);
            clicar(baseMap.equalCalculator());
        }catch (Exception e){
            log.error("Falha ao selecionar o operador de igual",e);
        }
    }

    @E("seleciono a operação {string}")
    public void selecionoAOperação(String operator) throws MalformedURLException {
        try {
            log.info("E seleciono a operação {}",operator);
            Thread.sleep(3000);
            clicar(baseMap.operator(operator));
        }catch (Exception e){
            log.error("Falha ao selecionar a operação: {}",operator,e);
        }
    }

    @Então("o resultado é {string}")
    public void oResultadoÉ(String resultado) throws MalformedURLException {
        try {
            log.info("Emtão o resultado é {}",resultado);
            Boolean aux;
            String result = baseMap.results().getAttribute("Name");
            if(result.contains(resultado)){
                aux = true;
            }else{
                aux = false;
            }
            Assert.assertTrue(aux);
            clicar(baseMap.close());
        }catch (Exception e){
            log.error("Falha ao obter resultados: {}", resultado,e);
        }
    }

}
