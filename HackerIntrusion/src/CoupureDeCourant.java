import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class CoupureDeCourant extends JLayeredPane {
	
	public void paint(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 400, 400);
		
	}

}
