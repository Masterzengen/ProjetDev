import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x,y,id);
		this.handler = handler;
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
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	
	private void collision() {
		for(int i =0; i< handler.object.size();i++) {
			GameObject tempobject = handler.object.get(i);
			if(tempobject.getId() == ID.Ennemy) {
				if(getBounds().intersects(tempobject.getBounds())) {
					Hud.PV = Hud.PV-2;
				}
			}
		}
	}
	
	public void tick() { //chaque tick on update la position par la vélocité
		x += velX;
		y += velY;
		
		x = limit(x,0,Game.WIDTH - 46);
		y = limit(y,0,Game.HEIGHT - 70);
		
		collision();
	}
	
	

	public void render(Graphics g) {
		
		
		g.setColor(Color.white);
		g.fillRoundRect(x,y,32,32,50,50);
	}
}
