package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String finalValue="";
    private String value="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view) {
        TextView response= findViewById(R.id.response);
        TextView preview= findViewById(R.id.preview);
        Button clickedButton = (Button) view;
        String buttonText = clickedButton.getText().toString();
        value= value+buttonText;
        preview.setText(value);
        if(buttonText.equals("C"))
        {
            value="";
            preview.setText("0");
        }else if(!value.matches(".*\\d.*")){
            Toast.makeText(getApplicationContext(),"Ingresa un valor",Toast.LENGTH_SHORT).show();
            value="";
            preview.setText("0");
        }
    }
    public void compareString(String operation)
    {

    }
}
