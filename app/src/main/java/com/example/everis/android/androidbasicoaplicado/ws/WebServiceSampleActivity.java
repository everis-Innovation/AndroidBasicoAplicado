package com.example.everis.android.androidbasicoaplicado.ws;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.everis.android.androidbasicoaplicado.R;

public class WebServiceSampleActivity extends AppCompatActivity {

    private final static String URL_LOGO = "https://www.everis.com/sites/all/themes/everis/logo.png";

    private ImageView mImageView;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_sample);

        mImageView = (ImageView) findViewById(R.id.imageview);
        mButton = (Button) findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DownloadImagesTask downloadImagesTask = new DownloadImagesTask(WebServiceSampleActivity.this, mImageView);
                downloadImagesTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, URL_LOGO);
            }
        });
    }

}


