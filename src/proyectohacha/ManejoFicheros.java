package proyectohacha;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ManejoFicheros {

	public static void dividir(String ruta, int partes) throws IOException {
		 int char1;         
	      FileInputStream leer;
	      FileOutputStream escribir;
	      
	      //creamos los objetos de cada flujo de E/S
	      leer = new FileInputStream(ruta);
	      escribir = new FileOutputStream("copia.txt");
	      
	     /*
	      * Leemos el primer caracter y lo almacenamos en la variable int "char1".
	      * solo se utilizan los "8 bits menos significativos" de la variable int.
	      * Recordemos que "el tipo int ocupa 4 bytes" (32 bits)y el tipo byte (8 bits)
	      */
	      char1 = leer.read();
	      
	     /*
	      * Recorremos con un bucle while todo el fichero byte a byte hasta el final.
	      * Cuando llegue al final retorna un valor -1
	      */
	      while(char1 != -1){          
	          escribir.write(char1);
	          char1 = leer.read();
	      }
	      
	     /*
	      *  Cerramos los flujos abiertos (acción siempre necesaria
	      *  para liberar recursos.
	      */
	         leer.close();
	         escribir.close();
		
	}
	
}
