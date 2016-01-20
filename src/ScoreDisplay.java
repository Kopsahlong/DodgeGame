import java.awt.TextField;
import java.util.ArrayList;
import java.util.Timer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class ScoreDisplay {
	private Group root;
	private int score;
	private Text text;
	
	public ScoreDisplay(Group g){
		root = g;
		score = 0;
		text = new Text();
        text.setX(Main.WIDTH-80);
        text.setY(20);
        text.setText("Score: "+score);
        root.getChildren().add(text);
	}
	public void setScore(int newscore){
		score = newscore;
        text.setText("Score: "+score);
	}
	public int getScore(){
		return score;
	}
}
