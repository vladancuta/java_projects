import java.util.Arrays;

public abstract class User {

    protected String name;
    protected String email;
    protected String phoneNumber;
    protected IOOperation[] operations;

    User(){}

    User(String name){
        this.name = name;
    }

    User(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    abstract public String toString();

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    abstract public void menu(Database database, User user);
}
