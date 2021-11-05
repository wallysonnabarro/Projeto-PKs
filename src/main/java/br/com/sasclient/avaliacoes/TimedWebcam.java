package br.com.sasclient.avaliacoes;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.github.sarxos.webcam.Webcam;
import java.util.concurrent.TimeUnit;

public class TimedWebcam {

    private final Webcam webcam = Webcam.getDefault();

    public TimedWebcam() {
        this.webcam.setViewSize(new Dimension(640, 480));
    }

    public void take(int times, int internalInSeconds, String folder) {
        this.webcam.open();
        for (Integer i = 0; i < times; i++) {
            try {
                System.out.println("Saving image " + i.toString() + '.');
                TimeUnit.SECONDS.sleep(internalInSeconds);
                ImageIO.write(webcam.getImage(), "PNG", new File(folder + "\\image" + i.toString() + ".png"));
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
        this.webcam.close();
    }

}