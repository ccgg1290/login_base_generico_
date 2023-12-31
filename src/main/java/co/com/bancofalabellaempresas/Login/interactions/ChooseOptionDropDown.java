package co.com.bancofalabellaempresas.Login.interactions;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
//import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static co.com.bancofalabellaempresas.Login.utils.KillBrowser.loggertest;

public class ChooseOptionDropDown implements Task {

    private final String opcion;
    private final WebElementFacade listaDespegable;



    public ChooseOptionDropDown(WebElementFacade listaDespegable,String opcion) {

        this.opcion = opcion;
        this.listaDespegable = listaDespegable;
    }
    public static ChooseOptionDropDown selectOptionDropDown(WebElementFacade listaDespegable, String opcion) {
        return Tasks.instrumented(ChooseOptionDropDown.class, listaDespegable, opcion);
    }
    public static Actor.ErrorHandlingMode selectOption(WebElementFacade listaDespegable,String opcion) {
        loggertest.debug("Escoger opcion dropdown");
        try {
            Select Listadespegable1 = new Select((WebElement)listaDespegable);
            Listadespegable1.selectByVisibleText(opcion);
        }catch (NullPointerException exception){
            throw new NullPointerException("La opcion para seleccionar la lista desplegable viene vacio, por favor, validar");
        }
        return null;
    }
    @Step("{0} select in the list the option '#opcion'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(selectOption(listaDespegable,opcion));
    }
}


