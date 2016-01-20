import java.awt.TextField;
import java.util.ArrayList;
import java.util.Timer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


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
    private int lives = 3;
    private int entrywidth;
    private int midpoint = Main.HEIGHT/2;
    private Stage s;
    private int finalScore;
    private GameOverMenu gameOverScreen;
    private Smiley myCharacter;
    private BasicBlock block;
    private int level;
    private BlockManager block_manage;
    private StatsDisplay stats;
    private Group root;
    private Bullet bullet;
    public static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
//    private Timeline animation;
//    private Timeline animationBlock;
    
    public DodgeGameRunner(Stage stage, int l){
    	level = l;
    	s = stage;
    }
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
        root = new Group();
        
        // Create a place to see the shapes
        Scene myScene = new Scene(root, width, height, Color.WHITE);
        
        //create objects
        stats = new StatsDisplay(root,level);
        myCharacter = new Smiley(root);
        bullet = new Bullet(root);
        block_manage = new BlockManager(root,level);
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
        bullet.updatePosition();
        if(block_manage.checkForSmileyCollision(myCharacter.getBounds())){stats.loseLife();}
        block_manage.checkForBulletCollision(bullet.getBounds());
        if(stats.getLives()==0){finalScore = stats.getScore(); gameOver();}
        if(block_manage.rightAbove(myCharacter.getX())){stats.setScore(stats.getScore()+1);}
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
        block_manage.removeUneededBlocks();
    }
    public void gameOver(){
    	//update scene to gameOver menu
//    	root.setVisible(false);
//    	root.getChildren().clear();
    	StartMenu.stopAnimation();
    	s.close();
    	gameOverScreen = new GameOverMenu(s,finalScore);
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
            case SPACE:
            	if(level==2){bullet.shoot(myCharacter.getX(),myCharacter.getY());}
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
