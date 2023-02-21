package bankapp;



import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Users> usersList = new ArrayList<>();

        Map<Integer,Users> usersMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        welcome();

        login(usersMap,usersList);


        mainPage(usersMap,usersList);

       // usersList.forEach(System.out::println);
        System.out.println("Good Bye!!");
        sc.close();

    }

    //Welcome page
    private static void welcome() {
        System.out.println("Welcome to ABC bank");
        System.out.println("1.Login");
        System.out.println("2.Create account");
    }

    //Login page for creating user and login
    private static void login( Map<Integer,Users> usersMap,List<Users> usersList) {
        int userLogin = userLogin();
        int userId = 0;
        // System.out.println(userLogin);

        //Login
        if(userLogin==1){
            loginPage(usersMap);
        }

        //Create user
        else {
            Users user = createAccount();
            usersList.add(user);
            int accountNo = user.getAccountNo();
            usersMap.put(accountNo,user);
          //  System.out.println(accountNo);
            System.out.println("Redirecting to login page");
            loginPage(usersMap);
        }
    }
    //Login with user id
    private static int userLogin() {
        while(true){
            int num = 0;
            boolean isNum = false;
            Scanner sc = new Scanner(System.in);
            try{
                num = sc.nextInt();
                isNum=true;
            }
            catch (InputMismatchException ex){
                System.out.println("Please enter valid input");
            }
            if(num==1 || num==2){
//                sc.close();
                return num;
            }
            if(isNum)System.out.println("Please enter valid number");
        }
    }
    //Create new account
    private static Users createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kindly provide your details");

        System.out.print("Your name: ");
        String name = sc.next();

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Mobile number: ");
        String mobileNo = sc.next();

        //  System.out.println(name + age + mobileNo);
        return new Users(name,mobileNo,age);
    }
    // Login page after details
    private static void loginPage(Map<Integer,Users> usersMap) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your userid to login");
        int userId = sc.nextInt();
        Set<Integer> userIds = usersMap.keySet();
        if(!userIds.contains(userId)) {
            System.out.println("Your account number doesn't exist or wrong. Provide valid id");
            loginPage(usersMap);
        }
        Users currentUser =  usersMap.get(userId);
        System.out.println("Welcome back "+currentUser.getName());
        userDashBoard(usersMap,currentUser, userId);
    }
    //User dashboard for account related details
    private static void userDashBoard(Map<Integer,Users> usersMap, Users currentUser,int userId) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Check Balance");
        System.out.println("4.Edit account info");
        System.out.println("5.To see account details");

        int userInput = sc.nextInt();
        if(userInput==1){
            System.out.println("Please enter the deposit amount");
            int amount = sc.nextInt();
            currentUser.deposit(amount*1.0);
            System.out.println("Deposited successfully");
//            System.out.println(usersMap.get(userId));
            message(usersMap,currentUser,userId);

        }
        else if(userInput==2){
            System.out.println("Please the enter the to withdraw");
            int amount = sc.nextInt();
            currentUser.withdraw(amount*1.0);
            message(usersMap,currentUser,userId);

        }
        else if(userInput==3){
            System.out.println("Your balance "+currentUser.getBalance());
            message(usersMap,currentUser,userId);

        }
        else if(userInput==4){
            System.out.println("1.Change the account name");
            System.out.println("2.Modify your age");
            System.out.println("3.Change phone number");
            int editAccount = sc.nextInt();
            if(editAccount==1){
                System.out.println("Enter the name: ");
                String name = sc.next();
                currentUser.setName(name);
            }
            else if(editAccount==2){
                System.out.println("Enter the correct age: ");
                int age = sc.nextInt();
                currentUser.setAge(age);
            }
            else{
                System.out.println("Enter the phone number");
                currentUser.setMobileNo(sc.next());
            }
            message(usersMap,currentUser,userId);
        }
        else{
            Users printUser = usersMap.get(userId);
            System.out.println(printUser);
            message(usersMap,currentUser,userId);
        }

    }

    private static void message(Map<Integer,Users> usersMap, Users currentUser,int userId){
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Go to dashboard again");
        System.out.println("2.Exit");
        int depositInput = sc.nextInt();
        if(depositInput==1) userDashBoard(usersMap,currentUser,userId);
        else {
            System.out.println("Thank you banking  with us!!");
        }
    }

    //Final page
    private static void mainPage(Map<Integer,Users> usersMap,List<Users> usersList) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("1.Go to main page");
        System.out.println("2.Logout");
        int input = sc.nextInt();
        if(input==1) {
            welcome();
            login(usersMap,usersList);
            mainPage(usersMap,usersList);
        }

    }



}
