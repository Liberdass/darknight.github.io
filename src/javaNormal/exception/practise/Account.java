package javaNormal.exception.practise;

public class Account {
    double balance ;//余额
    double deficit ;//透支额

    //获取余额
    public double getBalance(){
        return  balance;
    }
    //存钱
    public void deposit(double cash){

    }
    //取钱
    public void withdraw(double cash) throws OverdraftException{
        if(cash > balance + deficit){
            throw new OverdraftException("透支余额不足");
        }
    }

    public static void main(String[] args) {
        Account a = new Account();
        a.balance = 0;
        a.deficit = 100;
        try{
            a.withdraw(200);
        }catch (OverdraftException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
