import java.util.ArrayList;

public class LexBank {
    //representerar banken som helhet
    //hanterar en samling av konton(LexAccount-objekt)
    //har funktionalitet som påverkar flera konton och bankens data som helhet

    //Har endast statiska medlemmar, samt en privat konstruktor
    private static final ArrayList<LexAccount> accounts = new ArrayList<>(); //lagrar konton av typen LexAccount
    private static long accountNumberGenerator = 1; //variabel och startpunkt

    private LexBank() {} //private konstruktor för att förhindra att någon skapar instanser av LexBank

    public static long openNewAccount (String name) {
        long accountNumber = generateAccountNumber();
        LexAccount account = new LexAccount(name, accountNumber); //skapar en ny konto (objekt)
        //newAccount.setSaldo(initialSaldo); //sätter saldo till kontot
        accounts.add(account);//lägger till konto i listan
        outputMessage ("The account för " + name + " with the account number: " + accountNumber + " is created successfully!");
        //return newAccount; //viktigt!!!
        return accountNumber;

    }

    /**
     * Hämta kontot. Kontonumret används att identifiera konton.
     */
    public static LexAccount getAccount(long accountNumber){
        for(LexAccount account : accounts){ //kontrollerar varje konton i listan
            if (account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        System.out.println("No account found with the number: " + accountNumber);
        //throw new IllegalArgumentException("No account found with account number: " + accountNumber); //alternativ till sout
        return null;

    }


    private static long generateAccountNumber(){
        return accountNumberGenerator++;//generera en ny nästa nummer varje gång
    }


    //jag skapar en wrapper-metod för att anropa den privata metoden accountTransfer i main
    public static void performAccountTransfer(long fromAccount, long toAccount, double amount){
        if(amount <= 0){ //extra validering för amount
            System.out.println("Transfer amount should be positive.");
            return;
        }
        //anropar den privata metoden
        accountTransfer(fromAccount, toAccount, amount);
    }

    //denna private metod kan jag anropa i main om jag skapar en till metod att skydda denna metod
    private static void accountTransfer(long fromAccount, long toAccount, double amount) {

        LexAccount fromAcc = LexBank.getAccount(fromAccount);
        if(fromAcc == null) {
            System.out.println("The account: " + fromAccount + " doesn't exist.");
            return; // avsluta om kontot inte hittats
        }

        LexAccount toAcc = LexBank.getAccount(toAccount);
        if(toAcc == null) {
            outputMessage("The account: " + toAccount + " doesn't exist.");
            return; // avsluta om kontot inte hittats
        }

        if(fromAcc.getSaldo() < amount) {
            outputMessage("There is not enough money on the account " + fromAcc.getName());
            return;
        }

        try{
            fromAcc.withdraw(amount);
            toAcc.deposit(amount);

            //skriver ut success meddelanden
            System.out.println("The transfer of " + amount + " from account " + fromAccount + " to account" + toAccount + "was successful.");
            System.out.println("The remaining saldo on the account: " + fromAccount + " is " + fromAcc.getSaldo());
            System.out.println("Updated saldo on account: " + toAccount + " is " + toAcc.getSaldo());
        } catch (Exception e) {
            System.out.println("The transfer failed due to an unexpected error: " + e.getMessage());
        }
    }


        //all denna kod nedanför kan man enkelt ersätta med 2 rader ovanför, för att jag har getAccount metod! smidigt! undviker upprepningar
        /*for(LexAccount accountFrom : accounts){
            if(accountFrom.getAccountNumber() == fromAccount) {
                return accountFrom;
            }
        }
        System.out.println("Account with the number: " + fromAccount + " is not found");
        return null;

        for(LexAccount accountTo : accounts){
            if(accountTo.getAccountNumber() == toAccount){
                return accountTo;
            }
        }
        System.out.println("Account with the number: " + toAccount + " is not found");
        return null;*/


    public static void outputMessage (String msg) {
        String message = "Lex Bank: " + msg;
        System.out.println(message);
    }

    public static void printReport() {
        //System.out.println("Bank account report:");
        String output;
        output = "\n--- Lex Bank Report ----------------";
        //gå genom listan med alla konton
        for (LexAccount account : accounts) {
            output += "\n'" + account.getName() + " balance: " + account.getSaldo();
        }
        output += "\n------------------------------------";
        System.out.println(output);// viktigt att skriva ut sen för att se den från anrop i main



    }





}
