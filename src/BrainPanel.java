import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import BrainPanel.*;

public class BrainPanel extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage brainQ1, brainQ2, brainQ3, brainQ4, brainQ5, brainQ6, brainQ7, brainQ8;
	
	public BrainPanel() {
		//BufferedImage myPicture;
		FlowLayout layout = (FlowLayout)this.getLayout();
        layout.setVgap(0);
        layout.setHgap(0);
		
		try {
			//myPicture = ImageIO.read(new File("src/brain_map.png"));
			brainQ1 = ImageIO.read(new File("src/images/green_q1.png"));
			brainQ2 = ImageIO.read(new File("src/images/green_q2.png"));
			brainQ3 = ImageIO.read(new File("src/images/green_q3.png"));
			brainQ4 = ImageIO.read(new File("src/images/green_q4.png"));
			brainQ5 = ImageIO.read(new File("src/images/green_q5.png"));
			brainQ6 = ImageIO.read(new File("src/images/green_q6.png"));
			brainQ7 = ImageIO.read(new File("src/images/green_q7.png"));
			brainQ8 = ImageIO.read(new File("src/images/green_q8.png"));
			
			//BufferedImage region1 = myPicture.getSubimage(0, 0, myPicture.getWidth()/2, myPicture.getHeight()/4);
			//BufferedImage region2 = myPicture.getSubimage(myPicture.getWidth()/2, 0, myPicture.getWidth()/2, myPicture.getHeight()/4);
			//BufferedImage region3 = myPicture.getSubimage(0, myPicture.getHeight()/4, myPicture.getWidth()/2, myPicture.getHeight()/4);
			//BufferedImage region4 = myPicture.getSubimage(myPicture.getWidth()/2, myPicture.getHeight()/4, myPicture.getWidth()/2, myPicture.getHeight()/4);
			//BufferedImage region5 = myPicture.getSubimage(0, myPicture.getHeight()/2, myPicture.getWidth()/2, myPicture.getHeight()/4);
			//BufferedImage region6 = myPicture.getSubimage(myPicture.getWidth()/2, myPicture.getHeight()/2, myPicture.getWidth()/2, myPicture.getHeight()/4);
			//BufferedImage region7 = myPicture.getSubimage(0, myPicture.getHeight()/2 + myPicture.getHeight()/4, myPicture.getWidth()/2, myPicture.getHeight()/4);
			//BufferedImage region8 = myPicture.getSubimage(myPicture.getWidth()/2, myPicture.getHeight()/2 + myPicture.getHeight()/4, myPicture.getWidth()/2, myPicture.getHeight()/4);
			
			BufferedImage region1 = brainQ1;
			BufferedImage region2 = brainQ2;
			BufferedImage region3 = brainQ3;			
			BufferedImage region4 = brainQ4;
			BufferedImage region5 = brainQ5;
			BufferedImage region6 = brainQ6;
			BufferedImage region7 = brainQ7;
			BufferedImage region8 = brainQ8;
			
			
			ImageIcon iiRegion1 = new ImageIcon(region1);
			ImageIcon iiRegion2 = new ImageIcon(region2);
			ImageIcon iiRegion3 = new ImageIcon(region3);
			ImageIcon iiRegion4 = new ImageIcon(region4);
			ImageIcon iiRegion5 = new ImageIcon(region5);
			ImageIcon iiRegion6 = new ImageIcon(region6);
			ImageIcon iiRegion7 = new ImageIcon(region7);
			ImageIcon iiRegion8 = new ImageIcon(region8);
			
			
			JLabel jlRegion1 = new JLabel(iiRegion1);
			JLabel jlRegion2 = new JLabel(iiRegion2);
			JLabel jlRegion3 = new JLabel(iiRegion3);
			JLabel jlRegion4 = new JLabel(iiRegion4);
			JLabel jlRegion5 = new JLabel(iiRegion5);
			JLabel jlRegion6 = new JLabel(iiRegion6);
			JLabel jlRegion7 = new JLabel(iiRegion7);
			JLabel jlRegion8 = new JLabel(iiRegion8);
			
			
			jlRegion1.addMouseListener(new mlRegion1());
			jlRegion2.addMouseListener(new mlRegion2());
			jlRegion3.addMouseListener(new mlRegion3());
			jlRegion4.addMouseListener(new mlRegion4());
			jlRegion5.addMouseListener(new mlRegion5());
			jlRegion6.addMouseListener(new mlRegion6());
			jlRegion7.addMouseListener(new mlRegion7());
			jlRegion8.addMouseListener(new mlRegion8());
			
			
			this.add(jlRegion1);
			this.add(jlRegion2);
			this.add(jlRegion3);
			this.add(jlRegion4);
			this.add(jlRegion5);
			this.add(jlRegion6);
			this.add(jlRegion7);
			this.add(jlRegion8);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);		
	}

}
