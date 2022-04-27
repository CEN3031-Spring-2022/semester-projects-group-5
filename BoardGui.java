import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class BoardGui extends JPanel{
	private JPanel[][] chessBoard;
	private int moves;
	private String square;
	
	public BoardGui() {
		super();
		setLayout(new GridLayout(8,8));
		chessBoard = new JPanel[8][8];
		moves = 0;
		ImageIcon wPa = new ImageIcon("wPawn.png");
		wPa = scale(wPa);
		ImageIcon wBi = new ImageIcon("wBishop.png");
		wBi = scale(wBi);
		ImageIcon wKn = new ImageIcon("wKnight.png");
		wKn = scale(wKn);
		ImageIcon wRo = new ImageIcon("wRook.png");
		wRo = scale(wRo);
		ImageIcon wKi = new ImageIcon("wKing.png");
		wKi = scale(wKi);
		ImageIcon wQu = new ImageIcon("wQueen.png");
		wQu = scale(wQu);
		
		ImageIcon bPa = new ImageIcon("bPabn.png");
		bPa = scale(bPa);
		ImageIcon bBi = new ImageIcon("bBishop.png");
		bBi = scale(bBi);
		ImageIcon bKn = new ImageIcon("bKnight.png");
		bKn = scale(bKn);
		ImageIcon bRo = new ImageIcon("bRook.png");
		bRo = scale(bRo);
		ImageIcon bKi = new ImageIcon("bKing.png");
		bKi = scale(bKi);
		ImageIcon bQu = new ImageIcon("bQueen.png");
		bQu = scale(bQu);
		
		boolean white = true;
		for(int rank = 0; rank < 8; rank++) {
			for(int file = 0; file < 8; file++) {
				if(white) {
					JPanel s = new JPanel();
					s.setBackground(new Color(0xc6d6df)); // 0xc6d6df
					chessBoard[rank][file] = s;
					add(chessBoard[rank][file]);
				}else {
					JPanel s = new JPanel();
					s.setBackground(new Color(0x779ab0));
					chessBoard[rank][file] = s;
					add(chessBoard[rank][file]);
				}
				white = !white;
			}
			System.out.println();
			white = !white;
		}
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
                if(e.getX() < 100) {
                    square += "A";
                }else if(e.getX() >= 100 && e.getX() < 200) {
                    square += "B";
                }else if(e.getX() >= 200 && e.getX() < 300) {
                    square += "C";
                }else if(e.getX() >= 300 && e.getX() < 400) {
                    square += "D";
                }else if(e.getX() >= 400 && e.getX() < 500) {
                    square += "E";
                }else if(e.getX() >= 500 && e.getX() < 600) {
                    square += "F";
                }else if(e.getX() >= 600 && e.getX() < 700) {
                    square += "G";
                }else if(e.getX() >= 700 && e.getX() < 800) {
                    square += "H";
                }

                if(e.getY() < 100) {
                    square += "8";
                }else if(e.getY() >= 100 && e.getY() < 200) {
                    square += "7";
                }else if(e.getY() >= 200 && e.getY() < 300) {
                    square += "6";
                }else if(e.getY() >= 300 && e.getY() < 400) {
                    square += "5";
                }else if(e.getY() >= 400 && e.getY() < 500) {
                    square += "4";
                }else if(e.getY() >= 500 && e.getY() < 600) {
                    square += "3";
                }else if(e.getY() >= 600 && e.getY() < 700) {
                    square += "2";
                }else if(e.getY() >= 700 && e.getY() < 800) {
                    square += "1";
                }
//				File myObj = new File("chessMove.txt");
//                try {
//                    if(myObj.createNewFile())
//                    {
//                        System.out.println("File created: + myObj.getName()");
//                    }
//                    else
//                    {
//                        System.out.println("File already exists ");
//                    }
//                } catch (IOException e1) {
//                    System.out.println("An error occurred ");
//                    e1.printStackTrace();
//                }
//                try {
//                    FileWriter myWriter = new FileWriter("chessMove.txt");
//                    myWriter.write(square);
//                    myWriter.close();
//
//                } catch (IOException e1) {
//                    System.out.println("An error occurred ");
//                    e1.printStackTrace();
//                }
//				System.out.println(square);
			}

			public void mousePressed(MouseEvent e) {
//				String square = "";
//				if(e.getX() < 100) {
//					square += "A";
//				}else if(e.getX() >= 100 && e.getX() < 200) {
//					square += "B";
//				}else if(e.getX() >= 200 && e.getX() < 300) {
//					square += "C";
//				}else if(e.getX() >= 300 && e.getX() < 400) {
//					square += "D";
//				}else if(e.getX() >= 400 && e.getX() < 500) {
//					square += "E";
//				}else if(e.getX() >= 500 && e.getX() < 600) {
//					square += "F";
//				}else if(e.getX() >= 600 && e.getX() < 700) {
//					square += "G";
//				}else if(e.getX() >= 700 && e.getX() < 800) {
//					square += "H";
//				}
//				
//				if(e.getY() < 100) {
//					square += "8";
//				}else if(e.getY() >= 100 && e.getY() < 200) {
//					square += "7";
//				}else if(e.getY() >= 200 && e.getY() < 300) {
//					square += "6";
//				}else if(e.getY() >= 300 && e.getY() < 400) {
//					square += "5";
//				}else if(e.getY() >= 400 && e.getY() < 500) {
//					square += "4";
//				}else if(e.getY() >= 500 && e.getY() < 600) {
//					square += "3";
//				}else if(e.getY() >= 600 && e.getY() < 700) {
//					square += "2";
//				}else if(e.getY() >= 700 && e.getY() < 800) {
//					square += "1";
//				}
//				
//				System.out.println(square);
			}

			public void mouseReleased(MouseEvent e) {
//				String square = "";
//				if(e.getX() < 100) {
//					square += "A";
//				}else if(e.getX() >= 100 && e.getX() < 200) {
//					square += "B";
//				}else if(e.getX() >= 200 && e.getX() < 300) {
//					square += "C";
//				}else if(e.getX() >= 300 && e.getX() < 400) {
//					square += "D";
//				}else if(e.getX() >= 400 && e.getX() < 500) {
//					square += "E";
//				}else if(e.getX() >= 500 && e.getX() < 600) {
//					square += "F";
//				}else if(e.getX() >= 600 && e.getX() < 700) {
//					square += "G";
//				}else if(e.getX() >= 700 && e.getX() < 800) {
//					square += "H";
//				}
//				
//				if(e.getY() < 100) {
//					square += "8";
//				}else if(e.getY() >= 100 && e.getY() < 200) {
//					square += "7";
//				}else if(e.getY() >= 200 && e.getY() < 300) {
//					square += "6";
//				}else if(e.getY() >= 300 && e.getY() < 400) {
//					square += "5";
//				}else if(e.getY() >= 400 && e.getY() < 500) {
//					square += "4";
//				}else if(e.getY() >= 500 && e.getY() < 600) {
//					square += "3";
//				}else if(e.getY() >= 600 && e.getY() < 700) {
//					square += "2";
//				}else if(e.getY() >= 700 && e.getY() < 800) {
//					square += "1";
//				}
//				moves++;
//				
//				System.out.println(square);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public BoardGui(Square[][] b) {
		super();
		setLayout(new GridLayout(8,8));
		chessBoard = new JPanel[8][8];
		moves = 0;
		
		boolean white = true;
		for(int rank = 0; rank < 8; rank++) {
			for(int file = 0; file < 8; file++) {
				if(white) {
					JPanel s = new JPanel();
					s.setBackground(new Color(0xc6d6df)); // 0xc6d6df
					JLabel thing = b[rank][file].getPicture();
					s.add(thing);
					thing.setVisible(true);
//					chessBoard[rank][file] = s;
//					add(chessBoard[rank][file]);
					add(s);
				}else {
					JPanel s = new JPanel();
					s.setBackground(new Color(0x779ab0));
					JLabel thing = b[rank][file].getPicture();
					s.add(thing);
					thing.setVisible(true);
//					chessBoard[rank][file] = s;
//					add(chessBoard[rank][file]);
					add(s);
				}
				white = !white;
			}
			System.out.println();
			white = !white;
		}
	}

	public JPanel[][] getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(JPanel[][] chessBoard) {
		this.chessBoard = chessBoard;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}
	
	public ImageIcon scale(ImageIcon i) {
		Image buffer = i.getImage();
		Image b = buffer.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon(b);
		return i;
	}
}
