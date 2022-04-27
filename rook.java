public class Rook extends Piece
{
	public int pointValue = 5;
	public boolean hasMoved = false;
	
	public Rook(String colorIn) 
	{
		super(colorIn, "rook");
		
		if(color == "white")
		{
			symbol = "wRo";
		}
		else
		{
			symbol = "bRo";
		}
	}
	
	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) 
	{
		int moveFromRank = moveFromReq[0];
		int moveFromFile = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		String direction;
		
		if(!testKing)
		{
			if(toSquare.getType() == "king")
			{
				return false;
			}
		}
		
		if(moveToY == moveFromFile)
		{
			if(moveToX > moveFromRank)
			{
				direction = "rite";
			}
			else
			{
				direction = "left";
			}
		}
		
		else if(moveToX == moveFromRank)
		{
			if(moveToY > moveFromFile)
			{
				direction = "bot";
			}
			else
			{
				direction = "top";
			}
		}
		else
		{
			return false;
		}
		
		Square testSquare;
		
		if((direction == "rite") || (direction == "left"))
		{
			int displaceMax = Math.abs(moveToX - moveFromRank); 
		
			for(int displace = 1; displace <= displaceMax; displace++)
			{
				if(direction == "rite")
				{
					testSquare = Board.board[moveFromFile][moveFromRank + displace];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax))
					{
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor)))
					{
						return true;
					}
				}
				else
				{
					testSquare = Board.board[moveFromFile][moveFromRank - displace];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax))
					{
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor)))
					{
						return true;
					}
				}
			}
		}
		else
		{ 
			int displaceMax = Math.abs(moveToY - moveFromFile); 
				
			for(int displace = 1; displace <= displaceMax; displace++)
			{
				
				if(direction == "top")
				{
					testSquare = Board.board[moveFromFile - displace][moveFromRank];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax))
					{
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor)))
					{
						return true;
					}
				}
				else
				{
					testSquare = Board.board[moveFromFile + displace][moveFromRank];
					
					if((testSquare.getType() != "blank") && (displace != displaceMax))
					{
						return false;
					}
					else if((displace == displaceMax) && ((testSquare.getType() == "blank") || (testSquare.getColor() != plyColor)))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}