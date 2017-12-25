package companies.amazon;

public class NodeLevelDistance {
	private int level;
	private int distance;
	private Object node;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Object getNode() {
		return node;
	}

	public void setNode(Object node) {
		this.node = node;
	}

	public NodeLevelDistance(Object node, int level) {
		this.node = node;
		this.level = level;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
