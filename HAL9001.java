import java.util.Random;

public class HAL9001 extends Player
{
	
	public String name = "Hal";
	public String color = "black";
	public boolean isEvil = false;
	public Square[] arrayOfPieces;
	
	
	HAL9001(String nameIn, String colorIn)
	{
		super(nameIn, colorIn);
		// TODO Auto-generated constructor stub
	}

	public void setArrayOfPieces() 
	{
		this.arrayOfPieces = new Square[16];
		int i = 0;
		
		for (int rank = 0; rank < Board.board.length; rank++) 
		{
			for (int file = 0; file < Board.board.length; file++)
			{
				if (Board.board[rank][file].getColor() == "black")
				{
					arrayOfPieces[i] = Board.board[rank][file];
				}
			}
		}
	}
	public Square[] getArrayOfPieces() 
	{
		return arrayOfPieces;
	}
	
	public int[][] getMove()
	{
		int[][] move = new int[2][2];
		
		Random rand = new Random();
		int moveIn;
		
		boolean isValidMove = false;
		
		while (!isValidMove) 
		{
			for (int rank = 0; rank < move.length; rank++)
			{
				for (int file = 0; file < move.length; file++)
				{
					
					move[rank][file] = rand.nextInt(Board.board.length);
				}
			}
			if (Board.board[move[0][0]][move[0][1]].getColor() != "black")
			{
				isValidMove = true;
			}
		}
		
		return move;
	}
	
}
