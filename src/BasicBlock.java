import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class BasicBlock {
	private int myAxisLoc;
	private int myEntryWidth;
	private int myMidpoint;
	private static final int BLOCKWIDTH = 50;
    private Rectangle myTop;
    private boolean marked = false; //TODO: Change to hasPassed
    private boolean touched = false;
    private Rectangle myBottom;
    private Group root;

    //initialize the block object
	public BasicBlock(int mid, int entry, Group g) {
		myMidpoint = mid;
		myEntryWidth = entry;
		root = g;
		myAxisLoc = Main.WIDTH-BLOCKWIDTH;
		drawBasicBlock();
	}
	//draw the block on the root, starting from far right screen
	public void drawBasicBlock(){
		myTop = new Rectangle(Main.WIDTH, 0, BLOCKWIDTH, myMidpoint-myEntryWidth/2);
        myTop.setFill(Color.BLACK);
        myBottom = new Rectangle(Main.WIDTH, myMidpoint+myEntryWidth/2, BLOCKWIDTH,Main.HEIGHT-(myMidpoint-myEntryWidth/2));
        myBottom.setFill(Color.BLACK);
        root.getChildren().add(myTop);
        root.getChildren().add(myBottom);
	}
	//update the blocks location
	public void setAxisLoc(int newAxisLoc){
		myAxisLoc = newAxisLoc;
		myTop.setX(myAxisLoc);
		myBottom.setX(myAxisLoc);
	}
	//returns Axis Location
	public int getAxisLoc(){
		return myAxisLoc;
	}
	//returns whether or not the block intersects a given object
	public boolean intersects(Bounds boundaries){
		return myTop.intersects(boundaries) || myBottom.intersects(boundaries);
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
