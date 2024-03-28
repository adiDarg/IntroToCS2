import java.util.Scanner;

public class Main {
    //main: Complexity: Exponential - O(n^3)
    public static void main(String[] args)
    {
        mainMenu();
    }
    //mainMenu: Complexity: Exponential - O(n^3)
    public static void mainMenu(){
        RealEstate realEstate = new RealEstate();
        Scanner scanner = new Scanner(System.in);
        boolean endProgram = false;
        while (!endProgram)
        {
            System.out.println("--Main Menu--");
            System.out.println("Choose option:");
            System.out.println("1.Create new user");
            System.out.println("2.Login to existing user");
            System.out.println("3.Finish program");
            int choice = scanner.nextInt();
            if (choice < 1 || choice > 3){
                System.out.println("Invalid input, Input a number 1-3");
                continue;
            }
            switch (choice){
                case 1 -> {
                    realEstate.createUser();
                }
                case 2 -> {
                   loginMenu(realEstate);
                }
                case 3 -> {
                    System.out.println("Program will now be terminated");
                    endProgram = true;
                }
                default -> {
                    System.out.println("Invalid input, input 1,2 or 3");
                }
            }
        }
    }
    //loginMenu: Complexity: Exponential - O(n^2)
    public static void loginMenu(RealEstate realEstate){
        Scanner scanner = new Scanner(System.in);
        User user = realEstate.login();
        if (user == null){
            System.out.println("Username or password are wrong");
        }
        else{
            boolean disconnect = false;
            while (!disconnect)
            {
                System.out.println("Welcome " + user.getUsername() + "!");
                System.out.println("Choose option:");
                System.out.println("1.Post new property");
                System.out.println("2.Remove property post");
                System.out.println("3.Display all properties in the system");
                System.out.println("4.Display all properties you posted");
                System.out.println("5.Look for property by parameters");
                System.out.println("6.Disconnect and return to main menu");
                int secondChoice = scanner.nextInt();
                switch (secondChoice){
                    case 1 -> {
                        if (realEstate.postNewProperty(user)){
                            System.out.println("New property successfully posted!");
                        }
                        else{
                            System.out.println("New property post failed!");
                        }
                    }
                    case 2 -> realEstate.removeProperty(user);
                    case 3 -> realEstate.printAllProperties();
                    case 4 -> realEstate.printProperties(user);
                    case 5 -> {
                        Property[] propertiesMatching = realEstate.search();
                        System.out.println("Properties matching your search are:");
                        for (int i = 0; i < propertiesMatching.length; i++){
                            System.out.println(propertiesMatching[i]);
                            System.out.println();
                        }
                    }
                    case 6 -> {
                        System.out.println("Disconnecting and returning to main menu...");
                        disconnect = true;
                    }
                    default -> {
                        System.out.println("Invalid input, input 1,2,3,4,5 or 6");
                    }
                }
            }
        }
    }
}
