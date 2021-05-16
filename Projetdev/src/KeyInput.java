import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//l'input n'affecte que l'objet Player.
				if(key==KeyEvent.VK_Z) tempObject.setVelY(-3);
				if(key==KeyEvent.VK_S) tempObject.setVelY(3);
				if(key==KeyEvent.VK_D) tempObject.setVelX(3);
				if(key==KeyEvent.VK_Q) tempObject.setVelX(-3);
				
				
				
			}
					
					
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//l'input n'affecte que l'objet Player.
				if(key==KeyEvent.VK_Z) tempObject.setVelY(0);
				if(key==KeyEvent.VK_S) tempObject.setVelY(0);
				if(key==KeyEvent.VK_D) tempObject.setVelX(0);
				if(key==KeyEvent.VK_Q) tempObject.setVelX(0);
				
				
				
			}
	}
}

}
