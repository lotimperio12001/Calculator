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
import java.util.regex.Pattern;

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
            response.setText("0");
            firstValue=0;
            secondValue=0;
            thirdValue=0;
            operator="";
        }else if(!showValue.matches(".*\\d.*"))
        {
            showValue="0"+buttonText;
            preview.setText(showValue);
        }else if(buttonText.equals("="))
        {
            preview.setText(firstValue+operator+secondValue+"=");
            response.setText(thirdValue+"");
        }
        if(operatorList.contains(buttonText))
        {
            operator= buttonText;
            char lastCharacter = showValue.charAt(showValue.length() - 2);
            if(operatorList.contains(Character.toString(lastCharacter)))
            {
                showValue=showValue.replace(lastCharacter,operator.charAt(0));
                showValue=showValue.substring(0,showValue.length()-1);
                preview.setText(showValue);
            }
        }
        if(operatorList.contains(buttonText) && !showValue.isEmpty()&& firstValue==0)
        {
            firstValue=Double.parseDouble(showValue.substring(0,showValue.length()-1));
        }
        if(!operatorList.contains(buttonText)&&operator!="")
        {
            try {
                String [] divideValue=showValue.split((Pattern.quote(operator)));
                System.out.println(divideValue[1]);
                secondValue= Double.parseDouble(divideValue[1]);
            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if(operatorList.contains(buttonText)&&thirdValue!=0&&secondValue!=0)
        {
            showValue=""+thirdValue+buttonText;
            preview.setText(showValue);
            response.setText(""+thirdValue);
            firstValue=thirdValue;
        }else
        {
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
}
