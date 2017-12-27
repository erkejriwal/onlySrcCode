package onlySrcCode.onlySrcCodeProject.javapractice.javaadvanced;

import java.applet.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HelloWorldApplet extends Applet implements MouseListener {
	private StringBuffer strBuffer;

	public void paint(Graphics g) {
		  // Draw a Rectangle around the applet's display area.
	      g.drawRect(0, 0, 
	      getWidth() - 1,
	      getHeight() - 1);

	      // display the string inside the rectangle.
	      g.drawString(strBuffer.toString(), 10, 20);
	}

	public void init() {
		addMouseListener(this);
		strBuffer = new StringBuffer();
		addItem("initializing the apple ");
	}

	void addItem(String word) {
	      System.out.println(word);
	      strBuffer.append(word);
	      repaint();
	   }
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		addItem("mouse clicked! ");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}