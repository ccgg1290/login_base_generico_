package co.com.bancofalabellaempresas.Login.questions;


import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class IsPresentFile {


  public static Boolean isPresentFile(int fileQuantity) {

      int filesQuantity=fileQuantity-1;
      File folder=new File("C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\proyectos\\proyecto consultas y extractos\\ExtractosPorProducto\\src\\test\\resources\\archivos");

      File[] listaofFiles=folder.listFiles();
      for (File archivo:listaofFiles){
          log.info("Nombre archivo: "+archivo.getName());
      }
      log.info("Numero de archivos = "+listaofFiles.length);
      return listaofFiles.length>filesQuantity;

  }

}
