
package com.mycompany.entidadfinanciera.users;

import com.mycompany.entidadfinanciera.account.Accounts;

public class Users extends Accounts {
    private String name;
    private String lastName;
    private int age; 
    UsersType type; 
    Accounts linkedAccount; 
    boolean haveAcosigner; //para ver si tiene coudeudor o no 

    public Users(String name, String lastName, int age, UsersType type, boolean haveAcosigner) {
        super ("", 0, 0);
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.type = type;
        this.haveAcosigner = haveAcosigner;
    }

    public void youthAccount (String ID, double money, int age) throws Exception{  //cuenta para los niños <14
        if (linkedAccount != null){  //el null significa que no hay cuenta vinculada 
            throw new Exception ("Ya tienes una cuenta");
        }else {
            try{
               super.inicialyAccount(ID, money);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    public void requisitosCredito (double amount){
        if (age >14 && (haveAcosigner || type == UsersType.EMPLOYEE) ){
            super.aproveCredit(amount);
        } else {
            System.out.println("Lo sentimos, no cumples con los requisitos");
        }
    }

    @Override
    public String toString() {
        return "Users{" + "name=" + name + ", lastName=" + lastName + ", age=" + age + ", type=" + type + ", linkedAccount=" + linkedAccount + ", haveAcosigner=" + haveAcosigner + '}';
    }

   
    
    
    
    
    
}
