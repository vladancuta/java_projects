import java.util.ArrayList;

public class Database {

    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> usernames = new ArrayList<String>();

    public void addUser (User s){
        users.add(s);
        usernames.add(s.getName());

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
}
