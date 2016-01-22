import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.Timer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



class StartMenu {
    public static final String TITLE = "Dodge Game";
    public static final int KEY_INPUT_SPEED = 15;
    private Scene myScene;
    public static final int FRAMES_PER_SECOND = 90; //60
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    public static final double BLOCK_FRAMES_PER_SECOND = 2.5; //60
    private static final double BLOCK_MILLISECOND_DELAY = 1000 / BLOCK_FRAMES_PER_SECOND;
    private static final double BLOCK_SECOND_DELAY = 1.0 / BLOCK_FRAMES_PER_SECOND;
    private static Stage s;
    private static DodgeGameRunner myGame;
    private static CharacterMenu charMenu;
    private static Timeline animation;
    private static Timeline animationBlock;
    private static KeyFrame frame;
    private static KeyFrame frameBlock;


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
        Label welcomeLabel = new Label("Welcome to Dodge Game!");
        welcomeLabel.setFont(Font.font("Cambria", 32));

        Button btn1 = new Button("Start Level 1");
        btn1.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){startGame(1);}
        });
        Label scoreLevel1 = new Label("    High Score: NA");
        
        Button btn2 = new Button("Start Level 2");
        btn2.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){startGame(2);}
        });
        Label scoreLevel2 = new Label("    High Score: NA");

        Button btn3 = new Button("Customize Character");
        btn3.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){customizeCharacter();}
        });
        
        //TODO: GO BACK AND FIX THIS SOON

        GridPane gridpane = new GridPane();
        GridPane smallgrid = new GridPane();
        smallgrid.add(btn1, 1, 1);
        smallgrid.add(btn2, 1, 2);
        smallgrid.add(btn3, 1, 3);
        smallgrid.add(scoreLevel1, 2, 1);
        smallgrid.add(scoreLevel2, 2, 2);

        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(welcomeLabel,1,1);
        gridpane.add(smallgrid, 1, 2);
        myScene.setRoot(gridpane);
        
        // order added to the group is the order in which they are drawn
        // Respond to input
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        myScene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));
        return myScene;
    }
    public static void customizeCharacter(){
    	//close previous stage
    	s.close();
    	charMenu = new CharacterMenu(s);
        s.setTitle(charMenu.getTitle());
        Scene charScene = charMenu.init(Main.WIDTH, Main.HEIGHT);
        s.setScene(charScene);
        s.show();
    }
    public static void startGame(int level){
    	//close previous stage
    	s.close();
        // attach game to the stage and display it
        myGame = new DodgeGameRunner(s,level);
        s.setTitle(myGame.getTitle());
        Scene gamescene = myGame.init(Main.WIDTH, Main.HEIGHT);
        s.setScene(gamescene);
        s.show();
        
     // sets the game's loop
        frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                                      e -> myGame.step(SECOND_DELAY));
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
        //sets a loop to create and destroy blocks
        frameBlock = new KeyFrame(Duration.millis(BLOCK_MILLISECOND_DELAY),//1000
                e -> myGame.blockStep(BLOCK_SECOND_DELAY));//10
        animationBlock = new Timeline();
        animationBlock.setCycleCount(Timeline.INDEFINITE);
        animationBlock.getKeyFrames().add(frameBlock);
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
