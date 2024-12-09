package startup;

import java.util.ArrayList;

public class StartUpBust {
	private GameHelper helper = new GameHelper();                     //  declare and 
	private ArrayList<StartUp> startups = new ArrayList<StartUp>();   //  initialize the
	private int numOfGuesses = 0;                                     //  variable well need
	
	public void setUpGame() {
		StartUp one = new StartUp();    //  make three Startup objects, 
		one.setName("poniez");          //  give them names,
		StartUp two = new StartUp();    //  and stick them in the ArrayList
		two.setName("hacqi");
		StartUp three = new StartUp();
		three.setName("cabista");
		startups.add(one);
		startups.add(two);
		startups.add(three);
		
		System.out.println("Your goal is to sink three Startups.");  //  print brief instructions for user
		System.out.println("poniez, hacqi, cabista");
		System.out.println("Try to sink them all in the fewest number of guesses.");
		
		for (StartUp startup : startups) {                           //   repeat with each startup in the list
			ArrayList<String> newLocation = helper.placeStartup(3);  //   ask the helper for a Startup location
			startup.setLocationCells(newLocation);                   //   call the setter methods on this  Startup to give it the location 
			                                                         //   you just got from the helper.
		}	
	}
	
	public void startPlaying() {
		while (!startups.isEmpty()) {      // as long as the startup is NOT empty
			String userGuess = helper.getUserInput("Enter a Guess: ");    // get user input
			checkUserGuess(userGuess);    //  call our own checkUserGuess method
		}
		finishGame();  //  call our own finishGame method
	}
	
	public void checkUserGuess(String userGuess) {
		numOfGuesses++;  //  increment the number of guesses the user has made
		String result = "miss";  //  assume its a "miss", unless told otherwise
		
		for (StartUp startupToTest : startups) {  //  repeat with all the Startups in the list
			result = startupToTest.checkYourself(userGuess);  //  ask the Startups to check the useGuess looking for a hit (or kill)
			
			if (result.equals("hit")) {  //  get out of the loop early, no point in testing the others
				break;
			}
			if (result.equals("kill")) {  //  this ones dead so take it out of the Startups list then get out of the loop
				startups.remove(startupToTest);
				break;
			}
		}  // close for
		System.out.println(result);  //  print the result for the user
	}  //  close method
	
	public void finishGame() {
		System.out.println("All all Startups are sead! Your stock is now worthless");
		if (numOfGuesses <= 18) {                                                      //  print a message telling the 
			System.out.println("It only took you " + numOfGuesses);                    //  user how they did in the game
			System.out.println("You got out before your options sank.");
		} else {
			System.out.println("Took you long enough " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options");
		}
	}  //  close method
	
	public static void main(String[] args) {    
		StartUpBust game = new StartUpBust();   //  create the game object 
		game.setUpGame();                       //  tell the game object to set up the game
		game.startPlaying();                    //  tell the game object to start the main game play loop (keeps asking for user input and checking the guess)
	}  //  close method
}
