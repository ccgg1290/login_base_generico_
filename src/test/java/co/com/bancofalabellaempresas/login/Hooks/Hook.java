package co.com.bancofalabellaempresas.login.Hooks;

import co.com.bancofalabellaempresas.Login.tasks.HomePageTask;
import co.com.bancofalabellaempresas.Login.tasks.LoginTask;
import co.com.bancofalabellaempresas.Login.userinterfaces.LoginPage;
import co.com.bancofalabellaempresas.Login.utils.KillBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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

import static co.com.bancofalabellaempresas.Login.userinterfaces.HomePage.NAME_HOME;
import static co.com.bancofalabellaempresas.Login.utils.EnviromentConstants.returnUsuario;
import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertEquals;

public class Hook {




    static final Logger loggertest = LoggerFactory.getLogger(Hook.class);
    int login=0;
    int intento=2;
    @Before
    public void initialConfiguration() throws InterruptedException {


        OnStage.setTheStage(new OnlineCast());
        List<Map<String, String>> newdata = returnUsuario();


        loggertest.info("****** INICIO LOGIN ******");
        //newdata.forEach((k,v)-> System.out.println(" esto es el definitions clave: "+k+" valor: "+v));
        OnStage.theActorCalled("Cliente Corporativo").attemptsTo(
                Open.browserOn().the(LoginPage.class));
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.intoPage(newdata)
        );
        loggertest.info("****** FIN LOGIN ******");


        /* while(login==0) {
            try {
                login++;
                //Login++;
                // OnStage.setTheStage(new OnlineCast());
                loggertest.info("****** INICIO LOGIN ******");
                //newdata.forEach((k,v)-> System.out.println(" esto es el definitions clave: "+k+" valor: "+v));
                OnStage.theActorCalled("Cliente Corporativo").attemptsTo(
                        Open.browserOn().the(LoginPage.class));
                OnStage.theActorInTheSpotlight().attemptsTo(
                        LoginTask.intoPage(newdata)
                );
                loggertest.info("****** FIN LOGIN ******");
            } catch (Exception e) {
                System.out.println("Este es le error:" + e);
                System.out.println("Se cerro el navegador porque no cargaba");
                System.out.println("Intento" + intento);

                loggertest.info("****** INICIO LOGIN ******");
                //newdata.forEach((k,v)-> System.out.println(" esto es el definitions clave: "+k+" valor: "+v));
                //OnStage.theActorCalled("Cliente Corporativo").attemptsTo(
                  //      Open.browserOn().the(LoginPage.class));
                OnStage.theActorInTheSpotlight().attemptsTo(
                        LoginTask.intoPage(newdata)
                );
                loggertest.info("****** FIN LOGIN ******");

                intento++;
                login--;
            }

        }


         */



        /*
        OnStage.setTheStage(new OnlineCast());
        List<Map<String, String>> newdata = returnUsuario();
        loggertest.info("****** INICIO LOGIN ******");
        //newdata.forEach((k,v)-> System.out.println(" esto es el definitions clave: "+k+" valor: "+v));
        OnStage.theActorCalled("Cliente Corporativo").attemptsTo(
                Open.browserOn().the(LoginPage.class));
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.intoPage(newdata)
        );
        loggertest.info("****** FIN LOGIN ******");
*/
    }
    @After
    public static void CloseDriver() throws IOException, InterruptedException {
        //cerrar navegador
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
        //cerrartodoslos procesos
        KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
    }
}
