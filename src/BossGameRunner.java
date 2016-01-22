import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BossGameRunner {
	private int level;
	private Stage s;
    public static final String TITLE = "Dodge Game BOSS LEVEL";
    private Group root;
    private Bullet bullet;

	public BossGameRunner(Stage stage, int l){
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
        // Create a scene graph to organize the scene
        root = new Group();
        
        // Create a place to see the shapes
        Scene myScene = new Scene(root, width, height, Color.WHITE);
        
        //create objects
        // order added to the group is the order in which they are drawn
        // Respond to input
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        myScene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));
        return myScene;
    }
}
