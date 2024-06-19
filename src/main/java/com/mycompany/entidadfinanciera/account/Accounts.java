
package com.mycompany.entidadfinanciera.account;


public class Accounts implements Withdraw {   
    public String ID;
    public double money;
    public double Credit; 
    
    //CONSTRUCTOR 
    public Accounts(String ID, double money, double Credit) {
        this.ID = ID;
        this.money = money;
        this.Credit = Credit;
    }
    
    public void aproveCredit (double amount){
        this.Credit=amount; 
        System.out.println("Crédito aprobado");
    }
   
    public void inicialyAccount (String ID, double money) throws Exception{   //inicializar la cuenta sabiendo que debe haber un monto mínimo inicial 
        if (money < 10000){
            throw new Exception ("Monto insuficiente para abrir cuenta");   
        } else {
            this.ID = ID; 
            this.money = money; 
            System.out.println("Cuenta " + ID + " abierta");
        }
    }
   
    public void depositMoney (double mount){  //deporsitar cualquier monto 
        if (mount > 0){
            this.money=this.money+mount; 
            System.out.println("Dinero depositado con éxito");
            System.out.println("Saldo actual: " + this.money);
            return;
        } else {
            System.out.println("Valores incorrectos, intenta de nuevo");
        }
    }

    @Override
    public void withDraw(double amount) {
        if (amount > this.money){
            System.out.println("Dinero insuficiente");
        } else {
            if (amount > 0) {
                this.money = this.money - amount;
                System.out.println("Retiraste con éxito $"+amount);
                System.out.println("Dinero actual $"+this.money);
                return;
            }
        }
    }
}
