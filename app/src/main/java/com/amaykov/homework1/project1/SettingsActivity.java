package com.amaykov.homework1.project1;

import android.graphics.Color;
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
import android.content.Context;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.Toast;
import android.util.AttributeSet;
import android.content.Intent;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    SeekBar textSize;
    Button callActiv;
    CheckBox kursiv;
    CheckBox bold;
    EditText editEnter;
    RadioGroup colorsGroup;
    RadioButton red;
    RadioButton green;
    RadioButton blue;
    RadioButton black;
    int colour;
    int style;
    int txtsize = 20;
    String text;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.textView);
        name.setTextSize(txtsize);
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
        RadioGroup colorsGroup = (RadioGroup) findViewById(R.id.radio);


        textSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtsize = progress;

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), txtsize + "dp", Toast.LENGTH_SHORT).show();
            }
        });

        editEnter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text = s.toString();
                if(count == 0)
                    text = "1";
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        colorsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioButton) {
                    colour = 1;

                } else if (checkedId == R.id.radioButton2) {
                    colour = 2;
                }
                else if (checkedId == R.id.radioButton3) {
                    colour = 3;
                }
                else {
                    colour = 0;
                }
            }
        });


        callActiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bold.isChecked())
                    style = 1;
                if(kursiv.isChecked())
                    style = 2;
                else
                    style = 0;
                text = editEnter.getText().toString();

                Intent intent = new Intent(SettingsActivity.this, PreviewActivity.class);
                if(text.isEmpty())
                    txtsize = 0;
                intent.putExtra("KEY_STRING", text);
                intent.putExtra("KEY_INT1", style);
                intent.putExtra("KEY_INT2", txtsize);
                intent.putExtra("KEY_INT3", colour);
                startActivity(intent);
            }
        });



    }
}