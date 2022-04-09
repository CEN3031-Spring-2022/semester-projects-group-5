import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class board extends JPanel{
	private int numPieces = 32;
	private JPanel[][] chessBoard;
	private rook bR1 = new rook(0, 0, false);
	private rook bR2 = new rook(0, 7, false);
	private knight bKn1 = new knight(0, 1, false);
	private knight bKn2 = new knight(0, 6, false);
	private bishop bB1 = new bishop(0, 2, false);
	private bishop bB2 = new bishop(0, 5, false);
	private queen bQ = new queen(0, 3, false);
	private king bK = new king(0, 4, false);
	
	private rook wR1 = new rook(7, 0, true);
	private rook wR2 = new rook(7, 7, true);
	private knight wKn1 = new knight(7, 1, true);
	private knight wKn2 = new knight(7, 6, true);
	private bishop wB1 = new bishop(7, 2, true);
	private bishop wB2 = new bishop(7, 5, true);
	private queen wQ = new queen(7, 3, true);
	private king wK = new king(7, 4, true);
	
	private pawn bP1 = new pawn(1,0,false);
	private pawn bP2 = new pawn(1,1,false);
	private pawn bP3 = new pawn(1,2,false);
	private pawn bP4 = new pawn(1,3,false);
	private pawn bP5 = new pawn(1,4,false);
	private pawn bP6 = new pawn(1,5,false);
	private pawn bP7 = new pawn(1,6,false);
	private pawn bP8 = new pawn(1,7,false);
	
	private pawn wP1 = new pawn(6,0,true);
	private pawn wP2 = new pawn(6,1,true);
	private pawn wP3 = new pawn(6,2,true);
	private pawn wP4 = new pawn(6,3,true);
	private pawn wP5 = new pawn(6,4,true);
	private pawn wP6 = new pawn(6,5,true);
	private pawn wP7 = new pawn(6,6,true);
	private pawn wP8 = new pawn(6,7,true);
	
	public board() throws IOException{
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
	
	public int getNumPieces() {
		return numPieces;
	}

	public void setNumPieces(int numPieces) {
		this.numPieces = numPieces;
	}

	public void setBoard() throws IOException {
		chessBoard[6][0].add(wP1, JLabel.CENTER);
		chessBoard[6][1].add(wP2, JLabel.CENTER);
		chessBoard[6][2].add(wP3, JLabel.CENTER);
		chessBoard[6][3].add(wP4, JLabel.CENTER);
		chessBoard[6][4].add(wP5, JLabel.CENTER);
		chessBoard[6][5].add(wP6, JLabel.CENTER);
		chessBoard[6][6].add(wP7, JLabel.CENTER);
		chessBoard[6][7].add(wP8, JLabel.CENTER);
		
		chessBoard[1][0].add(bP1, JLabel.CENTER);
		chessBoard[1][1].add(bP2, JLabel.CENTER);
		chessBoard[1][2].add(bP3, JLabel.CENTER);
		chessBoard[1][3].add(bP4, JLabel.CENTER);
		chessBoard[1][4].add(bP5, JLabel.CENTER);
		chessBoard[1][5].add(bP6, JLabel.CENTER);
		chessBoard[1][6].add(bP7, JLabel.CENTER);
		chessBoard[1][7].add(bP8, JLabel.CENTER);
		
		chessBoard[0][0].add(bR1, JLabel.CENTER);
		chessBoard[0][7].add(bR2, JLabel.CENTER);
		chessBoard[0][1].add(bKn1, JLabel.CENTER);
		chessBoard[0][6].add(bKn2, JLabel.CENTER);
		chessBoard[0][2].add(bB1, JLabel.CENTER);
		chessBoard[0][5].add(bB2, JLabel.CENTER);
		chessBoard[0][3].add(bQ, JLabel.CENTER);
		chessBoard[0][4].add(bK, JLabel.CENTER);
		
		chessBoard[7][0].add(wR1, JLabel.CENTER);
		chessBoard[7][7].add(wR2, JLabel.CENTER);
		chessBoard[7][1].add(wKn1, JLabel.CENTER);
		chessBoard[7][6].add(wKn2, JLabel.CENTER);
		chessBoard[7][2].add(wB1, JLabel.CENTER);
		chessBoard[7][5].add(wB2, JLabel.CENTER);
		chessBoard[7][3].add(wQ, JLabel.CENTER);
		chessBoard[7][4].add(wK, JLabel.CENTER);
		
	}
	
	public JPanel[][] getChessBoard() {
		return chessBoard;
	}
	
	public piece findPiece(JPanel panel) {
		if(panel.getComponentCount() == 0) {
			return null;
		}	
		return (piece) (panel.getComponent(0));
	}

	public void setChessBoard(JPanel[][] chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	public void updateChessBoard(board board) {	
		this.chessBoard = board.getChessBoard();
	}
	
	public void highlight(ArrayList<JPanel> panels) {
		System.out.println(panels);
		for(int i = 0; i < panels.size(); i++) {
			panels.get(i).setBackground(new Color(0xFAFF8E));
		}
	}

	public void deletePiece() {
		
	}
	
	public boolean isEmpty(int file, int rank) {
		boolean empty = false;
		JPanel[][] board = getChessBoard();
		
		if(board[rank][file].getComponentCount() == 0) {
			empty = true;
		}
		return empty;
	}
	/*
	public boolean inCheck(int file, int rank) {
		boolean check = false;
		for (piece Piece : piecesArray) {
			if (Piece.isLegal(file, rank)){
			check = true; }
		}
	}
	public boolean checkmate(int file, int rank) {
	}
	
	*/
}