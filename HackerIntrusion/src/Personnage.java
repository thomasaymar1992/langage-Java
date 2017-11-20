import java.awt.Rectangle;

public class Personnage {
	
	public int x;
	public int y;
	
	Personnage(int personnageX, int personnageY) {
		
		this.x = personnageX;
		this.y = personnageY;
	}
	
	public int getY() {
		
		return y;
		
	}
	
	public int getX() {
		
		return x;
	}

}
