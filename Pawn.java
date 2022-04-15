public class Pawn extends Piece
{
	public Pawn(String colorIn) 
	{
		super(colorIn, "pawn");
		
		if(color == "white")
		{
			symbol = "wPa";
		}
		else{
			symbol = "bPa";
		}
	}
	
	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing)
	{
		
		int moveFromRank = moveFromReq[0];
		int moveFromFile = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		int moveForwardTwo; 
		int moveForwardOne;
		int pawnRowOnPlySide;
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		if(!testKing)
		{
			if(toSquare.getType() == "king")
			{
				return false; 
			}
		}
		
		if(plyColor == "white")
		{
			moveForwardTwo = -2;
			moveForwardOne = -1;
			pawnRowOnPlySide = 6;
		}
		else
		{ 
			moveForwardTwo = 2;
			moveForwardOne = 1;
			pawnRowOnPlySide = 1;
		}
			
		if(moveToY == moveFromFile + moveForwardOne)
		{
			if((moveToX == moveFromRank - 1) || (moveToX == moveFromRank + 1))
			{
				if((toSquare.getType() != "blank") && (toSquare.getColor() != plyColor))
				{
					return true; 
				}
			}	
			else if((moveToX == moveFromRank) && (toSquare.getType() == "blank"))
			{ 
				return true;
			}
		}

		else if((moveToY == moveFromFile + moveForwardTwo) && (moveToX == moveFromRank) && (toSquare.getType() == "blank"))
		{ 
			if(moveFromFile == pawnRowOnPlySide)
			{ 
				return true;
			}
		}
		
		return false;
	}	
}
