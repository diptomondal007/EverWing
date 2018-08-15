package everwing11;

/**
 *
 * @author Masum Mollik
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Dipto Mondal
 */
public class MenuBack extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("img/bookie.jpg").getImage();
        int baslangcx = 0;
        int baslangcy = 0;
        g.drawImage(image,baslangcx, baslangcy,null);
        
    }
}
