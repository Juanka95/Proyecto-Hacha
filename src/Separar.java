

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;





public class Separar{
	
	 private static final long serialVersionUID = 1L;
		
	 public String path;
	 public int partes;
	 public String destino;
	 String ruta;
	 
public Separar(String path, int partes, String destino) {
	
		 this.path = path;
		 this.partes = partes;
		 this.destino = destino;
		 ruta = pullapart.ruta;
	 
	 } 
	 
	
	 public void partes(int partes){
	
		 try {
	            File file = new File(pullapart.path);
	            String nombre = file.getName();
	            String x = file.getParent();
	            System.out.println(x);
	            
	            /*
	            int y=0;
	            for (int a = x.length()-1; a >= 0; a --  ) {
	            	
	            		if (x.charAt(a)== '\\')
	            			
	            			y = a;
	            			break;
	            	
	            	
	            }
	            
	            String directorio = x.substring(0, y);
	            
	            System.out.println("------------------------------");
	            System.out.println(y + "" + x + directorio);
	            System.out.println("------------------------------");
	            */
	            if (file.exists()) {
	            File splitFile = new File(ruta);
	            if (!splitFile.exists()) {
	                splitFile.mkdir();
	                System.out.println("Creacion en -> "+ splitFile.getAbsolutePath());
	            }

	            int i = 1;
	            String fileName = file.getName();
	            InputStream inputStream = new FileInputStream(file);
	            String videoFile = splitFile.getAbsolutePath() +"\\"+ i +"_"+ file.getName(); 
	            OutputStream outputStream = new FileOutputStream(videoFile);
	            System.out.println("Lugar de la separacion "+ videoFile);
	            int bytes = inputStream.available() ;

	            int splitSize = inputStream.available() / partes;
	            int streamSize = 0;
	            int read = 0;
	            while ((read = inputStream.read()) != -1) {

	                if (splitSize == streamSize) {
	                    if (i != partes) {
	                        i++;
	                       
	                        videoFile = splitFile.getAbsolutePath() +"\\"+ i +"_"+file.getName();
	                        outputStream = new FileOutputStream(videoFile);
	                        streamSize = 0;
	                    }
	                }
	                outputStream.write(read);
	                streamSize++;
	            }

	            inputStream.close();
	            outputStream.close();
	            System.out.println("Total de partes separadas ->"+ partes);
	            CrearXml.crear(ruta, partes, bytes, nombre);
	            
	            
	        } else {
	            System.err.println(file.getAbsolutePath() +" File Not Found.");
	        }
   } catch (Exception e) {
       e.printStackTrace();
   }

		
		
		 
		 
}
	public int partes() {
		
		return partes();
		
	}
		 
	}



