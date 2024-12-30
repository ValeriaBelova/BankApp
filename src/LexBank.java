import java.util.ArrayList;

public class LexBank {
    //representerar banken som helhet
    //hanterar en samling av konton(LexAccount-objekt)
    //har funktionalitet som påverkar flera konton och bankens data som helhet

    //Har endast statiska medlemmar, samt en privat konstruktor
    private static ArrayList<LexAccount> accounts = new ArrayList<>(); //lagrar konton av typen LexAccount

    private LexBank() {} //private konstruktor för att förhindra att någon skapar instanser av LexBank

    public static LexAccount openNewAccount (String name) {
        LexAccount newAccount = new LexAccount(name); //skapar en ny konto (objekt)
        //newAccount.setSaldo(initialSaldo); //sätter saldo till kontot
        accounts.add(newAccount);//lägger till konto i listan
        outputMessage ("The account för " + name + " is created successfully!");
        return newAccount; //viktigt!!!
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
        output += "\n----------------";
        System.out.println(output);// viktigt att skriva ut sen för att se den från anrop i main



    }





}
