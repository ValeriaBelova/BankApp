public class Main {
    public static void main(String[] args) {
        long account1Number = LexBank.openNewAccount("Amelia Andersson"); //variabel account1Number håller kontonumret som genereras av LexBank.openNewAccount()
        LexAccount account1 = LexBank.getAccount(account1Number);//hämtar det faktiska kontoobjektet
        if(account1 != null){ //innan anropa metoden deposit får jag kolla om kontot inte är null (fånga ogiltiga insättningar)
            account1.deposit(500.0);
        }

        long account2Number = LexBank.openNewAccount("Freja Andersson");//hämtar kontonumret och lagrar i account2Number
        LexAccount account2 = LexBank.getAccount(account2Number);//hämtar själva kontoobjekt med hjälp av kontonummer
        if(account2 != null){
            account2.deposit(600.0);
            account2.withdraw(50.0);
        }

        long account3Number = LexBank.openNewAccount("Valeria Belova");
        LexAccount account3 = LexBank.getAccount(account3Number);
        if(account3 != null){
            account3.deposit(550.0);
        }

        try{
            account3.deposit(-40.0);
        } catch (IllegalArgumentException e){
            System.out.println("FAIL: " + e.getMessage());
        }

        LexBank.printReport();

    }
}