package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String operator="";
    private double firstValue=0;
    private double secondValue=0;
    private double thirdValue=0;
    private String showValue="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view) {
        String[] operators = {"+", "-", "*", "/", "%"};
        List<String> operatorList = Arrays.asList(operators);
        TextView response= findViewById(R.id.response);
        TextView preview= findViewById(R.id.preview);
        Button clickedButton = (Button) view;
        String buttonText = clickedButton.getText().toString();
        showValue= showValue+buttonText;
        preview.setText(showValue);
        if(buttonText.equals("C"))
        {
            showValue="";
            preview.setText("0");
        }else if(!showValue.matches(".*\\d.*"))
        {
            showValue="0"+buttonText;
            preview.setText(showValue);
        }
        if(operatorList.contains(buttonText) && !showValue.isEmpty()&& firstValue==0)
        {
            operator= operator+buttonText;
            firstValue=Integer.parseInt(showValue.substring(0,showValue.length()-1));
        }
        if((firstValue!=0 || !operatorList.contains(buttonText))&&secondValue!=0)
        {
            String [] divideValue= showValue.split(operator);
            secondValue= Integer.parseInt(divideValue[1]);
        }
        if(operatorList.contains(buttonText)&&thirdValue!=0)
        {
            showValue=""+thirdValue+buttonText;
            response.setText(""+thirdValue);
            firstValue=thirdValue;
        }
        switch (operator)
        {
            case "+":
                thirdValue=firstValue+secondValue;
                break;
            case "-":
                thirdValue=firstValue-secondValue;
                break;
            case "*":
                thirdValue=firstValue*secondValue;
                break;
            case "/":
                thirdValue=firstValue/secondValue;
        }
    }
}
