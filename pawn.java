import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class pawn extends ImageIcon{
	private int file;
	private int rank;
	private boolean isWhite;
	
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
	
	public boolean isLegal(int file, int rank, boolean firstMove) {
		boolean legal = false;
		if(firstMove) {
			
		}
		return legal;
	}
	
	public void enPassant() {
		
	}
}
