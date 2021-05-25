import java.util.Random;

public class Spawn {

	private Handler handler;
	private Hud hud;
	private int scoreTemp= 0;
	private Random r = new Random();
	
	
	public Spawn(Handler handler, Hud hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreTemp++;
		
		if(scoreTemp>=1000) {
			scoreTemp = 0;
			hud.setLevel(hud.getLevel()+1);
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy,handler));
		}
				
		
		
	}
}
