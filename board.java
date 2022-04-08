import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class board extends JPanel{
	private int numPieces = 32;
	private JPanel[][] chessBoard;
	
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
		for(int file = 0; file < 8; file++) {
			chessBoard[6][file].add(new pawn(6, file, true), JLabel.CENTER);
		}
		for(int file = 0; file < 8; file++) {
			chessBoard[1][file].add(new pawn(6, file, false), JLabel.CENTER);
		}
		chessBoard[0][0].add(new rook(0, 0, false), JLabel.CENTER);
		chessBoard[0][7].add(new rook(0, 7, false), JLabel.CENTER);
		chessBoard[0][1].add(new knight(0, 1, false), JLabel.CENTER);
		chessBoard[0][6].add(new knight(0, 6, false), JLabel.CENTER);
		chessBoard[0][2].add(new bishop(0, 2, false), JLabel.CENTER);
		chessBoard[0][5].add(new bishop(0, 5, false), JLabel.CENTER);
		chessBoard[0][3].add(new queen(0, 3, false), JLabel.CENTER);
		chessBoard[0][4].add(new king(0, 4, false), JLabel.CENTER);
		
		chessBoard[7][0].add(new rook(7, 0, true), JLabel.CENTER);
		chessBoard[7][7].add(new rook(7, 7, true), JLabel.CENTER);
		chessBoard[7][1].add(new knight(7, 1, true), JLabel.CENTER);
		chessBoard[7][6].add(new knight(7, 6, true), JLabel.CENTER);
		chessBoard[7][2].add(new bishop(7, 2, true), JLabel.CENTER);
		chessBoard[7][5].add(new bishop(7, 5, true), JLabel.CENTER);
		chessBoard[7][3].add(new queen(7, 3, true), JLabel.CENTER);
		chessBoard[7][4].add(new king(7, 4, true), JLabel.CENTER);
	}
	
	public JPanel[][] getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(JPanel[][] chessBoard) {
		this.chessBoard = chessBoard;
		System.out.println("board updated");
	}
	
	public void updateChessBoard(board board) {
		
		this.chessBoard = board.getChessBoard();
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
}