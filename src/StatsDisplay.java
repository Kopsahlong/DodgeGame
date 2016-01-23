import javafx.scene.Group;
import javafx.scene.text.Text;

public class StatsDisplay {
	private Group root;
	private int score; //TODO:SOMEHOW MAKE THIS NOT PUBLIC
	private int lives;
	private Text scoreText;
	private Text lifeText;
	private Text levelText;
	private UIController myUI;
	
	public StatsDisplay(UIController ui, Group g, int level){
		root = g;
		score = 0;
		lives = 3;
		myUI = ui;
		
		scoreText = new Text();
		lifeText = new Text();
        levelText = new Text();

        myUI.writeWhiteText(root,scoreText, "Score: "+score,Main.WIDTH-80,20);
        myUI.writeWhiteText(root,lifeText, "Lives: "+lives,Main.WIDTH-180,20);
        myUI.writeWhiteText(root,levelText, "Level: "+level,Main.WIDTH-280,20);
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
