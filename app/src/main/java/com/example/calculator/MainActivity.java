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
        Button[] buttons = new Button[16];
        for (int i = 0; i < buttons.length; i++) {
            String buttonIdName = "button" + (i + 1);
            int buttonId = getResources().getIdentifier(buttonIdName, "id", getPackageName());

            if (buttonId != 0) {
                buttons[i] = findViewById(buttonId);
            }
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clickedButton = (Button) view;
                    String buttonText = clickedButton.getText().toString();
                    preview.setText("Botón seleccionado: " + buttonText);
                }
            });
        }
    }

}