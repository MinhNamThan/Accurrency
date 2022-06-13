package com.example.currencyapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity{
    Spinner spinner1;
    Spinner spinner2;
    TextView value1,value2;
    ImageView DV1, DV2;
    String [] items = {"United States-dollar", "Europe - Euro", "England - pound", "Viet Nam - VND"};
    int weight1,weight2;
    boolean haveDot = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (Spinner) findViewById(R.id.listKindOfMoney1);
        spinner2 = (Spinner) findViewById(R.id.listKindOfMoney2);
        DV1 = findViewById(R.id.DV1);
        DV2 = findViewById(R.id.DV2);
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nameCur = parent.getItemAtPosition(position).toString();
                if(nameCur.equals(items[0])){
                    DV1.setImageResource(R.drawable.ic_attach_money_black_24dp);
                    weight1 = 23177;
                }else if(nameCur.equals(items[1])){
                    DV1.setImageResource(R.drawable.ic_euro_black_24dp);
                    weight1 = 24379;
                }else if(nameCur.equals(items[2])){
                    DV1.setImageResource(R.drawable.ic_currency_pound_black_24dp);
                    weight1 = 28552;
                }else{
                    DV1.setImageResource(R.drawable.ic_stat_name);
                    weight1 = 1;
                }
                currency();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nameCur = parent.getItemAtPosition(position).toString();
                if(nameCur.equals(items[0])){
                    DV2.setImageResource(R.drawable.ic_attach_money_black_24dp);
                    weight2 = 23177;
                }else if(nameCur.equals(items[1])){
                    DV2.setImageResource(R.drawable.ic_euro_black_24dp);
                    weight2 = 24379;
                }else if(nameCur.equals(items[2])){
                    DV2.setImageResource(R.drawable.ic_currency_pound_black_24dp);
                    weight2 = 28552;
                }else{
                    DV2.setImageResource(R.drawable.ic_stat_name);
                    weight2 = 1;
                }
                currency();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void currency(){
        float tmp = Float.parseFloat(value1.getText().toString());
        tmp = (float)tmp*weight1/weight2;
        String tmpstr = String.format("%.4g%n",tmp);
        //String tmpstr = String.valueOf( tmp);

        while (tmpstr.charAt(tmpstr.length()-1) == '0'){
            tmpstr = tmpstr.substring(0,tmpstr.length()-1);
        }
        if(tmpstr.charAt(tmpstr.length()-1) == '.'){
            tmpstr = tmpstr.substring(0,tmpstr.length()-1);
        }
        value2.setText(tmpstr);
    }
    public void clearAll(View view) {
        value1.setText("0");
        currency();
    }

    public void backSpace(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")||tmp.length() == 1){
            value1.setText("0");
        }else{
            value1.setText(tmp.substring(0,tmp.length()-1));
        }
        currency();
    }

    public void addNum9(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("9");
        value1.setText(tmp+"9");
        currency();
    }

    public void addNum8(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("8");
        else value1.setText(tmp+"8");
        currency();
    }

    public void addNum7(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("7");
        else value1.setText(tmp+"7");
        currency();
    }

    public void addNum6(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("6");
        else value1.setText(tmp+"6");
        currency();
    }

    public void addNum5(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("5");
        else value1.setText(tmp+"5");
        currency();
    }

    public void addNum4(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("4");
        else value1.setText(tmp+"4");
    }

    public void addNum2(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("2");
        else value1.setText(tmp+"2");
        currency();
    }

    public void addNum1(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("1");
        else value1.setText(tmp+"1");
        currency();
    }

    public void addNum3(View view) {
        String tmp = value1.getText().toString();
        if(tmp.equals("0")) value1.setText("3");
        else value1.setText(tmp+"3");
        currency();
    }

    public void addDot(View view) {
        if (!haveDot) {
            String tmp = value1.getText().toString();
            value1.setText(tmp + ".");
            currency();
            haveDot = true;
        }
    }

    public void addNum0(View view) {
        String tmp = value1.getText().toString();
        if(!tmp.equals("0"))
            value1.setText(tmp+"0");
        currency();
    }
}