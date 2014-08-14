package ja.paths;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JPanel;


public class DrawSurface extends JPanel{
	
	private Game theGame;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * DrawSurface
	 * Empty Constructor
	 */
	DrawSurface()
	{
		theGame = new Game(); //provide a temporary empty game.  will be replaced when render called.
	}
	
	/**
	 * DrawSurface
	 * Constructor
	 * @param app - reference to the app data
	 */
	DrawSurface(Game theGame)
	{
		this.theGame = theGame;  //TODO make read only?
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		drawScreen(g);
		
		return;
	}
	
	void drawScreen(Graphics g)
	{
		
		g.setColor(new Color(0,0,0));
		//g.drawLine(0, 0, this.getWidth(), this.getHeight());
		//g.drawLine(0, this.getHeight(), this.getWidth(), 0);
		
		//get a copy of the navMap
		NavData navMap = theGame.getNavData();
		
		TreeMap<String,Node> nodeList = navMap.getNodeList();
		
		//draw the nodes
		
		int nodeSize = 8; //temp size.  TODO make constant... or put in node itself
		
		for(Map.Entry<String,Node> entry : nodeList.entrySet()) 
		{
			Node curNode = entry.getValue();
			Position nodePosition = curNode.getPosition();
			g.fillRect((int)nodePosition.getX()-(nodeSize/2), (int)nodePosition.getY()-(nodeSize/2), nodeSize, nodeSize);
		}
		
		
		
		//draw all the connections
		
		HashSet<NodeConnection> connectList = navMap.getConnectionList();
		
		
		
		Iterator<NodeConnection> connectIter = connectList.iterator();
		
		while ( connectIter.hasNext() )
		{
			Node startNode = null;
			Node endNode = null;
			
			NodeConnection curConnection = connectIter.next();
			
			startNode = nodeList.get(curConnection.getStartID());
			endNode = nodeList.get(curConnection.getEndID());
			
			if ( startNode != null && endNode != null)
			{
				Position startNodePos = startNode.getPosition();
				Position endNodePos = endNode.getPosition();
				g.drawLine((int)startNodePos.getX(), (int)startNodePos.getY(), (int)endNodePos.getX(), (int)endNodePos.getY());
			}
			
		}
		
		//draw the agents
		
		g.setColor(Color.red);
		
		ArrayList<Agent> agentList = theGame.getAgentList();
		int agentSize = 16; //temp size.  TODO make constant... or put in node itself
		
		for (int i =0; i<agentList.size(); i++)
		{
			Agent curAgent = agentList.get(i);
			Position agentPos = curAgent.getPosition();
			g.fillOval((int)agentPos.getX()-(agentSize/2), (int)agentPos.getY()-(agentSize/2), agentSize, agentSize);
		}
		
		//draw time
		g.drawString((new Long( (theGame.getLastLoopTime()/1000000000)).toString()), 0, 10);
		
	}
	
	void Render(Game theGame)
	{
		this.theGame = theGame;
		this.repaint();
	}

}
