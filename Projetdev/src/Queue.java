import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Queue extends GameObject{
	
	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width;
	private int height;
	private float taille;
	
	//taille = 0.001 - 0.1

	public Queue(int x, int y,int width, int height, float taille, ID id, Handler handler, Color color) {
		
		super(x, y, id);
		this.color = color;
		this.width = width;
		this.height = height;
		this.taille = taille;
		this.handler = handler;
		
	}
	

	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type,alpha));
	}
	public void tick() {
		if(alpha>taille) {
			alpha -= (taille - 0.01f);
		}else handler.removeObject(this);
		
	}

	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect(x,y,width,height);
		g2d.setComposite(makeTransparent(1));
	}


	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
