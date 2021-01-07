package com.example.aplikacja_napijsie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitySetupApp1 extends AppCompatActivity {

    private Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_app_1);
        button5 =(Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();


            }

        });

    }
    public void openActivity3 (){
        Intent intent= new Intent(this, ActivitySetupApp2.class);
        startActivity(intent);
    }
}