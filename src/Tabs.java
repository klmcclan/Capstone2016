import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Tabs extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int regionNum;
	
	JPanel leftEEG;
	JPanel rightEEG;
	
	public Tabs (int regionNum){
		
		this.regionNum = regionNum;
		
		if(regionNum == 0){	
			
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			
			leftEEG = new JPanel(new GridLayout(1,1));
			leftEEG.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
			leftEEG.setBorder(BorderFactory.createTitledBorder(""));
					
//			ImageIcon image = new ImageIcon("eeg_map.png");
//			JLabel label = new JLabel("", image, JLabel.CENTER);
//			leftEEG.add(label);
			
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("src/updated_eeg_map.png"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				leftEEG.add(picLabel);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			rightEEG = new JPanel();
			rightEEG.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));	
			rightEEG.setBorder(BorderFactory.createTitledBorder(""));
			JLabel right = new JLabel("EEG testing");	
			rightEEG.add(right);
			
			this.add(rightEEG);
			this.add(leftEEG);			
		}
		else {
			JLabel sector = new JLabel("Region " + regionNum);
			this.add(sector);
		}
		
	}
	
	public int getRegionNum() {

		return regionNum;
	}
	
}