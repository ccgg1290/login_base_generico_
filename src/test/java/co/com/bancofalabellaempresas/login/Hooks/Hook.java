package co.com.bancofalabellaempresas.login.Hooks;

import co.com.bancofalabellaempresas.Login.tasks.HomePageTask;
import co.com.bancofalabellaempresas.Login.tasks.LoginTask;
import co.com.bancofalabellaempresas.Login.userinterfaces.LoginPage;
import co.com.bancofalabellaempresas.Login.utils.KillBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static co.com.bancofalabellaempresas.Login.interactions.WindowsManager.changeWindow;

import static co.com.bancofalabellaempresas.Login.questions.AssertThat.theTextOfTheElementIs;
import static co.com.bancofalabellaempresas.Login.userinterfaces.HomePage.NAME_HOME;
import static co.com.bancofalabellaempresas.Login.utils.EnviromentConstants.returnUsuario;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
@Slf4j
public class Hook {

    @Before
    public void initialConfiguration() throws InterruptedException {
        OnStage.setTheStage(new OnlineCast());
        List<Map<String, String>> newdata = returnUsuario();
        log.info("****** INICIO LOGIN ******");
        //newdata.forEach((k,v)-> System.out.println(" esto es el definitions clave: "+k+" valor: "+v));
        OnStage.theActorCalled("Cliente Corporativo").attemptsTo(
                Open.browserOn().the(LoginPage.class));
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.intoPage(newdata));
        log.info("****** FIN LOGIN ******");

    }
    @After
    public static void CloseDriver() throws IOException, InterruptedException {
        //cerrar navegador
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
        //cerrartodoslos procesos
        KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
    }
}
