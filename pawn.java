import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class pawn extends ImageIcon implements MouseListener{
	private int file;
	private int rank;
	private boolean isWhite;
	private int timesMoved;
	
	public pawn(int rank, int file, boolean isWhite) throws IOException {
		super();
		if(isWhite) {
			ImageIcon wPawn = new ImageIcon("wPawn.png");
			Image i = wPawn.getImage();
			Image j = i.getScaledInstance(70, 85, java.awt.Image.SCALE_SMOOTH);
			setImage(j);
		}else {
			ImageIcon wPawn = new ImageIcon("bPawn.png");
			Image i = wPawn.getImage();
			Image j = i.getScaledInstance(70, 85, java.awt.Image.SCALE_SMOOTH);
			setImage(j);
		}
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
		return legal;
	}
	
	public void enPassant() {
		
	}

	public void mouseClicked(MouseEvent e) {
		for(int rank = 0; rank < 8; rank++) {
			for(int file = 0; file < 8; file++) {
				if(isLegal(file, rank)) {
					
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	public int getTimesMoved() {
		return timesMoved;
	}
	public void setTimesMoved(int timesMoved) {
		this.timesMoved = timesMoved;
	}
}
