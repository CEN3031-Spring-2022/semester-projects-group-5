import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFrame;

public class chessTester{
	public static void main(String[] args) throws IOException {
		JFrame game = new JFrame();
		game.setLayout(new BorderLayout());
		board board = new board();
		game.add(board, BorderLayout.CENTER);
		game.setVisible(true);
		//game.pack();
		game.setSize(817,840);
		game.setResizable(false);
		game.setDefaultCloseOperation(3);
		board.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int X = e.getX();
				int Y = e.getY();
				
				System.out.println(board.getComponentAt(X, Y));
				
//				game.remove(board);
//				board.getChessBoard();
//				game.add(board, BorderLayout.CENTER);
//				
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
