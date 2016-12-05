import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*;

import javax.swing.JPanel;

public class BrainPanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		g.setColor(Color.green);
		g.fillOval(0, 0, width, height);
		g.setColor(Color.black);
		g.drawOval(0, 0, width, height);
		
		g.drawLine(width/2, 0, width/2, height);
	}
}
