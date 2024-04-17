package snakesAndLadder;

/*
 * Computer Sub class that extends to the randomizer superclass.
 */
public class ComputerSubClass extends SnakeLadderAndComputerRandomizer{

	/**
	* Check if the computer total is equal to the random number generated, and adds to or subracts from the computer total.
	* pre: none.
	* post: the computer total has been returned.
	*/
	public int compGame (int[] snake, int[] ladder, int compTot1, int winNum)
	{
		 System.out.println();//output free line
		 System.out.println("Computer move...");//output that it is computer move
		 setComp();
		 int compNum = getComp();//get the computer number from 1 to 6
		 System.out.println("Computer chose " + compNum);//output computer number to the user
		 compTot1 += compNum;//add to computer total
		
		for(int s = 0; s < snake.length; s++)//a for loop that loops to the number of times the array snake was set to.
		{
			setSnakeNum(winNum);//sets a random number for snake from 1 to 55 in the superclass.
			int sna = getSnakeNum();//gets the returned snake random number set in the before statement and set it equal to a variable 'sna'.
			
			for (int l = s; l < ladder.length; l++)//a for loop that loops to the number of times the array ladder was set to.
			{
				setLadderNum(winNum);//sets a random number for ladder from 1 to 40 in the superclass.
				int lad = getLadderNum();//gets the returned ladder random number set in the before statement and set it equal to a variable 'lad'.
			
				if (compTot1 == sna || compTot1 == lad)//if user total equals the snake random number or the ladder random number. then below will be executed.
        		{
        			setSnakLadPoints();//sets a random number from 2 to 10 in the superclass.
        			int snaLadPoints = getSnakLadPoints();//gets the returned random number set in the before statement and is same point for snake and ladder.
        			
        			if (compTot1 == sna)//if user total equals the random snake number, below is executed.
        			{
        				compTot1 -= snaLadPoints;//subtracts the snake points from the computer total.
        				System.out.println("Computer got snake, computer is down: " + snaLadPoints);//output to the user that computer got snake and by how many points.
        				     				
        				if (compTot1 <= 0)//if the computer total is less than 0, then below is executed.
        				{
        					compTot1 = 0;//computer total is resetted to 0.
        				}
        				break;
        			}
        			
        			else if (compTot1 == lad)//if computer total equals the random ladder number, below is executed.
        			{
        				compTot1 += snaLadPoints;//adds the ladder points to the computer total.
        				System.out.println("Computer got ladder, computer is up: " + snaLadPoints);//output to the user that computer got ladder and by how many points.
        				break;
        			}
        			break;//stops the for loop.
        		}		
				
			}

		}
		
		System.out.println("Computer is now at " + compTot1);//output what computer total is at.
		System.out.println();//output a free line.
		return compTot1;//returns the computer total.
	}

}
