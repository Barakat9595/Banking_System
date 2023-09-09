class inquiry extends transaction {
    public String currencytype;
    public double balance;
    @Override
    public double execute(account account)
    {
        if(currencytype.equals("u")){
            balance = account.getBalance();
            System.out.println("your balance is " + balance);
            
        }
        
        else if(currencytype.equals("e"))
        {
            balance = account.getBalance()/0.93;
            account.setBalance(balance);
            System.out.println("your balance is " + balance);
            
            
        }
        
        return balance;
    }
    
}