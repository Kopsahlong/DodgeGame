import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class UIController {
	private GameController myGC;
	public UIController(GameController gc){
		myGC = gc;
	}
	public void writeText(Group root, Text text, String s, int x, int y){
		text.setX(x);
		text.setY(y);
		text.setText(s);
		text.setFill(Color.BLACK);
        root.getChildren().add(text);
	}
	public void writeWhiteText(Group root, Text text, String s, int x, int y){
		text.setX(x);
		text.setY(y);
		text.setText(s);
		text.setFill(Color.WHITE);
        root.getChildren().add(text);
	}
	public void writeStaticText(Group root, String s, int x, int y){
		Text text = new Text();
		text.setX(x);
		text.setY(y);
		text.setText(s);
		text.setFill(Color.BLACK);
        root.getChildren().add(text);
	}
	public void writeStaticWhiteText(Group root, String s, int x, int y){
		Text text = new Text();
		text.setX(x);
		text.setY(y);
		text.setText(s);
		text.setFill(Color.WHITE);
        root.getChildren().add(text);
	}
	public void makeButton(Group root, Button btn, int xpos, int ypos, String type, int level){
		btn.setTranslateX(xpos);
		btn.setTranslateY(ypos);
		btn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){
        		myGC.switchScene(type,level+1);
        	}
        });
        root.getChildren().add(btn);
	}
	public void makeButton(Group root, String text, int xpos, int ypos, String type, int level){
		Button btn = new Button(text);
		btn.setTranslateX(xpos);
		btn.setTranslateY(ypos);
		btn.setOnAction(new EventHandler<ActionEvent>() { 
        	public void handle(ActionEvent event){
        		myGC.switchScene(type,level+1);
        	}
        });
        root.getChildren().add(btn);
	}
	public ImageView makeImage(Group root,int x, int y, String file){
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(file));
        ImageView imageview = new ImageView(image);
        imageview.setX(x);
        imageview.setY(y);
        root.getChildren().add(imageview);
        return imageview;
	}
	public void setCaveBackGround(Group root){
		Image caveicon = new Image("../images/caveBackGround3.jpg");
        ImageView caveImage = new ImageView(caveicon);
        caveImage.setX(0);
        caveImage.setY(0);
        root.getChildren().add(caveImage);
	}
}
