package snakesAndLadder;

import java.util.Scanner;//imported the scanner or the output box

public class SnakesAndLadderGame {

	/**
	* Output the instructions to the user.
	* pre: none
	* post: 'i' needs to be less that the number of instructions. 
	*/
	public static void instruction()
	{
		String [] instruction = {"Welcome to a modified version of 'Snake and Ladder' game against a computer.",
				"Rules and game information:",
				"1. You will have to reach 50 or more points to win the game.",
				"2. You have to input any number ranging from 1 to 6 just like in a six-sided die.",
				"3. You can only get ladder or snake at a point.",
				"4. The snakes and the ladder numbers in the game are random, it will be randomized for the computer too.", 
				"5. The snakes can be at 50 and above too, therfore make your input wisely.",
				"6. The point’s added or deducted from the snakes and ladders will be random too ranging from 2 – 10 points max.",
				"7. Enter 'Yes' or any key to start the game. ",
				"8. Enter 'Q' to quit now or '100' to quit once the game is started."
				};
		
		for (int i = 0; i < instruction.length; i++)//a for loop that loops upto the array length.
		{
			System.out.println(instruction[i]);//output the statement at that specific array number.
		}
	}
	
	/**
	* Check if the user or the computer wins the game and output who won.
	* pre: none
	* post: user Choice has been returned. 
	*/
	public static String CheckerForWinner(int uTot, int cTot, int toWin, int user, int comp)
	{
		String userC = "Q";
		
		if (uTot >= toWin)//if the user total is above the winning number below is executed.
		{	
			System.out.println("-------------------------");//output dashes to represent game end.
			System.out.println("Congrats! You won against a computer. :)");//output user won.
			System.out.println("Your score: " + user + ", Computer score: " + comp);//output user and computer score
			System.exit(0);//exit program.
			return userC; 
		}
    	else if (cTot >= toWin)//if the computer total is above the winning number below is executed.
    	{
    		System.out.println("-------------------------");//output dashes to represent game end.
    		System.out.println("Sorry, you lost! :(");//output user lost.
    		System.out.println("The Computer won!");//output computer won.
    		System.out.println("Your score: " + user + ", Computer score: " + comp);//output user and computer score.
    		System.exit(0);//exit program.
    		return userC; 
    	}
		
		return userC = "W";
		
	}
	

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);//the scanner or the output box.
		
		String userChoice;//a variable string for user choice.
		int userTot = 0;//a variable for the user's total in the game and is initialized to 0.
		int compTot = 0;//a variable for the computer's total in the game and is initialized to 0.
		final int TOWIN = 50;//a constant variable to win the game which is set to 50.
		String quit = "You chose to quit the game.";//a string variable quit is set equal to a string sentence which shows the user that they quit the game.
		
		instruction();//calls a method called instruction for outputting instructions for the game.
		
		userChoice = "Yes";//default user choice is set to "Yes".
		userChoice = userInput.next();//user choice to start game or quit.
        userChoice = userChoice.toUpperCase();//changing user input to uppercase.
        
        if (!userChoice.equals("Q"))//if the user chooses to start the program by entering anything other than "Q".
        {
	        System.out.println("Game started - GOODLUCK");//output that the game started to the user.
	        System.out.println();//output a free new line to the user.
        }
        
        while (!userChoice.equals("Q"))// this will loop as long as the user choice is not q.
        {
        	
        	UserSubClass user = new UserSubClass();//an object created for user as a sub class.
        	user.setScan(userInput);//executes setScan in user subclass to scan the user input.
        	user.getScan();//executes getScan in user subclass to get the user input back.
        	
        	for (int i = 1; i <= 6; i++)// a for loop that goes from 1 to 6 in order to check user inputted from 1 to 6.
        	{
	        	if (user.getScan() == i) //if the user input is from 1 to 6.
	        	{
	        		userTot += user.getScan();// adds the user input to the user's total current score. 
	        		user.UserClass(userTot, TOWIN);//executes userClass in user subclass to set the user total and winning number in ths subclass.
	        		
	        		int [] snake = new int [5];//Array for randomizing the snake numbers in the game each time, also sets the difficulty of game (more snakes = less chance to win).
	        		int [] ladder = new int [3];//Array for randomizing the ladder numbers in the game each time, also sets the difficulty of the game (more ladders = more chance to win).
	        		
	        		userTot = user.userGame(snake, ladder);//executes userGame in user subclass to check user total equals to any random snake and ladder numbers.
	        	}
	        	
	        	else if (user.getScan() == 100)// if the user chose to input 100 this will be executed.
	        	{	
	        		System.out.println(quit);//output that the user chose to quit the game.
	        		System.exit(0);//exit the programs.
	        	}
        	}
        	
        	
        	for(int c = 1; c <= 6; c++)//a for loop to check user inputted from 1 to 6.
        	{
        		if (user.getScan() == c)//if user input is from 1 to 6, below code will be executed.
        		{
	        		 System.out.println("Your now at " + userTot);//output the current user's total score in the game. 
	        		 CheckerForWinner(userTot, compTot, TOWIN, userTot, compTot);//executes method to check for the winner of the game to check user total with the random numbers of snake and ladder..
	        		 
	        		 ComputerSubClass comp = new ComputerSubClass();//an object created for the computer to play the game in the sub class.
	        	
	        		 int [] snake = new int [4];//Array for randomizing the snake numbers in the game each time, also sets the difficulty of game (more snakes = less chance to win).
	        		 int [] ladder = new int [3];//Array for randomizing the ladder numbers in the game each time, also sets the difficulty of the game (more ladders = more chance to win).
	        		 
	        		 compTot = comp.compGame(snake, ladder, compTot, TOWIN );//compGame method from computer subclass is executed.
	        		 System.out.println("Your at: " + userTot);//output user total score again just to compare with the computer's total score.
        		}
        	}
        	
        	userChoice = CheckerForWinner(userTot, compTot, TOWIN, userTot, compTot);//a method to check see the winner of the game.       	 
        	System.out.println("Your move...");//output to the user that it is user's move.
        }
      
        System.out.println(quit);//output that the user chose to quit the game.
        userInput.close();//close the user input.
    	System.exit(0);//exit the program.
	}
}

