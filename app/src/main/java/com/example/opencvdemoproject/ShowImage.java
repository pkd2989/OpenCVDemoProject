package com.example.opencvdemoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.io.IOException;

public class ShowImage extends AppCompatActivity {

    ImageView ourImage;
    Bitmap bitImage;
    Mat image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        ourImage = findViewById(R.id.ourImage);

        try {
            image = Utils.loadResource(getApplicationContext(),R.drawable.lenna);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Imgproc.cvtColor(image,image,Imgproc.COLOR_RGB2BGRA);
        // Convert Mat to Bitmap
        bitImage = Bitmap.createBitmap(image.cols(),image.rows(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(image,bitImage);

        // Set image to imageview
        ourImage.setImageBitmap(bitImage);
    }
}