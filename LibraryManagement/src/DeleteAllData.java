import java.util.Scanner;

public class DeleteAllData implements IOOperation{
    @Override
    public void oper(Database database, User user) {

        System.out.println("Sure you want to delete all data? 1. Yes, 2. No");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1){
            database.deleteAllData();
        }
        else {
            user.menu(database, user);
        }

    }
}
