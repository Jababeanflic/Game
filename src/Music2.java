import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music2 {
	
	void playAtatat(String musicLocation) {
		
		try 
		{
			File musicPath = new File(musicLocation);
			
			if(musicPath.exists()) 
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);	
				Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(+10f);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
                }			
			
		}catch(Exception ex) {
		ex.printStackTrace();
		}
    }
}