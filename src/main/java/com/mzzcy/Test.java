package com.mzzcy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

/**
 * Created by changyin.zhao on 3/30/18
 */
public class Test {

    public static void main(String arg[]) {
        Iterator iter = ImageIO.getImageWritersByFormatName("jpeg");

        ImageWriter writer = (ImageWriter)iter.next();
        // instantiate an ImageWriteParam object with default compression options
        ImageWriteParam iwp = writer.getDefaultWriteParam();

        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        iwp.setCompressionQuality((float)0.3);

        try {
            for (int i = 1; i <= 100; i++) {
                long startTime = System.currentTimeMillis();
                File input = new File("/home/mzzcy/Desktop/img/" + String.format("%03d", i) + ".bmp");

                BufferedImage orginImg = ImageIO.read(input);
                File file = new File("/home/mzzcy/Desktop/jpg/" + String.format("%03d", i) + ".jpg");
                FileImageOutputStream output = new FileImageOutputStream(file);
                writer.setOutput(output);
                IIOImage image = new IIOImage(orginImg, null, null);
                writer.write(null, image, iwp);
                System.out.println(System.currentTimeMillis() - startTime);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.dispose();
        }
    }

}


