package onlySrcCode.onlySrcCodeProject.geeksforgeeksdatastructure.DataStructures.binaryTree;

import java.util.ArrayList;

public class MaxWidthBST {
	private ArrayList<Integer> levelWidths;
	private int maxWidth = 0;
	
	public ArrayList<Integer> getWidthLevels() {
		return levelWidths;
	}
	public void setWidthLevels(ArrayList<Integer> widthLevels) {
		this.levelWidths = widthLevels;
	}
	public int getMaxWidth() {
		return maxWidth;
	}
	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public MaxWidthBST() {
		this.levelWidths = new ArrayList<Integer>();
	}



	private class WidthLevel{
		private int width;
		private int level;
		
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
	}
}
