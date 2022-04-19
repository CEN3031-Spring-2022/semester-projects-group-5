import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scoreboard extends JPanel{
	private int p1Score;
	private int p2Score;
	private String p1Name;
	private String p2Name;
	
	//each piece worth given amount, taking will update this
	public Scoreboard(String p1Name, String p2Name) {
		this.p1Name = p1Name;
		this.p2Name = p2Name;
		this.p1Score = 0;
		this.p2Score = 0;
		
		int diff = 0;
		String text = "";
		if(p1Score > p2Score) {
			diff = p1Score - p2Score;
			text = p1Name + ": +" + diff + "      " + p2Name + ": -" + diff;
		}else if(p1Score < p2Score) {
			diff = p2Score - p1Score;
			text = p1Name + ": -" + diff + "      " + p2Name + ": +" + diff;
		}else {
			text = p1Name + " and " + p2Name + " are even in material";
		}
		JLabel score = new JLabel(text);
		add(score);
	}
	
	public int getP1Score() {
		return p1Score;
	}
	public void setP1Score(int p1Score) {
		this.p1Score = p1Score;
	}
	public int getP2Score() {
		return p2Score;
	}
	public void setP2Score(int p2Score) {
		this.p2Score = p2Score;
	}

	public String getP1Name() {
		return p1Name;
	}

	public void setP1Name(String p1Name) {
		this.p1Name = p1Name;
	}

	public String getP2Name() {
		return p2Name;
	}

	public void setP2Name(String p2Name) {
		this.p2Name = p2Name;
	}
	
	public void updateScoreboard() {
		int diff = 0;
		String text = "";
		if(p1Score > p2Score) {
			diff = p1Score - p2Score;
			text = p1Name + ": +" + diff + "\n" + p2Name + ": -" + diff;
		}else if(p1Score < p2Score) {
			diff = p2Score - p1Score;
			text = p1Name + ": -" + diff + "\n" + p2Name + ": +" + diff;
		}else {
			text = p1Name + " and " + p2Name + " are even in material";
		}
		JLabel score = new JLabel(text);
		add(score);
	}
}
