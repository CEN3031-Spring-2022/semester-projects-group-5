

public class Bishop extends Piece
{

	public int pointValue = 3;
	public int rank;
	public int file;

	public Bishop(String colorIn) 
	{
		super(colorIn, "bishop");
		
		if(color == "white")
		{
			symbol = "wBi";
		}
		else
		{
			symbol = "bBi";
		}
	}
	
	public String getPiece()
	{
		return symbol;	
	}
	/*
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	public void setFile(int file)
	{
		this.file = file;
	}
	
	public int getRank()
	{
		return rank;
	}
	public int getFile()
	{
		return file;
	}
	*/
	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) 
	{
		
		int moveFromRank = moveFromReq[0];
		int moveFromFile = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		int moveDistance = Math.abs(moveToX - moveFromRank);
		
		if(!testKing)
        {
            if(toSquare.getType() == "king")
            {
                if(!(toSquare.getColor() == color))
                {
                    return true;
                }
            }
        }
		
		String direction;
		
		if(moveToX > moveFromRank)
		{
			if(moveToY < moveFromFile)
			{
				direction = "topRight";
			}
			else
			{
				direction = "botRight";
			}
		}
		else
		{
			if(moveToY < moveFromFile)
			{
				direction = "topLeft";
			}
			else
			{
				direction = "botLeft";
			}
		}
		
		Square testSquare;
		
		int displaceMaxX = Math.abs(moveToX - moveFromRank);
		int displaceMaxY = Math.abs(moveToY - moveFromFile); 
		
		for(int displaceX = 1; displaceX <= displaceMaxX; displaceX++)
		{
			for(int displaceY = 1; displaceY <= displaceMaxY; displaceY++)
			{
				if(direction == "topRight")
				{
					testSquare = Board.board[moveFromFile - displaceY][moveFromRank + displaceX];
				}
			
				else if(direction == "botRight")
				{
					testSquare = Board.board[moveFromFile + displaceY][moveFromRank + displaceX];
				}
				
				else if(direction == "topLeft")
				{
					testSquare = Board.board[moveFromFile - displaceY][moveFromRank - displaceX];
				}
				
				else
				{ 
					testSquare = Board.board[moveFromFile + displaceY][moveFromRank - displaceX];
				}
			
				if((testSquare.getType() != "blank") && (displaceMaxX != moveDistance) && (displaceMaxY != moveDistance))
				{
					return false;
				}
				else if((displaceMaxX == moveDistance) && (displaceMaxY == moveDistance) && ((testSquare.getColor() != plyColor) || (testSquare.getType() == "blank")))
				{
					return true;
				}
			}
		}
		return false;
	}
}
