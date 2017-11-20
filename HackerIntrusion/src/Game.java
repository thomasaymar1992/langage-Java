import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Game {

	public static void main(String[] args) {
	
		JFrame f = new JFrame();
		Terrain p = new Terrain();
	    JLayeredPane layeredPane = new JLayeredPane();
		CoupureDeCourant c = new CoupureDeCourant();
		f.add(layeredPane);
		f.setSize(900, 900);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

}
