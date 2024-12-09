package startup;

import java.util.ArrayList;

public class StartUp {
	private ArrayList<String> locationCells;  //  an ArrayList of cell locations
	private String name;                      //  the Startups name
	
	public void setLocationCells(ArrayList<String> loc) {  //  a setter method that updates the Startups location (Random location)
		locationCells = loc;                               //  provided by the GameHelper placeStartup() method
	}
	
	public void setName(String n) {  //  your basic setter method
		name = n;
	}
	
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);  //  The ArrayList indexOf() method in action! if the user guess is one of the 
 		if (index >= 0) {                              //  entries in the ArrayList, indexOf() will return its ArrayList location if not indexOf() will return -1
			locationCells.remove(index);  //  Using ArrayList remove() method to delete an entry
			
			if (locationCells.isEmpty()) {  //  Using the isEmpty() method to use if all of the locations have been guessed
				result = "kill";
				System.out.println("Ouch! you sunk " + name + " : ( ");  //  tell the user when a Startup has been sunk
			} else {
				result = "hit";
			}
		}
		return result;  //  return "miss" or "hit" or "kill"
	}

}
