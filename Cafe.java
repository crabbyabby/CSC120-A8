/**
 * Creates a Cafe class as an extension of the Building class
 * Has all attributes of Building class and additional ones relating to the storage of coffee supplies
 */
public class Cafe extends Building {

    //Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private int maxCoffeeOunces;
    private int maxSugarPackets;
    private int maxCreams;
    private int maxCups;
    private boolean hasElevator;

    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1, 100, 100, 100, 100, false);
    }

    public Cafe(String name, String address, int nFloors){
        this(name, address, nFloors, 100, 100, 100, 100, false);
    }

    /**
   * Constructs a new Cafe with specific attributes about its location and amount of supplies
   * @param name A String of the name of the house
   * @param address A String of the address of the house
   * @param nFloors An integer of the number of floors in the house
   * @param nCoffeeOunces An integer of the number of coffee ounces stocked
   * @param nSugarPackets An integer of the number of sugar packets stocked
   * @param nCreams An integer of the number of creams stocked
   * @param nCups An integer of the number of cups stocked
   * @param hasElevator A boolean of if the cafe has an elevator
   */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

        this.maxCoffeeOunces = nCoffeeOunces;
        this.maxSugarPackets = nSugarPackets;
        this.maxCreams = nCreams;
        this.maxCups = nCups;

        this.hasElevator = hasElevator;

        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells a coffee
     * Decreases the stored amounts of supply by the size
     * Restocks supplies as needed
     * @param nCoffeeOunces number of coffee ounces restocked
     * @param nSugarPackets number of sugar packets restocked
     * @param nCreams number of creams restocked 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (size < 1 || nSugarPackets < 1 || nCreams < 1){
            throw new RuntimeException("Invalid order.");
        } else {
            if (this.nCoffeeOunces - size >= 0){
                this.nCoffeeOunces -= size;
            } else{
                restock(20, 20, 20, 20);
            }

            if (this.nSugarPackets - nSugarPackets >= 0){
                this.nSugarPackets -= nSugarPackets;
            } else{
                restock(20, 20, 20, 20);
            }

            if (this.nCreams - nCreams >= 0){
                this.nCreams -= nCreams;
            } else{
                restock(20, 20, 20, 20);
            }

            if (this.nCups > 0){
                this.nCups -= 1;
            } else{
                restock(20, 20, 20, 20);
            }
        }
    }

    /**
     * Restocks coffee supplies by the amount listed
     * Checks to ensure the restock doesn't go over the maximum number of each that can be on the shelf
     * If it goes over, sets to max amount possible
     * @param nCoffeeOunces number of coffee ounces restocked
     * @param nSugarPackets number of sugar packets restocked
     * @param nCreams number of creams restocked 
     * @param nCups number of cups restocked 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (this.nCoffeeOunces + nCoffeeOunces <= this.maxCoffeeOunces){
            this.nCoffeeOunces += nCoffeeOunces;
        } else {
            this.nCoffeeOunces = this.maxCoffeeOunces;
            System.out.println("Restock would've overfilled shelf. Restocked to max number of coffee ounces instead.");
        }

        if (this.nSugarPackets + nSugarPackets <= this.maxSugarPackets){
            this.nSugarPackets += nSugarPackets;
        } else { 
            this.nSugarPackets = this.maxSugarPackets;
            System.out.println("Restock would've overfilled shelf. Restocked to max number of sugar packets instead.");
        }

        if (this.nCreams + nCreams <= this.maxCreams){
            this.nCreams += nCreams;
        } else {
            this.nCreams = this.maxCreams;
            System.out.println("Restock would've overfilled shelf. Restocked to max number of creams instead.");
        }

        if (this.nCups + nCups <= this.maxCups){
            this.nCups += nCups;
        } else {
            this.nCups = this.maxCups;
            System.out.println("Restock would've overfilled shelf. Restocked to max number of cups instead.");
        }
    }

   /**
   * Lists potential commands user can run.
   */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(n, n, n)");
    }

    public void goToFloor(int n){
      if (this.hasElevator){
        super.goToFloor(n);
      } else {
        if (this.activeFloor - n > 1 || this.activeFloor - n < -1){
          throw new RuntimeException("You can't move there!");
        } else {
          super.goToFloor(n);
        }
      }
    }

   /**
   * Getter for hasElevator variable
   * @returns Boolean if there is an elevator in the library
   */
    public boolean hasElevator(){
      return this.hasElevator;
    }

    
    public static void main(String[] args) {

        Cafe yummy = new Cafe("Yummy", "123 Cool St", 2, 20, 20, 20 ,20, true);
        yummy.showOptions();
        System.out.println(yummy);
        yummy.enter();
    }
    
}
