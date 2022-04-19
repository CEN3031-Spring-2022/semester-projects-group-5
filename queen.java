public class Queen extends Piece
{
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
				return false;
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
		
			for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++)
			{
				if(direction == "topRight")
				{
					testSquare = Board.board[moveFromFile - diagMoveAway][moveFromRank + diagMoveAway];
				}
				else if(direction == "botRight")
				{
					testSquare = Board.board[moveFromFile + diagMoveAway][moveFromRank + diagMoveAway];
				}
				else if(direction == "topLeft")
				{
					testSquare = Board.board[moveFromFile - diagMoveAway][moveFromRank - diagMoveAway];
				}
				else
				{ 
					testSquare = Board.board[moveFromFile + diagMoveAway][moveFromRank - diagMoveAway];
				}
			
				if((testSquare.getType() != "blank") && (diagMoveAway != moveDistance))
				{
					return false;
				}
				else if((diagMoveAway == moveDistance) && ((testSquare.getColor() != plyColor) || (testSquare.getType() == "blank")))
				{
					return true;
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