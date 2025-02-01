public class CredentialsObj {
    
    public static Object arrayList;
    public String username, password;
    CredentialsObj(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
