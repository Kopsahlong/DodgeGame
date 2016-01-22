import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * This is the main program, it is basically boilerplate to create
 * an animated scene.
 * 
 * @author Robert C. Duvall
 */
public class Main extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    public static final int FRAMES_PER_SECOND = 200;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

    private DodgeGameRunner myGame;
    private StartMenu startMenu;

    /**
     * Set things up at the beginning.
     */
    @Override
    public void start (Stage s) {
    	//open the start menu
    	startMenu = new StartMenu(s);	
    }

    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
    public int getHeight(){
    	return HEIGHT;
    }
    public int getWidth(){
    	return WIDTH;
    }
}
