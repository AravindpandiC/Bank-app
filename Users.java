package bankapp;

public class Users {
    private static int idGenerate = 1;
    private final int accountNo;
    private String name;
    private String mobileNo;
    private int age;
    private double balance;
    private int transactionID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getAge() {
        return age;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        if(amount>=balance) {
            System.out.println("Insufficient funds");
            return;
        }
        this.balance -= amount;
        System.out.println("Withdrawn "+amount+" successfully");
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return "Users{" +
                "accountNo=" + accountNo +
                ", name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAccountNo(){
        return accountNo;
    }
    public Users(String name, String mobileNo, int age) {
        accountNo = idGenerate;
        this.name = name;
        this.mobileNo = mobileNo;
        this.age = age;

        System.out.println("Account created successfully. Your account number is "+accountNo);
        System.out.println("Please don't forgot your account number");
        idGenerate++;
    }





}
