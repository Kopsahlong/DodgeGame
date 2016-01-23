import javafx.application.Application;
import javafx.stage.Stage;


/**
 * This is the main program, it is basically boilerplate to create
 * an animated scene.
 * 
 * @author Krista Opsahl-Ong and Robert C. Duvall
 */
public class Main extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;

    /**
     * Set things up at the beginning.
     */
    
    @Override
    public void start (Stage s) {    	
    	//open the start menu
    	GameController control = new GameController(s);
    	control.switchScene(GameController.START,-1);
    }

    /**
     * Start the program.
     */
    public static void main (String[] args) {
    	//make splash screen
        launch(args);
    }
}
