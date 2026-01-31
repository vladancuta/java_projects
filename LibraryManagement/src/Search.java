import java.util.Scanner;

public class Search implements  IOOperation{

    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter book name ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        int i = database.getBook(name);
        if (i == -1) System.out.println("Book doesn't exist!");
        else {
            System.out.println(database.getBook(i).toString());
        }
        user.menu(database, user);

    }
}
