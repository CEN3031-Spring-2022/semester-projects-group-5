import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class chessTester {
	public static void main(String[] args) throws IOException {
		JFrame game = new JFrame();
		game.setLayout(new BorderLayout());
		board board = new board();
		game.add(board, BorderLayout.CENTER);
		game.setVisible(true);
		game.pack();
		game.setSize(800,800);
		game.setDefaultCloseOperation(3);
	}
}
