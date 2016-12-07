import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.geom.*;

import javax.swing.*;

public class Tabs extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int regionNum;
	
	public Tabs (int regionNum){
		
		this.regionNum = regionNum;
		if(regionNum == 0){
			JLabel sector = new JLabel("EEG");
			this.add(sector);
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