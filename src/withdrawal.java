
 class withdrawal extends transaction {
    public double amount;

    @Override
    public double execute(account account) {
        
        double balance = account.getBalance();
        balance -= amount;
        account.setBalance(balance);
        
        return balance;
    }
}
