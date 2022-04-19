public class King extends Piece
{

	public King(String colorIn) 
	{
		super(colorIn, "king");
		
		if(this.color == "white")
		{
			symbol = "wKi";
		}
		else
		{
			symbol = "bKi";
		}
	}

	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing)
	{
		
		int moveFromRank = moveFromReq[0];
		int moveFromFile = moveFromReq[1];
		int moveToX = moveToReq[0];
		int moveToY = moveToReq[1];
		
		Square toSquare = Board.board[moveToY][moveToX];
		
		for (int moveAwayX = -1; moveAwayX <= 1; moveAwayX++)
		{
			for (int moveAwayY = -1; moveAwayY <= 1; moveAwayY++)
			{
				if(moveToX == moveFromRank + moveAwayX && moveToY == moveFromFile + moveAwayY)
				{
					if((toSquare.getType() != "blank") && (toSquare.getColor() != plyColor))
					{
						return true;
					}
					else if(toSquare.getType() == "blank"){
						return true;
					}
				}
			}
		}
		
		return false;
	}
}