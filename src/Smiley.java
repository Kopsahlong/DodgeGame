import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Smiley {
	private int Y;
	private int X;
	private ImageView mySmiley;
	private Group root;
	public Smiley(Group g){
		root = g;
		if(CharacterMenu.getChosenImage()!=null){mySmiley = CharacterMenu.getChosenImage();}
		else{
			Image smileicon = new Image(getClass().getClassLoader().getResourceAsStream("smiley3.png"));
			mySmiley = new ImageView(smileicon);
		}
		Y = (int)(Main.HEIGHT / 2  - mySmiley.getBoundsInLocal().getHeight() / 2);
		X = (int)(Main.WIDTH / 5 - mySmiley.getBoundsInLocal().getWidth() / 2);
        mySmiley.setX(X);
        mySmiley.setY(Y);
        root.getChildren().add(mySmiley);

	}
	public void setY(int newY){
		Y = newY;
		mySmiley.setY(Y);
	}
	public int getY(){
		return Y;
	}
	public int getX(){
		return X;
	}
	public Bounds getBounds(){
		return mySmiley.getBoundsInParent();
	}
}
