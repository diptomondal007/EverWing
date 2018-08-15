package everwing11;

import java.awt.Graphics;

/**
 *
 * @author Masum Mollik
 */
public class fireBall {
    private int x;
    private int y;
    public int init_x;
    private int health = 60;
    public fireBall(int x , int y){
        this.x = x ;
        this.y = y;
    }
    
    public void tick(){
       gameManager manager = new gameManager();
        if(manager.bossOneDead == true && manager.miniOneDead == true && gameManager.miniTwoDead == true){
            
            

                System.out.println("Fire       ::: x:"+x +" boss y:"+y);

            
                y+=2;
                
            
            
        }
    
    }
    
    public void render(Graphics g){
        if(!(health <= 0)){
            gameManager manager = new gameManager();

            g.drawImage(LoadImages.fireBall, x-15, y, 100, 80, null);
        }
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
}

