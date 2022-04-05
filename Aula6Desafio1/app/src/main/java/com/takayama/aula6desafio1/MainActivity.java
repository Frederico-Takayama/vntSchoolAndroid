package com.takayama.aula6desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_message = findViewById(R.id.et_message);
        Button bt_sendIntent = findViewById(R.id.send_intent);

        bt_sendIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = et_message.getText().toString();

                Intent sendIntent = new Intent()
                        .setAction(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TEXT, message)
                        .setType("text/plain");

                Intent sharedIntent = new Intent().createChooser(sendIntent, null);
                startActivity(sharedIntent);
            }
        });

    }
}