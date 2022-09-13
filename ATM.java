import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ATM {

   public static void main(String[] args) {
       ArrayList<User> users = new ArrayList<>();
       Scanner scan = new Scanner(System.in);
       String continueExit;
       
       
       users.add(new User("00000", 12345, true, new CheckingAccount(2002), new SavingAccount(21, 3)));//Default Admin
       users.add(new User("1", 1, false, new CheckingAccount(100), new SavingAccount(100, 5)));//Test User

       do {
           System.out.println("Enter your account number ");
           String accountNumber = scan.next();
           System.out.println("Please enter your PIN ");
           int PIN = scan.nextInt();
           
           int error = 0;
           for (int i = 0; i < users.size(); i++) {

               if (users.get(i).getAccountNumber().equals(accountNumber) && users.get(i).getPIN() == PIN) {
            	   error = 1;
                   
                   if (users.get(i).userADMIN()) {
                       int optionAdmin;
                       
                       do {//Admin Menu
                           System.out.println("(1) Add user\r\n" + "(2) Delete user\r\n" + "(3) List all users\r\n" + "(4) Apply interest to all savings accounts\r\n" + "(5) Exit");
                           System.out.print("Select an option: ");
                           optionAdmin = scan.nextInt();
                           
                           if(optionAdmin == 1) {//Add User
                        	   System.out.println("Enter account number for user ");
                               String newAccountnum = scan.next();
                               
                               System.out.println("Enter PIN for user ");
                               int newPin = scan.nextInt();
                               
                               System.out.println("Enter starting balance in checking account to be opened with ");
                               double balanceChecking = scan.nextDouble();
                               
                               System.out.println("Enter starting balance in saving account to be opened with ");
                               double balanceSavings = scan.nextDouble();
                               
                               System.out.println("Enter the intrest rate for savings account ");
                               double intrestRate = scan.nextDouble();

                               users.add(new User(newAccountnum, newPin, false, new CheckingAccount(balanceChecking), new SavingAccount(balanceSavings, intrestRate)));
                               
                           }else if(optionAdmin == 2) {//Delete User
                        	   
                        	   for (int userlist = 0; userlist < users.size(); userlist++) {
                                   System.out.println("Account Number: " + users.get(userlist).getAccountNumber());
                               }
                        	   
                        	   System.out.println("\n\nEnter account number to be terminated: ");
                               String delAccountNum = scan.next();
                               int userTerminated = 0;

                               Iterator<User> data = users.iterator();
                               while (data.hasNext()) {

                                   if (data.next().getAccountNumber().equals(delAccountNum)) {
                                	   userTerminated = 1;
                                	   data.remove();
                                   }
                               }

                               if (userTerminated == 1) {
                                   System.out.println("User Terminated");
                                   
                               } else {
                                   System.out.println("User " + delAccountNum + " not found!");
                               }
                           
                         }else if(optionAdmin == 3) {//List User
                               for (int userlist = 0; userlist < users.size(); userlist++) {
                                   System.out.println("Account Number: " + users.get(userlist).getAccountNumber());
                               }
                              
                         }else if(optionAdmin == 4) {//Apply intrest
                               for (int intrestApply = 0; intrestApply < users.size(); intrestApply++) {

                                   users.get(intrestApply).getSavingAccount().applyIntrest(1/*month*/);
                               }
                               System.out.println("Intrest Applied!\n");
                               
                         }else if(optionAdmin == 5) {//Exit
                               System.out.println("Logged out!");

                         }else {
                               System.out.println("Invalid! Try Again!");
                           }
                       } while (optionAdmin != 5);
                       
                   } else {

                       int optionUser;
                       do {//Regular User Menu
                           System.out.println("(1) Get checking balance\r\n" + "(2) Deposit into checking\r\n" + "(3) Withdraw from checking\r\n" + "(4) Get savings balance\r\n" + "(5) Deposit into savings\r\n" + "(6) Withdraw from savings\r\n" + "(7) Exit");
                           System.out.print("Select an option: ");
                           optionUser = scan.nextInt();
                           
                           if(optionUser == 1) {//Checking Balance
                               System.out.println("You checking acccount balance is: $" + users.get(i).getCheckingAccount().checkBalance());
                               
                           }else if(optionUser == 2) {//Checking Deposit
                               System.out.println("How much money to deposit: ");
                               double checkingDeposit = scan.nextDouble();
                               users.get(i).getCheckingAccount().deposit(checkingDeposit);
                               
                           }else if(optionUser == 3) {//Checking Withdraw
                               System.out.println("How much money to withdraw: ");
                               double checkingWithdraw = scan.nextDouble();
                               users.get(i).getCheckingAccount().withdraw(checkingWithdraw);
                               
                           }else if(optionUser == 4) {//Savings Balance
                               System.out.println("Saving acccount balance is: $" + users.get(i).getSavingAccount().checkBalance());
                               System.out.println("Saving acccount intrest rate is: " + users.get(i).getSavingAccount().getIntrestRate() + " %");
                               
                           }else if(optionUser == 5) {//Savings Deposit
                               System.out.println("How much money to deposit: ");
                               double savingsDeposit = scan.nextDouble();
                               users.get(i).getSavingAccount().deposit(savingsDeposit);
                               
                           }else if(optionUser == 6) {//Savings Withdraw
                               System.out.println("How much money to withdraw: ");
                               double savingsWithdraw = scan.nextDouble();
                               users.get(i).getSavingAccount().withdraw(savingsWithdraw);

                           }else if(optionUser == 7) {//Exit
                               System.out.println("Logged out successfully!");
                               
                           }else {
                               System.out.println("Invalid! Try Again!");
                           }

                       } while (optionUser != 7);
                   }
               }
           }
           if (error == 0) {

               System.out.println("User not found!");
           }

           System.out.println("Continue y/n");
           continueExit = scan.next();
       } while (!continueExit.equalsIgnoreCase("n"));
   }
}
