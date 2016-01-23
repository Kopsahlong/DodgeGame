import javafx.geometry.Bounds;

public interface Block {
    public void drawBlock();
    public void setAxisLoc(int newAxisLoc);
    public int getAxisLoc();
    public void setColorRed();
	public void setColorGray();
	public boolean intersects(Bounds boundaries);
	public void setColorTransparent();
	public void touch();
	public boolean wasTouched();
	public void mark();
	public boolean isMarked();
	public void smileyIntersect();
	public void bulletIntersect(Bullet bullet);
}