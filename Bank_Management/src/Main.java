import java.util.ArrayList;
import java.util.Scanner;

class Bank_Account{
    private String Name;
    private String Account_No;
    private double Balance;
//    private String Account_Type;


    public Bank_Account(String Name, String Account_no) {
        this.Name = Name;
        this.Account_No = Account_no;
        this.Balance =0.0;
    }

    public String getAccount_No() {
        return Account_No;
    }

    public String getName() {
        return Name;
    }

    public double getBalance() {
        return Balance;
    }

    public void Deposit(double amount){
        Balance = amount + Balance;
        System.out.println("Amount Deposited");
        System.out.println("Current Balance :\u20B9 " + Balance);
    }

    public double Withdraw(double amount){
        if(Balance < amount){
            System.out.println("The balance Less than your Withdraw amount :\u20B9"+ "\n Current Balance is : " + Balance);
            return Balance;
        }
         Balance =Balance-amount;
        System.out.println("Withdraw Successfully... " + "\n Remaining Amount :" + " " + Balance);
        return Balance;
    }
    public void Details(){
        System.out.println("Account Holder name :" + Name);
        System.out.println("Account Number:" + Account_No);
        System.out.println("Current Balance: \u20B9" + Balance);
    }
}

class Bank{
    private static ArrayList<Bank_Account> Account = new ArrayList<>();

    public void Create_Account(String Name, String Account_No){
        Bank_Account newacc = new Bank_Account(Name,Account_No);
        Account.add(newacc);
        System.out.println("Account created Succesfully");
        System.out.println("your Account Details : " + "\n Name : " + Name +"\n " + "Account Number : " + Account_No);
    }

        public static Bank_Account Find_Account(String Account_No) {
           for (Bank_Account acc : Account) {
               if (acc.getAccount_No().equals(Account_No)) {
                   return acc;
               }
           }
           // Only print after checking all
           System.out.println("Didn't Find the Account Number");
           return null;
       }




   public void Delete_Account(String Account_No){
        Bank_Account acc = Bank.Find_Account(Account_No);{
            if(acc!=null){
                Bank.Account.remove(acc);
                System.out.println("Account Deleted Successfully !");
            }
            else if(acc == null){
                System.out.println("No Matches Found \n Try another Number or Enter Correct Number");
           }
       }
   }

   public void List_Account(){
        for(Bank_Account acc : Bank.Account){
            acc.Details();
        }
   }

}


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bank b = new Bank();
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome To Our Bank");

            System.out.println("1.create Account \t\t 2.Find Account");
            System.out.println("3.Delete Account \t\t 4.Deposit");
            System.out.println("5.Withdraw Money \t\t 6.Account_Details \n7.Exit");

            System.out.println("Enter Your Choices");
            int choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    in.nextLine();

                    System.out.print("Enter Account Name");
                    String Name = in.nextLine();

                    System.out.println(" Enter Account Number");
                    String Acc_no = in.nextLine();

                    b.Create_Account(Name,Acc_no);
                }


                case 2 -> {
                    in.nextLine();
                    System.out.println("Enter Account Number : ");
                    String Acc_no = in.nextLine();
                    Bank_Account acc = Bank.Find_Account(Acc_no);
                    if(Acc_no != null){
                        System.out.println("Account Found !");
                        System.out.println("Account Number : " +Acc_no + "\n" + "Account Holder : "+ acc.getName());
                    }
                    else{
                        System.out.println("Account Not Found !");
                        System.out.println("Enter correct Account Number");
                    }
                }

                case 3 -> {
                    in.nextLine();
                    System.out.println("Enter Account Number : ");
                    String Acc_no = in.nextLine();
                    b.Delete_Account(Acc_no);
                }

                case 4 -> {
                    in.nextLine();
                    System.out.println("Enter Account Number : ");
                    String Acc_no = in.nextLine();

                    Bank_Account depacc = Bank.Find_Account(Acc_no);
                    if (depacc != null) {
                        System.out.println("Enter the Amount");
                        int Amount = in.nextInt();
                        depacc.Deposit(Amount);
                    } else {
                        System.out.println("Enter the Account Number Correctly");
                    }
                }

                case 5 -> {
                    in.nextLine();
                    System.out.println("Enter Account Number : ");
                    String Acc_no = in.nextLine();
                    Bank_Account depacc = Bank.Find_Account(Acc_no);
                    if (depacc != null) {
                        System.out.println("Enter the Amount");
                        int Amount = in.nextInt();
                        depacc.Withdraw(Amount);
                    }
                }
                case 6 -> {
                    in.nextLine();
                    System.out.println("Enter Account Number : ");
                    String Acc_no = in.nextLine();
                    Bank_Account depacc = Bank.Find_Account(Acc_no);
                    if (depacc != null) {
                        depacc.Details();
                    }
                }
                case 7 -> {
                    System.out.println("Thank You !");
                    exit = true ;
                }
            }
        }
    }
}