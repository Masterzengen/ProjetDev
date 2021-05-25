import java.awt.Color;
import java.awt.Graphics;

public class Hud {
	
	public static int PV = 100;
	private int score = 0;
	private int level = 1;
	public void tick() {
		score++;
	}
	
	
	





	public int getLevel() {
		return level;
	}








	public void setLevel(int level) {
		this.level = level;
	}








	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(15,15,PV*3,32);
		//g.setColor(Color.green);
		//g.fillRect(15,15,300,32);
		g.setColor(Color.white);
		g.drawString("Score: " + score, 15,64);
		g.drawString("Level: " + level, 15,85);
	}
	
	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}
}
