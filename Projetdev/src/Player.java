import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	public Player(int x, int y, ID id) {
		super(x,y,id);
		velX = 1;
	}
	
	public void tick() { //chaque tick on update la position par la v�locit�
		//x += velX;
		//y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x,y,32,32);
	}
}
