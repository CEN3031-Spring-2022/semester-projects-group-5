import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JPanel implements ActionListener{
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
		PvP.addActionListener(this);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean isSelected = false;
		boolean updatedStatus = false;
		JButton src = (JButton) e.getSource();
		System.out.println("button pressed");
		
		updatedStatus = !isSelected;
		System.out.println(updatedStatus);
		if(updatedStatus == true){
			BoardGui b1;

			
		}
		
	}
}