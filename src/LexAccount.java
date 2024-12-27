public class LexAccount {
//representerar ett enskilt bankkonto
    String name; //göra private (inkapsling) att skydda data från att ändras direkt utan att gå via metoder!
    double saldo;

    public LexAccount(String name) { //konstruktor som tar emot ett namn
        this.name = name;
    }

    public LexAccount(double saldo) { //konstruktor som har emot ett saldo
        this.saldo = saldo;
    }

    public LexAccount(String name, double saldo) { //konstruktor som initierar både namn och saldo vid skapandet
        this.name = name;
        this.saldo = saldo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) { // denna metod kanske behövs inte för att man ska sätta ändra saldo bara i metoder
        this.saldo = saldo;
    }

    public void putMoney(double input) {
        if (input <= 0) { //förhindrar ogiltiga insättningar
            System.out.println("The amount you put should be positive.");
            return; //använder return här för tidig avslutning om ett ogiltigt tillstånd upptäcks! det är bästa practices!
        }
        saldo = saldo + input; //alternativ saldo += input;
        System.out.println("Your updated amount on the account is: " + saldo);
    }

    public void outMoney(double output) {
        if (output > saldo) { //förhindrar ogiltiga uttagningar
            System.out.println("You have not enough money on your account. Withdrawal failed");
            return; //Det blir tydligt att metoden avslutas direkt när ett villkor är uppfyllt
        }
        if (output <= 0) { //förhindrar ogiltiga uttagningar
            System.out.println("The amount to withdraw must be positive");
            return;
        }
            saldo = saldo - output; //alternativ saldo -= output;
            System.out.println("You take out: " + output);
            System.out.println("The remaining saldo is: " + saldo);
    }

    public void getStatus() {
        System.out.println("The account holder is: " + name);
        System.out.println("The current saldo is: " + saldo);
    }

    public void printAccountStatus(){
        System.out.println(String.format("Balance is: %.2f", saldo));//skriver ut saldo med 2 decimaler.

    }

}
