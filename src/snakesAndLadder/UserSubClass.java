package snakesAndLadder;

import java.util.InputMismatchException;//import the mismatch exception for catch.
import java.util.Scanner;//import the scanner.

/*
 * User Sub class that extends to the randomizer superclass.
 */
public class UserSubClass extends SnakeLadderAndComputerRandomizer {
	
	int userInp;//variable for user input
	int userTot1;//variable for user total
	int winNum;//variable for the winning number
	
	/**
	* user input and check user input is an integer.
	* pre: none.
	* post: user input must be an integer.
	*/
	public void setScan (Scanner userInput1)
	{
		boolean j = true;//boolean to a variable j is set to true.
		
		while (j)//while j is true below will loop.
		  {
			   try//a try catch to make sure user input an integer.
			   {
				   System.out.print("Enter a number from 1 to 6: ");//output asking user to enter a number from 1 to 6.
				   this.userInp = userInput1.nextInt();//user input.
				   j = false;//to stop the loop, j set to false.
			   }
			   
			   catch (InputMismatchException e)//catch is the user did not input an integer.
			   {
				   userInput1.next();//user input again.
				   System.out.println("That’s not an integer from 1 to 6. Try again: ");//output to try again.
			   }
		  }
	}
	
	/**
	* just a free constructor .
	* pre: none.
	* post: none.
	*/
	public UserSubClass() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	* sets the user total and winning number to the variables of the subclass.
	* pre: none.
	* post: user total and winning number object created.
	*/
	public void UserClass(int userTot, int tOWIN) 
	{
		this.userTot1 = userTot;//set user total to class variable.
		this.winNum = tOWIN;//set winning number to class variable.
	}

	/**
	* returns the user input.
	* pre: none.
	* post: the user input has been returned.
	*/
	public int getScan ()
	{
		return userInp;//return user input
	}
	
	/**
	* Check if the user total is equal to the random number generated, and adds to or subracts from the user total.
	* pre: none.
	* post: the user total has been returned.
	*/
	public int userGame (int[] snake, int[] ladder)
	{
		for(int s = 0; s < snake.length; s++)//a for loop that loops to the number of times the array snake was set to.
		{
			setSnakeNum(winNum);//sets a random number for snake from 1 to 55 in the superclass.
			int sna = getSnakeNum();//gets the returned snake random number set in the before statement and set it equal to a variable 'sna'.
			
			for (int l = s; l < ladder.length; l++)//a for loop that loops to the number of times the array ladder was set to.
			{
				setLadderNum(winNum);//sets a random number for ladder from 1 to 40 in the superclass.
				int lad = getLadderNum();//gets the returned ladder random number set in the before statement and set it equal to a variable 'lad'.
			
				if (userTot1 == sna || userTot1 == lad)//if user total equals the snake random number or the ladder random number. then below will be executed.
        		{
        			setSnakLadPoints();//sets a random number from 2 to 10 in the superclass.
        			int snaLadPoints = getSnakLadPoints();//gets the returned random number set in the before statement and is same point for snake and ladder.
        			
        			if (userTot1 == sna)//if user total equals the random snake number, below is executed.
        			{
        				userTot1 -= snaLadPoints;//subtracts the snake points from the user total.
        				System.out.println("You got snake, you are down: " + snaLadPoints);//output to the user that user got snake and by how many points.
        				
        				if (userTot1 <= 0)//if the user total is less than 0, then below is executed.
        				{
        					userTot1 = 0;//user total is resetted to 0.
        				}
        				break;
        			}
        			
        			else if (userTot1 == lad)//if user total equals the random ladder number, below is executed.
        			{
        				userTot1 += snaLadPoints;//adds the ladder points to the user total.
        				System.out.println("You got ladder, you are up: " + snaLadPoints);//output to the user that user got ladder and by how many points.
        				break;
        			}
        			break;//stops the for loop.
        		}		
				
			}

		}
		
		return userTot1;//return the user total.
	}

}
