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
//		pawn awPawn = new pawn(6, 0, true);
//		pawn bwPawn = new pawn(6, 1, true);
//		pawn cwPawn = new pawn(6, 2, true);
//		pawn dwPawn = new pawn(6, 3, true);
//		pawn ewPawn = new pawn(6, 4, true);
//		pawn fwPawn = new pawn(6, 5, true);
//		pawn gwPawn = new pawn(6, 6, true);
//		pawn hwPawn = new pawn(6, 7, true);
//		pawn abPawn = new pawn(1, 0, false);
//		pawn bbPawn = new pawn(1, 1, false);
//		pawn cbPawn = new pawn(1, 2, false);
//		pawn dbPawn = new pawn(1, 3, false);
//		pawn ebPawn = new pawn(1, 4, false);
//		pawn fbPawn = new pawn(1, 5, false);
//		pawn gbPawn = new pawn(1, 6, false);
//		pawn hbPawn = new pawn(1, 7, false);
		for(int file = 0; file < 8; file++) {
			c[6][file].add(new JLabel(new pawn(6, file, true), JLabel.CENTER));
		}
		for(int file = 0; file < 8; file++) {
			c[1][file].add(new JLabel(new pawn(6, file, false), JLabel.CENTER));
		}
	}
	
	public void deletePiece(Image i) {
		
	}
}