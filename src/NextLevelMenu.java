import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NextLevelMenu {
	private int level;
	private Scene myScene;
	private Stage s;
	public NextLevelMenu(Stage stage, int l){
		level = l;
		s = stage;
		
		Scene nextlevelscene = init(Main.WIDTH, Main.HEIGHT);
    	s.setScene(nextlevelscene);
    	s.show();
	}
	public Scene init(int width, int height){
        // Create a scene graph to organize the scene
        Group root = new Group();
        
        // Create a place to see the shapes
        myScene = new Scene(root, width, height, Color.WHITE);
        
      //create objects
        
        Image winicon = new Image(getClass().getClassLoader().getResourceAsStream("WinningDisplay.png"));
        ImageView WinningImage = new ImageView(winicon);
        WinningImage.setX(270);
        WinningImage.setY(30);
        root.getChildren().add(WinningImage);
        
        Text winningText = new Text();
        winningText.setX(Main.WIDTH/2-95);
        winningText.setY(Main.HEIGHT/2+80);
        if(level!=2){
        	winningText.setText("YOU WON LEVEL "+level+"!");
        	Button nextLevelBtn = new Button("Next Level");
        	nextLevelBtn.setOnAction(new EventHandler<ActionEvent>() { 
        		public void handle(ActionEvent event){
        			s.close();
        			DescriptionScreen descripScreen = new DescriptionScreen(s,level+1);
        		}
        	});
        	nextLevelBtn.setTranslateX(Main.WIDTH/2-50);
        	nextLevelBtn.setTranslateY(Main.HEIGHT/2+130);
        	root.getChildren().add(nextLevelBtn);
        }
        else{
        	winningText.setText("YOU WON THE GAME!");
            winningText.setX(Main.WIDTH/2-112);
        }
        winningText.setFont(new Font("Arial", 20));
        root.getChildren().add(winningText);

        Button startNewGameBtn = new Button("New Game");
        startNewGameBtn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){openMenu();}
        });
        startNewGameBtn.setTranslateX(Main.WIDTH/2-50);
        startNewGameBtn.setTranslateY(Main.HEIGHT/2+160);
        root.getChildren().add(startNewGameBtn);

        //TODO: GO BACK AND FIX THIS SOON
        
        return myScene;
	}
	
	public void openMenu(){
    	s.close();
        // attach main menu to stage and display it
    	StartMenu startMenu = new StartMenu(s);	
    	s.setTitle(startMenu.getTitle());
        Scene menuscene = startMenu.init(Main.WIDTH, Main.HEIGHT);
        s.setScene(menuscene);
        s.show();
    }
}
