import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CharacterMenu {
	private Stage s;
	private static ImageView myChosenImage;
	private int myChooserX = Main.WIDTH/5;
	private int myChooserY = 180;
    private Scene myScene;
    private Circle myChooser;
	private final static String TITLE = "Dodge Game";
	private Group root;
	private static ImageView mySmiley;
	private ImageView myHeartSmiley;
	private ImageView myTongueEmoji;
	private ImageView myAngryEmoji;

	public CharacterMenu(Stage stage){
		s = stage;
    	Scene finallevelscene = init(Main.WIDTH, Main.HEIGHT);
    	s.setScene(finallevelscene);
    	s.show();
	}
	public String getTitle () {
        return TITLE;
    }
	public Scene init(int width, int height){
		// Create a scene graph to organize the scene
        root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
        myChooser = new Circle();
		root.getChildren().add(myChooser);

        drawChooser();
		
        Text chooseText = new Text();
        chooseText.setX(220);
        chooseText.setY(50);
        chooseText.setText("Choose a character by pressing the left and right arrow keys.");
        root.getChildren().add(chooseText);

        Text remindText = new Text();
        remindText.setX(270);
        remindText.setY(300);
        remindText.setText("Press <Enter> to choose and return to Start.");
        root.getChildren().add(remindText);

        
        //create objects
        Image smileicon = new Image(getClass().getClassLoader().getResourceAsStream("smiley3.png"));
        mySmiley = new ImageView(smileicon);
        mySmiley.setX(Main.WIDTH/5-30);
        mySmiley.setY(100);
        root.getChildren().add(mySmiley);
        
        Image hearticon = new Image(getClass().getClassLoader().getResourceAsStream("HeartEyesEmoji.png"));
        myHeartSmiley = new ImageView(hearticon);
        myHeartSmiley.setX(2*Main.WIDTH/5-30);
        myHeartSmiley.setY(100);
        root.getChildren().add(myHeartSmiley);
        
        Image tongueicon = new Image(getClass().getClassLoader().getResourceAsStream("TongueEmoji.png"));
        myTongueEmoji = new ImageView(tongueicon);
        myTongueEmoji.setX(3*Main.WIDTH/5-30);
        myTongueEmoji.setY(100);
        root.getChildren().add(myTongueEmoji);
        
        Image angryicon = new Image(getClass().getClassLoader().getResourceAsStream("AngryEmoji.png"));
        myAngryEmoji = new ImageView(angryicon);
        myAngryEmoji.setX(4*Main.WIDTH/5-30);
        myAngryEmoji.setY(100);
        root.getChildren().add(myAngryEmoji);
        
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
        	openMenu();
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
    public void openMenu(){//TODO: MAKE THIS INTO CLASS FOR START MENU
    	s.close();
        // attach main menu to stage and display it
    	StartMenu startMenu = new StartMenu(s);	
    	s.setTitle(startMenu.getTitle());
        Scene menuscene = startMenu.init(Main.WIDTH, Main.HEIGHT);
        s.setScene(menuscene);
        s.show();
    }
}
