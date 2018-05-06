package com.example.android.singlescreenapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public static void sendMyEmail(Context context, String[] recipientList,
                                 String title, String subject, String body) {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipientList);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(emailIntent, title));
    }

    ImageButton button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (ImageButton) findViewById(R.id.imageButton1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=28.7020862&daddr=-80.6694383"));
                startActivity(mapIntent);
            }
        });

        button2 = (ImageButton) findViewById(R.id.imageButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.beachyoufeet.com"));
                startActivity(intent);

            }
        });

        button3 = (ImageButton) findViewById(R.id.imageButton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:11234782936"));
                startActivity(callIntent);
            }
        });

        button4 = (ImageButton) findViewById(R.id.imageButton4);
        final Context context = getApplicationContext();
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMyEmail(context, new String[]{"bsantiago@beachyourfeet.com"}, "Sending Email",
                        "Test Email", "I am body");

            }
        });

    }

}
