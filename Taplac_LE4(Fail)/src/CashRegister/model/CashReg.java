package CashRegister.model;

public class CashReg {
   private int money;
   private String owner;
   private String password;

    public CashReg(int money, String owner, String password){
        this.money = money;
        this.owner = owner;
        this.password = password;

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
