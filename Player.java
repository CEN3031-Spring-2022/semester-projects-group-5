import java.util.Scanner;

class Player 
{
	private String name;
	private String color;
	private final Scanner scanner = new Scanner(System.in);
	
	Player(String nameIn, String colorIn)
	{
		name = nameIn;
		color = colorIn;
	}
	
	private int convertCharToNum(char charIn)
	{
		int numOut = -1;
		
		for(int i = 0; i < Board.SIDE_LETTERS.length; i++)
		{
			if(Board.SIDE_LETTERS[i] == charIn)
			{
				numOut = i;
			}
		}
		return numOut;
	}
	
	private int convertCharNumtoNum(char charIn)
	{
		int numOut = -1;
		int convertedNum = Character.getNumericValue(charIn); 
		
		for(int i: Board.SIDE_NUMS)
		{
			if(i == convertedNum)
			{
				numOut = convertedNum;   
			}
		}
		return numOut;
	}
	
	public int[][] getMove()
	{	
		int[][] move = new int[2][2];
		for(int runNum = 1; runNum <= 2; runNum++)
		{
			while(true)
			{
				if(runNum == 1)
				{ 
					System.out.print(name + ", input your location to move from. (EX: E4)\n>> ");
				}
				else
				{
					System.out.print(name + ", input you location to move to. (EX: E4)\n>> ");
				}
				String moveIn = scanner.nextLine().trim();
			
				
				if(!moveIn.isEmpty() && moveIn.length() <= 2 && !(moveIn.contains(" ") || moveIn.contains("\t")))
				{
					if(!Character.isDigit(moveIn.charAt(0)) && Character.isDigit(moveIn.charAt(1)))
					{
						int rank, file;
			
						if((rank = convertCharToNum(Character.toUpperCase(moveIn.charAt(0)))) != -1)
						{
							if((file = convertCharNumtoNum(moveIn.charAt(1))) != -1)
							{
								file = 8 - file;
								int tempArray[] = {rank, file};
								if(runNum == 1)
								{
									if(Board.board[file][rank].getType() == "blank" || Board.board[file][rank].getColor() != color)
									{ 
										tempArray[0] = -1;																
										tempArray[1] = -1;
										int[][] errorArray = {tempArray, tempArray};
										return errorArray;
									}
								}
								move[runNum - 1] = tempArray;
								break;
							}
						}
					}
				}
				System.out.println("Invalid location. Try again.");
			}		
		}
		return move;
	}
}
