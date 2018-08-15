/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package everwing11;
import java.awt.image.BufferStrategy;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dipto Mondal and Masum
 */
public class Menu{
    protected JFrame menuFrame;
    protected Container contentPane;
    private Font font;
    private Graphics g;
    public static Canvas canvas;
    private  BufferStrategy buffer;
    
    private JButton newGame,about,instruction,highScore,exit;
    public Menu(){
        menuFrame = new JFrame("EverWing");
        MenuBack menuBack = new MenuBack();
        //menuFrame.add(menuBack);
        menuFrame.setPreferredSize(new Dimension(500, 500));
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setLocation(700, 250);
       //menuFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("everwingmenuback.png")))));
        contentPane = menuFrame.getContentPane();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(500, 500));
        canvas.setFocusable(false);
        menuFrame.add(canvas);
        canvas.setBackground(Color.DARK_GRAY);
        //contentPane.add(menuBack);
        
        
        loadFont();
        initButtons();
     
        menuFrame.pack();
        
    }

    public Canvas getCanvas(){
        return canvas;
    }
    
    
    private void initButtons(){
        
        
            
        newGame = new JButton("New Game");
        newGame.setBounds(200,100,140,40);
        newGame.setFont(font);
        about = new JButton("Credit");
        about.setBounds(200, 150, 140, 40);
        about.setFont(font);
        highScore = new JButton("High Scores");
        highScore.setBounds(200,200,140,40);
        highScore.setFont(font);
        instruction =new JButton("Instruction");
        instruction.setBounds(200,250, 140, 40);
        instruction.setFont(font);
        exit = new JButton("Exit");
        exit.setBounds(200, 300,140, 40);
        exit.setFont(font);
        
        
        contentPane.add(newGame);
        contentPane.add(about);
        contentPane.add(exit);
        contentPane.add(instruction);
        contentPane.add(highScore);
        
        
         //button functionality
        newGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameSetup game= new gameSetup("EverWing", 500, 500);
                menuFrame.dispose();
                game.start();
                
            }
            
           
            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
        about.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				About about = new About();
				menuFrame.dispose();
			}
		});
        
        
        
        
        
        instruction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Instruction instruction = new Instruction();
				menuFrame.dispose();
				
				
			}
		});
    
        
        
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        }
        );
        
        buffer = canvas.getBufferStrategy();
        if(buffer == null){
            getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = buffer.getDrawGraphics();
        
        g.drawImage(LoadImages.image, 50,50, 400,400,null);
        buffer.show();
        
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
