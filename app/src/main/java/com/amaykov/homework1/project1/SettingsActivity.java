package com.amaykov.homework1.project1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class SettingsActivity extends AppCompatActivity {

    SeekBar textSize;
    Button callActiv;
    CheckBox kursiv;
    CheckBox bold;
    EditText editEnter;
    RadioButton red;
    RadioButton green;
    RadioButton blue;
    RadioButton black;
    int colour;
    int style;
    int txtsize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSize = findViewById(R.id.seekBar);
        textSize.setMax(100);
        textSize.setProgress(12);
        callActiv = findViewById(R.id.button);
        kursiv = findViewById(R.id.checkBox1);
        bold = findViewById(R.id.checkBox2);
        editEnter = findViewById(R.id.editTextText);
        red = findViewById(R.id.radioButton);
        green = findViewById(R.id.radioButton2);
        blue = findViewById(R.id.radioButton3);
        black = findViewById(R.id.radioButton4);



    }
}