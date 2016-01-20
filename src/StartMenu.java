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



class StartMenu {
    public static final String TITLE = "Dodge Game";
    public static final int KEY_INPUT_SPEED = 15;
    private Scene myScene;
    public static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    private Stage s;
    private DodgeGameRunner myGame;
    private static Timeline animation;
    private static Timeline animationBlock;

    public StartMenu(Stage stage){
    	//open up startmenu scene
    	s = stage;
    	Scene menuscene = init(Main.WIDTH, Main.HEIGHT);
    	s.setScene(menuscene);
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
        Button btn = new Button("Start Game");
        btn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){startGame();}
        });
        root.getChildren().add(btn);
        // order added to the group is the order in which they are drawn
        // Respond to input
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        myScene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));
        return myScene;
    }
    public void startGame(){
    	//close previous stage
    	s.close();
        // attach game to the stage and display it
        myGame = new DodgeGameRunner(s);
        s.setTitle(myGame.getTitle());
        Scene gamescene = myGame.init(Main.WIDTH, Main.HEIGHT);
        s.setScene(gamescene);
        s.show();
        
     // sets the game's loop
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                                      e -> myGame.step(SECOND_DELAY));
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
        //sets a loop to create and destroy blocks
        KeyFrame frame2 = new KeyFrame(Duration.millis(1000),//2000
                e -> myGame.blockStep(5));//10
        animationBlock = new Timeline();
        animationBlock.setCycleCount(Timeline.INDEFINITE);
        animationBlock.getKeyFrames().add(frame2);
        animationBlock.play();
    }
    public static void stopAnimation(){
    	animation.stop();
    	animationBlock.stop();
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
