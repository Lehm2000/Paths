package ja.paths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import javax.swing.JFrame;

public class Game {
	
	
	private boolean isRunning;
	private long lastLoopTime;
	
	private DrawSurface window;
	
	private NavData navMap;
	private ArrayList<Agent> agentList;// = new ArrayList<Agent>();
	
	
	
	Game()
	{
		//clear the lists, just in case.
		
		navMap = new NavData();
		agentList = new ArrayList<Agent>();
		
	}
	
	Game(DrawSurface window)
	{
		this.window = window;
		
		navMap = new NavData();
		agentList = new ArrayList<Agent>();
		
	}
	
	
	public boolean Init()
	{
		isRunning = false;
		
		Node tempNode01 = new Node(100,100);
		Node tempNode02 = new Node(300,100);
		Node tempNode03 = new Node(200,300);
		
		navMap.AddNode("1", tempNode01);
		navMap.AddNode("2", tempNode02);
		navMap.AddNode("3", tempNode03);
		
		navMap.AddConnection("1","2");
		navMap.AddConnection("1","3");
		
		//connectionList.add(new NodeConnection("1","2"));
		//connectionList.add(new NodeConnection("1","3"));
		
		Agent newAgent01 = new Agent(navMap.getNode("2").getPosition(), 1.0f);
		agentList.add(newAgent01);
		
		
		return true;
	}
	
	/**
	 * GameLoop()
	 * Main game loop
	 */
	public void GameLoop()
	{
		lastLoopTime = System.nanoTime();
		
		while (isRunning)
		{
			long now = System.nanoTime();
			long elapsedTime = now - lastLoopTime;
			lastLoopTime = now;
			
			//game logic
			for (int i = 0; i<agentList.size();i++)
			{
				Agent curAgent = agentList.get(i);
				curAgent.Update(mapData);  //tell agent to update and pass current map data to it.
				
			}
			
			//repaint
			window.Render(this);
			
		}
	}
	
	public void GameStart()
	{
		isRunning = true;
		GameLoop();
	}
	
	//Getters and Setters
	NavData getNavData()
	{
		return new NavData(navMap);  //return a copy of the navMap
	}
	
	ArrayList<Agent> getAgentList()
	{
		return new ArrayList<Agent>(agentList);
	}

	public long getLastLoopTime() {
		return lastLoopTime;
	}
	
	

}
