package companies.amazon;


public class NodeLevel {
	private int level;
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

	public NodeLevel(Object node, int level) {
		this.node = node;
		this.level = level;
	}

}
