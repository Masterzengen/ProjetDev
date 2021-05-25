import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject{
	
	private Handler handler;

	public Enemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		velX = 3;
		velY = 3;
		this.handler=handler;
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,20,20);
	}
	@Override
	public void tick() {
		x +=velX;
		y +=velY;
		//L'ennemi rebondi sur les cotés.
		if(y <=0 || y>=Game.HEIGHT - 48) velY = velY *(-1);
		if(x <=0 || x>=Game.WIDTH - 32) velX = velX *(-1);
		
		handler.addObject(new Queue(x,y,20,20,0.1f,ID.Queue,handler,Color.red));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x,y,20,20);
		
	}

}
