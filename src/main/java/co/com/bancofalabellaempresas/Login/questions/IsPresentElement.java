package co.com.bancofalabellaempresas.Login.questions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static co.com.bancofalabellaempresas.Login.utils.KillBrowser.loggertest;
import static net.serenitybdd.core.Serenity.getDriver;

public class IsPresentElement  {
    public By element;
    public IsPresentElement(By element) {
        this.element = element;
    }
  public static Boolean isPresentElement(By element) {
        WebDriver driver = getDriver();

      Boolean element2;
      try {
          element2 = driver.findElements(element).size() != 0;
          loggertest.debug("Resultado del asserTrue",element2);
      }
      catch (AssertionError exception) {
          throw new AssertionError("El elemento no esta visible, por favor validaer");
      }
      return element2;
  }

}
