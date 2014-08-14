package ja.paths;

public class NodeConnection {
	
	private String startID;
	private String endID;
	
	//private connectionType;  not sure what this will be yet.
	
	NodeConnection()
	{
		startID ="";
		endID = "";
	}
	
	NodeConnection(String startID, String endID)
	{
		this.startID = startID;
		this.endID = endID;
	}

	public String getStartID() {
		return startID;
	}

	public void setStartID(String startID) {
		this.startID = startID;
	}

	public String getEndID() {
		return endID;
	}

	public void setEndID(String endID) {
		this.endID = endID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endID == null) ? 0 : endID.hashCode());
		result = prime * result + ((startID == null) ? 0 : startID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeConnection other = (NodeConnection) obj;
		if (endID == null) {
			if (other.endID != null)
				return false;
		} else if (!endID.equals(other.endID))
			return false;
		if (startID == null) {
			if (other.startID != null)
				return false;
		} else if (!startID.equals(other.startID))
			return false;
		return true;
	}
	
	

}
