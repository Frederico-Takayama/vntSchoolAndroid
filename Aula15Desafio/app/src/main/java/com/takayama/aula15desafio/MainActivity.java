package com.takayama.aula15desafio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String CHANNEL_ID = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonShowNotify = findViewById(R.id.btn_show_notify);
        buttonShowNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Entrou", Toast.LENGTH_SHORT).show();
                mostrarNofiticacao();
            }
        });
    }

    private void mostrarNofiticacao() {
        NotificationChannel mainChannel = new NotificationChannel(CHANNEL_ID,
                "mainChannel",
                NotificationManager.IMPORTANCE_DEFAULT);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(mainChannel);

        NotificationCompat.Builder builder
                = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Notificação Aula 15")
                .setContentText("Essa é a notificação do desafio da aula 15")
                .setPriority(NotificationCompat.PRIORITY_LOW);

        NotificationManagerCompat.from(this).notify(1,builder.build());
    }
}