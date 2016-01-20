import java.util.ArrayList;
import javafx.scene.Group;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class BlockManager {
	private static final int BLOCK_SPEED = 2;
	private ArrayList<BasicBlock> blocks;
	private Group root;
	
	public BlockManager(Group g){
		root = g;
		blocks = new ArrayList<BasicBlock>();
	}
	
	public void addBlock(int mid, int entry){
		//generate some midpoint and entry width depending on the level
//		int mid = 200;
//		int entry = 100;
		//create new block
		BasicBlock newBlock = new BasicBlock(mid,entry,root);
		blocks.add(newBlock);
	}
	//update block positions
	public void updatePositions(){
		for(BasicBlock block : blocks){
			block.setAxisLoc(block.getAxisLoc()-BLOCK_SPEED);
		}
	}

	//remove blocks that have gone off screen
	public void removeUneededBlocks(){
		for(int i = 0; i<blocks.size();i++){
			if(blocks.get(i).getAxisLoc()<0){blocks.remove(i);}
		}
	}
	public void checkForCollision(Bounds boundaries){
		for(BasicBlock block : blocks){
			if(block.intersects(boundaries)){block.setColorRed();}
		}
		//return false;
	}
	public int getBlockNumber(){
		return blocks.size();
	}
}
