package DataStructures.trie;

public class SuffixTrie {
	private SuffixTrieNode root;

	public SuffixTrieNode getRoot() {
		return root;
	}

	public void setRoot(SuffixTrieNode root) {
		this.root = root;
	}
	
	public SuffixTrie(){
		this.root = new SuffixTrieNode();
	}
	
	public void insert(String word, int index){
		int wordlength = word.length();
		SuffixTrieNode tempNode = this.root;
		for (int i = 0; i < wordlength; i++) {
			char character = word.charAt(i);
			if(tempNode.getChildren()[character] == null){
				SuffixTrieNode newNode = new SuffixTrieNode(index);
				tempNode.getChildren()[character] = newNode;	
				tempNode = newNode;
			}else{
				tempNode = tempNode.getChildren()[character];
				tempNode.getIndexList().add(index);
			}
		}
	}
	
	public void printAllIndexesOfPattern(String pattern){
		int patternlength = pattern.length();
		SuffixTrieNode tempNode = this.root;
		for (int i = 0; i < patternlength; i++) {
			char character = pattern.charAt(i);
			if(tempNode.getChildren()[character] != null){
				tempNode = tempNode.getChildren()[character];
			}else{
				System.out.println("pattern does not exist in text");
				return;
			}
		}
		System.out.println("pattern found at index:- "+tempNode.getIndexList().toString());
	}
}
