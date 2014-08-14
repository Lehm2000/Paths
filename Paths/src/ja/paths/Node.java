package ja.paths;

import java.awt.Point;



public class Node {
	
	//private members
	
	private Position position;
	
	//private String id; //unique id to identify node.
	
	/**
	 * Constructor
	 * No params.
	 * @param x
	 * @param y
	 */
	Node()
	{
		this.position = new Position(0,0);
	}
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	Node(int x, int y)
	{
		this.position = new Position(x,y);
		
	}
	
	Node(Node node)
	{
		if (node!=null)
		{
			this.position = new Position (node.getPosition());
		}
	}
	
	/**
	 * setPosition 
	 * Sets position to the specified x and y coordinates
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y)
	{
		if (position != null)
		{
			position.setX(x);
			position.setY(y);
		}
	}

	
	
	//Getters and Setters
	
	public Position getPosition() {
		return new Position(position);  //return copy of the position
	}

	public void setPosition(Position position) {
		this.position = new Position(position);
	}
	
	
}
