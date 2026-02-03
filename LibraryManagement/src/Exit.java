import java.util.Scanner;

public class Exit implements IOOperation{
    Scanner scanner;
    Database database;
    User user;

    @Override
    public void oper(Database database, User user) {
        this.database = database;
        this.user = user;
        System.out.println("Sure you want to want to exit? 1. Yes, 2. No");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("0.Exit \n 1. Login \n 2. New user");
            int n = scanner.nextInt();

            switch (n) {
                case 1: {
                    login();
                    break;
                }
                case 2: {
                    newuser();
                    break;
                }
            }
        }
        else {
            user.menu(database, user);
        }
    }
        private void login(){
            System.out.println("Enter phone number: ");
            String phonenumber = scanner.next();
            System.out.println("Enter email: ");
            String email = scanner.next();
            int i = database.login(phonenumber, email);
            if(i != -1){
                User user = database.getUser(i);
                user.menu(database, user);
            } else {
                System.out.println("user doesn't exist");
            }
        }

        private void newuser(){
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter email: ");
            String email = scanner.next();
            System.out.println("Enter phone number : ");
            String phoneNumber = scanner.next();
            System.out.println(" 1.Admin \n 2.Normal user");
            int n2 = scanner.nextInt();
            User user;
            if (n2 == 1){
                user = new Admin(name, email, phoneNumber);
            }
            else {
                user = new NormalUser(name, email, phoneNumber);
            }
            database.addUser(user);
            user.menu(database, user);
        }
}
