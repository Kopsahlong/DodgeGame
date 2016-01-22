import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DescriptionScreen {
	private int level;
    private Stage s;
    private Scene myScene;
	
	public DescriptionScreen(Stage stage, int l){
		s = stage;
		level = l;
    	Scene descripscene = init(Main.WIDTH, Main.HEIGHT);
    	s.setScene(descripscene);
    	s.show();
	}
	public Scene init(int width, int height)
	{
		// Create a scene graph to organize the scene
        Group root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
        //write text depending on the level
        
        Image caveicon = new Image(getClass().getClassLoader().getResourceAsStream("caveBackGround3.jpg"));
        ImageView caveImage = new ImageView(caveicon);
        caveImage.setX(0);
        caveImage.setY(0);
        root.getChildren().add(caveImage);
        
        Text descripText = new Text();
        descripText.setX(190);
        descripText.setY(100);
        descripText.setText(levelText());
        descripText.setFill(Color.WHITE);
        root.getChildren().add(descripText);
        
        Text remindText = new Text();
        remindText.setX(290);
        remindText.setY(300);
        remindText.setFill(Color.WHITE);
        remindText.setText("Press <ENTER> to begin the round.");
        root.getChildren().add(remindText);
        
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        return myScene;
	}
	public String levelText(){
		switch(level){
		case 1:
			return  "Oh no! Your emoji is stuck in a cave and needs to get out! \n"
					+ "Navigate through the cave by pressing the <UP> and <DOWN> arrow keys,\n"
					+ "and make sure to avoid the stalagmites and stalagtites because they \n"
					+ "will hurt your emoji!";
		case 2:
			return  "Your emoji has made it through the first part of the cave, only to \n"
					+ "end up in an even colder, more dangerous section! Now you must avoid \n"
					+ "not only the stalagmites and stalagtites, but also the frozen ice \n"
					+ "barriers between them! Luckily, your emoji happened to have found a gun \n"
					+ "in the first part of the cave, and can now fire bullets! Fire by \n"
					+ "pressing the <SPACE> button. Good luck!";
		default:
			return "default";
		}
	}
	
    private void handleKeyInput (KeyCode code) {
        switch (code) {
        case ENTER: //begins the level
        	StartMenu.startGame(level);
        	break;
        default:
            // do nothing
        }
    }
}
