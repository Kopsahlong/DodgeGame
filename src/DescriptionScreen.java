import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class DescriptionScreen {
	private int level;
    private Scene myScene;
    private UIController myUI;
    private GameController myGC;

	public DescriptionScreen(GameController gc, UIController ui, int l){
		level = l;
		myUI = ui;
		myGC = gc;
	}
	public Scene init(int width, int height)
	{
		// Create a scene graph to organize the scene
        Group root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
        //write text depending on the level
        myUI.setCaveBackGround(root);
        myUI.writeStaticWhiteText(root,levelText(),190,100);
        myUI.writeStaticWhiteText(root,"Press <ENTER> to begin the round.",290,300);
        
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
        	myGC.switchScene(GameController.GAME, level);
        	break;
        default:
            // do nothing
        }
    }
}
