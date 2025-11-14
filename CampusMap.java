import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        myMap.addBuilding(new Building("Seeleye Hall", "123 Elm Street Northhampton, MA 01603"));
        myMap.addBuilding(new Building("Ainsworth Gym", "102 Lower College Lane Northhampton, MA 01603"));
        myMap.addBuilding(new Building("Burton", "345 College Lane Northhampton, MA, 01603", 4));
        myMap.addBuilding(new Building("Lazurus Center", "73 College Lane Northhampton MA 01603", 3));
        myMap.addBuilding(new House("Scales", "234 Elm Street Northhampton MA 01603", 4, true, true));
        myMap.addBuilding(new House("Chase", "36 Elm Street Northhampton MA 01603", 3, true, false));
        myMap.addBuilding(new House("Wilson", "345 Elm Street Northhampton MA 01603", 4, false, false));
        myMap.addBuilding(new House("Emerson", "230985 College Lane Road Northhampton MA 01603", 4, false, false));
        myMap.addBuilding(new House("Tyler", "84 College Lane Northhampton MA 01603", 4, true, false));
        myMap.addBuilding(new Library("Neilson Library", "123 Street Street Northhampton, MA 01603", 4, true));
        myMap.addBuilding(new Cafe("Compass Cafe", "123 Street Street Northhampton, MA 01603", 1, 50, 50, 50, 50, false));

        System.out.println(myMap);
    }
    
}
