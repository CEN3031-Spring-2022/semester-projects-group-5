import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class chessTester{
	public static void main(String[] args) throws IOException {
		JFrame game = new JFrame();
		game.setLayout(new BorderLayout());
		board board = new board();
		game.add(board, BorderLayout.CENTER);
		scoreboard score = new scoreboard();
		game.add(score, BorderLayout.SOUTH);
		game.setVisible(true);
		game.pack();
		game.setSize(817,840);
		game.setResizable(false);
		game.setDefaultCloseOperation(3);
		board.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int X = e.getX();
				int Y = e.getY();
				
				try {
					if(board.findPiece((JPanel) board.getComponentAt(X, Y)) != null) {
						System.out.println("hi "+ board.findPiece((JPanel) board.getComponentAt(X, Y)));
						board.highlight(board.findPiece((JPanel) board.getComponentAt(X, Y)).highlightLegal());
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				board.getChessBoard();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
