package InfoBars;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class StatusBar extends JFrame implements ActionListener
{
  JLabel lTime;
  SimpleDateFormat sdf = new SimpleDateFormat( "MMM dd yyyy hh:mm:ss" );
  
  public StatusBar(JFrame frame)
  {
    lTime = new JLabel( sdf.format( new GregorianCalendar().getTime() ) );
    lTime.setHorizontalAlignment( JLabel.RIGHT );
    frame.add( lTime, BorderLayout.SOUTH );
    Timer timer = new Timer( 1000, this );
    timer.start();
  }
  
  public void actionPerformed( ActionEvent ae )
  {
    lTime.setText( sdf.format( new GregorianCalendar().getTime() ) );
  }
}