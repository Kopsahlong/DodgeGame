import javafx.scene.Group;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet {
	private static Circle myBullet;
	private int myX;
	private int myY;
	private Group root;
	private final static int BULLET_SPEED = 3;
	private boolean active = false;
	
	public Bullet(Group g){
		root = g;
		myX = 0;
		myY = 0;
		draw();
	}
	public void draw(){
		myBullet = new Circle();
		myBullet.setFill(Color.TRANSPARENT);
		myBullet.setCenterX(myX+20);
		myBullet.setCenterY(myY+20);
		myBullet.setRadius(4);
		root.getChildren().add(myBullet);
	}
	public void shoot(int x, int y){
		active = true;
		myBullet.setFill(Color.WHITE);
		myX = x+20;
		myY = y+20;
		myBullet.setCenterX(myX);
		myBullet.setCenterY(myY);
	}
	public void updatePosition(){
		myX = myX+BULLET_SPEED;
		myBullet.setCenterX(myX);
	}
	public boolean isActive(){
		return active;
	}
	public void makeInActive(){
		active = false;
		myBullet.setFill(Color.TRANSPARENT);
	}
	public Bounds getBounds(){
		return myBullet.getBoundsInParent();
	}
}
