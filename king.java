import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class king extends JLabel{
	private int file;
	private int rank;
	private boolean isWhite;
	private int timesMoved;
	
	public king(int rank, int file, boolean isWhite) throws IOException {
		super();
		if(isWhite) {
			ImageIcon wKing = new ImageIcon("wKing.png");
			setIcon(wKing);
		}else {
			ImageIcon bKing = new ImageIcon("bKing.png");
			setIcon(bKing);
		}
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("king");
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

	public int getTimesMoved() {
		return timesMoved;
	}

	public void setTimesMoved(int timesMoved) {
		this.timesMoved = timesMoved;
	}
}
