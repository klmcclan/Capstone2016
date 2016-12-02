import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class Launcher {
	
	private JFrame frame;
	
	// Left Panel
	JPanel leftPanel;
	JTextArea EEG1;
	JTextArea EEG2;
	
	JPanel rightPanel;
	private JPanel mainMenuPanel;
	
	final int WIDTH = 1500;
	final int HEIGHT = 1000;
	
	public Launcher() {
        frame = new JFrame();
		mainMenuPanel = initMainMenuPanel();
        
        frame.setTitle("Display Values");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainMenuPanel);
		frame.setVisible(true);
	}
	
	public JPanel initMainMenuPanel() {
		
		JPanel mainPanel = new JPanel();
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