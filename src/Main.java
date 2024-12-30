public class Main {
    public static void main(String[] args) {

        LexAccount account = null;
        LexAccount account1 = LexBank.openNewAccount("Account1");
        account1.deposit(100.0);
        LexAccount account2 = LexBank.openNewAccount("Account2");
        account2.deposit(200.0);
        LexAccount account3 = LexBank.openNewAccount("Account3");
        account3.deposit(-30.0);

        /*try{
            account3.deposit(300.0);
        } catch (IllegalArgumentException e){
            System.out.println("FAIL: " + e.getMessage());
        }*/

        LexBank.printReport();

    }
}