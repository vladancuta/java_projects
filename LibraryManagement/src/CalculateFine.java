import java.util.Scanner;

public class CalculateFine implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter book name: ");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.next();

        for(Borrowing b : database.getBrws()){
            if (b.getBook().getName().matches(bookname) && b.getUser().getName().matches(user.getName())){
                if(b.getDaysleft()>0){
                    System.out.println("You are late. You have to pay" + b.getDaysleft() * 50 + "as fine.\n");
                }
                else System.out.println("You don't have to pay fine. \n");
            }
        }
        user.menu(database, user);
    } //video6 - 10:55
}
