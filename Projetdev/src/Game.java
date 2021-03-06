import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1442798787354930462L;
	public static int WIDTH = 640;
	public static int HEIGHT = 500;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Hud hud;
	private Spawn spawn;
	private Random r;
	
	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Test", this);
		
		hud = new Hud();
		r = new Random();
		spawn = new Spawn(handler, hud);
		handler.addObject(new Player(100,100,ID.Player,handler));
		handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Enemy,handler));

	
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void tick() {
		handler.tick();
		hud.tick();
		spawn.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		handler.render(g);
		hud.render(g);
		g.dispose();
		bs.show();
	}
	
	
	
	
	
	
	
	
	
	public void run() { //Game loop, calcul les Fps
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer>1000) {
				timer +=1000;
				System.out.println("FPS: "+ frames);
				frames = 0;
			}	
		}
		stop();
		
	}
	
	
	

	public static void main(String[] args) {
		new Game();

	}

}
