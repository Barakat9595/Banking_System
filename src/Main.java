import java.util.Scanner;



public class Main {
    public static void main(String[] args) 
    {
        
        System.out.println("welcome to ATM. please enter yor process name");
        System.out.println("---------------------");
        System.out.println(" 1 to enter account name \n 2 to deposit \n 3 to withdraw \n 4 to view your balance \n 5 to cancel last action \n 6 to exit");
        Scanner scan = new Scanner(System.in);
        
        int process = scan.nextInt();
        account user1 = null;
        
        if(process == 1)
        {
             System.out.println("Please enter your account number");
                int accountNumber = scan.nextInt();
                scan.nextLine();
                System.out.println("Please enter your owner name");
                String ownerName = scan.nextLine();
                System.out.println("Please enter your balance");
                double balance = scan.nextDouble();
                user1 = new account(accountNumber, ownerName, balance);
        }
        else
        {
            try {
                throw new  IllegalArgumentException("you must enter your account details first");
            }
            catch(IllegalArgumentException I)
            {
               System.out.println("Please enter your account number");
                int accountNumber = scan.nextInt();
                scan.nextLine();
                System.out.println("Please enter your owner name");
                String ownerName = scan.nextLine();
                System.out.println("Please enter your balance");
                double balance = scan.nextDouble();
                user1 = new account(accountNumber, ownerName, balance);
                
            }
            
        }
        
        System.out.println("please enter your action number");
        int newProcess=0;
        while(newProcess !=6){
        System.out.println("2 to deposit \n 3 to withdraw \n 4 to view your balance \n 5 to cancel last action \n 6 to exit");
        newProcess = scan.nextInt();
       
        if(newProcess == 2)
        {
            deposit d1 = new deposit();
            System.out.println("please enter your deposit value");
            double value = scan.nextDouble();
            d1.amount = value;
            user1.setBalance(d1.execute(user1));
            System.out.println("your new balance is " + user1.getBalance());
            
            System.out.println("press s to save or 5 to undo");
            String ss = scan.next();
             if(ss.equals("5") )
             {
              deposit_rollback dR = new deposit_rollback(d1.amount);
            
               user1.setBalance(dR.cancelTran(user1));
               System.out.println("your new balance is " + user1.getBalance());
            
           
             }
         
            
            
        }
        else if(newProcess == 3)
        {
            withdrawal w1 = new withdrawal();
            System.out.println("please enter your withdrawal value");
            double value = scan.nextDouble();
            w1.amount = value;
            user1.setBalance(w1.execute(user1));
            System.out.println("your new balance is " + user1.getBalance());
            
            System.out.println("press s to save or 5 to undo");
            String ss = scan.next();
             if(ss.equals("5") )
             {
              withdrawal_rollback wR = new withdrawal_rollback(w1.amount);
            
               user1.setBalance(wR.cancelTran(user1));
               System.out.println("your new balance is " + user1.getBalance());
            
           
             }
         
        }
        else if(newProcess == 4)
        {
            inquiry i1 = new inquiry();
            System.out.println("please enter the desired currency to view your balance");
            System.out.println("E for euro and U for USD");
            String Curr = scan.next();
            i1.currencytype = Curr;
            i1.execute(user1);
            
        }
        
        
        
        
           
    
    }
        System.out.println("closing system, thanks for using ATM");
    }
        
        
        
    
    
}
