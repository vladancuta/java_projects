import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome! \n 1. Login \n 2. New user");
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
            default:
                System.out.println("Error");
        }

    }

    private static void login(){
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
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
        if (n2 == 1){
            User admin = new Admin(name, email, phoneNumber);
        }
        else {
            User normalUser = new NormalUser(name, email, phoneNumber);
        }
    }
}