
package co.com.bancofalabellaempresas.Login.tasks;

import co.com.bancofalabellaempresas.Login.interactions.Refresh;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;


import static co.com.bancofalabellaempresas.Login.interactions.WindowsManager.changeWindow;
import static co.com.bancofalabellaempresas.Login.questions.AssertThat.theTextOfTheElementIs;
import static co.com.bancofalabellaempresas.Login.userinterfaces.HomePage.NAME_HOME;
import static co.com.bancofalabellaempresas.Login.userinterfaces.LoginPage.*;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.hamcrest.Matchers.equalTo;
@Slf4j
public class LoginTask implements Task {

    private final List<Map<String, String>> data;
    public LoginTask(List<Map<String, String>> data) {

        this.data = data;
    }
    public static LoginTask intoPage(List<Map<String, String>> data) {
        return Tasks.instrumented(LoginTask.class,data);
    }
    @Step("-------------- Before the test--------------")
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(CLIENTE_EMPRESARIAL, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Enter.theValue(data.get(0).get("ClienteEmpresarial")).into(CLIENTE_EMPRESARIAL),
                    SelectFromOptions.byVisibleText("Cédula de Ciudadanía").from(TIPO_DE_IDENTIFICACION),
                    //selectOptionDropDown(TIPO_DE_IDENTIFICACION,data.get(0).get("TipoDeIdentificación")),
                    WaitUntil.the(NUMERO_DE_IDENTIFICACION, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Enter.theValue(data.get(0).get("NúmeroDeIdentificación")).into(NUMERO_DE_IDENTIFICACION),
                    WaitUntil.the(CLAVE_PERSONAL, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Enter.theValue(data.get(0).get("ClavePersonal")).into(CLAVE_PERSONAL),
                    WaitUntil.the(CLAVE_TOKEN, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Enter.theValue(data.get(0).get("ClaveToken")).into(CLAVE_TOKEN),
                    WaitUntil.the(BTN_SIGIN, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_SIGIN)
            );
        }
        catch(Error|Exception e){
            log.info("SE CAPTURO EL ERROR");


            OnStage.theActorInTheSpotlight().attemptsTo(
                    Refresh.thePage(),
                    WaitUntil.the(CLIENTE_EMPRESARIAL, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Enter.theValue(data.get(0).get("ClienteEmpresarial")).into(CLIENTE_EMPRESARIAL),
                    SelectFromOptions.byVisibleText("Cédula de Ciudadanía").from(TIPO_DE_IDENTIFICACION),
                    //selectOptionDropDown(TIPO_DE_IDENTIFICACION,data.get(0).get("TipoDeIdentificación")),
                    WaitUntil.the(NUMERO_DE_IDENTIFICACION, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Enter.theValue(data.get(0).get("NúmeroDeIdentificación")).into(NUMERO_DE_IDENTIFICACION),
                    WaitUntil.the(CLAVE_PERSONAL, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Enter.theValue(data.get(0).get("ClavePersonal")).into(CLAVE_PERSONAL),
                    WaitUntil.the(CLAVE_TOKEN, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Enter.theValue(data.get(0).get("ClaveToken")).into(CLAVE_TOKEN),
                    WaitUntil.the(BTN_SIGIN, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_SIGIN)
            );



        }finally {

            OnStage.theActorInTheSpotlight().attemptsTo(
                    HomePageTask.selectBank(data)
            );

            theActorInTheSpotlight().should(
                    seeThat("El nombre en el Home page ",
                            theTextOfTheElementIs(NAME_HOME),
                            equalTo("Dayana Andrea Rojas Alba")
                    )
            );

        }

    }
}
