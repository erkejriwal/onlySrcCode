package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.trie;

import java.util.ArrayList;

public class SuffixTrieNode {
	private SuffixTrieNode[] children;
	private ArrayList<Integer> indexList; 
	
	public SuffixTrieNode[] getChildren() {
		return children;
	}

	public void setChildren(SuffixTrieNode[] children) {
		this.children = children;
	}

	public ArrayList<Integer> getIndexList() {
		return indexList;
	}

	public void setIndexList(ArrayList<Integer> indexList) {
		this.indexList = indexList;
	}

	public SuffixTrieNode(int index) {
		this.children = new SuffixTrieNode[256];
		this.indexList = new ArrayList<Integer>();
		this.indexList.add(index);
	}
	
	public SuffixTrieNode() {
		this.children = new SuffixTrieNode[256];
	}
}
