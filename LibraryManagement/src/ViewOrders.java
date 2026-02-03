import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrders implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter book name: ");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.next();

        int i = database.getBook(bookname);

        if(i == -1){
            System.out.println("Book doesn't exist!");
        }
        else {
            System.out.println("BOOK\t\tUSER\t\tQTY\t\tPRICE");
            for (Order order : database.getAllOrders()){
                if (order.getBook().getName().matches(bookname)){
                    System.out.println(order.getBook().getName() + "\t\t" + order.getUser().getName() +
                                        "\t\t" + order.getQty() + "\t\t" + order.getBook().getPrice() );
                }
            }
        }
        user.menu(database, user);
    }
}
