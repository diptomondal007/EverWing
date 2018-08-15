package everwing11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Masum Mollik & Dipto Mondal
 */
public class gameManager implements KeyListener{
    private Player player;
    private miniBossOne miniOne;
    private miniBossTwo miniTwo;
    private boss bs;
    
    
    public static ArrayList<Bullet> bullet;
    private ArrayList<Enemy> enemies;
    private long current;
    private long delay;
    private int health;
    private int score;
    private boolean start;
    private int bossHealth;
    private int miniHealthOne;
    private int miniHealthTwo;
    public static boolean bossOneDead = false;
    public static boolean miniOneDead = false;
    public static boolean miniTwoDead = false;
    private boolean bossExplode = false;
    private boolean bossOneExplode = false;
    private boolean bossTwoExplode = false;
    
    
    public gameManager(){
        
    }
    public void init(){
        Display.frame.addKeyListener(this);
        player = new Player((gameSetup.gameWidth/2)+50,(gameSetup.gameheight-30)+50);
        player.init();
        bullet = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();
        bs = new boss((gameSetup.gameWidth/2)+50, 50);
        miniOne = new miniBossOne((gameSetup.gameWidth/2)+50, 50);
        miniTwo = new miniBossTwo((gameSetup.gameWidth/2)+50+3, 50);
       current = System.nanoTime();
        delay = 2000;
        health = player.getHealth();
        score  = 0;
        bossHealth = bs.getHealth();
        miniHealthOne = miniOne.getHealth();
        miniHealthTwo = miniTwo.getHealth();
        
    }
    public void render(Graphics g){
        if(start){
            System.out.println("Boss One ::::"+bossOneDead);
            System.out.println("Mini ONe ::::"+miniOneDead);
            System.out.println("mini Two ::::"+miniTwoDead);
//        g.fillRect(0, 0, 50, 80);
        player.render(g);
        for(int i = 0; i < bullet.size(); i++) {
            bullet.get(i).render(g);
        }
        for (int i = 0; i < bullet.size(); i++) {
            if(bullet.get(i).getY()<=50){
                bullet.remove(i);
                i--;
            }
        }
        
        for (int i = 0; i < enemies.size(); i++) {
            if(!(enemies.get(i).getX()<= 60|| enemies.get(i).getX()>=392 || enemies.get(i).getY()>= 450-40)){          
               if(enemies.get(i).getY()>=50){
                    enemies.get(i).render(g);
               }
            }
        }
        for (int i = 0; i < enemies.size(); i++) {
            ClashSound explode = new ClashSound();
            int ex = enemies.get(i).getX();
            int ey = enemies.get(i).getY();
            
            int px = player.getX();
                int py = player.getY();
                if(px < ex + 50 && px + 60 > ex && 
                   py < ey + 50 && py + 60 > ey && ex <= 394 && ex >= 62){
                    enemies.remove(i);
                    i--;
                    health--;
                    
                try {
                    explode.Sound();
                } catch (Exception ex1) {
                    Logger.getLogger(gameManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                    
                    System.out.println(health);
                    System.out.println(px);
                    System.out.println(ex);
                    if(health <= 0){
                        enemies.removeAll(enemies);
                        player.setHealth(0);
                    }
                }
                
            //all collisions with bullets start
            for (int j = 0; j < bullet.size(); j++) {
                //collision of enemy and player
                /*if(r1.x < r2.x+width &&
                 r1.x+width > r2.x &&
                 r1.y < r2.y + width &&
                r1.y + width > r2.y
                */
                // r1 = enemies / player
                //r2 = bullet   / enemies
                
                
                
                //collsion between enemies and bullets starts
                int bx = bullet.get(j).getX();
                int by = bullet.get(j).getY();                
                if(ex < bx + 8 && ex + 50 > bx && ey < by + 8 && ey + 50 > by){
                    enemies.remove(i);
                    i--;
                    bullet.remove(j);
                    j--;
                    try {
                    explode.Sound();
                } catch (Exception ex1) {
                    Logger.getLogger(gameManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                    score += 5;
                }
                //collsion between enemies and bullets ends
                
                //collision between boss and bullets starts
                if(bossHealth>0 && bossOneDead == false){
                    int bossX = bs.getX();
                    int bossY = bs.getY();
                    if(bossX < bx + 8 && bossX + 80 > bx && bossY < by + 8 && bossY + 80 > by){
                    bullet.remove(j);
                    j--;
                    bossHealth--;
                    bs.setHealth(bossHealth);
                    System.out.println("BOSS HEALTH REMAINING:    "+bossHealth);
                    
                }
                }
                
                
            
            
            
            
            
            
            
            
             //collision between mini_boss and bullets starts
                if(miniHealthOne>0 && bossOneDead == true && miniOneDead == false){
                    int miniOneX = miniOne.getX();
                    int miniOneY = miniOne.getY();
                    if(miniOneX < bx + 8 && miniOneX + 60 > bx && miniOneY < by + 8 && miniOneY + 60 > by){
//                    bullet.remove(j);
//                    j--;
                    miniHealthOne--;
                    miniOne.setHealth(miniHealthOne);
                    System.out.println("---miniBOSS HEALTH REMAINING:    "+bossHealth);
                    
                }
                }
                
                if(miniHealthTwo>0 && bossOneDead == true && miniTwoDead == false){
                    int miniTwoX = miniTwo.getX();
                    int miniTwoY = miniTwo.getY();
                    if(miniTwoX < bx + 8 && miniTwoX + 60 > bx && miniTwoY < by + 8 && miniTwoY + 60 > by){
                    bullet.remove(j);
                    j--;
                    miniHealthTwo--;
                    miniOne.setHealth(miniHealthTwo);
                    System.out.println("---miniBOSS HEALTH  T REMAINING:    "+miniHealthTwo);
                    
                }
                }
                //collsion between mini_boss and bullets ends

                        
            
            
            
            
            
            
            
            
              
                
                
                
            }
            
            if(bossHealth <= 0) {
                bossOneDead = true;
                if(bossExplode == false){
                    try {
                    explode.Sound();
                    bossExplode = true;
                } catch (Exception ex1) {
                    Logger.getLogger(gameManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                }
            }
            if(miniHealthOne <= 0) {
                miniOneDead = true;
                if(bossOneExplode == false){
                    try {
                    explode.Sound();
                    bossOneExplode = true;
                } catch (Exception ex1) {
                    Logger.getLogger(gameManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                }
            }
            if(miniHealthTwo <= 0) {
                miniTwoDead = true;
                if(bossTwoExplode == false){
                    try {
                    explode.Sound();
                    bossTwoExplode = true;
                } catch (Exception ex1) {
                    Logger.getLogger(gameManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                }
            }
//            System.out.println("boss one dead :"+bossOneDead);
            //all collsions with bullets end
            
            g.setColor(Color.CYAN);
            g.setFont(new Font("arial", Font.ITALIC, 40));
            g.drawString(""+score,70,50);
            
        }
        //boss generate
        if((score >= 10) && bossHealth > 0 && bossOneDead == false){
                bs.render(g);
            }
        //boss && player collision starts
        int bossX = bs.getX();
        int bossY = bs.getY();
        int px = player.getX();
        int py = player.getY();
        if(px < bossX + 70 && px + 60 > bossX && py < bossY + 70 && py + 60 > bossY){
                        health--;
                        bs.setY(85);
                        System.out.println("boss collide,,,          health :"+health);
                        if(health <= 0){
                        enemies.removeAll(enemies);
                        player.setHealth(0);
                    }
        }
        //boss && player collision ends
        
        
        
        
        
        //mini_boss generate
        if((score >= 10) && miniHealthOne > 0 && bossOneDead == true && miniOneDead == false){
                miniOne.render(g);
            }
        //mini_boss && player collision starts
        int miniOneX = miniOne.getX();
        int miniOneY = miniOne.getY();
        
        if(px < miniOneX + 50 && px + 40 > miniOneX && py < miniOneY + 50 && py + 40 > miniOneY && bossOneDead == true && miniOneDead== false){
                        health--;
                        miniOne.setY(85);
                        System.out.println("miniOneboss collide,,,          health :"+miniHealthOne);
                        if(health <= 0){
                        enemies.removeAll(enemies);
                        player.setHealth(0);
                    }
        }
        
        
        if((score >= 10) && miniHealthTwo > 0 && bossOneDead == true && miniTwoDead == false){
                miniTwo.render(g);
            }
        //mini_boss && player collision starts
        int miniTwoX = miniTwo.getX();
        int miniTwoY = miniTwo.getY();
        
        if(px < miniTwoX + 50 && px + 40 > miniTwoX && py < miniTwoY + 50 && py + 40 > miniTwoY && bossOneDead == true && miniTwoDead== false){
                        health--;
                        miniTwo.setY(85);
                        System.out.println("miniOneboss collide,,,          health :"+miniHealthTwo);
                        if(health <= 0){
                        enemies.removeAll(enemies);
                        player.setHealth(0);
                    }
        }
        //mini_boss && player collision ends
        
        
        
        
        
        }
        else{
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("arial",Font.PLAIN,33));
            g.drawString("Press enter start", 70, gameSetup.gameheight/2 +50);
            
        }
    }
    public void tick(){
        if(start){
            
            if(score>= 10 && bossHealth > 0 && bossOneDead == false){
                bs.tick();
            }
            if(score >= 10 && bossOneDead == true && miniOneDead == false){
                miniOne.tick();
            }
            if(score >= 10 && bossOneDead == true && miniTwoDead == false){
                miniTwo.tick();
            }
            player.tick();
        
        
        for(int i = 0; i < bullet.size(); i++) {
            bullet.get(i).tick();
            
        }
        
        //enemy
        if(bossOneDead == true && miniOneDead == true && miniTwoDead == true){
            delay = 1300;
        }
        long breaks = (System.nanoTime() - current)/1000000;
        if(breaks > delay){
            for(int i = 0 ; i < 2 ; i++){
            Random rand = new Random();
            int randx  = rand.nextInt(450);
            int randy = rand.nextInt(450);
            if(health > 0){
            enemies.add(new Enemy(randx, -randy));
            }
        }
            current = System.nanoTime();
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).tick();
        }
    }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int source = ke.getKeyCode();
        if(source == KeyEvent.VK_ENTER){
            start = true;
            init();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int source = ke.getKeyCode();
        if(source == KeyEvent.VK_ENTER){
            start = true;
            init();
        }
    }
    public boolean getStart(){
        return start;
    }
    public void setStart(boolean start){
        this.start = start;
    }
    public int getScore(){
        return  score;
    }
//    public boolean getBossOneDead(){
//        System.out.println(bossOneDead);
//        return bossOneDead;
//    }
//   public void setBossOneDead(boolean bossOneDead){
//       this.bossOneDead = bossOneDead;
//   }
   
}
