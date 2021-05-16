import java.awt.Color;
import java.awt.Graphics;

public class Ennemy extends GameObject{

	public Ennemy(int x, int y, ID id) {
		super(x, y, id);
		velX = 3;
		velY = 3;
	}

	@Override
	public void tick() {
		x +=velX;
		y +=velY;
		//L'ennemi rebondi sur les cotés.
		if(y <=0 || y>=Game.HEIGHT - 48) velY = velY *(-1);
		if(x <=0 || x>=Game.WIDTH - 32) velX = velX *(-1);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x,y,20,20);
		
	}

}
