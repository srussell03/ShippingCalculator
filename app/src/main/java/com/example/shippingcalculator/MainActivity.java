package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weightET;
    ShipItem shipItem;
    TextView baseTV, addedTV, totalTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightET = (EditText)findViewById(R.id.editText_weight);
        shipItem = new ShipItem();
        baseTV = (TextView)findViewById(R.id.base_cost_textView);
        addedTV = (TextView)findViewById(R.id.added_cost_textView);
        totalTV = (TextView)findViewById(R.id.total_cost_textView);

        weightET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    shipItem.setWeight(Double.parseDouble(charSequence.toString()));
                }catch(NumberFormatException e){
                    shipItem.setWeight(0.0);
                }
                displayShipping();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void displayShipping(){
        @SuppressLint("DefaultLocale") String base = String.format("$ %.2f",shipItem.getBaseCost());
        @SuppressLint("DefaultLocale") String added = String.format("$ %.2f",shipItem.getAddedCost());
        @SuppressLint("DefaultLocale") String total = String.format("$ %.2f",shipItem.getTotalCost());
        baseTV.setText(base);
        addedTV.setText(added);
        totalTV.setText(total);
    }
}