import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import BrainPanel.*;

public class BrainPanel extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	public BrainPanel(JTabbedPane tabbed) {
		BufferedImage myPicture;
		JPanel image = new JPanel();
		image.setLayout(new GridLayout (4, 2, 0, 0));
		
		try {
			myPicture = ImageIO.read(new File("src/brain_map.png"));

			Image tmp = myPicture.getScaledInstance(800, 1000, Image.SCALE_SMOOTH);
			BufferedImage dimg = new BufferedImage(800, 1000, BufferedImage.TYPE_INT_ARGB);
			
			Graphics2D g2d = dimg.createGraphics();
			g2d.drawImage(tmp, 0, 0, null);
			g2d.dispose();
			
			ArrayList<BufferedImage> abiRegions = new ArrayList<BufferedImage>();
			ArrayList<ImageIcon> aiRegions = new ArrayList<ImageIcon>();
			ArrayList<JLabel> ajlRegions = new ArrayList<JLabel>();
			abiRegions.add(dimg.getSubimage(0, 0, dimg.getWidth()/2, dimg.getHeight()/4));
			abiRegions.add(dimg.getSubimage(dimg.getWidth()/2, 0, dimg.getWidth()/2, dimg.getHeight()/4));
			abiRegions.add(dimg.getSubimage(0, dimg.getHeight()/4, dimg.getWidth()/2, dimg.getHeight()/4));
			abiRegions.add(dimg.getSubimage(dimg.getWidth()/2, dimg.getHeight()/4, dimg.getWidth()/2, dimg.getHeight()/4));
			abiRegions.add(dimg.getSubimage(0, dimg.getHeight()/2, dimg.getWidth()/2, dimg.getHeight()/4));
			abiRegions.add(dimg.getSubimage(dimg.getWidth()/2, dimg.getHeight()/2, dimg.getWidth()/2, dimg.getHeight()/4));
			abiRegions.add(dimg.getSubimage(0, dimg.getHeight()/2 + dimg.getHeight()/4, dimg.getWidth()/2, dimg.getHeight()/4));
			abiRegions.add(dimg.getSubimage(dimg.getWidth()/2, dimg.getHeight()/2 + dimg.getHeight()/4, dimg.getWidth()/2, dimg.getHeight()/4));
			for (BufferedImage region : abiRegions) {
				aiRegions.add(new ImageIcon(region));
			}
			for(ImageIcon region: aiRegions) {
				ajlRegions.add(new JLabel(region));
			}
			for(int i = 0; i < ajlRegions.size(); i++) {
				ajlRegions.get(i).addMouseListener(new mlRegion(tabbed, i));
				image.add(ajlRegions.get(i));
			}
 			this.add(image);
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
