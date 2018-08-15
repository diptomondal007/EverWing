package everwing11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Masum Mollik & Dipto Mondal
 */
public class gameSetup implements Runnable{
    private String title;
    private int width;
    private int height;
    private Thread thread;
    private boolean running;
    private BufferStrategy buffer;
    private Graphics g;
    private int y;
    private boolean start;
    private gameManager manager;
    public static final int gameWidth = 400;
    public static final int gameheight = 400;
    public static int imageCount = 0;
    
    private Display display;
    
    public gameSetup(String title , int width , int height){
        this.height = height;
        this.title = title;
        this.width = width;
    }
    
        public void init(){
            display = new Display(title, width, height);
            LoadImages.init();
            manager = new gameManager();
            manager.init();
            start = true;
            Sound soundp = new  Sound();
        try {
            soundp.Sound();
        } catch (Exception ex) {
            Logger.getLogger(gameSetup.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
    
    public synchronized void start(){
        if(running)
            return;
        running  = true;
        if(thread == null){
        thread = new Thread(this);
        thread.start();
        }

    }
    public synchronized void stop(){
        if(!(running)) return;
        running  = false;
        try {
            thread.join();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(gameSetup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tick(){
        imageCount++;
        System.out.println("Image Count:::::::::::"+imageCount);
        if(imageCount % 830 == 0){
            Sound soundp = new  Sound();
        try {
            soundp.Sound();
        } catch (Exception ex) {
            Logger.getLogger(gameSetup.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        manager.tick();
        y+= 1;
    }
    
    public void render(){
        buffer = display.getCanvas().getBufferStrategy();
        if(buffer == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = buffer.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        // draw 
        
                    g.drawImage(LoadImages.image , 50,50, gameWidth,gameheight,null);
            
        
        
        
        manager.render(g);
        //end of draw
        
        buffer.show();
        g.dispose();
    }
    
    @Override
    public void run() {
        init();
            
        int fps = 50;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long current = System.nanoTime();
        
        while(running){
            delta = delta + (System.nanoTime() - current)/ timePerTick;
            current = System.nanoTime();
            if(delta >= 1){
                
                
            tick();
        
            render();
            delta--;
            }
        }
    }
}
