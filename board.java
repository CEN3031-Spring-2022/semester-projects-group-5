import java.awt.BorderLayout;
import java.util.Scanner;
import javax.swing.*;

public abstract class Board 
{	
	static final char SIDE_LETTERS[] = {'A','B','C','D','E','F','G','H'};
	static final int SIDE_NUMS[] = {1,2,3,4,5,6,7,8};
	public static Square board[][] = new Square[8][8];
	
	private static final Scanner scanner = new Scanner(System.in);
	
	private static void setup()
	{
		board[0][0] = new Rook("black");
		board[0][1] = new Knight("black");
		board[0][2] = new Bishop("black");
		board[0][3] = new Queen("black");
		board[0][4] = new King("black");
		board[0][5] = new Bishop("black");
		board[0][6] = new Knight("black");
		board[0][7] = new Rook("black");
		
		for(int i = 0; i < 8; i++)
		{
			board[1][i] = new Pawn("black");
		}
		
		for(int i = 2; i < 6; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				board[i][j] = new BlankSpace();
			}
		}
		
		for(int i = 0; i < 8; i++)
		{
			board[6][i] = new Pawn("white");
		}

		board[7][0] = new Rook("white");
		board[7][1] = new Knight("white");
		board[7][2] = new Bishop("white");
		board[7][3] = new Queen("white");
		board[7][4] = new King("white");
		board[7][5] = new Bishop("white");
		board[7][6] = new Knight("white");
		board[7][7] = new Rook("white");
		
	}
	
	private static String checkForCheckOrMate(String plyColor)
	{
		for(int kingFile = 0; kingFile < 8; kingFile++)
		{
			for(int kingRank = 0; kingRank < 8; kingRank++)
			{
				Square kingSquare = board[kingFile][kingRank];
				
				String kingColor;
				if(plyColor == "white")
				{
					kingColor = "black";
				}
				else
				{
					kingColor = "white";
				}
				
				if((kingSquare.getType() == "king") && (kingSquare.getColor() == kingColor)){
					
					for(int threatFile = 0; threatFile < 8; threatFile++){
						for(int threatRank = 0; threatRank < 8; threatRank++){
							Square threatSquare = board[threatFile][threatRank];
							
							if((threatSquare.getType() != "blank") && (threatSquare.getColor() == plyColor)){
								int[] moveFrom = {threatRank, threatFile};
								int[] moveTo = {kingRank, kingFile};
							
								if(threatSquare.checkMove(moveFrom, moveTo, plyColor, true)){
									return "check";
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	private static void update(int[] origLoc, int[] newLoc)
	{
		board[newLoc[1]][newLoc[0]] = board[origLoc[1]][origLoc[0]];
		board[origLoc[1]][origLoc[0]] = new BlankSpace();
	}
	
	private static void draw()
	{
		System.out.print("\n   ");
		
		for(char i: SIDE_LETTERS)
		{
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n   ");
		
		for(int i = 0; i < 8; i++)
		{
			System.out.print(" --- ");
		}
		
		System.out.print("\n");
		for(int i = 0; i < 8; i++)
		{
			System.out.print(" " + (8 - i) + " ");
			
			for(Square j: board[i])
			{
				System.out.print("|" + j.getSymbol() + "|");
			}
			System.out.print(" " + (8 - i) + " ");
			
			System.out.print("\n   ");
			
			for(int j = 0; j < 8; j++)
			{
				System.out.print(" --- ");
			}
			System.out.print("\n");
		}
		System.out.print("   ");
		for(char i: SIDE_LETTERS)
		{ 
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n\n");
	}
	
	private static String getName(int playerNum, String prevName)
	{ 
		String name;
		
		while(true)
		{
			System.out.print("Player " + playerNum + " please enter your name.\n>> ");
			name = scanner.nextLine().trim();
			
			if(!name.isEmpty() && !(name.contains(" ") || name.contains("\t")) && !name.equals(prevName)) 
				
				break;
			else
				System.out.println("Invalid name. Try again.");
		}
		return name;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("=====> CHESS <=====");
		//adding gui stuff
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
		String ply1Name = getName(1, null);
		String ply2Name = getName(2, ply1Name);
		
		Player whitePly = new Player(ply1Name, "white");
		Player blackPly = new Player(ply2Name, "black");
		
		MainMenu mainMenu = new MainMenu();
		frame.add(mainMenu);
		BoardGui boardOnGui = new BoardGui();
		//frame.add(boardOnGui);
		
		Scoreboard score = new Scoreboard(ply1Name, ply2Name);
		frame.add(score, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.pack();
		frame.setSize(817,866);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);
		
		setup(); 
		
		while(true)
		{
			for(int runNum = 1; runNum <= 2; runNum++)
			{
				draw();
				
				int move[][] = new int[2][2];
				
				while(true)
				{
				
					if(runNum == 1)
					{
						move = whitePly.getMove();
					}
					else
					{
						move = blackPly.getMove();
					}
				
					if(move[0][0] == -1)
					{
						System.out.println("Invalid location. Try again.");
						continue;
					}
					
					int[] moveFrom = move[0];
					int[] moveTo = move[1];
					Square fromSquare = board[moveFrom[1]][moveFrom[0]];
				
					boolean checkValue;
					if(runNum == 1)
					{
						checkValue = fromSquare.checkMove(moveFrom, moveTo, "white", false);
					}
					else
					{
						checkValue = fromSquare.checkMove(moveFrom, moveTo, "black", false);
					}
					if(checkValue)
					{
						update(moveFrom, moveTo);
						
						if(runNum == 1)
						{
							if (checkForCheckOrMate("white") == "check")
							{
								System.out.println("Check!");
							}
						}
						else
						{
							if (checkForCheckOrMate("black") == "check")
							{
								System.out.println("Check!");
							}
						}
						break;
					}
					System.out.println("Invalid move. Try again.");
				}
			}
		}
	}
}