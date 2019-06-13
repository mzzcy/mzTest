package com.mzzcy;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Vector;
import javax.media.MediaLocator;

/**
 * Created by changyin.zhao on 11/2/18
 */
public class TMain {

    public static final File dir = new File("/home/mzzcy/Desktop/img/");
    public static final String[] extensions = new String[]{"bmp"};
    public static final FilenameFilter imageFilter = new FilenameFilter() {
        @Override
        public boolean accept(final File dir, String name) {
            for (final String ext : extensions) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public static void main(String[] args) throws IOException {
        File file = new File("/home/mzzcy/Desktop/a.mp4");
        if (!file.exists()) {
            file.createNewFile();
        }
        Vector<String> imgLst = new Vector<>();
        if (dir.isDirectory()) {
            int counter = 1;
            for (final File f : dir.listFiles(imageFilter)) {
                imgLst.add(f.getAbsolutePath());

            }
        }
        makeVideo("file:\\" + file.getAbsolutePath(), imgLst);
    }

    public static void makeVideo(String fileName, Vector imgLst) throws MalformedURLException {
        JpegImagesToMovie2 imageToMovie = new JpegImagesToMovie2();
        MediaLocator oml;
        if ((oml = JpegImagesToMovie2.createMediaLocator(fileName)) == null) {
            System.err.println("Cannot build media locator from: " + fileName);
            System.exit(0);
        }
        int interval = 40;
        imageToMovie.doIt(720, 360, (1000 / interval), imgLst, oml);
    }


}
