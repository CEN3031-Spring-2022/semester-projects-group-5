import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;

public interface piece {
	public void move(int file, int rank);
	public boolean isLegal(int file, int rank);
	public ArrayList<JPanel> highlightLegal() throws IOException ;
}
