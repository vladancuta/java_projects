import java.util.Scanner;

public class AddBook implements IOOperation{

    @Override
    public void oper(Database database, User user) {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book name: ");
        String name = scanner.next();
        if(database.getBook(name) != -1){
            System.out.println("Book already exists!");
            user.menu(database, user);
        }
        else book.setName(name);
        System.out.println("Enter book author: ");
        book.setAuthor(scanner.next());
        System.out.println("Enter book publisher: ");
        book.setPublisher(scanner.next());
        System.out.println("Enter book location: ");
        book.setAddress(scanner.next());
        System.out.println("Enter qty: ");
        book.setQty(scanner.nextInt());
        System.out.println("Enter book price: ");
        book.setPrice(scanner.nextDouble());
        System.out.println("Enter book borrowing copies: ");
        book.setBrwcopies(scanner.nextInt());

        database.AddBook(book);
        System.out.println("Book added successfully!\n");

        user.menu(database, user);


    }
}
