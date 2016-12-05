import java.awt.*;
import java.awt.geom.QuadCurve2D;

import javax.swing.*;

public class BrainPanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		g.setColor(Color.green);
		g.fillOval(0, 0, width, height);
		g.setColor(Color.black);
		g.drawOval(0, 0, width, height);
		
		g.drawLine(width/2, 0, width/2, height);
		
		QuadCurve2D q = new QuadCurve2D.Float();
		q.setCurve(0, 3*height/12, width/2, 3*height/8, width, 3*height/12);
		g2.draw(q);
		
		q.setCurve(0, 6*height/12, width/2, 5*height/8, width, 6*height/12);
		g2.draw(q);
		
		q.setCurve(0, 9*height/12, width/2, 7*height/8, width, 9*height/12);
		g2.draw(q);
		
	}
}
