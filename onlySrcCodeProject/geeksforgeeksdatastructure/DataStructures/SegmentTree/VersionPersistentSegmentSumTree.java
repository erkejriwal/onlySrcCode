package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.SegmentTree;

import java.util.ArrayList;
import java.util.List;

public class VersionPersistentSegmentSumTree {
	private Node[] versions;
	private int noOfLeafs;
	private int latestVersion;

	public VersionPersistentSegmentSumTree(int[] inputArray,int totalVersions) {
		versions = new Node[totalVersions];
		this.noOfLeafs = inputArray.length;
		this.latestVersion = 0;
		versions[0]=this.constructSegmentTree(inputArray, 0, noOfLeafs-1);
	}

	private Node constructSegmentTree(int[] inputArray,
			int originalArrayStartIndex, int originalArrayEndIndex) {
		if (originalArrayStartIndex == originalArrayEndIndex) {
			return new Node(inputArray[originalArrayStartIndex]);
		}
		int mid = (originalArrayStartIndex + originalArrayEndIndex) / 2;

		Node left= this.constructSegmentTree(
				inputArray, originalArrayStartIndex, mid);
		Node right= this.constructSegmentTree(
				inputArray, mid+1, originalArrayEndIndex);
		return new Node(left.getData()+right.getData(), left, right);
	}
	
	public int findSum(int versionNo, int queryStartIndex, int queryEndIndex) {
		if(versionNo > this.latestVersion || versionNo < 0){
			System.out.println("wrong version entered, till now we have versions from 0 to " +latestVersion);
			return 0;
		}
		return this.findSumUtil(queryStartIndex, queryEndIndex, 0,
				this.noOfLeafs - 1,this.versions[versionNo]);
	}

	private int findSumUtil(int queryStartIndex, int queryEndIndex,
			int originalArrayStartIndex, int originalArrayEndIndex, Node root) {
		if (root == null || originalArrayEndIndex < queryStartIndex
				|| queryEndIndex < originalArrayStartIndex) {
			return 0;
		}
		if (queryStartIndex <= originalArrayStartIndex
				&& queryEndIndex >= originalArrayEndIndex) {
			return root.getData();
		}
		int mid = (originalArrayStartIndex + originalArrayEndIndex) / 2;
		return this.findSumUtil(queryStartIndex, queryEndIndex,
				originalArrayStartIndex, mid, root.getLeft())
				+ this.findSumUtil(queryStartIndex, queryEndIndex, mid + 1,
						originalArrayEndIndex, root.getRight());
	}
	
	public void updateValue(int updateDifference, int updationIndex) {
		this.latestVersion++;
		this.versions[latestVersion] = 
		this.updateValueUtil(updateDifference, updationIndex, 0,
				this.noOfLeafs - 1, this.versions[latestVersion-1]);
	}

	private Node updateValueUtil(int updateDifference, int updationIndex,
			int originalArrayStartIndex, int originalArrayEndIndex, Node root) {
		if (updationIndex < originalArrayStartIndex
				|| originalArrayEndIndex < updationIndex) {
			return root;
		} 
		if (originalArrayStartIndex == originalArrayEndIndex) {
			Node newNode = new Node(root.getData()+updateDifference);
			return newNode;
		}

		Node left = null, right = null;
		int mid = (originalArrayEndIndex + originalArrayStartIndex) / 2;
		left = this.updateValueUtil(updateDifference, updationIndex,
				originalArrayStartIndex, mid,
				root.getLeft());
		right = this.updateValueUtil(updateDifference, updationIndex, mid + 1,
				originalArrayEndIndex, root.getRight());
	
		Node newNode = new Node(left.getData()+right.getData(),left,right);
		return newNode;
	}
	
}
