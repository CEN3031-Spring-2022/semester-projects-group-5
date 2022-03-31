import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class pawn extends JLabel{
	private int file;
	private int rank;
	private boolean isWhite;
	private int timesMoved;
	
	public pawn(int rank, int file, boolean isWhite) throws IOException {
		super();
		if(isWhite) {
			Icon wPawn = new ImageIcon("wPawn.png");
			setIcon(wPawn);
		}else {
			Icon bPawn = new ImageIcon("bPawn.png");
			setIcon(bPawn);
		}
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("pawn");
			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
			}

			public void mouseExited(MouseEvent e) {
				
			}
		});
	}
	
	public int getFile() {
		return file;
	}

	public void setFile(int file) {
		this.file = file;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public void move(int file, int rank) {
		setFile(file);
		setRank(rank);
	}
	
	public boolean isLegal(int file, int rank) {
		boolean legal = false;
		int moves = getTimesMoved();
		if(moves == 0) {
			if(isWhite) {
				if((file == getFile() && rank == (getRank()+1)) || (file == getFile() && rank == (getRank()+2))) {
					legal = true;
				}
			}else {
				if((file == getFile() && rank == (getRank()-1)) || (file == getFile() && rank == (getRank()-2))) {
					legal = true;
				}
			}
		}else {
			if(isWhite) {
				if((file == getFile() && rank == (getRank()+1))) {
					legal = true;
				}
			}else {
				if((file == getFile() && rank == (getRank()-1))) {
					legal = true;
				}
			}
		}
		return legal;
	}
	
	public void highlightLegal() {
		for(int rank = 0; rank < 8; rank++) {
			for(int file = 0; file < 8; file++) {
				if(isLegal(file, rank)) {
					
				}
			}
		}
	}
	
	public void enPassant() {
		
	}

	public int getTimesMoved() {
		return timesMoved;
	}
	
	public void setTimesMoved(int timesMoved) {
		this.timesMoved = timesMoved;
	}
}
