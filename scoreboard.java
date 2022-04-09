import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class scoreboard extends JPanel{
	private int p1Score;
	private int p2Score;
	
	//each piece worth given amount, taking will update this
	public scoreboard() {
		this.p1Score = 0;
		this.p2Score = 0;
		
		JLabel score = new JLabel("Scoreboard");
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
	
}
