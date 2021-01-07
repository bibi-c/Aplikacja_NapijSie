package com.example.aplikacja_napijsie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import	android.widget.Toast;
import android.content.Context;

public class ActivitySetupApp2 extends AppCompatActivity {


    private Button button6;
    private Integer sex;
    private Integer age;
    private Double weight;
    private Integer act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_app_2);

        button6 =(Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }

        });


        Intent intent = getIntent();
        sex = intent.getIntExtra("SEX", -1);
        age = intent.getIntExtra("AGE", -1);
        weight = intent.getDoubleExtra("WEIGTH", -1);

        Context context = getApplicationContext();
//        CharSequence text = "SEX: " + sex;
//        int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
//
//        text = "AGE: " + age;
//        toast = Toast.makeText(context, text, duration);
//        toast.show();
//
//        text = "WEIGHT: " + weight;
//        toast = Toast.makeText(context, text, duration);
//        toast.show();

    }

    public void openActivity4 (){
        Intent intent = new Intent(this, ActivitySetupApp3.class);

        RadioGroup rb_activity_type = (RadioGroup) findViewById(R.id.radioGroupActivity);

        Integer act_sel = rb_activity_type.getCheckedRadioButtonId();
        act = -1;

        if (act_sel == R.id.rbActivityMinimal) {
            act = 0;
        }
        else if (act_sel == R.id.rbActivityModerate) {
            act = 1;
        }
        else if (act_sel == R.id.rbActivityHigh) {
            act = 2;
        }

        Context context = getApplicationContext();
        CharSequence text = "ACTIVITY TYPE: " + act;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();

        // SAVE INTO SQLITE
        DBAdapter dbo = new DBAdapter(context);
        dbo.open();
        Integer setup_rows_cnt = dbo.selectSetupCnt();
        if (setup_rows_cnt > 0){
            dbo.clearSetup();
        }

        //TODO: CALCULATE THE DAILY DEMAND i/o

        dbo.insertSetup(sex, age, weight, act, -1d);


        intent.putExtra("SEX", sex);
        intent.putExtra("AGE", age);
        intent.putExtra("WEIGTH", weight);
        intent.putExtra("ACT", act);

        startActivity(intent);
    }
}