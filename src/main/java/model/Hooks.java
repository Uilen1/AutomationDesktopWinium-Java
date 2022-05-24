package model;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import static factory.DriverFactory.getDriver;
import static factory.DriverFactory.killDriver;


public class Hooks {

    public static final Logger log = LoggerFactory.getLogger(Hooks.class);
    Utils utils = new Utils();

    @Before
    public void before(){
        log.info("Criando driver da sessao");
        getDriver();
    }

    @After
    public void after_all(){
        log.info("Finalizando o driver da sessão");
        killDriver();
    }

    @AfterStep
    public void getScreenShot() throws Exception {
        log.info("obtendo screenshot da tela");
        utils.screenShot();
    }
}
