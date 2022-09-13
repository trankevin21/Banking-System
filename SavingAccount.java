public class SavingAccount {
   private double balance;
   private double intrestRate;
  

   
   public SavingAccount(double balance, double intrestRate) {
       super();
       this.balance = balance;
       this.intrestRate = intrestRate;
   }
  
   public double getIntrestRate() {
       return intrestRate;
   }

   public void setIntrestRate(double intrestRate) {
       this.intrestRate = intrestRate;
   }
   
   public double intrestPaid(int month) {
       double intrest = this.balance*(1+intrestRate/100*month) - this.balance;
       return intrest;
   }
  
   public void applyIntrest(int month) {//Each time applied is 1 month
      
       this.balance += intrestPaid(month);
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
