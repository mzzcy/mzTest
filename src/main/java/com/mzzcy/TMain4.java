package com.mzzcy;

import static org.bytedeco.opencv.helper.opencv_imgcodecs.cvLoadImage;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;

/**
 * @author changyin.zhao on 6/12/19
 */
public class TMain4 {
    public static void main(String []args)
    {
        Function<Integer,Integer> A=i->i+1;
        Function<Integer,Integer> B=i->i*i;
        System.out.println("F1:"+B.apply(A.apply(5)));
        System.out.println("F1:"+B.compose(A).apply(5));
        System.out.println("F2:"+A.apply(B.apply(5)));
        System.out.println("F2:"+B.andThen(A).apply(5));
    }
    public static void convertJPGtoMovie(ArrayList<String> links, String vidPath)
    {
        OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(vidPath,640,720);
        try {
            recorder.setFrameRate(1);
            recorder.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4);
            recorder.setVideoBitrate(9000);
            recorder.setFormat("mp4");
            recorder.setVideoQuality(0); // maximum quality
            recorder.start();
            for (int i=0;i<links.size();i++)
            {
                recorder.record(grabberConverter.convert(cvLoadImage(links.get(i))));
            }
            recorder.stop();
        }
        catch (org.bytedeco.javacv.FrameRecorder.Exception e){
            e.printStackTrace();
        }
    }
}
