package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Conversion_Button = (Button) findViewById(R.id.Convert_Button);
        Button Clear_Button = (Button) findViewById(R.id.Clear_Button);
        Temperature Current_Temperature = new Temperature();
        EditText temperature = (EditText) findViewById(R.id.Temperature_EditText);
        RadioButton Celsius = (RadioButton) findViewById(R.id.Celsius_RadioButton);
        RadioButton Fahrenheit = (RadioButton) findViewById(R.id.Fahernhiet_RadioButton);
        Clear_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Temperature_Edit_Text = (EditText) findViewById(R.id.Temperature_EditText);
                RadioGroup Temperature_Radio_Group = (RadioGroup) findViewById(R.id.Temperature_Radio_Group);
                Temperature_Edit_Text.setText("");
                Temperature_Radio_Group.clearCheck();
                Toast.makeText(getApplicationContext(),"Data & Selections Erased",Toast.LENGTH_LONG).show();
            }
        });
        /*ALWAYS PUT RADIO BUTTONS IN RADIO GROUP (ALL FUNCTIONALITIES ARE PRESERVED) */
        /* Example One ==> Radio Buttons */
        Conversion_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(temperature.getText().toString().equals(""))){

                    if(Celsius.isChecked()){
//                        Fahrenheit.setClickable(false);
//                        Fahrenheit.setSelected(false);
//                        Fahrenheit.setActivated(false);

                        float temp = Float.parseFloat(temperature.getText().toString());
                        Current_Temperature.setTemperature(temp);
                        temp = Current_Temperature.To_C();
                        temperature.setText(String.valueOf(temp));
                    }
                    else if(Fahrenheit.isChecked()){
//                        Celsius.setClickable(false);
//                        Celsius.setSelected(false);
//                        Celsius.setActivated(false);
//                        Fahrenheit.toggle();
                        Fahrenheit.toggle();
                        float temp = Float.parseFloat(temperature.getText().toString());
                        Current_Temperature.setTemperature(temp);
                        temp = Current_Temperature.To_F();
                        temperature.setText(String.valueOf(temp));
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please Enter a valid Number",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        /* Example OnTwo ==> Spinner */
        final Spinner Temperature_Options = (Spinner) findViewById(R.id.Temperature_Spinner);
        Temperature_Options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Temperature Current_Temperature = new Temperature();
                EditText temperature = (EditText) findViewById(R.id.Temperature_EditText);
                if (!(temperature.getText().toString().equals(""))){
                    String Selected_Option = Temperature_Options.getSelectedItem().toString();
                    if (Selected_Option.equals("Celsius")){
                        float temp = Float.parseFloat(temperature.getText().toString());
                        Current_Temperature.setTemperature(temp);
                        temp = Current_Temperature.To_C();
                        temperature.setText(String.valueOf(temp));
                    }
                    else if (Selected_Option.equals("Fahrenheit")){
                        float temp = Float.parseFloat(temperature.getText().toString());
                        Current_Temperature.setTemperature(temp);
                        temp = Current_Temperature.To_F();
                        temperature.setText(String.valueOf(temp));
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please Enter a valid Number",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}