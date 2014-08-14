package ja.paths;

public class Position {
	
	private float x;
	private float y;
	//private in z;		//for future use
	
	Position()
	{
		this.x = 0;
		this.y = 0;
	}
	
	Position(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	Position(Position position)
	{
		this.x = position.x;
		this.y = position.y;
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}

	
}
