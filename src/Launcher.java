import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;


public class Launcher extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	
	menuBar = new JMenuBar();
	
	//Build the first menu.
	menu = new JMenu("A Menu");
	menu.setMnemonic(KeyEvent.VK_A);
	menu.getAccessibleContext().setAccessibleDescription(
	        "The only menu in this program that has menu items");
	menuBar.add(menu);

	//a group of JMenuItems
	menuItem = new JMenuItem("A text-only menu item",
	                         KeyEvent.VK_T);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(
	        KeyEvent.VK_1, ActionEvent.ALT_MASK));
	menuItem.getAccessibleContext().setAccessibleDescription(
	        "This doesn't really do anything");
	menu.add(menuItem);

	menuItem = new JMenuItem("Both text and icon",
	                         new ImageIcon("images/middle.gif"));
	menuItem.setMnemonic(KeyEvent.VK_B);
	menu.add(menuItem);

	menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
	menuItem.setMnemonic(KeyEvent.VK_D);
	menu.add(menuItem);

	//a group of radio button menu items
	menu.addSeparator();
	ButtonGroup group = new ButtonGroup();
	rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
	rbMenuItem.setSelected(true);
	rbMenuItem.setMnemonic(KeyEvent.VK_R);
	group.add(rbMenuItem);
	menu.add(rbMenuItem);

	rbMenuItem = new JRadioButtonMenuItem("Another one");
	rbMenuItem.setMnemonic(KeyEvent.VK_O);
	group.add(rbMenuItem);
	menu.add(rbMenuItem);

	//a group of check box menu items
	menu.addSeparator();
	cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
	cbMenuItem.setMnemonic(KeyEvent.VK_C);
	menu.add(cbMenuItem);

	cbMenuItem = new JCheckBoxMenuItem("Another one");
	cbMenuItem.setMnemonic(KeyEvent.VK_H);
	menu.add(cbMenuItem);

	//a submenu
	menu.addSeparator();
	submenu = new JMenu("A submenu");
	submenu.setMnemonic(KeyEvent.VK_S);

	menuItem = new JMenuItem("An item in the submenu");
	menuItem.setAccelerator(KeyStroke.getKeyStroke(
	        KeyEvent.VK_2, ActionEvent.ALT_MASK));
	submenu.add(menuItem);

	menuItem = new JMenuItem("Another item");
	submenu.add(menuItem);
	menu.add(submenu);

	//Build second menu in the menu bar.
	menu = new JMenu("Another Menu");
	menu.setMnemonic(KeyEvent.VK_N);
	menu.getAccessibleContext().setAccessibleDescription(
	        "This menu does nothing");
	menuBar.add(menu);
	
	// Left Panel
	JPanel leftPanel;
	
	// Right Panel
	JPanel rightPanel;
	private JTabbedPane tabbedPanels;
	
	final int WIDTH = 900;		// Changed these to fit the GUI to my screen - appropriate ratio is 1.5 width/height
	final int HEIGHT = 600;
	
	public Launcher() {
        frame = new JFrame();
		tabbedPanels = initGUI();
        
        frame.setTitle("Display Values");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tabbedPanels);
		frame.setVisible(true);
	}
		
	public JTabbedPane initGUI() {		// Building the GUI
	
		JTabbedPane tabbedPanel = new JTabbedPane();
		tabbedPanel.setTabPlacement(JTabbedPane.BOTTOM);
		
		JPanel mainPanel = new JPanel();
		
		mainPanel = initMainPanel(mainPanel);		
		tabbedPanel.add("Main", mainPanel);
		
		for(int i=0; i<=8; i++) {							// Creates 8 other tabs for each region
			
			if(i == 0) {
				JPanel panel = new Tabs(i);
				tabbedPanel.add("EEG", panel);
			}
			else {
				JPanel panel = new Tabs(i);
				tabbedPanel.add("Region " + i, panel);
			}
		}
		
		return tabbedPanel; 
	} 
	
	public JPanel initMainPanel(JPanel mainPanel) {			// Builds the main Panel
	
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
				
		leftPanel = new JPanel(new GridLayout(1,1));
		leftPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
		leftPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		BrainPanel test = new BrainPanel();
		leftPanel.add(test);
		
		rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));	
		rightPanel.setBorder(BorderFactory.createTitledBorder(""));
		JLabel right = new JLabel("right testing");	
		rightPanel.add(right);
		
		mainPanel.add(rightPanel);
		mainPanel.add(leftPanel);
		
		return mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("this is sort of working?");
	}
	
}
