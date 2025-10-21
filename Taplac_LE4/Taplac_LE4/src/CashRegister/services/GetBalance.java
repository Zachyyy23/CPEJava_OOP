package CashRegister.services;

import CashRegister.model.CashReg;

public class GetBalance {

    public static void displayBalance(CashReg cashier) {
        System.out.println("=================================");
        System.out.println("Current Balance: " + cashier.getCurrentBalance() + " Pesos");
        System.out.println("=================================");
    }

}
