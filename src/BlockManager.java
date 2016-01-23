import java.util.ArrayList;
import javafx.scene.Group;
import javafx.geometry.Bounds;

public class BlockManager {
	private static final int BLOCK_SPEED = 2;
	private ArrayList<Block> blocks;
	private Group root;
	private int level;
	
	public BlockManager(Group g, int l){
		root = g;
		level = l;
		blocks = new ArrayList<Block>();
	}
	
	public void addBlock(int mid, int entry){
		//randomly add a Barrier Block with a 10% chance for level 2
		Block newBlock;
		switch(level){
		case 2:
			double addNum = Math.random();
			if(addNum<.2){newBlock = new BarrierBlock(mid,entry,root);}
			else{newBlock = new BasicBlock(mid,entry,root);}
			break;
		default:
			newBlock = new BasicBlock(mid, entry, root);
			break;
		}
		blocks.add(newBlock);	
		
	}
	//update block positions
	public void updatePositions(){
		for(Block block : blocks){
			block.setAxisLoc(block.getAxisLoc()-BLOCK_SPEED);
		}
	}
	//check to see if a block is right above the smiley
	public boolean rightAbove(int SmileyAxisLoc){
		//this will update the score multiple times but we will have a way to check for that
		for(Block block : blocks){
			if(Math.abs(block.getAxisLoc()-SmileyAxisLoc)<=1&&!block.isMarked()){
				block.setColorGray();
				block.mark();
				return true;
			}
		}
		return false;
	}
	//remove blocks that have gone off screen
	public void removeUneededBlocks(){
		for(int i = 0; i<blocks.size();i++){
			if(blocks.get(i).getAxisLoc()<0){
				blocks.get(i).setColorTransparent();
				blocks.remove(i);}
		}
	}
	public boolean checkForSmileyCollision(Bounds boundaries){
		for(Block block : blocks){
			//checks for smiley collision
			if(block.intersects(boundaries)&&block.wasTouched()==false){
				// update score if block hasn't been touched yet
				if(!block.wasTouched()){
					block.smileyIntersect();
					block.touch();
					return true;
				}
			}
			
		}
		return false;
	}
	public boolean checkForBulletCollision(Bullet bullet){
		for(Block block : blocks){
			//checks for bullet collision
			if(block.intersects(bullet.getBounds())&&bullet.isActive()){//TODO:TAKE OUT THE IS ACTIVE PART SOMEHOW
				// update score if block hasn't been touched yet
				block.bulletIntersect(bullet);
			}
			
		}
		return false;
	}
	public int getBlockNumber(){
		return blocks.size();
	}
}
