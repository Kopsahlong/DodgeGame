
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



class FinalLevelMenu {
    public static final String TITLE = "WINNER!";
    public static final int KEY_INPUT_SPEED = 15;
    private Scene myScene;
    public static final int FRAMES_PER_SECOND = 60;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    private Stage s;
    private DodgeGameRunner myGame;

    public FinalLevelMenu(Stage stage){
    	//open up startmenu scene
    	s = stage;
    	Scene finallevelscene = init(Main.WIDTH, Main.HEIGHT);
    	s.setScene(finallevelscene);
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
        Label winningLabel = new Label("YOU WON THE GAME!!");
        winningLabel.setFont(Font.font("Cambria", 32));
        
        Button startNewGameBtn = new Button("New Game");
        startNewGameBtn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){openMenu();}
        });
        
        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(winningLabel,1,1);
        gridpane.add(startNewGameBtn, 1, 2);
        myScene.setRoot(gridpane);       
        
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
