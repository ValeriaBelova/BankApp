public class LexAccount {
//representerar ett enskilt bankkonto
    private String name; //göra private (inkapsling) att skydda data från att ändras direkt utan att gå via metoder!
    private double saldo;
    long accountNumber;

    /**
     * Standard konstruktor
     */

    public LexAccount(String name) { //konstruktor som tar emot ett namn
        this.name = name; //alternativt setName(name); försnygga till
        saldo = 0.0;
    }

    /**
     *
     */

    public LexAccount(double saldo) { //konstruktor som har emot ett saldo
        this.saldo = saldo;
    }

    /**
     *
     */

    public LexAccount(String name, double saldo) { //konstruktor som initierar både namn och saldo vid skapandet
        this.name = name;
        this.saldo = saldo;
        statusMessage("Created successfully");
    }

    // Konstruktor som tar emot både namn och kontonummer
    public LexAccount(String name, long accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.saldo = 0.0;
    }

    public long getAccountNumber() { //kontonummer kan inte ändras efter skapandet av kontot och därför lägger vi inte setter, bara getter
        return accountNumber;
    }


    public LexAccount(long accountNumber){
        this.accountNumber = accountNumber;
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

    /**
     *
     */

    public void deposit(double input) { //deposit namn är mer korrekt än putMoney
        //TODO: error handling (det har jag nere if satser)
        if (input <= 0) { //förhindrar ogiltiga insättningar
            System.out.println("The amount you put should be positive.");
            return; //använder return här för tidig avslutning om ett ogiltigt tillstånd upptäcks! det är bästa practices!
        }
        saldo = saldo + input; //alternativ saldo += input;
        System.out.println("Your amount on the account is: " + saldo);
        statusMessage("Deposit of " + input + " is done successfully."); //använder egen metod här, bra
    }

    /**
     *
     */

    public void withdraw(double output) { //namn withdraw är mer korrekt outMoney
        //TODO: error handling
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
            statusMessage("Withdrawal of " + output + " successful.");
    }

    public void statusMessage(String msg) { //användning av denna metod: Anropa statusMessage varje gång något i kontot förändras eller användaren behöver informeras
        String message = "Account " + name + " : ";
        message += msg;
        System.out.println(message);
    }

    public void printAccountStatus(){
        System.out.println(String.format("Balance is: %.2f", saldo));//skriver ut saldo med 2 decimaler.

    }

}
