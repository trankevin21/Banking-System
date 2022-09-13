public class User {
   private String accountNumber;
   private int pin;
   private boolean userADMIN;
   private CheckingAccount checkingAccount;
   private SavingAccount savingAccount;
   
   
   
   public User(String accountNumber, int pin2, boolean userADMIN, CheckingAccount checkingAccount, SavingAccount savingAccount) {
       super();
       this.accountNumber = accountNumber;
       pin = pin2;
       this.userADMIN = userADMIN;
       this.checkingAccount = checkingAccount;
       this.savingAccount = savingAccount;
   }
   
   public boolean userADMIN() {
       return userADMIN;
   }
   
   public void setAdmin(boolean userADMIN) {
       this.userADMIN = userADMIN;
   }
   
   public int getPIN() {
       return pin;
   }
   
   public void setPIN(int pin2) {
	   pin = pin2;
   }
   
   public String getAccountNumber() {
       return accountNumber;
   }
   
   public CheckingAccount getCheckingAccount() {
       return checkingAccount;
   }
   
   public SavingAccount getSavingAccount() {
       return savingAccount;
   }
  
   public String toString() {
       return "User [accountNumber=" + accountNumber +", userADMIN=" + userADMIN + ", checkingAccount=" + checkingAccount + ", savingAccount=" + savingAccount + "]";
   }
  
}
