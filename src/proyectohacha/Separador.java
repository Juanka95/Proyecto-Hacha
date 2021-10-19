package proyectohacha;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class Separador {

	
	public static  void splitAndZipFile(File f) throws IOException {

        int partCounter=0;
        int counter=1;
        int sizeOfFiles = (1024 * 1024)*100;// 100MB
        byte[] buffer = new byte[sizeOfFiles];

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))) {//try-with-resources para asegurar que se cierran los buffers.

            String name = f.getName();

                int tmp = 0;
                while ((tmp = bis.read(buffer)) > 0) {
                    //Nombramos cada parte con un identificador al final, para que no se sobreescriba.
                    File newFile = new File(f.getParent(), name+ "." + String.format("%03d", partCounter++));

                    //Grabamos el fichero temporal(que sera borrado posteriormente)
                    try (FileOutputStream out = new FileOutputStream(newFile)) {
                        out.write(buffer, 0, tmp);//tmp is chunk size
                    }

                    //Leemos el nuevo fichero
                    FileInputStream in = new FileInputStream(newFile);
                    //Creamos el zip con el fichero
                    ZipOutputStream out = new ZipOutputStream(new FileOutputStream("WebContent\\pru\\temp\\zip"+counter+".zip"));

                    //Creamos la entrada dentro del zip
                    out.putNextEntry(null);

                    //Agregamos el contenido del fichero al zip
                    byte[] b = new byte[1024];
                    int count;

                    while ((count = in.read(b)) > 0) {
                        out.write(b, 0, count);
                    }
                    counter++;
                    in.close();
                    out.close();

                    if(newFile.exists()){
                       newFile.delete();
                    }
            }
        }

        System.out.println("Termine!");
    }



public static void main (String[] args){

         try {
            splitAndZipFile(new File("D:\\KINGSTON\\2CFSI\\Actividad1"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

     }

}
	
