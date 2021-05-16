import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	public Player(int x, int y, ID id) {
		super(x,y,id);
		//velX = 1;
	}
	
	public static int limit(int x, int min, int max) {
		if(x>=max) {
			return x = max;
		}else if(x<=min) {
			return x=min;
		}else {
			return x;
	}
	}
	
	public void tick() { //chaque tick on update la position par la vélocité
		x += velX;
		y += velY;
		
		x = limit(x,0,Game.WIDTH - 46);
		y = limit(y,0,Game.HEIGHT - 70);
		
	}
	
	

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRoundRect(x,y,32,32,50,50);
	}
}
