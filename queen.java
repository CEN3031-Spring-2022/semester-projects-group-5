import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class queen extends JLabel{
	private int file;
	private int rank;
	private boolean isWhite;
	private int timesMoved;
	
	public queen(int rank, int file, boolean isWhite) throws IOException {
		super();
		if(isWhite) {
			ImageIcon wQueen = new ImageIcon("wQueen.png");
			setIcon(wQueen);
		}else {
			ImageIcon bQueen = new ImageIcon("bQueen.png");
			setIcon(bQueen);
		}
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("queen");
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

	public int getTimesMoved() {
		return timesMoved;
	}

	public void setTimesMoved(int timesMoved) {
		this.timesMoved = timesMoved;
	}
}
