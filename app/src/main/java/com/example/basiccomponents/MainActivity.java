package com.example.basiccomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.name = findViewById(R.id.name);
        this.mViewHolder.email = findViewById(R.id.email);

        //TextViews
        this.mViewHolder.showE = findViewById(R.id.showE);
        this.mViewHolder.gender = findViewById(R.id.gender);
        this.mViewHolder.listenerView = findViewById(R.id.listenerView);

        //CheckBox
        this.mViewHolder.checkGreen = findViewById(R.id.checkGreen);
        this.mViewHolder.checkRed = findViewById(R.id.checkRed);
        this.mViewHolder.checkWhite = findViewById(R.id.checkWhite);

        //RadioButton
        this.mViewHolder.biOne = findViewById(R.id.biOne);
        this.mViewHolder.nonBi = findViewById(R.id.nonBi);
        this.mViewHolder.biZero = findViewById(R.id.biZero);

        //RadioGroup
        this.mViewHolder.listener = findViewById(R.id.listener);
        listenerRadioGroup();
    }

    public void checkBox() {
        String text = "";
        if(mViewHolder.checkGreen.isChecked()) {
            text = mViewHolder.checkGreen.getText().toString();
        }if(mViewHolder.checkRed.isChecked()){
            text = text + mViewHolder.checkRed.getText().toString();
        }if(mViewHolder.checkWhite.isChecked()){
            text = text + mViewHolder.checkWhite.getText().toString();
        }mViewHolder.showE.setText(text);
    }

    public void radioButton() {
        if (mViewHolder.nonBi.isChecked()) {
            mViewHolder.gender.setText("Gender? Non Binary is Selected");
        } else if (mViewHolder.biZero.isChecked()) {
            mViewHolder.gender.setText("Gender? Binary 0 is Selected");

        } else if (mViewHolder.biOne.isChecked()) {
            mViewHolder.gender.setText("Gender? Binary 1 is Selected");
        }
    }

    public void listenerRadioGroup(){
        mViewHolder.listener.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.biOne){
                    mViewHolder.listenerView.setText("BINARY ONE");
                }else if(checkedId == R.id.biZero){
                    mViewHolder.listenerView.setText("BINARY ZERO");
                }else if(checkedId == R.id.nonBi){
                    mViewHolder.listenerView.setText("NON BINARY");
                }
            }
        });

    }




    public void button(View v){
        if(mViewHolder.name.getText().toString().equals("") && mViewHolder.email.getText().toString().equals("") && mViewHolder.checkGreen.isChecked()) {
            checkBox();
        }else if(!mViewHolder.name.getText().toString().equals("") || !mViewHolder.email.getText().toString().equals("")) {
            mViewHolder.showE.setText(mViewHolder.name.getText().toString() + " from " + mViewHolder.email.getText().toString());
        }else{
            radioButton();
        }
    }

    public static class ViewHolder{
        private EditText name, email;
        private TextView showE, gender, listenerView;
        private CheckBox checkRed, checkGreen, checkWhite;
        private RadioButton nonBi, biZero, biOne;
        private RadioGroup listener;
    }
}