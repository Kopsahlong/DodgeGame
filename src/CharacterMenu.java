import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CharacterMenu {
	//private Stage s;
	private static ImageView myChosenImage;
	private int myChooserX = Main.WIDTH/5;
	private int myChooserY = 180;
    private Scene myScene;
    private Circle myChooser;
	private Group root;
	private static ImageView mySmiley;
	private ImageView myHeartSmiley;
	private ImageView myTongueEmoji;
	private ImageView myAngryEmoji;
	private UIController myUI;
    private GameController myGC;

	public CharacterMenu(GameController gc, UIController ui){
		myGC = gc;
		myUI = ui;
	}
	public Scene init(int width, int height){
		// Create a scene graph to organize the scene
        root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
        myChooser = new Circle();
		root.getChildren().add(myChooser);
        drawChooser();
		
        myUI.writeStaticText(root,"Choose a character by pressing the left and right arrow keys.",220,50);
        myUI.writeStaticText(root,"Press <Enter> to choose and return to Start.",270,300);

        mySmiley = myUI.makeImage(root,1*Main.WIDTH/5-30,100,"smiley3.png");
        myHeartSmiley = myUI.makeImage(root,2*Main.WIDTH/5-30,100,"HeartEyesEmoji.png");
        myTongueEmoji = myUI.makeImage(root,3*Main.WIDTH/5-30,100,"TongueEmoji.png");
        myAngryEmoji = myUI.makeImage(root,4*Main.WIDTH/5-30,100,"AngryEmoji.png");
        
        myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        return myScene;
	}
	public void drawChooser(){
        myChooser.setFill(Color.BLACK);
        myChooser.setCenterX(myChooserX);
        myChooser.setCenterY(myChooserY);
        myChooser.setRadius(5);
	}
	// What to do each time a key is pressed
    private void handleKeyInput (KeyCode code) {
        switch (code) {
        case ENTER: //switches to start menu
        	if(myChooserX==Main.WIDTH/5){myChosenImage = mySmiley;}
            if(myChooserX==2*Main.WIDTH/5){myChosenImage = myHeartSmiley;}
            if(myChooserX==3*Main.WIDTH/5){myChosenImage = myTongueEmoji;}
            if(myChooserX==4*Main.WIDTH/5){myChosenImage = myAngryEmoji;}
        	myGC.switchScene(GameController.START, -1);
        	break;
        case LEFT: //make selected emoji the one to the left if one exists there
        	if(myChooserX!=Main.WIDTH/5){myChooserX=myChooserX-Main.WIDTH/5;}
        	drawChooser();
        	break;
        case RIGHT://make selected emoji the one to the right if one exists there
        	if(myChooserX!=4*Main.WIDTH/5){myChooserX=myChooserX+Main.WIDTH/5;}
        	drawChooser();
        	break;
        default:
            // do nothing
        }
    }
    public static ImageView getChosenImage(){
    	if(myChosenImage==null){return mySmiley;}
    	else {return myChosenImage;}
    }
}
