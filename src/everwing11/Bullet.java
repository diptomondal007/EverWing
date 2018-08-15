package everwing11;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Masum Mollik & Dipto Mondal
 */
public class Bullet {
    
    private int x;
    private int y;
    private int speed;
    
    public Bullet(int x , int y){
        this.x = x;
        this.y = y;
        speed = 10;
    }
    public void tick(){
        y -= speed;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public void render(Graphics g){
        
        g.drawImage(LoadImages.bullets,x-30, y-40, 80, 80,null);
        
            }
}
