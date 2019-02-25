package com.example.everis.android.androidbasicoaplicado;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog pDialog;

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);


        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MyAsyncTask tarea2 = new MyAsyncTask(MainActivity.this);
                tarea2.execute();
            }
        });
    }
}
