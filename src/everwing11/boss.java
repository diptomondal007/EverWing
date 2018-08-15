package everwing11;

import java.awt.Graphics;

/**
 *
 * @author Masum Mollik
 */
public class boss {
    private int x;
    private int y;
    public int init_x;
    public boolean right = true;
    public boolean down = true;
    private int health = 60;
    public boss(int x , int y){
        this.x = x ;
        this.y = y;
    }
    
    public void tick(){
        if(!(health <= 0)){
            gameManager manager = new gameManager();

                System.out.println("boss x:"+x +" boss y:"+y);

            if(down){
                y+=2;
                if(y>=380){
                    down = false;
                }
            }
            if(!down){
                y-=4;
                if(y<= 80){
                    down = true;
                }
            }
            if(right){
                x += 4;
                if(x >= 394){
                    right = false;
                }
            }
            if(!right){
                x -= 4;
                if(x <= 62){
                    right = true;
                }

            }
        }
    }
    
    public void render(Graphics g){
        if(!(health <= 0)){
            gameManager manager = new gameManager();

            g.drawImage(LoadImages.enemies, x-15, y, 100, 80, null);
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

