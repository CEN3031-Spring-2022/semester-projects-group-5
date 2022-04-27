

public class Bishop extends Piece
{

	public int pointValue = 3;

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
				return false; 
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
		return false;
	}
}