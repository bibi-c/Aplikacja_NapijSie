package com.example.aplikacja_napijsie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import	android.widget.Toast;

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
        RadioGroup rb_sex = (RadioGroup) findViewById(R.id.radioGroupSex);

        Integer sex_sel = rb_sex.getCheckedRadioButtonId();
        Integer sex = -1;

        if (sex_sel == R.id.rbSetupSexFemale) {
            sex = 0;
        }
        else if (sex_sel == R.id.rbSetupSexMale) {
            sex = 1;
        }

        TextView tv_age = (TextView) findViewById(R.id.editTextAge);

        String tv_age_txt = tv_age.getText().toString();
        Integer age = Integer.parseInt(tv_age_txt);

        TextView tv_weight = (TextView) findViewById(R.id.editTextWeigth);

        String tv_weight_txt = tv_weight.getText().toString();
        Double weight = Double.parseDouble(tv_weight_txt);

//      Context context = getApplicationContext();
//      CharSequence text = "SEX: " + sex;
//      int duration = Toast.LENGTH_SHORT;
//      Toast toast = Toast.makeText(context, text, duration);
//      toast.show();

//      text = "AGE: " + age;
//      toast = Toast.makeText(context, text, duration);
//      toast.show();

//      text = "WEIGHT: " + weight;
//      toast = Toast.makeText(context, text, duration);
//      toast.show();

        intent.putExtra("SEX", sex);
        intent.putExtra("AGE", age);
        intent.putExtra("WEIGTH", weight);
        startActivity(intent);
    }
}