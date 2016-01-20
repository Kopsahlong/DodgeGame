import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.stage.Stage;
import javafx.util.Duration;



class GameOverMenu {
    public static final String TITLE = "Game Over!";
    public static final int KEY_INPUT_SPEED = 15;
    private Scene myScene;
    public static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    private int score;
    private Stage s;
    private DodgeGameRunner myGame;

    public GameOverMenu(Stage stage, int finalScoreNum){
    	//open up startmenu scene
    	s = stage;
    	score = finalScoreNum;
    	Scene gameoverscene = init(Main.WIDTH, Main.HEIGHT);
    	s.setScene(gameoverscene);
    	s.show();
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
        Group root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
        //create objects
        Text gameOverText = new Text();
        gameOverText.setX(Main.WIDTH/2);
        gameOverText.setY(Main.HEIGHT/2-100);
        gameOverText.setText("GAME OVER!");
        root.getChildren().add(gameOverText);
        
        Text finalScore = new Text();
        finalScore.setX(Main.WIDTH/2);
        finalScore.setY(Main.HEIGHT/2);
        finalScore.setText("FINAL SCORE: "+score);
        root.getChildren().add(finalScore);
        
        Button tryAgainBtn = new Button("Try Again");
        tryAgainBtn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){openMenu();}
        });
        root.getChildren().add(tryAgainBtn);
        
        // order added to the group is the order in which they are drawn
        // Respond to input
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        myScene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));
        return myScene;
    }
    public void openMenu(){
    	s.close();
        // attach main menu to stage and display it
    	StartMenu startMenu = new StartMenu(s);	
    	s.setTitle(startMenu.getTitle());
        Scene menuscene = startMenu.init(Main.WIDTH, Main.HEIGHT);
        s.setScene(menuscene);
        s.show();
    }

    /**
     * Change properties of shapes to animate them
     * 
     * Note, there are more sophisticated ways to animate shapes,
     * but these simple ways work too.
     */

    // What to do each time a key is pressed
    private void handleKeyInput (KeyCode code) {
        switch (code) {
            default:
                // do nothing
        }
    }

    // What to do each time a key is pressed
    private void handleMouseInput (double x, double y) {
    	//do nothing
    }
}
