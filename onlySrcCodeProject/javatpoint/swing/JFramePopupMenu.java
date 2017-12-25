//package javatpoint.swing;
//
//import java.awt.Component;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//
//public class JFramePopupMenu extends JFrame  {
//	private JPanel jContentPane = null;
//	private JButton jbnPopup = null;
//	private JTextField jtfNumOfMenus = null;
//	private JLabel lblNumElem = null;
//
//    private XJPopupMenu scrollablePopupMenu = new XJPopupMenu(this);
//    private JButton getBtnPopup() {
//
//        if (jbnPopup == null) {
//            jbnPopup = new JButton();
//            jbnPopup.setText("View Scrollable popup menu ");
//            int n = Integer.parseInt(getTxtNumElem().getText());
//
//            for (int i=0;i&lt;n;i++){
//            	XCheckedButton xx = new XCheckedButton(" JMenuItem  " + (i+1));
//                xx.addActionListener(new ActionListener(){
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println( e );
//                        scrollablePopupMenu.hidemenu();
//                    }
//
//                });
//
//                // Add Custom JSeperator after 2nd and 7th MenuItem.
//                if(i == 2 || i == 7){
//                	scrollablePopupMenu.addSeparator();
//                }
//                scrollablePopupMenu.add(xx);
//            }
//
//            jbnPopup.addMouseListener(new MouseAdapter() {
//                public void mousePressed(MouseEvent e) {
//                	Component source = (Component) e.getSource();
//                	scrollablePopupMenu.show(source, e.getX(), e.getY());
//				}
//            });
//        }
//
//        return jbnPopup;
//    }
//
//	private JTextField getTxtNumElem() {
//		if (jtfNumOfMenus == null) {
//			jtfNumOfMenus = new JTextField();
//			jtfNumOfMenus.setColumns(3);
//			jtfNumOfMenus.setText("60");
//		}
//		return jtfNumOfMenus;
//	}
//
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//			   JFramePopupMenu thisClass = new JFramePopupMenu();
//  		            thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			    thisClass.setVisible(true);
//			}
//		});
//	}
//
//	public JFramePopupMenu() {
//		super();
//		initialize();
//	}
//
//	private void initialize() {
//		this.setSize(274, 109);
//		this.setContentPane(getJContentPane());
//		this.setTitle(" Scrollable JPopupMenu ");
//	}
//
//	private JPanel getJContentPane() {
//		if (jContentPane == null) {
//			lblNumElem = new JLabel();
//			FlowLayout flowLayout = new FlowLayout();
//			flowLayout.setHgap(8);
//			flowLayout.setVgap(8);
//			jContentPane = new JPanel();
//			jContentPane.setLayout(flowLayout);
//			jContentPane.add(getBtnPopup(), null);
//			jContentPane.add(lblNumElem, null);
//			jContentPane.add(getTxtNumElem(), null);
//		}
//
//		return jContentPane;
//	}
//}
//
//class XCheckedButton extends JButton {
//	//	Icon to be used to for the Checked Icon of the Button
//	private static ImageIcon	checkedIcon;
//	
//         /**
//	 * These colors are required in order to simulate the JMenuItem's L&amp;F
//	 */
//
//	public static final Color MENU_HIGHLIGHT_BG_COLOR = UIManager.getColor
//             ("MenuItem.selectionBackground");
//	public static final Color MENU_HIGHLIGHT_FG_COLOR = UIManager.getColor
//              ("MenuItem.selectionForeground");
//	public static final Color MENUITEM_BG_COLOR = UIManager.getColor
//              ("MenuItem.background");
//	public static final Color MENUITEM_FG_COLOR = UIManager.getColor
//              ("MenuItem.foreground");
//
//	//  This property if set to false, will result in the checked Icon not being 
//        //   displayed  when the button is selected
//	   private boolean displayCheck	= true;
//	   public XCheckedButton() {
//		super();
//		init();
//	}
//
//	public XCheckedButton(Action a) {
//		super(a);
//		init();
//	}
//
//	public XCheckedButton(Icon icon) {
//		super(icon);
//		init();
//	}
//
//	public XCheckedButton(String text, Icon icon) {
//		super(text, icon);
//		init();
//	}
//
//	public XCheckedButton(String text) {
//		super(text);
//		init();
//	}
//	/**
//	 * Initialize component LAF and add Listeners
//	 */
//
//	private void init() {
//		MouseAdapter mouseAdapter = getMouseAdapter();
//		// Basically JGoodies LAF UI for JButton does not allow
//                   Background color to be set.
//  
//		// So we need to set the default UI, 
//
//		ComponentUI ui = BasicButtonUI.createUI(this);
//		this.setUI(ui);
//		setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 2));
//
//		setMenuItemDefaultColors();
//
//		// setContentAreaFilled(false);
//		setHorizontalTextPosition(SwingConstants.RIGHT);
//		setHorizontalAlignment(SwingConstants.LEFT);
//
//		//  setModel(new JToggleButton.ToggleButtonModel());
//		setModel(new XCheckedButtonModel());
//		setSelected(false);
//		this.addMouseListener(mouseAdapter);
//	}
//
//	private void setMenuItemDefaultColors() {
//		XCheckedButton.this.setBackground(MENUITEM_BG_COLOR);
//		XCheckedButton.this.setForeground(MENUITEM_FG_COLOR);
//	}
//
//	/**
//	 * @return
//	 */
//
//	private MouseAdapter getMouseAdapter() {
//		return new MouseAdapter() {
//
//        // For static menuitems, the background color remains the highlighted color,
//           if this is not overridden
//
//			public void mousePressed(MouseEvent e) {
//				setMenuItemDefaultColors();
//			}
//
//			public void mouseEntered(MouseEvent e) {
//				XCheckedButton.this.setBackground(MENU_HIGHLIGHT_BG_COLOR);
//				XCheckedButton.this.setForeground(MENU_HIGHLIGHT_FG_COLOR);
//			}
//
//			public void mouseExited(MouseEvent e) {
//				setMenuItemDefaultColors();
//			}
//		};
//	}
//
//	/**	 * @param checkedFlag
//
//	 */
//
//	public void displayIcon(boolean checkedFlag) {
//		if (checkedFlag &amp;&amp; isDisplayCheck()) {
//			if (checkedIcon == null) {
//				checkedIcon = new ImageIcon("check.gif");
//			}
//			this.setIcon(checkedIcon);
//		} else {
//			this.setIcon(XConstant.EMPTY_IMAGE_ICON);
//		}
//		this.repaint();
//	}
//	private class XCheckedButtonModel extends JToggleButton.ToggleButtonModel {
//		/*
//		 * Need to Override keeping the super code, else the check mark won't come  
//		 */
//
//		public void setSelected(boolean b) {
//			ButtonGroup group = getGroup();
//			if (group != null) {
//				// use the group model instead
//				group.setSelected(this, b);
//				b = group.isSelected(this);
//			}
//			if (isSelected() == b) {
//				return;
//			}
//
//			if (b) {
//				stateMask |= SELECTED;
//			} else {
//				stateMask &amp;= ~SELECTED;
//			}
//
//			//	Send ChangeEvent
//			fireStateChanged();
//			// Send ItemEvent
//			fireItemStateChanged(new ItemEvent(this, ItemEvent.ITEM_STATE_CHANGED, 
//                          this,this.isSelected() ? ItemEvent.SELECTED : ItemEvent.DESELECTED));
//			XCheckedButton.this.displayIcon(b);
//		}
//	}
//
//       // Returns true if Button will display Checked Icon on Click. Default Behaviour is 
//       // to display a Checked Icon  
//
//	public boolean isDisplayCheck() {
//		return displayCheck;
//	}
//
//	/**
//	 * Sets the property which determines whether a checked Icon should be displayed or not
//	 * Setting to false, makes this button display like a normal button 
//	 * @param displayCheck
//	 */
//
//	public void setDisplayCheck(boolean displayCheck) {
//		this.displayCheck = displayCheck;
//	}
//}
