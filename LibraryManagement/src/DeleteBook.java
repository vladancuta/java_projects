import java.util.Scanner;

public class DeleteBook implements IOOperation{
    @Override
    public void oper(Database database, User user) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the book you want to delete");
        String bookname = scanner.next();
        int i = database.getBook(bookname);
        if (i == -1) System.out.println("Book doesn't exist!");
        else {
            database.deleteBook(i);
            System.out.println("Book deleted!");
        }
        user.menu(database, user);

    }
}
