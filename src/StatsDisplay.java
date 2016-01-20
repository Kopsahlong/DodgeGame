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

public class StatsDisplay {
	private Group root;
	private int score; //TODO:SOMEHOW MAKE THIS NOT PUBLIC
	private int lives;
	private Text scoreText;
	private Text lifeText;
	
	public StatsDisplay(Group g){
		root = g;
		score = 0;
		lives = 3;
		scoreText = new Text();
		scoreText.setX(Main.WIDTH-80);
		scoreText.setY(20);
		scoreText.setText("Score: "+score);
        root.getChildren().add(scoreText);
        lifeText = new Text();
        lifeText.setX(Main.WIDTH-180);
        lifeText.setY(20);
        lifeText.setText("Lives: "+lives);
        root.getChildren().add(lifeText);
	}
	public void setScore(int newscore){
		score = newscore;
        scoreText.setText("Score: "+score);
	}
	public int getScore(){
		return score;
	}
	public void loseLife(){
		lives = lives-1;
		lifeText.setText("Lives: "+lives);
	}
	public int getLives(){
		return lives;
	}
}
