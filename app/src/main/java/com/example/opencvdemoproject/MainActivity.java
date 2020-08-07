package com.example.opencvdemoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {


    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS: {
                    Toast.makeText(getApplicationContext(), "OpenCV Loaded Successfully", Toast.LENGTH_SHORT).show();
                    break;

                }

                case LoaderCallbackInterface.MARKET_ERROR: {
                    Toast.makeText(getApplicationContext(), "Google Play Market cannot be invoked", Toast.LENGTH_SHORT).show();
                    break;
                }

                default: {
                    super.onManagerConnected(status);
                    break;
                }

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (OpenCVLoader.initDebug()) {
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        } else {
            Toast.makeText(getApplicationContext(),"OpenCV not found",Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, ShowImage.class);
        startActivity(intent);
    }
}