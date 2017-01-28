import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import InfoBars.MenuBar;
import InfoBars.StatusBar;


public class Launcher extends JPanel
{
	
	private static final long serialVersionUID = 1L;

	private JFrame frame = new JFrame();
	
	// Status Bar
	JLabel statusBar; 
	
	// Left Panel
	JPanel leftPanel;
	
	// Right Panel
	JPanel rightPanel;
	private JTabbedPane tabbedPanels;
	
	// Changed these to fit the GUI to my screen - appropriate ratio is 1.5 width/height
	final int WIDTH = 900;	
	final int HEIGHT = 700;
	
	public Launcher() {                
		MenuBar mb = new MenuBar(frame);
	    StatusBar sb = new StatusBar(frame);
	    
		tabbedPanels = initGUI();
		
        
        frame.setTitle("Display Values");
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension dim = toolkit.getScreenSize();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tabbedPanels);
		frame.setVisible(true);
		
		frame.pack();
	}
	
	
	// Building the GUI
	public JTabbedPane initGUI() {		
	
		JTabbedPane tabbedPanel = new JTabbedPane();
		tabbedPanel.setTabPlacement(JTabbedPane.BOTTOM);
		
		JPanel mainPanel = new JPanel();
		
		mainPanel = initMainPanel(mainPanel);		
		tabbedPanel.add("Main", mainPanel);
		// Creates 8 other tabs for each region
		for(int i=0; i<=8; i++) {							
			
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
	
	// Builds the main Panel
	public JPanel initMainPanel(JPanel mainPanel) {			
		
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
	
}
