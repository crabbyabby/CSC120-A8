/**
 * Creates a House class as an extension of the Building class
 * Has all attributes of Building class and additional ones
 */

import java.util.ArrayList;

public class House extends Building{

  /**
   * An ArrayList of the Student class to track residents
   */
  private ArrayList<Student> residents;

  /**
   * A boolean of if the House has a dining room
   */
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(){
    this("<Name Unknown>", "<Address Unknown>", 1, true, false);
  }

  public House(String name, String address, int nFloors, boolean hasElevator){
    this(name, address, nFloors, false, hasElevator);

  }

  /**
   * Constructs a new House with specific attributes about its location and interior
   * @param name A String of the name of the house
   * @param address A String of the address of the house
   * @param nFloors An integer of the number of floors in the house
   * @param residents An ArrayList of the Student class which tracks the name and other identifying information about the student
   * @param hasDiningRoom A boolean which details if the house does or doesn't have a dining room
   * @param hasElevator A boolean which details if the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for if the house has a dining room
   * @return boolean of if there's a dining room
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /**
   * Accessor for nResidents
   * @return int of the number of residents in the house
   */
  public int nResidents(){
    int nRes = 0;
    if (this.residents.isEmpty()){
      nRes = 0;
    } else {
      nRes = this.residents.size();
    }
    return nRes;
  }

  /**
   * Moves in a student into the house by adding them to residents ArrayList
   * @param s the student to move in
   * @throws Exception if the student is already in the residents list
   * @return boolean of if there's a dining room
   */
  public void moveIn(Student s){
    if (this.residents.contains(s)){
      throw new RuntimeException("Student is already moved in");
    } else {
      this.residents.add(s);
    }
  }

  /**
   * Moves out a student
   * @param s the student to move out
   * @throws Exception if that student is not there
   * @return Student class of student who moved out
   */
  public Student moveOut(Student s){
    if (this.residents.contains(s)){
      this.residents.remove(s);
      return s;
    } else {
      throw new RuntimeException("Student has already been moved out.");
    }
  }

  /**
   * Sees if a student is a reisdent
   * @param s to check
   * @return Boolean if the student is a resident
   */
  public boolean isResident(Student s){
    if (this.residents.contains(s)){
      return true;
    } else {
      return false;
    }
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

   /**
   * Lists potential commands user can run.
   */
  public void showOptions() {
      System.out.println("Available options at " + this.name + 
        ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom(n, n, n)" +
        "\n + nResidents()\n + moveIn(s)\n + moveOut(s)\n + isResident(s)");
  }

  public static void main(String[] args) {
    House home = new House("Home", "456 House Street", 3, true, true);
    home.showOptions();
  }

}