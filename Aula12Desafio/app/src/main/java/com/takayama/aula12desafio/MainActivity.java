package com.takayama.aula12desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String DIALOG_AGREE_KEY = "dialog_agree";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        Boolean disclaimerApproved = sharedPreferences.getBoolean(DIALOG_AGREE_KEY,false);
        if(!disclaimerApproved) {
            //ref.: https://www.youtube.com/watch?v=W4qqTcxqq48
            showCustomDialog();
        } else {
            sharedPreferences.edit().putBoolean(DIALOG_AGREE_KEY, false).commit();
            Toast.makeText(MainActivity.this,"reset", Toast.LENGTH_SHORT).show();
        }
    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_layout);

        Button btnAgree = dialog.findViewById(R.id.btn_agree);
        Button bntDisagree = dialog.findViewById(R.id.btn_not_agree);

        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"agreed", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean(DIALOG_AGREE_KEY, true).commit();
                dialog.hide();
            }
        });

        bntDisagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"don't agreed", Toast.LENGTH_SHORT)
                        .show();
                MainActivity.this.finishAffinity();
            }
        });

        dialog.show();
    }
}