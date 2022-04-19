public class BlankSpace extends Square
{
	
	public BlankSpace() 
	{
		super("blank");
		symbol = "   ";
		color = null;
		
	}

	public void move(int[] moveToLoc)
	{
		
	}

	public boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing) 
	{ 
		return false;
	}

}