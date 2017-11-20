import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class Terrain extends JLayeredPane implements KeyListener, ActionListener {
		
	int tableau[][] = {{0,0,1,0,1,0,1,0},
					   {0,0,2,1,0,1,0,1},
					   {0,0,1,0,1,0,1,0},
					   {0,1,0,1,0,1,0,1},
					   {0,0,1,0,1,0,1,0},
					   {0,1,0,1,0,1,0,1},
					   {0,0,1,0,1,0,1,0},
					   {0,1,0,1,0,1,0,1}};

	public int compteur = 180000;
	public int clignote;
	public boolean collision;
	ArrayList<Rectangle> listMurs = new ArrayList<>();
	ArrayList<Rectangle> listLampes = new ArrayList<>();
	Rectangle touchRect = new Rectangle();
	Personnage pers = new Personnage(0,0);
	Timer t = new Timer(5, this);
	Rectangle r = new Rectangle(0,0);
	
	Terrain() {
		
		setFocusable(true);
		addKeyListener(this);
		t.start();
	
	}
    
public void paint(Graphics g) {
	
	      for (int i = 0; i < 8; i++) {

	         for (int j = 0; j < tableau[i].length; j++) {

	             if (tableau[i][j] == 1) {

	               g.setColor(Color.WHITE);
	               g.fillRect(100*i, 100*j, 100, 100);
	               Rectangle r = new Rectangle(100*i, 100*j, 100, 100);
	               listMurs.add(r);
	               
	             }
	             else if(tableau[i][j] == 0) {

	               g.setColor(Color.BLACK);
	               g.fillRect(100*i, 100*j, 100, 100);
	               
	             }
	             else if(tableau[i][j] == 2) {

		               g.setColor(Color.YELLOW);
		               g.fillRect(100*i, 100*j, 100, 100);
		               Rectangle r = new Rectangle(100*i, 100*j, 100, 100);
		               listLampes.add(r);
		               
		         }
	         }
	      }
	      g.setColor(Color.RED);
	      g.fillRect(pers.x, pers.y, 100, 100);
	      
	      CoupureDeCourant c = new CoupureDeCourant();
	      this.add(c);

}

@Override
public void keyPressed(KeyEvent arg0) {

int key = arg0.getKeyCode();
	
	if(key == KeyEvent.VK_UP) {
		
		pers.y--;
		
		if(collision(pers.x, pers.y)) {
			
			pers.y++;
		}
		
		if(collisionLampe(pers.x, pers.y)) {
			
			tableau[touchRect.x/100][touchRect.y/100] = 0;
			repaint();
			
		}
		
	}
	else if(key == KeyEvent.VK_LEFT) {
		
		pers.x--;
		
		if(collision(pers.x, pers.y)) {
			
			pers.x++;
		}
		
		if(collisionLampe(pers.x, pers.y)) {
			
			tableau[touchRect.x/100][touchRect.y/100] = 0;
			repaint();
			
		}
		
	}
	else if(key == KeyEvent.VK_RIGHT) {
				
		pers.x++;
		
		if(collision(pers.x, pers.y)) {
			
			pers.x--;
		}
		
		if(collisionLampe(pers.x, pers.y)) {
			
			tableau[touchRect.x/100][touchRect.y/100] = 0;
			repaint();
		
		}
		
	}
	else if(key == KeyEvent.VK_DOWN) {
	
		pers.y++;
		
			if(collision(pers.x, pers.y)) {
			
				pers.y--;
			}
			if(collisionLampe(pers.x, pers.y)) {
				
				tableau[touchRect.x/100][touchRect.y/100] = 0;
				repaint();
				
			}
	}
}

@Override
public void keyReleased(KeyEvent e) {
	
	
}

@Override
public void keyTyped(KeyEvent e) {
	
	
}

@Override
public void actionPerformed(ActionEvent arg0) {
	
	repaint();
	
}

public boolean collision(int x, int y) {
	
	Rectangle pers = new Rectangle(x, y, 100, 100);
	
	for (int i = 0; i < listMurs.size(); i++) {

		if(pers.intersects(listMurs.get(i)) == true) {
			
			return true;
			
		}
        
    }
	
	return false;
	
}

public boolean collisionLampe(int x, int y) {
	
	Rectangle pers = new Rectangle(x, y, 100, 100);
	
	for (int i = 0; i < listLampes.size(); i++) {

		if(pers.intersects(listLampes.get(i)) == true) {
			
			touchRect.x = listLampes.get(i).x;
			touchRect.y = listLampes.get(i).y;
			
			return true;
			
		}
        
    }
	
	return false;
	
}

}
