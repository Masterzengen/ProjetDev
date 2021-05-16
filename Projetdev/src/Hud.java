import java.awt.Color;
import java.awt.Graphics;

public class Hud {
	
	public static int PV = 100;
	
	public void tick() {
		PV--;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(15,15,PV*3,32);
		//g.setColor(Color.green);
		//g.fillRect(15,15,300,32);
	}

}
