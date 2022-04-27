import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Square 
{
	
	//-1 indicates that piece is off the board
	protected String symbol;
	public String color; //black white or null for blanks
	public String type;
	
	public Square(String typeIn)
	{
		type = typeIn;
	}
	
	String getSymbol()
	{
		return symbol;
	}
	JLabel getPicture() {
		ImageIcon wPa = new ImageIcon("wPawn.png");
		wPa = scale(wPa);
		ImageIcon wBi = new ImageIcon("wBishop.png");
		wBi = scale(wBi);
		ImageIcon wKn = new ImageIcon("wKnight.png");
		wKn = scale(wKn);
		ImageIcon wRo = new ImageIcon("wRook.png");
		wRo = scale(wRo);
		ImageIcon wKi = new ImageIcon("wKing.png");
		wKi = scale(wKi);
		ImageIcon wQu = new ImageIcon("wQueen.png");
		wQu = scale(wQu);
		
		ImageIcon bPa = new ImageIcon("bPawn.png");
		bPa = scale(bPa);
		ImageIcon bBi = new ImageIcon("bBishop.png");
		bBi = scale(bBi);
		ImageIcon bKn = new ImageIcon("bKinght.png");
		bKn = scale(bKn);
		ImageIcon bRo = new ImageIcon("bRook.png");
		bRo = scale(bRo);
		ImageIcon bKi = new ImageIcon("bKing.png");
		bKi = scale(bKi);
		ImageIcon bQu = new ImageIcon("bQueen.png");
		bQu = scale(bQu);
		String symb = getSymbol();
		if(symb == "wPa") {
			return new JLabel(wPa);
		}
		if(symb == "wKn") {
			return new JLabel(wKn);
		}
		if(symb == "wBi") {
			return new JLabel(wBi);
		}
		if(symb == "wRo") {
			return new JLabel(wRo);
		}
		if(symb == "wKi") {
			return new JLabel(wKi);
		}
		if(symb == "wQu") {
			return new JLabel(wQu);
		}
		
		if(symb == "bPa") {
			return new JLabel(bPa);
		}
		if(symb == "bKn") {
			return new JLabel(bKn);
		}
		if(symb == "bBi") {
			return new JLabel(bBi);
		}
		if(symb == "bRo") {
			return new JLabel(bRo);
		}
		if(symb == "bKi") {
			return new JLabel(bKi);
		}
		if(symb == "bQu") {
			return new JLabel(bQu);
		}
		return new JLabel(new ImageIcon("dot.png"));
	}
	
	public String getColor()
	{
		return color;
	}
	public String getType()
	{
		return type;
	}
	
	public ImageIcon scale(ImageIcon i) {
		Image buffer = i.getImage();
		Image b = buffer.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon(b);
		return i;
	}
	
	public abstract boolean checkMove(int[] moveFromReq, int[] moveToReq, String plyColor, boolean testKing);
}