package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float first_number = 0;
    float second_number = 0;

    private enum operation
    {
        add,
        subtract,
        mult,
        divide
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setNums()
    {
        EditText first_number_text = (EditText) findViewById(R.id.first_number_field);
        EditText second_number_text = (EditText) findViewById(R.id.second_number_field);
        first_number = Float.parseFloat(first_number_text.getText().toString());
        second_number = Float.parseFloat(second_number_text.getText().toString());
    }

    private float calculate(operation op)
    {
        float result = 0;

        switch (op)
        {
            case add:
                result = first_number + second_number;
                break;
            case subtract:
                result = first_number - second_number;
                break;
            case mult:
                result = first_number * second_number;
                break;
            case divide:
                result = first_number / second_number;
                break;
            default:
                break;
        }

        return result;
    }

    public void onClickAdd(View view)
    {
        setNums();

        float result = calculate(operation.add);
        goToDisplayCalculation(Float.toString(result));
    }

    public void onClickSubtract(View view)
    {
        setNums();

        float result = calculate(operation.subtract);
        goToDisplayCalculation(Float.toString(result));
    }

    public void onClickMult(View view)
    {
        setNums();

        float result = calculate(operation.mult);
        goToDisplayCalculation(Float.toString(result));
    }

    public void onClickDivide(View view)
    {
        setNums();

        float result = calculate(operation.divide);
        goToDisplayCalculation(Float.toString(result));
    }

    public void goToDisplayCalculation(String s)
    {
        Intent intent = new Intent(this, DisplayCalculation.class);
        intent.putExtra("message",s);
        startActivity(intent);
    }

}