import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public int spd = 5;
	
	public void tick() {
		for(float i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get((int) i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(float i = 0; i < object.size(); i++){
			GameObject tempObject = object.get((int) i);
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemys(){
		for(float i = 0; i < object.size(); i++){
			GameObject tempObject = object.get((int) i);

			if(tempObject.getID() == ID.Player) 
			{
				object.clear();
				if(Game.gameState != Game.STATE.End)
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}
