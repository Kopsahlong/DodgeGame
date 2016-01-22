import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BarrierBlock implements Block{
	private int myAxisLoc;
	private int myEntryWidth;
	private int myMidpoint;
	private static final int BLOCKWIDTH = 50;
    private Rectangle myTop;
    private boolean marked = false; //TODO: Change to hasPassed
    private boolean touched = false;
    private Rectangle myBottom;
    private Group root;
    private boolean barrierPresent = true;
    
    private Rectangle myBarrier;
    //initialize the block object
	public BarrierBlock(int mid, int entry, Group g) {
		myMidpoint = mid;
		myEntryWidth = entry;
		root = g;
		myAxisLoc = Main.WIDTH-BLOCKWIDTH;
		drawBlock();
	}
	//draw the block on the root, starting from far right screen
	public void drawBlock(){
		myTop = new Rectangle(Main.WIDTH, 0, BLOCKWIDTH, myMidpoint-myEntryWidth/2);
        myTop.setFill(Color.DARKGRAY);
        myBottom = new Rectangle(Main.WIDTH, myMidpoint+myEntryWidth/2, BLOCKWIDTH, Main.HEIGHT-(myMidpoint-myEntryWidth/2));
        myBottom.setFill(Color.DARKGRAY);
        myBarrier = new Rectangle(Main.WIDTH, myMidpoint-myEntryWidth/2+10, BLOCKWIDTH, myEntryWidth - 20);
        myBarrier.setFill(Color.ALICEBLUE);
        root.getChildren().add(myTop);
        root.getChildren().add(myBottom);
        root.getChildren().add(myBarrier);
	}
	//update the blocks location
	public void setAxisLoc(int newAxisLoc){
		myAxisLoc = newAxisLoc;
		myTop.setX(myAxisLoc);
		myBottom.setX(myAxisLoc);
		myBarrier.setX(myAxisLoc);
	}
	//returns Axis Location
	public int getAxisLoc(){
		return myAxisLoc;
	}
	//returns whether or not the block intersects a given object
	public boolean intersects(Bounds boundaries){
		return myTop.intersects(boundaries) || myBottom.intersects(boundaries) || (myBarrier.intersects(boundaries)&&barrierPresent);
	}
	public void smileyIntersect(){
		if(barrierPresent){myBarrier.setFill(Color.RED);}
		setColorRed();
	}
	//make the bullet inactive, and if the bullet hit the barrier, then make the barrier inactive
	public void bulletIntersect(){
		Bullet.makeInActive();
		if(myBarrier.intersects(Bullet.getBounds())){
			barrierPresent=false;
			myBarrier.setFill(Color.TRANSPARENT);
		}//has hit the barrier
	}
	//setblock color
	public void setColorRed(){
		myTop.setFill(Color.RED);
		myBottom.setFill(Color.RED);
	}
	public void setColorGray(){
		myTop.setFill(Color.GRAY);
		myBottom.setFill(Color.GRAY);
	}
	public void setColorTransparent(){
		myTop.setFill(Color.TRANSPARENT);
		myBottom.setFill(Color.TRANSPARENT);
	}
	public void mark(){
		marked = true;
	}
	public boolean isMarked(){
		return marked;
	}
	public void touch(){
		touched = true;
	}
	public boolean wasTouched(){
		return touched;
	}

}