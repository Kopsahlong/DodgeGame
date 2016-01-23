import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class GameOverMenu {
    public static final String TITLE = "Game Over!";
    public static final int KEY_INPUT_SPEED = 15;
    private Scene myScene;
    private int score;
    private Group root;
    private UIController myUI;
    private GameController myGC;

    public GameOverMenu(GameController gc, UIController ui, int finalScoreNum){
    	myUI = ui;
    	myGC = gc;
    	score = finalScoreNum;
    }
    /**
     * Create the game's scene
     */
    public Scene init (int width, int height) {
        // Create a scene graph to organize the scene
        root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
        //create objects
        myUI.makeImage(root, Main.WIDTH/2-110, Main.HEIGHT/2-160, "HaloEmojiDisplay.png");
        
        Text gameOverText = new Text();
        myUI.writeText(root,gameOverText, "GAME OVER!", Main.WIDTH/2-50, Main.HEIGHT/2+80);
        gameOverText.setFont(new Font("Arial", 20));
        
        Text finalScore = new Text();
        myUI.writeText(root,finalScore,"FINAL SCORE: "+score,Main.WIDTH/2-37, Main.HEIGHT/2+100);
        
        myUI.makeButton(root, "New Game", Main.WIDTH/2-30, Main.HEIGHT/2+150, GameController.START, -1);

        return myScene;
    }
}
