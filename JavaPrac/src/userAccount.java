public class userAccount {

    String name;
    int idNumber;
    String password;

    userAccount(String name, int idNumber, String password) {

        this.name = name;
        this.idNumber = idNumber;
        this.password = password;
    }

    void showInfo(){
        System.out.println("Hello " + this.name + " welcome!");
        System.out.println("Here are your details " + this.idNumber+ "\n" + this.password);
    }
}
