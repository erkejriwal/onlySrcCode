package DataStructures.advacedLists.XorDllNotPossibleInJava;

public class XorDLLNode {
	private int data;
	/**
	 * named as pointer diff but actually it is xor sum of previous and
	 * next nodes
	 */
	private XorDLLNode pointerDiff;
	public XorDLLNode(int data){
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public XorDLLNode getPointerDiff() {
		return pointerDiff;
	}
	public void setPointerDiff(XorDLLNode pointerDiff) {
		this.pointerDiff = pointerDiff;
	}
	
}
