import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;



class StartMenu {
    private static final int BUTTON_WIDTH = 148;
    private static final int BUTTON_HEIGHT = 20;
    private Group root;
    private Scene myScene;
    private GameController myGC;
    public StartMenu(GameController gc){
    	myGC = gc;
    }

    /**
     * Create the game's scene
     */
    public Scene init (int width, int height) {
        // Create a scene graph to organize the scene
        root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
        //create objects
        Image logoicon = new Image(getClass().getClassLoader().getResourceAsStream("cavedodgelogo2.png"));
        ImageView myLogo = new ImageView(logoicon);
        
        Button btn1 = makeSizedButton("Start Level 1", GameController.DESCRIP,1);
        Button btn2 = makeSizedButton("Start Level 2", GameController.DESCRIP,2);
        Button btn3 = makeSizedButton("Customize Character", GameController.CHOOSE_CHAR,-1);

        putItemsInGrid(myLogo, btn1, btn2, btn3);
        
        return myScene;
    }

	private void putItemsInGrid(ImageView myLogo, Button btn1, Button btn2, Button btn3) {
		GridPane gridpane = new GridPane();
        gridpane.add(myLogo,1,1);
        
        GridPane smallgrid = new GridPane();
        smallgrid.add(btn1,1,1);
        smallgrid.add(btn2,1,2);
        smallgrid.add(btn3,1,3);
        smallgrid.setAlignment(Pos.CENTER);

        gridpane.add(smallgrid,1,2);
        gridpane.setAlignment(Pos.CENTER);
        myScene.setRoot(gridpane);
        gridpane.setStyle("-fx-background-image: url('../images/caveBackGround3.jpg')");
	}
	//not using ui controller for this bc this method is unique to the start menu class
    public Button makeSizedButton(String text, String type, int level){
    	Button btn = new Button(text);
		btn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){
        		myGC.switchScene(type,level);
        	}
        });
        btn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		return btn;
	}
}
