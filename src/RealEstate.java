import java.util.Scanner;
public class RealEstate {
    private User[] users;
    private Property[] properties;
    private final City[] cities;
    private final int VALID_PASSWORD_MINIMUM_LENGTH = 5;
    private final char[] CHARACTERS_NEEDED_FOR_VALID_PASSWORD = {'$', '%', '_'};
    private final int VALID_PHONE_NUMBER_LENGTH = 10;
    public RealEstate(){
        users = new User[0];
        properties = new Property[0];
        cities = new City[10];
        String[] streetsTelAviv = {"King George", "Hertzel","Jacob Rock", "Son of Judah", "Bugrashov"};
        cities[0] = new City("Tel Aviv","Mercaz", streetsTelAviv);
        String[] streetsHaifa = {"Harofeh", "Ahad HaAm", "Aharon", "Al Hariri"};
        cities[1] = new City("Haifa","North", streetsHaifa);
        String[] streetsBeerSheva = {"Arad Alley", "Bat Sheva", "Dikla", "Toledano", "Menahem Gabbai"};
        cities[2] = new City("Beer Sheva", "Negev", streetsBeerSheva);
        String[] streetsAshkelon = {"Ayala", "Gilad", "LeviA", "Refidim", "Plugot"};
        cities[3] = new City("Ashkelon", "South", streetsAshkelon);
        String[] streetsNetanya = {"Balfour", "Dankner", "Fichman", "Weissburg", "Michal"};
        cities[4] = new City("Netanya", "HaSharon", streetsNetanya);
        String[] streetsAshdod = {"Shay Agnon", "Shevet Gad", "Piteda", "Kislev", "HaGalim"};
        cities[5] = new City("Ashdod", "South", streetsAshdod);
        String[] streetsPetahTikva = {"Josef Feldman", "Elhanan", "Ichilov", "Unkelus"};
        cities[6] = new City("Petah Tikva", "Mercaz", streetsPetahTikva);
        String[] streetsKiryatGat = {"Yehoshafat", "Kesef", "Leshem", "Geon HaYarden"};
        cities[7] = new City("Kiryat Gat", "South", streetsKiryatGat);
        String[] streetsKiryatShmona = {"Baba Sali", "Salamanovitch", "Shmuel Ohana", "HaBanim", "Keren HaYesod", "Mekorot"};
        cities[8] = new City("Kiryat Shmona", "North", streetsKiryatShmona);
        String[] streetsEilat = {"Efroni", "HaGir", "Gishron", "Dakar", "Karish", "Malkit"};
        cities[9] = new City("Eilat", "South", streetsEilat);
    }
    //createUser: Complexity: Exponential - O(n^2)
    void createUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input username");
        String username = inputUsernameForSignIn();
        System.out.println("Input password");
        String password = inputPasswordForSignIn();
        System.out.println("Input phone number");
        String phoneNumber = inputPhoneNumber();
        System.out.println("input 1 if you're a realtor, otherwise input 0");
        boolean isRealtor = inputIsRealtor();
        User[] newUsers = new User[users.length + 1];
        newUsers[users.length] = new User(username,password,phoneNumber,isRealtor);
        for (int i = 0; i < users.length; i++){
            newUsers[i] = users[i];
        }
        users = newUsers;
    }
    //inputUsername: Complexity: Linear - O(n)
    private String inputUsernameForSignIn(){
        Scanner scanner = new Scanner(System.in);
        String username;
        boolean validUsername = false;
        do
        {
            username = scanner.nextLine();
            for (int i = 0; i < users.length; i++)
            {
                if (username.equals(users[i].getUsername())){
                    System.out.println("A user already has this name, input a different username");
                    break;
                }
                else if (i == users.length - 1){
                    validUsername = true;
                }
            }
            if (users.length == 0){
                validUsername = true;
            }
        } while(!validUsername);
        return username;
    }
    //inputPassword: Complexity: Linear - O(n)
    private String inputPasswordForSignIn(){
        String password;
        Scanner scanner = new Scanner(System.in);
        do
        {
            password = scanner.nextLine();
            if (!isPasswordStrong(password))
            {
                System.out.println("Password not strong enough. Input new password");
            }
            else {
                break;
            }
        } while (true);
        return password;
    }
    //inputPhoneNumber: Complexity: Linear - O(n)
    private String inputPhoneNumber(){
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        do {
            phoneNumber = scanner.nextLine();
            if (!isPhoneNumberValid(phoneNumber)){
                System.out.println("Input new phone number");
            }
            else {
                break;
            }
        } while (true);
        return phoneNumber;
    }
    //inputIsRealtor: Complexity: Linear - O(n)
    private boolean inputIsRealtor(){
        boolean isRealtor;
        Scanner scanner = new Scanner(System.in);
        do{
            String chooseRealtorOrNot = scanner.nextLine();
            if (chooseRealtorOrNot.equals(String.valueOf(1))) {
                isRealtor = true;
                break;
            }
            else if (chooseRealtorOrNot.equals(String.valueOf(0))){
                isRealtor = false;
                break;
            }
            else {
                System.out.println("Invalid input");
            }
        } while (true);
        return isRealtor;
    }
    //isPasswordStrong: Complexity: Constant - O(1)
    private boolean isPasswordStrong(String password) {
        if (password.length() < VALID_PASSWORD_MINIMUM_LENGTH) {
            System.out.println("password too short");
            return false;
        }
        boolean containsDigit = false;
        for (int i = 0; i <= 9; i++)
        {
            String digit = String.valueOf(i);
            if (password.contains(digit)) {
                containsDigit = true;
                break;
            }
        }
        boolean containsCharacter = false;
        for (int i = 0; i < CHARACTERS_NEEDED_FOR_VALID_PASSWORD.length; i++){
            if (password.contains(String.valueOf(CHARACTERS_NEEDED_FOR_VALID_PASSWORD[i]))){
                containsCharacter = true;
                break;
            }
        }
        if (!containsDigit) {
            System.out.println("Password has to contain at least 1 digit");
        }
        if (!containsCharacter) {
            System.out.println("Password has to contain at least 1 character");
        }
        return containsDigit && containsCharacter;
    }
    //isPhoneNumberValid: Complexity: Linear - O(n)
    private boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.length() != VALID_PHONE_NUMBER_LENGTH){
            System.out.println("Length of a phone number has to be exactly 10");
            return false;
        }
        if (!phoneNumber.startsWith("05")){
            System.out.println("Phone number must begin with 05");
            return false;
        }
        boolean isCharacterInt = false;
        for (int i = 0; i < phoneNumber.length(); i++){
            for (int j = 0; j < 10; j++)
            {
                if (phoneNumber.charAt(i) == String.valueOf(j).charAt(0)){
                    isCharacterInt = true;
                    break;
                }
            }
            if (!isCharacterInt){
                return false;
            }
            isCharacterInt = false;
        }
        return true;
    }
    //login: Complexity: Linear - O(n)
    User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input username");
        String username = scanner.nextLine();
        System.out.println("Input password");
        String password = scanner.nextLine();
        User user = null;
        for (int i = 0; i < users.length; i++)
        {
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
                user = users[i];
            }
        }
        return user;
    }
    //postNewProperty: Complexity: Linear - O(n)
    boolean postNewProperty(User user){
        Scanner scanner = new Scanner(System.in);
        if ((user.isRealtor()&& user.getProperties().length ==5)|| (user.getProperties().length ==2)){
            System.out.println("You have reached the limit and can't post more properties");
            return false;
        }

        for (int i = 0; i < cities.length; i++){
            System.out.println(cities[i]);
        }
        System.out.println("Choose city");
        String cityChoice = scanner.nextLine();
        City cityChosen = null;
        for (int i = 0; i < cities.length; i++){
            if (cities[i].getName().equals(cityChoice)){
                cityChosen = cities[i];
                break;
            }
            else if (i == cities.length - 1){
                return false;
            }
        }

        for (int i = 0; i < cityChosen.getStreets().length; i++){
            System.out.println(cityChosen.getStreets()[i]);
        }
        System.out.println("Choose street");
        String streetChoice = scanner.nextLine();
        for (int i = 0; i < cityChosen.getStreets().length; i++){
            if (streetChoice.equals(cityChosen.getStreets()[i])){
                break;
            }
            else if (i == cityChosen.getStreets().length - 1){
                return false;
            }
        }

        System.out.println("Input property type:");
        System.out.println("1 for regular apartment");
        System.out.println("2 for penthouse apartment");
        System.out.println("3 for private home");
        int propertyType = scanner.nextInt();
        if (propertyType < 1 || propertyType > 3){
            System.out.println("Invalid input");
            return false;
        }
        System.out.println("On what floor is the property(write as a number)");
        int propertyFloor = scanner.nextInt();
        System.out.println("How many rooms are in the property(write as a number)");
        int propertyRoomCount = scanner.nextInt();
        System.out.println("Input property number");
        int propertyNumber = scanner.nextInt();
        System.out.println("Input 1 if property is for rent, input 0 if for sale");
        int rentOrSale = scanner.nextInt();
        if (rentOrSale != 0 && rentOrSale != 1){
            System.out.println("Invalid input");
            return false;
        }
        boolean isForRent = rentOrSale == 1;
        System.out.println("Input price of the property");
        int priceOfProperty = scanner.nextInt();

        Property property = new Property(cityChosen,streetChoice,propertyRoomCount,priceOfProperty,propertyType,isForRent,propertyNumber,propertyFloor,user);
        properties = addPropertyToArray(properties,property);
        user.setProperties(addPropertyToArray(user.getProperties(),property));
        return true;
    }
    //addPropertyToArray: Complexity: Linear - O(n)
    Property[] addPropertyToArray(Property[] arr, Property property){
        Property[] newProperties = new Property[arr.length +1];
        newProperties[arr.length] = property;
        for (int i = 0; i < arr.length; i++){
            newProperties[i] = arr[i];
        }
        return newProperties;
    }
    //removeProperty: Complexity: Linear - O(n)
    void removeProperty(User user){
        Scanner scanner = new Scanner(System.in);
        if (user.getProperties().length == 0){
            System.out.println("You have no properties");
        }
        else {
            for (int i = 0; i < user.getProperties().length; i++){
                System.out.println(i+1 + "." +user.getProperties()[i]);
            }
            System.out.println("Choose property");
            int propertyToDelete = scanner.nextInt();
            if (propertyToDelete < 1 || propertyToDelete > user.getProperties().length){
                System.out.println("Invalid input");
            }
            else {
                delete(user, propertyToDelete);
                System.out.println("Property was successfully deleted!");
            }
        }
    }
    private void delete(User user, int propertyToDelete){
            Property[] newProperties = new Property[user.getProperties().length -1];
            Property deletedProperty = new Property(null,null,0,0,0,false,0,0,null);
            int newPropertiesIndex = 0;
            for (int i = 0; i < user.getProperties().length; i++){
                if (i != propertyToDelete - 1){
                    newProperties[newPropertiesIndex] = user.getProperties()[i];
                    newPropertiesIndex++;
                }
                else{
                    deletedProperty = user.getProperties()[i];
                }
            }
            user.setProperties(newProperties);
            newPropertiesIndex = 0;
            for (int i = 0; i < properties.length; i++){
                if (!properties[i].equals(deletedProperty)){
                    newProperties[newPropertiesIndex] = properties[i];
                    newPropertiesIndex++;
                }
            }
            properties = newProperties;
    }
    //printAllProperties: Complexity: Linear - O(n)
    void printAllProperties(){
        for (int i = 0; i < properties.length; i++){
            System.out.println(properties[i]);
        }
    }
    //printProperties: Complexity: Linear - O(n)
    void printProperties (User user){
        for (int i = 0; i < user.getProperties().length; i++){
            System.out.println(user.getProperties()[i]);
        }
    }
    //search: Complexity: Linear - O(n)
    Property[] search(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want an apartment to rent or for sale?");
        int rentOrSale;
        do {
            System.out.println("Input 1 for rent, 0 for sale, -999 for both");
            rentOrSale = scanner.nextInt();
        } while ((rentOrSale != 1 && rentOrSale != 0 && rentOrSale != -999));
        System.out.println("What type of property do you want?");
        int propertyType;
        do {
            System.out.println("Input 1 for regular apartment, 2 for penthouse apartment, 3 for private house");
            propertyType = scanner.nextInt();
        } while (propertyType != 1 && propertyType != 2 && propertyType !=3 && propertyType != -999);
        int roomCount;
        do {
            System.out.println("How many rooms do you want? Input a natural number");
            roomCount = scanner.nextInt();
        } while (roomCount < 1 && roomCount != -999);
        System.out.println("What price range do you want?");
        int minimumPrice;
        do {
            System.out.println("Input minimum:");
            minimumPrice = scanner.nextInt();
        } while (minimumPrice < 0 && minimumPrice != -999);
        int maximumPrice = 0;
        if (minimumPrice != -999){
            do {
                System.out.println("Input maximum(needs to be larger than minimum)");
                maximumPrice = scanner.nextInt();
            } while (maximumPrice < minimumPrice);
        }
        return lookForMatchingProperties(rentOrSale,propertyType,roomCount,minimumPrice,maximumPrice);
    }
    //lookForMatchingProperties: Complexity: Linear - O(n)
    private Property[] lookForMatchingProperties(int rentOrSale, int propertyType, int roomCount, int minimumPrice, int maximumPrice){
        Property[] propertiesMatching = new Property[countPropertiesMatching(rentOrSale,propertyType,roomCount,minimumPrice,maximumPrice)];
        int propertiesMatchingIndex = 0;
        for (int i = 0; i < properties.length; i++){
            int propertyRentOrSale = properties[i].isForRent()? 1 : 0;
            if (rentOrSale == propertyRentOrSale || rentOrSale == -999) {
                if (propertyType == properties[i].getType() || propertyType == -999) {
                    if (roomCount == properties[i].getNumberOfRooms() || roomCount == -999) {
                        if (minimumPrice == -999 || (minimumPrice < properties[i].getPrice() && maximumPrice > properties[i].getPrice())) {
                            propertiesMatching[propertiesMatchingIndex] = properties[i];
                            propertiesMatchingIndex++;
                        }
                    }
                }
            }
        }
        return propertiesMatching;
    }
    //countPropertiesMatching: Complexity: Linear - O(n)
    private int countPropertiesMatching(int rentOrSale, int propertyType, int roomCount, int minimumPrice, int maximumPrice){
        int count = 0;
        int propertyRentOrSale;
        for (int i = 0; i < properties.length; i++){
            propertyRentOrSale = properties[i].isForRent()? 1 : 0;
            if (rentOrSale == propertyRentOrSale || rentOrSale == -999) {
                if (propertyType == properties[i].getType() || propertyType == -999) {
                    if (roomCount == properties[i].getNumberOfRooms() || roomCount == -999) {
                        if (minimumPrice == -999 || (minimumPrice < properties[i].getPrice() && maximumPrice > properties[i].getPrice())) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
