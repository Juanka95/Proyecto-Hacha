package proyectohacha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Separar{
	
	 public String path;
	 public int partes;
	 
	 public Separar(String path, int partes) {
		 
		 this.path = path;
		 this.partes = partes;
	 
	 }
	 
	 public void Separar(){
	
	        try {
	            File path = new File(pullapart.path);//File read from Source folder to Split.
	            if (path.exists()) {

	            String videoFileName = path.getName().substring(0, path.getName().lastIndexOf(".")); // Name of the videoFile without extension
	            File splitFile = new File("D:\\"+ videoFileName);//Destination folder to save.
	            if (!splitFile.exists()) {
	                splitFile.mkdirs();
	                System.out.println("Directory Created -> "+ splitFile.getAbsolutePath());
	            }

	            int i = 01;// Files count starts from 1
	            InputStream inputStream = new FileInputStream(path);
	            String videoFile = splitFile.getAbsolutePath() +"/"+ String.format("%02d", i) +"_"+ path.getName();// Location to save the files which are Split from the original file.
	            OutputStream outputStream = new FileOutputStream(videoFile);
	            System.out.println("File Created Location: "+ videoFile);
	           // Total files to split.
	            int splitSize = inputStream.available() / partes;
	            int streamSize = 0;
	            int read = 0;
	            while ((read = inputStream.read()) != -1) {

	                if (splitSize == streamSize) {
	                    if (i != partes) {
	                        i++;
	                        String fileCount = String.format("%02d", i); // output will be 1 is 01, 2 is 02
	                        videoFile = splitFile.getAbsolutePath() +"/"+ fileCount +"_"+ path.getName();
	                        outputStream = new FileOutputStream(videoFile);
	                        System.out.println("File Created Location: "+ videoFile);
	                        streamSize = 0;
	                    }
	                }
	                outputStream.write(read);
	                streamSize++;
	            }

	            inputStream.close();
	            outputStream.close();
	            System.out.println("Total files Split ->"+ partes);
	        } else {
	            System.err.println(path.getAbsolutePath() +" File Not Found.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	        
	
	}
}

