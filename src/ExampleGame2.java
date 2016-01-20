import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/**
 * Separate the game code from some of the boilerplate code.
 * 
 * @author Robert C. Duvall
 */
class ExampleGame2 {
    public static final String TITLE = "Dodge Game";
    public static final int KEY_INPUT_SPEED = 15;
    private static final double GROWTH_RATE = 1.1;
    private static final int BOUNCER_SPEED = 30;
    private static final int BLOCK_SPEED = 1;

    private Scene myScene;
    private ImageView mySmiley;
    private Rectangle myTopBlock;
    private Rectangle myBottomBlock;
    private Smiley myCharacter;
    private BasicBlock block;
    private ArrayList<BasicBlock> blockArray;

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
        // Create a scene graph to organize the scene
        Group root = new Group();
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        //create objects
        myCharacter = new Smiley(root);
        block = new BasicBlock(300,150,root);
        
        
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
        // update attributes        
        block.setAxisLoc(block.getAxisLoc()-BLOCK_SPEED);
        
        //block manager add new blocks
        //block manager update all blocks
        //block manager take away old blocks
        // check for collisions
        if(block.intersects(myCharacter.getBounds())){
        	block.setColorRed();
        }
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
