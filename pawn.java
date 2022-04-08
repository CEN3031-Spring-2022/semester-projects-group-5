import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class pawn extends JLabel implements piece{
	private int file;
	private int rank;
	private boolean isWhite;
	private int timesMoved;
	
	public pawn(int rank, int file, boolean isWhite) throws IOException {
		super();
		this.file = file;
		this.rank = rank;
		this.isWhite = isWhite;
		timesMoved = 0;
		
		if(isWhite) {
			Icon wPawn = new ImageIcon("wPawn.png");
			setIcon(wPawn);
		}else {
			Icon bPawn = new ImageIcon("bPawn.png");
			setIcon(bPawn);
		}
//		addMouseListener(new MouseListener() {
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("pawn");
//				try {
//					highlightLegal();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			public void mousePressed(MouseEvent e) {
//				
//			}
//
//			public void mouseReleased(MouseEvent e) {
//				
//			}
//
//			public void mouseEntered(MouseEvent e) {
//				
//			}
//
//			public void mouseExited(MouseEvent e) {
//				
//			}
//		});
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
		int moves = getTimesMoved();
		
		if(moves == 0) {
			if(isWhite) {
				if((getFile() == file && getRank() == (rank-1)) || (getFile() == file && getRank() == (rank-2))) {
					return true;
				}
			}else {
				if((getFile() == file && getRank() == (rank+1)) || (getFile() == file && getRank() == (rank+2))) {
					return true;
				}
			}
		}else {
			if(isWhite) {
				if((getFile() == file && getRank() == (rank-1))) {
					return true;
				}
			}else {
				if((getFile() == file && getRank() == (rank+1))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<JPanel> highlightLegal() throws IOException {
		board cBoard = new board();
		cBoard.getChessBoard();
		ArrayList<JPanel> legalMoves = new ArrayList<JPanel>();
		for(int rank = 0; rank < 8; rank++) {
			for(int file = 0; file < 8; file++) {
				if(isLegal(file, rank)) {
					legalMoves.add(cBoard.getChessBoard()[rank][file]);
				}
			}
		}
		//System.out.println("Legal Moves: " + legalMoves);
		return legalMoves;
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
