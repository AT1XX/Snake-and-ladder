package snakesAndLadder;

public abstract class SnakeLadderAndComputerRandomizer {
	
	
		int snakeN;//variable for snake number.	
		int ladderN;//variable for ladder number.
		int ladderReducer;//variable for reducing ladder number.
		int snakLadPoints;//variable for adding snake number
		int comp;//variable for computer random number.
		
		/**
		* Sets a random snake number between 1 and 55 after adding 5 to the winning number of the game.
		* pre: none.
		* post: the random snake number must be between 1 and 55.
		*/
		public void setSnakeNum (int winNum)
		{
			winNum = winNum + 5;
			snakeN = (int)(Math.random() * ((winNum - 1) + 1)) + 1;//Maximum random number up to 55
		}

		/**
		* returns the snake random number .
		* pre: none.
		* post: the snake random number has been returned.
		*/
		public int getSnakeNum()
		{
			return snakeN;
		}
		
		/**
		* Sets a random ladder number between 1 and 40 after reducing 10 from the winning number of the game.
		* pre: none.
		* post: the random ladder number must be between 1 and 40.
		*/
		public void setLadderNum (int winNum)
		{
			this.ladderReducer = winNum - 10;
			ladderN = (int)(Math.random() * ((ladderReducer - 1) + 1)) + 1;//Maximum random number upto 40
		}

		/**
		* returns the ladder random number .
		* pre: none.
		* post: the ladder random number has been returned.
		*/
		public int getLadderNum()
		{
			return ladderN;
		}
		
		/**
		* Sets a random number between 2 and 10 for the snake and ladder points.
		* pre: none.
		* post: the snake ladder point must be between 2 and 10.
		*/
		public void setSnakLadPoints()
		{
			snakLadPoints = (int)(Math.random() * 10 + 2);//for snake and ladder points ranging from 2 to 10
		}
		
		/**
		* returns the snake ladder random point.
		* pre: none.
		* post: the snake ladder random point has been returned.
		*/
		public int getSnakLadPoints()
		{
			return snakLadPoints;
		}
		
		/**
		* sets a random number between 1 and 6 for the computer.
		* pre: none.
		* post: the computer number must be between 1 and 6.
		*/
		public void setComp()
		{
			comp = (int)(Math.random() * ((6 - 1) + 1)) + 1;
		}
		
		/**
		* returns the random computer number.
		* pre: none.
		* post: the computer number has been returned.
		*/
		public int getComp()
		{
			return comp;
		}
		
}
