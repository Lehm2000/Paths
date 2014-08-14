package ja.paths;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;

public class NavData {
	
	private TreeMap<String,Node> nodeList; 
	private HashSet<NodeConnection> connectionList;
	
	NavData()
	{
		nodeList = new TreeMap<String, Node>();
		connectionList = new HashSet<NodeConnection>();
		
	}
	
	NavData(NavData sourceNavData)
	{
		nodeList = sourceNavData.getNodeList();  //this should get a copy of the nodelist
		connectionList = sourceNavData.getConnectionList();  //this should get a copy of the connectionlist
	}
	
	public boolean AddNode(String key, Node node)
	{
		boolean result = false;
		
		if (!nodeList.containsKey(key))
		{
			result = true;
			nodeList.put(key, node);
		}
		
		return result;
	}
	
	public boolean AddConnection(String nodeStart, String nodeEnd)
	{
		boolean result = false;
		
		//first confirm that the nodes in question actually exist
		if ( nodeList.containsKey(nodeStart) && nodeList.containsKey(nodeEnd))
		{
			NodeConnection newConnection = new NodeConnection(nodeStart,nodeEnd);
			result = connectionList.add(newConnection);
		}
		
		return result;
	}
	/**
	 * Adds two connections to allow two way travel between nodes.
	 * @param nodeStart
	 * @param nodeEnd
	 * @return
	 */
	
	public boolean AddDualConnection(String nodeStart, String nodeEnd)
	{
		boolean result = false; //TODO is this relevant on this one??
		
		//first confirm that the nodes in question actually exist
		if ( nodeList.containsKey(nodeStart) && nodeList.containsKey(nodeEnd))
		{
			NodeConnection newConnection = new NodeConnection(nodeStart,nodeEnd);
			result = connectionList.add(newConnection);
			
			//switch start and end and add new connection.
			newConnection = new NodeConnection(nodeEnd,nodeStart);
			result = connectionList.add(newConnection);
		}
		
		return result;
	}
	
	String findNearestNode(Position position)
	{
		//Iterator<Node> iterNode = nodeList.
		
		String nearestNode = nodeList.firstEntry().getKey();
		float nearestDistance = put distance calculation here.
		
		for(Entry<String, Node> entry : nodeList.entrySet()) {
			String key = entry.getKey();
			Node value = entry.getValue();

			System.out.println(key + " => " + value);
		}
		
		return nearestNode;
	}
	
	
	//Getters and setters
	
	Node getNode(String key)
	{
		
		return new Node(nodeList.get(key));
	}
	
	TreeMap<String,Node> getNodeList()
	{
		return new TreeMap<String,Node>(nodeList); //this return a copy of the node list... are the nodes themselves copied or do we get a ref of those?
	}
	
	HashSet<NodeConnection> getConnectionList()
	{
		return new HashSet<NodeConnection>(connectionList); //this return a copy of the connection list... are the nodes themselves copied or do we get a ref of those?
	}

}
