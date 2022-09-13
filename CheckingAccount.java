public class CheckingAccount {
   private double balance;

   
   
   public CheckingAccount(double balance) {
       super();
       this.balance = balance;
   }

   public void setBalance(double balance) {
       this.balance = balance;
   }
   
   public double checkBalance() {
       return balance;
   }

   public void deposit(double balance) {
       this.balance += balance;
   }

   public void withdraw(double balance) {
       if (this.balance < balance) {
           System.out.println("INSUFFICIENT FUNDS!");
       } else {
           this.balance -= balance;
       }
       
   }

}
