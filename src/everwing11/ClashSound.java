package everwing11;

import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Masum Mollik & Dipto Mondal
 */
public class ClashSound {
    public void Sound() throws Exception
{

String file = "src/everwing11/Explosion.wav";
InputStream in = new FileInputStream(file);

AudioStream audioStream = new AudioStream(in);

AudioPlayer.player.start(audioStream);

}
}
    
    
    




