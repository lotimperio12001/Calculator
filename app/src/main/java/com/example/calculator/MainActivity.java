package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int firstValue=0;
    private int secondValue=0;
    private int finalValue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView preview= findViewById(R.id.preview);
        TextView response= findViewById(R.id.response);
        Button divide= findViewById(R.id.divide);
        Button multiply= findViewById(R.id.multiply);
        Button subtract= findViewById(R.id.subtract);
        Button plus= findViewById(R.id.plus);
        Button equals= findViewById(R.id.equals);
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view instanceof Button) {
                    Button button = (Button) view;
                    String buttonText = button.getText().toString();
                }
            }
        };
    }

}