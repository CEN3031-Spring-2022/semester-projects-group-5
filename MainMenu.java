import javax.swing.*;

public class MainMenu extends JPanel{
	public MainMenu() {
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel botPanel = new JPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel welcome = new JLabel("Please Select an Option to Play");
		
		JButton PvP = new JButton("Play Vs Player");
		JButton puzzle = new JButton("Puzzles");
		JButton bot = new JButton("Play Vs Bot");
		
		JLabel authors = new JLabel("created by: Alek, Evan, Bradley, Michael");
		
		topPanel.add(welcome);
		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
		midPanel.add(PvP);
		midPanel.add(bot);
		midPanel.add(puzzle);
		
		add(topPanel);
		add(midPanel);
		add(botPanel);
		add(authors);
	}
}
