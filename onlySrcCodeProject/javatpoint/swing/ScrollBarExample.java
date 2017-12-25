package javatpoint.swing;

import javax.swing.*;

public class ScrollBarExample {
	ScrollBarExample() {

		JFrame f = new JFrame();
		final JLabel label = new JLabel();
		label.setSize(500, 100);
		JButton b = new JButton("Show");
		b.setBounds(200, 150, 80, 30);
		DefaultListModel<String> l1 = new DefaultListModel<>();
		l1.addElement("C");
		l1.addElement("C++");
		l1.addElement("Java");
		l1.addElement("PHP");
		l1.addElement("C");
		l1.addElement("C++");
		l1.addElement("Java");
		l1.addElement("PHP");
		l1.addElement("C");
		l1.addElement("C++");
		l1.addElement("Java");
		l1.addElement("PHP");
		l1.addElement("C");
		l1.addElement("C++");
		l1.addElement("Java");
		l1.addElement("PHP");
		final JList<String> list1 = new JList<>(l1);
		list1.setBounds(100, 100, 75, 975);

		f.add(list1);
		f.add(b);
		f.add(label);
		f.setSize(450, 450);
		f.setLayout(null);
		f.setVisible(true);

		JScrollPane s = new JScrollPane();
		s.setViewportView(list1);
		s.setBounds(300, 100, 50, 100);
		f.add(s);
		f.setSize(600, 400);
		
		
		
		JMenu jMenu = new JMenu("Menu");
		JMenuItem item1 = new JMenuItem("1");
		JMenuItem item2 = new JMenuItem("2");
		JMenuItem item3 = new JMenuItem("3");
		JMenuItem item4 = new JMenuItem("4");
		JMenuItem item5 = new JMenuItem("5");
		JMenuItem item6 = new JMenuItem("6");
		jMenu.add(item1);
		jMenu.add(item2);
		jMenu.add(item3);
		JMenu subMenu = new JMenu("sub menu");
		jMenu.add(subMenu);
		subMenu.add(item4);
		subMenu.add(item5);
		subMenu.add(item6);
		subMenu.add(item4);
		subMenu.add(item5);
		subMenu.add(item6);
		for (int i = 30; i < 50; i++) {
			subMenu.add(new JMenuItem("My Name"+i));
		}
		
		
		/*JScrollPane s2 = new JScrollPane();
		s2.setViewportView(subMenu);
		s2.setBounds(300, 100, 50, 100);
		//f.add(s2);
		jMenu.add(s2);*/
		MenuScroller.setScrollerFor(subMenu,10);
		subMenu.add(new JMenuItem(""+55));

		JMenuBar bar = new JMenuBar();
		bar.add(jMenu);
		f.setJMenuBar(bar);
		
		
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new ScrollBarExample();
	}
}
