package com.mzzcy;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

/**
 * Created by changyin.zhao on 11/2/18
 */
public class TMain2 {

  private static Dimension screenBounds;
  public static int indexVideo = 1;
  private static final double FRAME_RATE = 50;

  private static final int SECONDS_TO_RUN_FOR = 20;
  private static final String OUTPUT_FILE = "/home/mzzcy/Desktop/V001.mp4";

  public static void main(String[] args) {
    final IMediaWriter writer = ToolFactory.makeWriter(OUTPUT_FILE);
    screenBounds = Toolkit.getDefaultToolkit().getScreenSize();
    writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_MP4ALS,
        screenBounds.width / 2, screenBounds.height / 2);
    long startTime = System.nanoTime();

    for (int index = 1; index <= 100; index++) {

      BufferedImage bgrScreen = getVideoImage();
      System.out.println("time stamp = "+ (System.nanoTime() - startTime));
      bgrScreen = convertToType(bgrScreen, BufferedImage.TYPE_3BYTE_BGR);
      // encode the image to stream #0
      //writer.encodeVideo(0, bgrScreen, (System.nanoTime() - startTime)/2,TimeUnit.NANOSECONDS);
      // encode the image to stream #0
      writer.encodeVideo(0, bgrScreen, System.nanoTime() - startTime,
          TimeUnit.NANOSECONDS);
      // sleep for frame rate milliseconds
      try {
        Thread.sleep((long) (100));
      } catch (InterruptedException e) {
        // ignore
      }
    }
    writer.close();
  }

  private static BufferedImage getVideoImage() {
//    File imgLoc = new File("/home/mzzcy/Desktop/img/" + String.format("%03d", indexVideo) + ".bmp");

    File imgLoc = new File("/home/mzzcy/Desktop/jpg/" + String.format("%03d", indexVideo) + ".jpg");
    BufferedImage img = null;
    try {
      img = ImageIO.read(imgLoc);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(imgLoc.getName());
    indexVideo++;
    return img;
  }

  public static BufferedImage convertToType(BufferedImage sourceImage,
      int targetType) {

    BufferedImage image;

    // if the source image is already the target type, return the source
    // image
    if (sourceImage.getType() == targetType) {
      image = sourceImage;
    }
    // otherwise create a new image of the target type and draw the new
    // image
    else {
      image = new BufferedImage(sourceImage.getWidth(),
          sourceImage.getHeight(), targetType);
      image.getGraphics().drawImage(sourceImage, 0, 0, null);
    }

    return image;

  }


}
