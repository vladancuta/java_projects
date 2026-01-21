public class NormalUser extends User{
    NormalUser(String name){
        super(name);
    }

    NormalUser(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);
    }
}
