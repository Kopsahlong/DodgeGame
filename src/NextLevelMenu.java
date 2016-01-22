import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        Label winningLabel = new Label("YOU WON LEVEL "+level+"!");
        winningLabel.setFont(Font.font("Cambria", 32));
        Button nextLevelBtn = new Button("Next Level");
        nextLevelBtn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){StartMenu.startGame(level+1);}
        });
        
        Button startNewGameBtn = new Button("Start New Game");
        startNewGameBtn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){openMenu();}
        });

        //TODO: GO BACK AND FIX THIS SOON

        GridPane gridpane = new GridPane();
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(winningLabel,1,1);
        gridpane.add(nextLevelBtn, 1, 2);
        gridpane.add(startNewGameBtn, 1, 3);
        myScene.setRoot(gridpane);
        
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
