import java.util.Scanner;

public class BorrowBook implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the book you want to borrow");
        String bookname = scanner.next();
        int i = database.getBook(bookname);
        if (i == -1) System.out.println("Book doesn't exist!");
        else {
            Book book = database.getBook(i);
            if(book.getBrwcopies() > 1){
                Borrowing borrowing = new Borrowing(book, user);
                book.setBrwcopies(book.getBrwcopies()-1);
                database.BorrowBook(borrowing, book, i);
                System.out.println("\n you must return the book in 14 days. \nExpiry date " + borrowing.getFinish() + "\n");
            }
            else {
                System.out.println("Book unavailable");
            }
        }
        user.menu(database, user);
    }
}
