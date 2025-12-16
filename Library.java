/**
 * Creates a Library class as an extension of the Building class
 * Has all attributes of Building class and additional about its collection
 */
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements{

  //Attributes
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  public Library(){
    this("<Name Unknown>", "<Address Unknown>", 1, false);
  }

  public Library(String name, String address){
    this(name, address, 1, false);
  }

  /**
   * Constructs a new Library with specific attributes about its location and interior
   * @param name A String of the name of the library
   * @param address A String of the address of the library
   * @param nFloors An integer of the number of floors in the library
   * @param hasElevator A boolean if the library has an elevator
   */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

   /**
   * Getter for hasElevator variable
   * @returns Boolean if there is an elevator in the library
   */
    public boolean hasElevator(){
      return this.hasElevator;
    }

  /**
   * Adds book to collection
   * @param title String of the new book
   * @throws Exception if the book is already in the collection
   */
    public void addTitle(String title){
      if (containsTitle(title)){
        throw new RuntimeException("This book is already in the collection.");
      } else {
        this.collection.put(title, true);
      }
    }

  /**
   * Removes book from collection
   * @param title String of the removed book
   * @throws Exception if the book is already isn't in the collection
   * @return name of the removed title
   */
    public String removeTitle(String title){
      if (containsTitle(title)){
        this.collection.remove(title);
        return title;
      } else {
        throw new RuntimeException("This book already isn't in the collection.");
      }
    } 

  /**
   * Checks out book from collection
   * @param title String of the checked out book
   * @throws Exception if the book isn't in the collection
   * @throws Exception if the book is already checked out
   */
    public void checkOut(String title){
      if (containsTitle(title)){
        if (isAvailable(title)){
          this.collection.replace(title, true, false);
        } else {
          throw new RuntimeException("This book is already checked out.");
        }
      } else {
        throw new RuntimeException("This book isn't in the collection.");
      }
    }

  /**
   * Returns book to the collection
   * @param title String of the book to return
   * @throws Exception if the book is already returned
   * @throws Exception if the book isn't in the collection
   */
    public void returnBook(String title){
      if (containsTitle(title)){
        if (isAvailable(title)){
          throw new RuntimeException("This book has already been returned.");
        } else {
          this.collection.replace(title, true, false);
        }
      } else {
        throw new RuntimeException("This book isn't in the collection.");
      }
    } 

   /**
   * Checks if the collection contains book by that title
   * @param title String of the book to check if its in the collection
   * @return boolean if the title contains the title
   */
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        return true;
      } else {
        return false;
      }
    }

   /**
   * Checks if the book is available
   * @param title String of the book to check if its in the collection
   * @throws Exception if book isn't in collection
   * @return boolean if the collection contains the book
   */
    public boolean isAvailable(String title){
      try{
        if (containsTitle(title)){
          return this.collection.get(title);
        } else {
          throw new RuntimeException("This book doesn't exist in the collection.");
        }
      } catch (Exception e){
        System.out.println(e.getLocalizedMessage());
        return false;
      }
    }

  /**
   * Prints collection in easy-to-read String
   */
    public void printCollection(){
      try{
        if (this.collection.size() < 1){
          throw new RuntimeException("No books in the collection to print out.");
        } else {
          this.collection.forEach((title, available) -> {
            if (available){
              System.out.println(title + " is available.");
            } else {
              System.out.println(title + " is not available.");
            }
          });
        }
      } catch (Exception e){
        System.out.println(e.getLocalizedMessage());
      }
    }

   /**
   * Lists potential commands user can run.
   */
    public void showOptions() {
      super.showOptions();
      System.out.println(" + addTitle(s)\n + removeTitle(s)\n + chekcOut(s)\n + returnBook(s)\n + containsTitle(s)\n + containsTitle(s)\n + isAvailable(s)\n + printCollection()");
    }

    /**
     * Allows user to go to a certain floor
     * Can skip floors if there is an elevator
     * @param n number floor to go to
     * @throws Exception if there is no elevator and they try to skip floors
     * @throws Exception if they try going to floor that does not exist.
     */
    public void goToFloor(int n){
      try{
        if (n > 1 && n <= this.nFloors){
            if (this.hasElevator){
                super.goToFloor(n);
            } else {
                if (this.activeFloor - n > 1 || this.activeFloor - n < -1){
                    throw new RuntimeException("You can't move there!");
                } else {
                    super.goToFloor(n);
                }
            }
        } else {
            throw new RuntimeException("Cannot go to a floor that does not exist.");
        }
      } catch(Exception e) {
        System.out.println(e.getLocalizedMessage());
      }
    }
  
    public static void main(String[] args) {
      Hashtable<String, Boolean> books = new Hashtable<String, Boolean>();
      
      Library testLibrary = new Library("Tester", "123 Green Street", 3, false);
      testLibrary.enter();
      testLibrary.showOptions();
      testLibrary.goToFloor(50);
    }
  
  }