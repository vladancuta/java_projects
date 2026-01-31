import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;

public class Database {

    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> usernames = new ArrayList<String>();
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<String> booknames = new ArrayList<String >();

    private File userfile = new File("/Users/vlad-adrianancuta/Desktop/java_projects/LibraryManagement/src/Users");
    private File booksfile = new File("/Users/vlad-adrianancuta/Desktop/java_projects/LibraryManagement/src/Books");


    public Database() {
        if(!userfile.exists()){
            try {
                userfile.createNewFile();
            } catch (Exception e) {}
        }

        if (!booksfile.exists()){
            try {
                booksfile.createNewFile();
            } catch (Exception e) {}
        }
        getUsers();
        getBooks();
    }


    public void addUser (User s){
        users.add(s);
        usernames.add(s.getName());
        saveUsers();

    }

    public int login(String phoneNumber, String email){
        int n = -1;
        for(User s : users){
            if(s.getPhoneNumber().matches(phoneNumber) && s.getEmail().matches(email)){
                n = users.indexOf(s);
            }
        }
        return n;
    }

    public User getUser(int n){

        return users.get(n);

    }

    public void AddBook(Book book){
        books.add(book);
        booknames.add(book.getName());
        saveBooks();
    }

    private void getUsers(){
        String text1 = "";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(userfile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        if (!text1.isEmpty()) {
            String[] a1 = text1.split("<NewUser/>");
            for(String s : a1) {
                if (s.trim().isEmpty()) continue;

                String[] a2 = s.split("<N/>");
                if (a2.length >= 4) {
                    String nume = a2[0].trim();
                    String email = a2[1].trim();
                    String telefon = a2[2].trim();
                    String tip = a2[3].trim();

                    if (tip.equals("ADMIN")) {
                        users.add(new Admin(nume, email, telefon));
                    } else {
                        users.add(new NormalUser(nume, email, telefon));
                    }
                }
            }
        }
    }

    private void saveUsers(){
        String text1 = "";
        for (User user : users){
            text1 = text1 + user.toString() + "<NewUser/>\n";
        }

        try {
            PrintWriter pw = new PrintWriter(userfile);
            pw.print(text1);
            pw.close();
            System.err.println("data saved");

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    private void saveBooks(){
        String text1 = "";
        for (Book book : books){
            text1 = text1 + book.toString() + "<NewBook/>\n";
        }

        try {
            PrintWriter pw = new PrintWriter(booksfile);
            pw.print(text1);
            pw.close();
            System.err.println("data saved");

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    private void getBooks(){
        String text1 = "";
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(booksfile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        if (!text1.isEmpty()) {
            String[] a1 = text1.split("<NewBook/>");
            for(String s : a1) {
                Book book = parseBook(s);
                books.add(book);
                booknames.add(book.getName());
          }
        }
    }
    public Book parseBook(String s){
        String[] a = s.split("<N/>");
        Book book = new Book();
        book.setName(a[0]);
        book.setAuthor(a[1]);
        book.setPublisher(a[2]);
        book.setAddress(a[3]);
        book.setQty(Integer.parseInt(a[4]));
        book.setPrice(Double.parseDouble(a[5]));
        book.setBrwcopies(Integer.parseInt(a[6]));
        return book;
    }

    public ArrayList<Book> getAllBooks(){
        return books;
    }

    public int getBook(String bookname){
        int i = -1;
        for(Book book : books){
            if(book.getName().matches(bookname)) i = books.indexOf(book);
        }
        return i;
    }

    public Book getBook(int i){
        return books.get(i);
    }

    public void deleteBook(int i){
        books.remove(i);
        booknames.remove(i);
        saveBooks();
    }
}
