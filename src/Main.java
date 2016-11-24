import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Main {
   private static int index = 0;

   public static void main(String args[]) {

      final String[] numbers = { "one", "two", "three", "four", "five" };
      final JLabel numToDisplay = new JLabel("", SwingConstants.CENTER);

      // Initiate JFrame
      JFrame frame = new JFrame("Counting Application");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setSize(screenSize.width,screenSize.height);       
      frame.setVisible(true);
      frame.add(numToDisplay);
      numToDisplay.setText(numbers[index]);
      frame.setVisible(true);
      int delay = 1000;
      new Timer(delay, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            index++;
            if (index >= numbers.length) {
               ((Timer) e.getSource()).stop();
            } else {
               numToDisplay.setText(numbers[index]);
            }
         }
      }).start();

   }
}