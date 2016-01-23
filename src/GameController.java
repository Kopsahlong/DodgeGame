import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController {
    public static final int KEY_INPUT_SPEED = 15;
    public static final int FRAMES_PER_SECOND = 90; //60
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    public static final double BLOCK_FRAMES_PER_SECOND = 2.5; //60
    private static final double BLOCK_MILLISECOND_DELAY = 1000 / BLOCK_FRAMES_PER_SECOND;
    private static final double BLOCK_SECOND_DELAY = 1.0 / BLOCK_FRAMES_PER_SECOND;
    
    public static final String GAME = "game";
    public static final String START = "start";
    public static final String NEXT_LEVEL = "next level";
    public static final String GAME_OVER = "game over";
    public static final String DESCRIP = "description";
    public static final String CHOOSE_CHAR = "choose character";

    private DodgeGameRunner myGame;
    private StartMenu myStartMenu;
    private CharacterMenu myCharMenu;
    private NextLevelMenu myNextLevelMenu;
    private GameOverMenu myGameOverMenu;
    private DescriptionScreen myDescripScreen;
    
    private Timeline animation;
    private Timeline animationBlock;
    private KeyFrame frame;
    private KeyFrame frameBlock;
    private Stage s;

	public GameController(Stage stage){
		s = stage;
	}
	public void switchScene(String sceneType, int level){
		s.close(); //close current stage
		switch(sceneType){
			case GAME:
				myGame = new DodgeGameRunner(this, new UIController(this),level);
				s.setScene(myGame.init(Main.WIDTH, Main.HEIGHT));
				setGameLoop();
				break;
			case START:
				myStartMenu = new StartMenu(this);	
		        s.setScene(myStartMenu.init(Main.WIDTH, Main.HEIGHT));
				break;
			case NEXT_LEVEL:
				myNextLevelMenu = new NextLevelMenu(new UIController(this),level);	
		        s.setScene(myNextLevelMenu.init(Main.WIDTH, Main.HEIGHT));
				break;
			case GAME_OVER:
				myGameOverMenu = new GameOverMenu(new UIController(this),myGame.getScore());
		        s.setScene(myGameOverMenu.init(Main.WIDTH, Main.HEIGHT));
				break;
			case DESCRIP:
				myDescripScreen = new DescriptionScreen(this, new UIController(this),level);
		        s.setScene(myDescripScreen.init(Main.WIDTH, Main.HEIGHT));
				break;
			case CHOOSE_CHAR:
				myCharMenu = new CharacterMenu(this, new UIController(this));
		        s.setScene(myCharMenu.init(Main.WIDTH, Main.HEIGHT));
				break;
			default:
				//do nothing
		}
        s.show(); //shows new stage
	}
	private void setGameLoop() {
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
	public void stopAnimation(){
    	animation.stop();
    	animationBlock.stop();
    }
}
