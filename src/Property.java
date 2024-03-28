public class Property {
    private final City city;
    private final String street;
    private final int numberOfRooms;
    private final int price;
    private final int type;
    private final boolean isForRent;
    private final int houseNumber;
    private final int floorNumber;
    private final User userWhoPostedIt;
    public Property(City city, String street, int numberOfRooms, int price, int type, boolean isForRent, int houseNumber, int floorNumber,User userWhoPostedIt){
        this.city = city;
        this.street = street;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.type = type;
        this.isForRent = isForRent;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.userWhoPostedIt = userWhoPostedIt;
    }
    //toString: Complexity: Constant - O(1)
    public String toString(){
        String toReturn = city + ", " + street + " " + houseNumber + "\n";
        switch (type){
            case 1-> toReturn += "apartment - ";
            case 2-> toReturn += "penthouse apartment - ";
            case 3-> toReturn += "private house - ";
            default -> toReturn += "";
        }
        toReturn += isForRent? "for rent: ": "for sale: ";
        toReturn += numberOfRooms == 1? numberOfRooms + " room, floor " + floorNumber:numberOfRooms + " rooms, floor " + floorNumber;
        toReturn += "\nContact info - " + userWhoPostedIt;
        return toReturn;
    }
    //getNumberOfRooms: Complexity: Constant - O(1)
    public int getNumberOfRooms(){
        return numberOfRooms;
    }
    //getPrice: Complexity: Constant - O(1)
    public int getPrice(){
        return price;
    }
    //getType: Complexity: Constant - O(1)
    public int getType(){
        return type;
    }
    //isForRent: Complexity: Constant - O(1)
    public boolean isForRent(){
        return isForRent;
    }
}
