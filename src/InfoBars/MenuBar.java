package InfoBars;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar menuBar;
	JMenu mFile, mView, mActions;
	JMenuItem miSave, miExit;
	JMenuItem miStart, miStop;
	
	private String fileName = new String();
	BufferedWriter writer;

	
	public MenuBar(JFrame frame) {
		menuBar = new JMenuBar();
		mFile = new JMenu("File");
		mView = new JMenu("View");
		mActions = new JMenu("Actions");
		
		miSave = new JMenuItem("Save");
		miExit = new JMenuItem("Exit");
		
		miStart = new JMenuItem("Start Recording");
		miStop = new JMenuItem("Stop Recording");
		

		
		try{
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fart.txt"), "utf-8"));
		}
		catch (Exception e) {System.out.println("Terrible error");}
		
		miExit.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});
		
		miStart.addActionListener((ActionEvent event) -> {
			String fName = new String();
			String lName = new String();
			String ssn = new String();
			// The following should probably become a single prompt in the future
			fName = JOptionPane.showInputDialog(this, "First Name:");
			lName = JOptionPane.showInputDialog(this, "Last Name:");
			ssn = JOptionPane.showInputDialog(this, "Social Security Number:");
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String fileTime = new SimpleDateFormat("MMM dd yyyy 'at' HH:mm:ss").format(new Date());
			fileName = "./src/patients/" + fName + "_" + lName + "_" + timeStamp + ".txt";
			
			try {
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
				writer.write("Patient: " + fName + " " + lName);
				writer.newLine();
				writer.write("SSN: " + ssn);
				writer.newLine();
				writer.write("Start Recording: " + fileTime);
				writer.newLine();
				writer.write("--------------------------------------------------------------------------------------------");
				writer.newLine();
				writer.close();
			}
			catch (Exception e) {}
		});
		
		miStop.addActionListener((ActionEvent event) -> {
			String fileTime = new SimpleDateFormat("MMM dd yyyy 'at' HH:mm:ss").format(new Date());
			try{
				FileWriter fstream = new FileWriter(fileName, true);
				writer = new BufferedWriter(fstream);
				writer.write("--------------------------------------------------------------------------------------------");
				writer.newLine();
				writer.write("End Recording: " + fileTime);
				writer.close();
			}
			catch (Exception e) {}
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

