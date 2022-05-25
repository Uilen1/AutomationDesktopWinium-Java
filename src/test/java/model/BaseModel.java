package model;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import maps.BaseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.BaseStep;

import java.net.MalformedURLException;

public class BaseModel{
    public static final Logger log = LoggerFactory.getLogger(BaseModel.class);
    public BaseStep baseStep =  new BaseStep();

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
            baseStep.selectedNumber(number1);
        }catch (Exception e){
            log.error("Falha ao selecionar os numeros number:{}",number1,e);
        }
    }

    @Quando("seleciono para obter o resultado")
    public void selecionoONumeroE() throws MalformedURLException {
        try {
            log.info("Quando seleciono para obter o resultado");
            baseStep.selectedEquals();
        }catch (Exception e){
            log.error("Falha ao selecionar o operador de igual",e);
        }
    }

    @E("seleciono a operação {string}")
    public void selecionoAOperação(String operator) throws MalformedURLException {
        try {
            log.info("E seleciono a operação {}",operator);
            baseStep.selectedOperator(operator);
        }catch (Exception e){
            log.error("Falha ao selecionar a operação: {}",operator,e);
        }
    }

    @Então("o resultado é {string}")
    public void oResultadoÉ(String resultado) throws MalformedURLException {
        try {
            log.info("Então o resultado é {}",resultado);
            baseStep.validatableResult(resultado);
            baseStep.selectedClose();
        }catch (Exception e){
            log.error("Falha ao obter resultados: {}", resultado,e);
        }
    }

}
