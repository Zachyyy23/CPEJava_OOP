package CashRegister.model;

public class CashReg {
    private int cashOnHand;

    public CashReg() {
        this.cashOnHand = 500; // default amount
    }

    public CashReg(int cashIn) {
        if (cashIn >= 0) {
            this.cashOnHand = cashIn;
        } else {
            this.cashOnHand = 500;
        }
    }

    public int getCurrentBalance() {
        return cashOnHand;
    }

    public void acceptAmount(int amountIn) {
        if (amountIn > 0) {
            cashOnHand += amountIn;
        }
    }
}
