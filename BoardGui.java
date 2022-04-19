import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class BoardGui extends JPanel{
	private JPanel[][] chessBoard;
	private int moves;
	
	public BoardGui() {
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
		setBoard();
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				
			}

			public void mousePressed(MouseEvent e) {
				String square = "";
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
				
				System.out.println(square);
			}

			public void mouseReleased(MouseEvent e) {
				String square = "";
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
				moves++;
				
				System.out.println(square);
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
	
	public void setBoard() {
		
	}
}
