import java.awt.TextField;
import java.util.ArrayList;
import java.util.Timer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;


/**
 * Separate the game code from some of the boilerplate code.
 * 
 * @author Robert C. Duvall
 */
class DodgeGameRunner {
    public static final String TITLE = "Dodge Game";
    public static final int KEY_INPUT_SPEED = 15;
    private double elapsedBlockTime;
    private int score;
    private int entrywidth;
    private int midpoint = Main.HEIGHT/2;

    private Scene myScene;
    private Smiley myCharacter;
    private BasicBlock block;
    private BlockManager block_manage;
    private ScoreDisplay score_display;

    /**
     * Returns name of the game.
     */
    public String getTitle () {
        return TITLE;
    }

    /**
     * Create the game's scene
     */
    public Scene init (int width, int height) {
    	score = 0;
        // Create a scene graph to organize the scene
        Group root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
        //create objects
        myCharacter = new Smiley(root);
        block_manage = new BlockManager(root);
        score_display = new ScoreDisplay(root);
        
        // order added to the group is the order in which they are drawn
        // Respond to input
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        myScene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));
        return myScene;
    }

    /**
     * Change properties of shapes to animate them
     * 
     * Note, there are more sophisticated ways to animate shapes,
     * but these simple ways work too.
     */
    public void step (double elapsedTime) {
        block_manage.updatePositions();
        block_manage.checkForCollision(myCharacter.getBounds());
    }
    public void blockStep (double elapsedTime) {
    	//generate random parameters for Block
    	int entrywidth = Main.HEIGHT/3 + (int)(Math.random() * 200); 
    	int tempmidpoint = Main.HEIGHT/2 + (int)(Math.random() * 100)*(int)Math.pow(-1,(int)(Math.random()*2)); 
    	while(Math.abs(tempmidpoint-midpoint)>140){
    		tempmidpoint = Main.HEIGHT/2 + (int)(Math.random() * 100)*(int)Math.pow(-1,(int)(Math.random()*2)); 
    	}
    	midpoint = tempmidpoint;
        block_manage.addBlock(midpoint,entrywidth);
        //score_display.setScore(score_display.getScore()+1);
        block_manage.removeUneededBlocks();
    }

    // What to do each time a key is pressed
    private void handleKeyInput (KeyCode code) {
        switch (code) {
            case UP:
            	myCharacter.setY(myCharacter.getY() - KEY_INPUT_SPEED);
                break;
            case DOWN:
            	myCharacter.setY(myCharacter.getY() + KEY_INPUT_SPEED);
                break;
            default:
                // do nothing
        }
    }

    // What to do each time a key is pressed
    private void handleMouseInput (double x, double y) {
//        if (myBottomBlock.contains(x, y)) {
//            myBottomBlock.setScaleX(myBottomBlock.getScaleX() * GROWTH_RATE);
//            myBottomBlock.setScaleY(myBottomBlock.getScaleY() * GROWTH_RATE);
//        }
    }
}
