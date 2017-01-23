import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BrainPanel extends JPanel
{
	
	private static final long serialVersionUID = 1L;

	
	public BrainPanel() {
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("src/brain_map.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			this.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		System.out.println("Is this a thing?");
//		int width = getWidth();
//		int height = getHeight();
//		
//		g.setColor(Color.green);
//		g.fillOval(0, 0, width, height);
//		g.setColor(Color.black);
//		g.drawOval(0, 0, width, height);
//		
//		g.drawLine(width/2, 0, width/2, height);
//		g.drawLine(0, height/4, width, height/4);
//		g.drawLine(0, height/2, width, height/2);
//		g.drawLine(0, 3*height/4, width, 3*height/4);
		
	}

	

}
