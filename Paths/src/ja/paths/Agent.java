package ja.paths;

public class Agent {
	
	//constants
	public final static char NOTHING = 0;
	public final static char IDLE = 1;
	public final static char MOVING = 2;
	
	
	//private members
	private Position position;
	private double speed;		//how fast is this guy.
	private String targetNode;	//id of the node where is this guy headed... might want to make this an collection of sometime to hold full path.
	private char currentAction;	//what is the agent currently up to.
	
	//Constructors
	Agent()
	{
		this.position = new Position(0,0);
		this.speed = 0;
		this.targetNode = null;
		this.currentAction = Agent.NOTHING;
	}
	
	Agent(Position position, double speed)
	{
		this.position = new Position(position);
		this.speed = speed;
		this.targetNode = null;
		this.currentAction = Agent.NOTHING;
	}
	
	void Update(NavData mapData)
	{
		switch (currentAction)
		{
		case Agent.NOTHING:
			// if agent is not doing anything let's get him moving.
			
			break;
		
			
		}
	}
	
	
	//Getters and Setters
	public Position getPosition() {
		return new Position(position);
	}
	public void setPosition(Position position) {
		this.position = new Position(position);
	}
	

	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getTargetNode() {
		return targetNode;
	}
	public void setTargetNode(String targetNode) {
		this.targetNode = targetNode;
	}
	
	

}
