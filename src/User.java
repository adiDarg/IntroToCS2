import javax.print.DocFlavor;

public class User {
    private final String username;
    private final String password;
    private final String phoneNumber;
    private final boolean isRealtor;
    private Property[] properties;
    public User(String username, String password, String phoneNumber, boolean isRealtor)
    {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isRealtor = isRealtor;
        this.properties = new Property[0];
    }
    //getUsername: Complexity: Constant - O(1)
    String getUsername(){
        return username;
    }
    //getPassword: Complexity: Constant - O(1)
    String getPassword(){
        return password;
    }
    //getProperties: Complexity: Constant - O(1)
    Property[] getProperties(){
        return properties;
    }
    //setProperties: Complexity: Constant - O(1)
    void setProperties(Property[] properties){
        this.properties = properties;
    }
    //isRealtor: Complexity: Constant - O(1)
    boolean isRealtor(){
        return isRealtor;
    }
    //toString: Complexity: Constant - O(1)
    public String toString(){
        String toReturn = username + ", " + phoneNumber;
        toReturn += isRealtor? "\nUser is a realtor": "\nUser is not a realtor";
        return toReturn;
    }
}
