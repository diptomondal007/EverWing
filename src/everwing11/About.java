package everwing11;

/**
 *
 * @author Masum Mollik
 */
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;

public class About {

	protected JFrame insframe;
	private Font font;
	private JButton back;
	protected Container content;
	public About() {
		insframe = new JFrame("EverWing");
		About_image about_image= new About_image();
		insframe.add(about_image);
		insframe.setSize(500, 500);
		insframe.setVisible(true);
		insframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insframe.setLocation(700, 250);
		content = insframe.getContentPane();
		content.setLayout(null);
		loadFont();
		initButtons();
		
		
	}

	
	private void initButtons() {
		back = new JButton("Back");
		back.setBounds(20,20,100,30);
		back.setFont(font);
		
		content.add(back);
		back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new Menu();
				insframe.dispose();
			}
		});
	}
	
	

    private void loadFont(){
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/everwing11/font.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, fis);
            font = font.deriveFont(Font.BOLD, 15);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}
