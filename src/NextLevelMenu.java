import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NextLevelMenu {
	private static final int HIGHEST_LEVEL = 2;
	private int level;
	private Scene myScene;
	private Group root;
	private UIController myUI;

	public NextLevelMenu(UIController ui, int l){
		myUI = ui;
		level = l;
	}
	public Scene init(int width, int height){
        // Create a scene graph to organize the scene
        root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
      //create objects
        if(level==HIGHEST_LEVEL){myUI.setEscapeBackGround(root);}
        else{myUI.setCaveBackGround(root);}
        	
        myUI.makeImage(root, 270, 30, "WinningDisplay.png");
        
        Text winningText = new Text();
        winningText.setFont(new Font("Arial", 20));
        if(level != HIGHEST_LEVEL){
        	myUI.writeText(root,winningText,"YOU WON LEVEL "+level+"!",Main.WIDTH/2-95,Main.HEIGHT/2+80);
        	Button nextLevelBtn = new Button("Next Level");
        	myUI.makeButton(root,nextLevelBtn,Main.WIDTH/2-50,Main.HEIGHT/2+130,GameController.DESCRIP,level);
        }
        else{
        	myUI.writeText(root,winningText,"YOU WON THE GAME!",Main.WIDTH/2-112,Main.HEIGHT/2+80);
        }
        
        myUI.makeButton(root,"New Game",Main.WIDTH/2-50,Main.HEIGHT/2+160,GameController.START,level);
        
        return myScene;
	}
}
