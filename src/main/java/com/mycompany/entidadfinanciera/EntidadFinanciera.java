
package com.mycompany.entidadfinanciera;

import com.mycompany.entidadfinanciera.files.AppendToFile;
import com.mycompany.entidadfinanciera.files.ReadFile;
import com.mycompany.entidadfinanciera.users.Users;
import com.mycompany.entidadfinanciera.users.UsersType;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EntidadFinanciera {

    public static void main(String[] args) throws Exception {
        
        Users user1 = new Users ("Camila", "Uribe", 18, UsersType.EMPLOYEE, true);
        Users user2 = new Users ("Carito", "Uribe", 26, UsersType.INDEPENDENT, false);
        Users user3 = new Users ("jeimmy", "Uribe", 26, UsersType.INDEPENDENT, false);
        
        
        File file = new File ("./Registros.txt"); 
       
        user1.depositMoney(20000);
        user1.youthAccount("djja", 10000, 8);
        user1.depositMoney(25000);
        user1.requisitosCredito(10000);
        
        
        user2.depositMoney(50000);
        
        
        try {
            if (file.createNewFile()) {
                System.out.println("Archivo creado");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            System.out.println("error" + e.getMessage());
        }
        
        ReadFile readFile = new ReadFile(file); //ESTA ES MI CLASE, LA QUE CREÉ PARA LEER EL ARCHIVO
        List<String> data = readFile.loadInformation(); 
        
     
        for (String line: data){
            String[] splited = line.split(";");
            if (splited.length == 3) { //nombre, edad, tipo
                try {
                    String name = splited[0];
                    int age = Integer.parseInt(splited[1]);
                    String type = splited[2];
                    System.out.println("REGISTRO: " + name + " " + age + " " + type);
                } catch (NumberFormatException e) {
                    System.out.println("Error al parsear la línea: " + line);
                }
            } 
            
        }
        AppendToFile appender = new AppendToFile(file);
        appender.addLineToEOF(user1); 
    }
}
