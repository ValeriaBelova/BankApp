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
