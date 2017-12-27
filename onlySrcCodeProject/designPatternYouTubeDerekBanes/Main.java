package onlySrcCode.onlySrcCodeProject.designPatternYouTubeDerekBanes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		String input = JOptionPane.showInputDialog(frame, "please enter");
		JOptionPane.showOptionDialog(frame, "select", input, 2,3, null, null, null);
		System.out.println(input);
	}

}
