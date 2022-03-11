import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class board extends JPanel{
	private int numPieces = 0;
	private JPanel[][] c;
	
	public board() throws IOException{
		super();
		setLayout(new GridLayout(8,8));
		c = new JPanel[8][8];
		boolean white = true;
		for(int rank = 0; rank < 8; rank++) {
			for(int file = 0; file < 8; file++) {
				if(white) {
					JPanel s = new JPanel();
					s.setBackground(new Color(0xc6d6df));
					c[rank][file] = s;
					add(c[rank][file]);
				}else {
					JPanel s = new JPanel();
					s.setBackground(new Color(0x779ab0));
					c[rank][file] = s;
					add(c[rank][file]);
				}
				white = !white;
			}
			System.out.println();
			white = !white;
		}
		setBoard();
	}
	
	public int getNumPieces() {
		return numPieces;
	}

	public void setNumPieces(int numPieces) {
		this.numPieces = numPieces;
	}

	public void setBoard() throws IOException {
		for(int file = 0; file < 8; file++) {
			c[6][file].add(new JLabel(new pawn(6, file, true), JLabel.CENTER));
		}
		for(int file = 0; file < 8; file++) {
			c[1][file].add(new JLabel(new pawn(6, file, false), JLabel.CENTER));
		}
		c[0][0].add(new JLabel(new rook(0, 0, false), JLabel.CENTER));
		c[0][7].add(new JLabel(new rook(0, 0, false), JLabel.CENTER));
		c[0][1].add(new JLabel(new knight(0, 0, false), JLabel.CENTER));
		c[0][6].add(new JLabel(new knight(0, 0, false), JLabel.CENTER));
		c[0][2].add(new JLabel(new bishop(0, 0, false), JLabel.CENTER));
		c[0][5].add(new JLabel(new bishop(0, 0, false), JLabel.CENTER));
		c[0][3].add(new JLabel(new queen(0, 0, false), JLabel.CENTER));
		c[0][4].add(new JLabel(new king(0, 0, false), JLabel.CENTER));
		
		c[7][0].add(new JLabel(new rook(0, 0, true), JLabel.CENTER));
		c[7][7].add(new JLabel(new rook(0, 0, true), JLabel.CENTER));
		c[7][1].add(new JLabel(new knight(0, 0, true), JLabel.CENTER));
		c[7][6].add(new JLabel(new knight(0, 0, true), JLabel.CENTER));
		c[7][2].add(new JLabel(new bishop(0, 0, true), JLabel.CENTER));
		c[7][5].add(new JLabel(new bishop(0, 0, true), JLabel.CENTER));
		c[7][3].add(new JLabel(new queen(0, 0, true), JLabel.CENTER));
		c[7][4].add(new JLabel(new king(0, 0, true), JLabel.CENTER));
	}
	
	public void deletePiece(Image i) {
		
	}
}