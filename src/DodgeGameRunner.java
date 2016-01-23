import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

/**
 * Separate the game code from some of the boilerplate code.
 * 
 * @author Robert C. Duvall
 */
class DodgeGameRunner {
    public static final String TITLE = "Dodge Game";
    public static final int KEY_INPUT_SPEED = 15;
    private int entrywidth = 100;
    private int midpoint = Main.HEIGHT/2;
    private Smiley myCharacter;
    private int level;
    private static final int[] winningScore = {75,100};//winning scores for each level
    private BlockManager block_manage;
    private StatsDisplay stats;
    private Group root;
    private Bullet bullet;
    private UIController myUI;
    private GameController myGC;
    
    public DodgeGameRunner(GameController gc, UIController ui, int l){
    	level = l;
    	myUI = ui;
    	myGC = gc;
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
        // Create a scene graph to organize the scene
        root = new Group();
        // Create a place to see the shapes
        Scene myScene = new Scene(root, width, height, Color.LIGHTGRAY);
        //set background
        myUI.setCaveBackGround(root);
        
        //create objects
        stats = new StatsDisplay(myUI,root,level);
        myCharacter = new Smiley(root);
        bullet = new Bullet(root);
        block_manage = new BlockManager(root,level);

        // Respond to input
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
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
        block_manage.checkForBulletCollision(bullet);
        if(stats.getLives()==0){gameOver();}
        if(stats.getScore()==winningScore[level-1]){wonLevel();}//check to see if you've won the level yet
        if(block_manage.rightAbove(myCharacter.getX())){stats.setScore(stats.getScore()+1);}
    }
    public void blockStep (double elapsedTime) {
    	//generate random parameters for Block
    	calculateBlockParameters();
        block_manage.addBlock(midpoint,entrywidth);
        block_manage.removeUneededBlocks();
    }
	private void calculateBlockParameters() {
		int tempentrywidth = Main.HEIGHT/3 + 10 + (int)(Math.random() * 200);//TODO: CHANGE TO DIVIDE BY 3 
    	int tempmidpoint = Main.HEIGHT/2 + (int)(Math.random() * 100)*(int)Math.pow(-1,(int)(Math.random()*2)); 
    	while(Math.abs((tempmidpoint-tempentrywidth/2)-(midpoint+entrywidth/2))<100||Math.abs((tempmidpoint+tempentrywidth/2)-(midpoint-entrywidth/2))<100){
    		tempmidpoint = Main.HEIGHT/2 + (int)(Math.random() * 100)*(int)Math.pow(-1,(int)(Math.random()*2)); 
    	}
    	midpoint = tempmidpoint;
    	entrywidth = tempentrywidth;
	}
    public void gameOver(){
    	myGC.stopAnimation();
    	myGC.switchScene(GameController.GAME_OVER,level);
    }
    public void wonLevel(){
    	myGC.stopAnimation();
    	myGC.switchScene(GameController.NEXT_LEVEL,level);
    }
    public void backToMenu(){
    	myGC.stopAnimation();
    	myGC.switchScene(GameController.START,-1);
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
            	break;
            case ESCAPE:
            	backToMenu();
            	break;
            default:
                // do nothing
        }
    }
    public int getScore(){
    	return stats.getScore();
    }
}
