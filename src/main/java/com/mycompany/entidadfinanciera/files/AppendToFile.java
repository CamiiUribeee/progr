
package com.mycompany.entidadfinanciera.files;

import com.mycompany.entidadfinanciera.users.Users;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class AppendToFile {
    private File file; 

    public AppendToFile(File file) {
        this.file = file;
    }
    
    public void addLineToEOF(Users line){
        try (FileWriter writer = new FileWriter(file, true)) {            
            PrintWriter printerWriter = new PrintWriter(writer);
            printerWriter.println(line.toString());  //FALTABA EL TO STRING 
            writer.close();
        }
        catch (IOException e) {
            System.out.println("La fila esta siendo usada");
        }

    }
    
    
}
