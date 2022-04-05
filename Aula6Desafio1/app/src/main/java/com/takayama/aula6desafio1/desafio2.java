package com.takayama.aula6desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class desafio2 extends AppCompatActivity {
    private final String TAG = "desafio2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio2);

        TextView tvMessage = findViewById(R.id.tv_message);

        Intent intent = getIntent();
        if (intent != null && intent.getAction() == Intent.ACTION_SEND) {
            String message = intent.getStringExtra(Intent.EXTRA_TEXT);
            if(!message.isEmpty()) {
                Log.d(TAG, "message= " + message);
                tvMessage.setText(message);
            }
        }
    }
}