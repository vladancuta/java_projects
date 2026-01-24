import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {

    static Database database = new Database();

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System!");

        int n;
        do {
            System.out.println("0.Exit \n 1. Login \n 2. New user");
            n = scanner.nextInt();

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
        } while (n != 0);
    }

    private static void login(){
        System.out.println("Enter phone number: ");
        String phonenumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        int i = database.login(phonenumber, email);
        if(i != -1){
            User user = database.getUser(i);
            user.menu();
        } else {
            System.out.println("user doesn't exist");
        }
    }

    private static void newuser(){
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
        user.menu();
    }
}