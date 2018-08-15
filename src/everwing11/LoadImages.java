package everwing11;

import com.sun.javafx.iio.ImageLoader;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Masum Mollik
 */
public class LoadImages {
    public static BufferedImage image;
    
    
    public static BufferedImage entities;
    public static BufferedImage bullets;
    public static BufferedImage enemies;
    public static BufferedImage enemiesTwo;
    public static BufferedImage fireBall;
    
    public static void init(){
        
        image =  imageLoader("game.png");
        
        
        entities = imageLoader("dragon.png");
        bullets = imageLoader("fireballf.png");
        enemies = imageLoader("everwing enemy 1.png");
        enemiesTwo = imageLoader("enemy_level3.png");
        fireBall = imageLoader("fireball11.png");
    }
    
    
    public static BufferedImage imageLoader(String path){
        try {
            return ImageIO.read(LoadImages.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(LoadImages.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        return null;
    }
}
