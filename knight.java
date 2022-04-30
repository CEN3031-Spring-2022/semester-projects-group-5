public class Knight extends Piece
{

	public int pointValue = 3;
	public int rank;
	public int file;

	public Knight(String colorIn) 
	{
		super(colorIn, "knight");
		
		if(color == "white")
		{
			symbol = "wKn";
		}
		else{
			symbol = "bKn";
		}
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
		
		boolean locationPass = false;
		
		for(int displaceX = -2; displaceX <= 2; displaceX++){
		
			if(displaceX != 0)
			{
				if(moveToX == moveFromRank + displaceX)
				{
					
					if(Math.abs(displaceX) == 1)
					{ 
						for(int displaceY = -2; displaceY <= 2; displaceY += 4)
						{
							if(moveToY == moveFromFile + displaceY)
							{
								locationPass = true;
							}
						}
					}
					else
					{ 
						for(int displaceY = -1; displaceY <= 1; displaceY += 2)
						{
							if(moveToY == moveFromFile + displaceY)
							{
								locationPass = true;
							}
						}
					}
				}
			}
		}
		if(locationPass)
		{
			
			if((toSquare.getType() == "blank") || (toSquare.getColor() != plyColor))
			{
				return true;
			}
		}
		
		return false;
	}
}