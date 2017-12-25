package DataStructures.trie;

public class Trie {
	private Node root;
	private int noOfAlphabets = 256;
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public Trie(){
		this.root = new Node(noOfAlphabets);
	}
	public Trie(int noOfAlphabets){
		this.noOfAlphabets = noOfAlphabets;
		this.root = new Node(this.noOfAlphabets);
	}
	
	public void insert (String word){
		int wordlength = word.length();
		Node tempNode = this.root;
		for (int i = 0; i < wordlength; i++) {
			char character = word.charAt(i);
			if(tempNode.getChildren()[character] == null){
				Node newNode = new Node(i == wordlength-1);
				tempNode.getChildren()[character] = newNode;
				tempNode = newNode;
			}else{
				tempNode = tempNode.getChildren()[character];
				if(i == wordlength-1){
					tempNode.setLeaf(true);
				}
			}
		}
	}
	
	public boolean search(String word){
		boolean isFound = false;
		Node tempNode = this.root;
		int wordLength = word.length();
		for (int i = 0; i < wordLength; i++) {
			if(tempNode.getChildren()[word.charAt(i)] != null){
				if(i == wordLength-1 && tempNode.getChildren()[word.charAt(i)].isLeaf()){
					isFound = true;
					return isFound;
				}else if(i < wordLength-1){
					tempNode = tempNode.getChildren()[word.charAt(i)];
				}
			}else{
				return false;
			}
		}
		return isFound;
	}
	
	public void printTrie(){
		System.out.print("\n ");
		this.printTrieUtil(this.root, 1,false);

	}
	
	private void printTrieUtil(Node node, int spaceLength, boolean doPrintSpace){
		if(node == null){
			return;
		}
		Node[] childNodes = node.getChildren();
		int count = 0;
		for (int i = 0;i<this.noOfAlphabets;i++) {
			if(childNodes[i]!= null){
				if(doPrintSpace || count!=0 ){
					String space = String.format("%"+ spaceLength +"s", " ");
					System.out.print("\n"+space+"|");
					count = 0;
				}
				
				System.out.print("->"+(char)i);
				this.printTrieUtil(childNodes[i], spaceLength+3,count!=0);
				
				count++;
			}
		}
	}
	
	public boolean hasChild(Node node){
		int count = 0;
		for (Node childNode:node.getChildren()) {
			if(childNode!= null){
				count++;
				if(count>0){
					return true;
				}
			}
		}
		return false;
	}
	
	public void delete(String word){
		this.deleteUtil(this.root, word, 0);
	}
	
	private boolean deleteUtil(Node node, String word, int wordNo){
		int wordLength = word.length();
		Node childNode = node.getChildren()[word.charAt(wordNo)];
		boolean isChildDeletedAndNeedToDeleteCurrent = false;
		if(wordNo > wordLength){
			return false;
		}
		if(childNode!= null){
			if(wordNo == wordLength-1){
				if(this.hasChild(childNode)){
					if(childNode.isLeaf()){
						childNode.setLeaf(false);
						System.out.println("word "+word+" deleted");
						return false;
					}else{
						System.out.println("\nword "+word+" doesn't exist!");
						return false;
					}
				}else{
					node.getChildren()[word.charAt(wordNo)] = null;
					System.out.println("word "+word+" deleted");
					return true;
				}
			}else{
				isChildDeletedAndNeedToDeleteCurrent = this.deleteUtil(childNode, word, wordNo+1);
				if(isChildDeletedAndNeedToDeleteCurrent){
					if(childNode.isLeaf()){
						return false;
					}else if(this.hasChild(childNode)){
						return false;
					}else{
						node.getChildren()[word.charAt(wordNo)] = null;
						return true;
					}
				}
			}
		}else{
			System.out.println("\nword "+word+" doesn't exist!");
		}
		
		return false;
	}
}
