package everwing11;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Masum Mollik
 */
public class Enemy {
    
    public boolean baal;
    private int x;
    private int y;
    public Enemy(int x , int y){
        this.x = x ;
        this.y = y;
    }
    
    public void tick(){
        y++;
        gameManager manager = new gameManager();
        if(manager.bossOneDead == true){
            y += 2;
        }
    }
    
    public void render(Graphics g){
        gameManager manager = new gameManager();
        System.out.println("boss one dead :"+manager.bossOneDead);
        if(manager.bossOneDead == false){
            g.drawImage(LoadImages.enemies, x-15, y, 70, 50, null);
        }
        else if(manager.bossOneDead == true){
            
            g.drawImage(LoadImages.enemiesTwo, x-15, y, 70, 50 ,null);
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
