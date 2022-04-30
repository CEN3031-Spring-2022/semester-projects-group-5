import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu extends JPanel implements ActionListener{
	public static Square board[][] = new Square[8][8];
	private boolean isSelected;
	public MainMenu() {
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel botPanel = new JPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel welcome = new JLabel("Please Select an Option to Play");
		
		JButton PvP = new JButton("Play Vs Player");
		JButton puzzle = new JButton("Puzzles");
		JButton bot = new JButton("Play Vs Bot");
		PvP.setPreferredSize(new Dimension(1000, 700));
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

	public void SetIsSelected(boolean isSelected){
		this.isSelected = isSelected;
	}

	public boolean GetIsSelected(){
		return isSelected;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		setVisible(false);
		SetIsSelected(true);
	}
}