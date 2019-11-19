package com.appsfromholland.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnC, btnR, btnU, btnD;
    TextView dbContent;
    MetingManager mm = new MetingManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button CREATE
        findViewById(R.id.btnC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mm.create(new Meting(Unit.WATT, (int) (Math.random() * 1000)));
            }
        });

        // Button READ
        findViewById(R.id.bntR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbContent.setText("");
                for(Meting m: mm.read()) {
                    dbContent.append(", " + m.toString());
                };
            }
        });

        // Button UPDATE
        findViewById(R.id.bntU).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Button DELETE
        findViewById(R.id.btnD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mm.delete();
            }
        });

        dbContent = findViewById(R.id.textView);

    }
}
