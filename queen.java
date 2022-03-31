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
		for(int i = 0; i <= 7; i++ ){
			for(int j = 0; j <=7; j++){
				if((rank == getRank() + 1) && (file == getFile())){
					legal = true;
				}
				if((rank == getRank() - 1) && (file == getFile())){
					legal = true;
				}
				if((rank == getRank()) && (file == getFile() + 1)){
					legal = true;
				}
				if((rank == getRank()) && (file == getFile() - 1)){
					legal = true;
				}
				if((getRank() == rank + 1) && (getFile() == (file+1))){
					legal = true;
				}
				if((getRank() == rank + 1) && (getFile() == file - 1)){
					legal = true;
				}
				if((getRank() == rank - 1) && (getFile() == file + 1)){
					legal = true;
				}
				if((getRank() == rank - 1) && (getFile() == file -1)){
					legal = true;
				}
				if((getRank() == rank) && (getFile() == (file+1))){
					legal = true;
				}
				if((getRank() == rank + 1) && (getFile() == file)){
					legal = true;
				}
				if((getRank() == rank) && (getFile() == file - 1)){
					legal = true;
				}
				if((getRank() == rank - 1) && (getFile() == file)){
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

	public int getTimesMoved() {
		return timesMoved;
	}

	public void setTimesMoved(int timesMoved) {
		this.timesMoved = timesMoved;
	}
}