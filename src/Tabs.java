import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.geom.*;

import javax.swing.*;

/**
 * We can add whatever functionality we need her to display in the tabs.
 */

public class Tabs extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int regionNum;
	
	public Tabs (int regionNum){
		
		this.regionNum = regionNum;
		JLabel sector = new JLabel("Region " + regionNum);
		this.add(sector);
	}
	
	public int getRegionNum() {

		return regionNum;
	}
	
}