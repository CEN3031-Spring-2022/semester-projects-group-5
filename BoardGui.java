import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class BoardGui extends JPanel{
	private JPanel[][] chessBoard;
	
	public BoardGui() {
		super();
		setLayout(new GridLayout(8,8));
		chessBoard = new JPanel[8][8];
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
	}
	
	public void setBoard() {
		
	}
}
