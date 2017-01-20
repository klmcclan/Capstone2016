package InfoBars;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar menuBar;
	JMenu mFile, mView, mActions;
	JMenuItem miSave, miExit;
	JMenuItem miStart, miStop;
	
	public MenuBar(JFrame frame) {
		menuBar = new JMenuBar();
		mFile = new JMenu("File");
		mView = new JMenu("View");
		mActions = new JMenu("Actions");
		
		miSave = new JMenuItem("Save");
		miExit = new JMenuItem("Exit");
		
		miStart = new JMenuItem("Start Recording");
		miStop = new JMenuItem("Stop Recording");
		
		miExit.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});
		
		mFile.add(miSave);
		mFile.add(miExit);
		
		mActions.add(miStart);
		mActions.add(miStop);
		
		menuBar.add(mFile);
		menuBar.add(mView);
		menuBar.add(mActions);
		
		frame.setJMenuBar(menuBar);
	}
	
	
}

