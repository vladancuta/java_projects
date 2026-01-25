import java.util.Scanner;

public class NormalUser extends User{
    NormalUser(String name){
        super(name);
        this.operations = new IOOperation[]{
          new ViewBooks(),
          new Search(),
          new PlaceOrder(),
          new BorrowBook(),
          new CalculateFine(),
          new ReturnBook(),
          new Exit()



        };
    }

    NormalUser(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);
    }

    @Override
    public void menu(){
        System.out.println("1. View Books");
        System.out.println("2. Search");
        System.out.println("3. Place Order");
        System.out.println("4. Borrow Book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        this.operations[n-1].oper();
    }
}
