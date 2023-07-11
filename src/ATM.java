import java.util.Scanner;
class accountnumber{
    public int getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(int accountbalance) {
        this.accountbalance = accountbalance;
    }

    private int accountbalance;
}
class InsufficientFundsException extends Exception{

    public InsufficientFundsException(String errormessage) {
        super(errormessage);
    }
}
class InvalidAmountException extends Exception
{
    public InvalidAmountException(String errormessage1) {
        super(errormessage1);
    }

}
public class ATM {

    public static void main(String[] args) {
        accountnumber ac=new accountnumber();
        ac.setAccountbalance(100000);
        int account_balance=ac.getAccountbalance();
        Scanner sc = new Scanner(System.in);
        int count=5;
        do{
            System.out.println("Welcome to bank");
            System.out.println("Choose the option "+"\n"+"1.Deposit"+"\n"+"2.WithDraw"+"\n"+"3.Check balance"+"\n"+"4.exit");
            int n=sc.nextInt();
            if(n==1){
                int balance=deposit(account_balance);
                System.out.println(balance+" Rs");
            }
            else if(n==2){
                withDraw(account_balance);
            }
            else if(n==3){
               checkbalance(account_balance);
            }
            else if(n==4){
                n=0;
                break;
            }
            else{
                System.out.println("Enter the choose is wrong");
            }
        }while(count>0);
    }
    public static void process(int balance) throws InsufficientFundsException, InvalidAmountException {

            Scanner Sc = new Scanner(System.in);
            System.out.println("enter the withdraw amount");
            int withdraw_amount=Sc.nextInt();
            if(withdraw_amount<balance){
                System.out.println("withdraw"+withdraw_amount);
                System.out.println("balance"+(balance-withdraw_amount));
            }
            else if(withdraw_amount>balance){
                throw new InsufficientFundsException("Account in your account is less 10000");
            }
            else{
                if (balance>0){
                    System.out.println("Withdraw");
                }
                else{
                    throw new InvalidAmountException("account balance less the zero and equal zero");
                }
            }

        }


    public static int deposit(int balance){
        Scanner Sc=new Scanner(System.in);
        System.out.println("Enter the deposit amount");
        int depositamount=Sc.nextInt();
        int accountbalance=depositamount+balance;
        return  accountbalance;
    }
    public static void withDraw(int balance){
        try {
            process(balance);
        }
        catch(InsufficientFundsException exception){
            System.out.println(exception.getMessage());
        }
        catch (InvalidAmountException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void checkbalance(int balance){
        System.out.println("account balance"+balance);
    }

}



