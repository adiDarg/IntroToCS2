public class City {
    private final String name;
    private final String geographicLocation;
    private final String[] streets;
    public City(String name, String geographicLocation, String[] streets){
        this.name = name;
        this.geographicLocation = geographicLocation;
        this.streets = streets;
    }
    //getName: Complexity: Constant - O(1)
    public String getName(){
        return this.name;
    }
    //getStreets: Complexity: Constant - O(1)
    public String[] getStreets(){
        return this.streets;
    }
    //toString: Complexity: Constant - O(1)
    public String toString(){
        return name + ", " + geographicLocation;
    }
}
