package co.com.bancofalabellaempresas.Login.interactions;


import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@Slf4j
public class RobotJava implements Task {

    public static RobotJava clickPositionPage() {
        return Tasks.instrumented(RobotJava.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {

            Thread.sleep(5000);

            Robot robot = null;
            robot = new Robot();

            log.info("****Descarga PDF DESDE EL BOTON*****");
            log.info("mouse Move");
            robot.mouseMove(490, 450);
            String filelocation=("C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\proyectos\\proyecto consultas y extractos\\ExtractosPorProducto\\src\\test\\resources\\archivos\\pruebaBotondescargarExtracto");
            StringSelection filepath=new StringSelection(filelocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
            log.info("Press Space");
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            log.info("Press CONTROL V");
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            log.info("Press Enter");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(5000);
            log.info("****Descarga PDF DESDE EL ICONO*****");
            String filelocationi=("C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\proyectos\\proyecto consultas y extractos\\ExtractosPorProducto\\src\\test\\resources\\archivos\\pruebaiconoExtracto");
            StringSelection filepathi=new StringSelection(filelocationi);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathi, null);
            log.info("mouse Move");
            robot.mouseMove( 760, 160);
            log.info("click al icono descargar");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(8000);
            log.info("Press Space");
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            log.info("Press CONTROL V");
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            log.info("Press Enter");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);


        } catch (AWTException | InterruptedException ex ) {
            throw new RuntimeException(ex);
        }

    }


}