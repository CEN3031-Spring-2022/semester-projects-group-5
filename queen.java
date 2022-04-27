public class Queen extends Piece
{
	
	public int pointValue = 9;
	
	public Queen(String colorIn) 
	{
		super(colorIn, "queen");
		
		if(color == "white")
		{
			symbol = "wQu";
		}
		else
		{
			symbol = "bQu";
		}
	}
	public String getPiece()
	{
		return symbol;	
	}
	
	@Override
	
	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) 
	{
		
		int moveFromRank = moveFromReq[0];
		int moveFromFile = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		String direction;
		String type;
		
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
		
		if(moveToY == moveFromFile)
		{
			if(moveToX > moveFromRank)
			{
				direction = "right";
				type = "straight";
			}
			else
			{
				direction = "left";
				type = "straight";
			}
		}
		
		else if(moveToX == moveFromRank)
		{
			if(moveToY > moveFromFile)
			{
				direction = "bot";
				type = "straight";
			}
			else
			{
				direction = "top";
				type = "straight";
			}
		}
		else if(moveToX > moveFromRank)
		{
			if(moveToY < moveFromFile)
			{
				direction = "topRight";
				type = "diagonal";
			}
			else
			{
				direction = "botRight";
				type = "diagonal";
			}
		}
		else if(moveToX < moveFromRank)
		{
			if(moveToY < moveFromFile)
			{
				direction = "topLeft";
				type = "diagonal";
			}
			else
			{
				direction = "botLeft";
				type = "diagonal";
			}
		}
		else
		{
			return false;
		}
		
		Square testSquare;
		
		if(type == "diagonal")
		{
			int moveDistance = Math.abs(moveToX - moveFromRank);
		
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
		}
		else
		{
			if((direction == "right") || (direction == "left"))
			{
				int displaceMax = Math.abs(moveToX - moveFromRank);
		
				for(int displace = 1; displace <= displaceMax; displace++)
				{
					if(direction == "right")
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
		}
		return false;
	}

}
