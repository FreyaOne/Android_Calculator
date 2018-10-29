package com.example.fling.caculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class scienceCaculor extends AppCompatActivity {

    protected EditText input;  //初始为空
    protected TextView result;
    protected int c = 0;    //计算的次数
    protected List<String> method = new ArrayList<String>();
    protected String strResult;
    private double temp;
    private double temp2;
    private String[] str1;
    private boolean isClear;  //判断屏幕是否需要为空
    private boolean u = true;  //判断是否连续点击运算符号
    private double square;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_caculor);
        Button bt0 = (Button) findViewById(R.id.bt0);
        Button bt1 = (Button) findViewById(R.id.bt1);
        Button bt2 = (Button) findViewById(R.id.bt2);
        Button bt3 = (Button) findViewById(R.id.bt3);
        Button bt4 = (Button) findViewById(R.id.bt4);
        Button bt5 = (Button) findViewById(R.id.bt5);
        Button bt6 = (Button) findViewById(R.id.bt6);
        Button bt7 = (Button) findViewById(R.id.bt7);
        Button bt8 = (Button) findViewById(R.id.bt8);
        Button bt9 = (Button) findViewById(R.id.bt9);
        Button btDian = (Button) findViewById(R.id.btDian);

        //运算按钮
        Button btMultiply = (Button) findViewById(R.id.btMultiply);
        Button btMinus = (Button) findViewById(R.id.btMinus);
        Button btPlus = (Button) findViewById(R.id.btPlus);
        Button btEqual = (Button) findViewById(R.id.btEqual);
        Button btPercent = (Button) findViewById(R.id.btPercent);
        Button btClear = (Button) findViewById(R.id.btClear);
        Button btAll = (Button) findViewById(R.id.btAll);
        Button btSquare = (Button) findViewById(R.id.btSquare);
        Button btDivide = (Button) findViewById(R.id.btDivide);
        input = (EditText) findViewById(R.id.textView);
        result = (TextView) findViewById(R.id.textView2);


        bt0.setOnClickListener(clickListener);
        bt1.setOnClickListener(clickListener);
        bt2.setOnClickListener(clickListener);
        bt3.setOnClickListener(clickListener);
        bt4.setOnClickListener(clickListener);
        bt5.setOnClickListener(clickListener);
        bt6.setOnClickListener(clickListener);
        bt7.setOnClickListener(clickListener);
        bt8.setOnClickListener(clickListener);
        bt9.setOnClickListener(clickListener);
        btMultiply.setOnClickListener(clickListener);
        btDian.setOnClickListener(clickListener);
        btAll.setOnClickListener(clickListener);
        btMinus.setOnClickListener(clickListener);
        btPlus.setOnClickListener(clickListener);
        btEqual.setOnClickListener(clickListener);
        btSquare.setOnClickListener(clickListener);
        btPercent.setOnClickListener(clickListener);
        btClear.setOnClickListener(clickListener);
        btDivide.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View view) {
            String command = ((Button) view).getText().toString();
            strResult = input.getText().toString();
            switch (view.getId()) {
                case R.id.bt1:
                    strResult += "1";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt2:
                    strResult += "2";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt3:
                    strResult += "3";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt4:
                    strResult += "4";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt5:
                    strResult += "5";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt6:
                    strResult += "6";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt7:
                    strResult += "7";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt8:
                    strResult += "8";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt9:
                    strResult += "9";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.bt0:
                    strResult += "0";
                    u = false;
                    input.setText(strResult);
                    break;
                case R.id.btDian:
                    strResult += ".";
                    input.setText(strResult);
                    break;
                case R.id.btPlus:
                    strResult += "＋";
                    input.setText(strResult);
                    method.add("+");
//                    method[0] = "+";
                    getResult();
                    break;
                case R.id.btMinus:
                    strResult += "－";
                    input.setText(strResult);
                    method.add("-");
                    getResult();
                case R.id.btMultiply:
                    strResult += "×";
                    input.setText(strResult);
                    method.add("*");
                    getResult();
                    break;
                case R.id.btDivide:
                    strResult += "÷";
                    input.setText(strResult);
                    method.add("/");
                    getResult();
                    break;
                case R.id.btSquare:
                    strResult += "²";
                    input.setText(strResult);
                    method.add("²");
                    getResult();
                    break;
                case R.id.btEqual:
                    strResult = input.getText().toString();
                    str1 = strResult.split("＋|－|×|÷");
                    temp2 = Double.parseDouble(str1[str1.length - 1]);
                    if (method.get(method.size() - 1) == "+") {
                        temp += temp2;
                    } else if (method.get(method.size() - 1) == "-") {
                        temp -= temp2;
                    } else if (method.get(method.size() - 1) == "*") {
                        temp *= temp2;
                    } else if (method.get(method.size() - 1) == "/") {
                        if (temp2 == 0) {
                            return;
                        } else {
                            temp /= temp2;
                        }
                    }
                    result.setText("" + temp);
                    c = 0;
                    input.setSelection(input.getText().length());
                    break;
                case R.id.btClear:
                    strResult = input.getText().toString();
                    if (strResult != null && !strResult.equals("")) {
                        input.setText(strResult.substring(0, strResult.trim().length() - 1));
                    } else {
                        input.setText("");
                    }
                    input.setSelection(input.getText().length());
                    break;
                case R.id.btAll:
                    input.setText("");
                    break;
                default:
            }

        }

        public void getResult() {
            strResult = input.getText().toString();
            str1 = strResult.split("＋|－|×|÷|\\²");

            if (c == 0) {
                temp = Double.parseDouble(str1[c]);
                c += 1;
            } else {
                if (u == false) {
                    if (method.contains("²") == true) {
                        temp2 = Double.parseDouble(str1[c - 1]);
                    } else {
                        Log.e("aasss", "1231231313");
                        temp2 = Double.parseDouble(str1[c]);
                    }
                    c += 1;
                    equals(temp2);
                } else {
                    Toast.makeText(scienceCaculor.this, "请正确输入", Toast.LENGTH_LONG).show();
                }
                u = true;
            }
        }

        public void equals(double dou) {
//            strResult = input.getText().toString();
            if (method.get(method.size() - 2) == "+") {
                temp += dou;
            } else if (method.get(method.size() - 2) == "-") {
                temp -= dou;
            } else if (method.get(method.size() - 2) == "*") {
                temp *= dou;
            } else if (method.get(method.size() - 2) == "/") {
                if (dou == 0) {
                    return;
                } else {
                    temp /= dou;
                }
            } else if (method.get(method.size() - 2) == "²") {
                temp = temp * dou;
            }
//            Toast.makeText(MainActivity.this,"a aa a a", Toast.LENGTH_LONG).show();
            result.setText("" + temp);

        }

        public List midToBack(){
            List<String> list = new ArrayList<String>();
            strResult = input.getText().toString();
            for(int i = 0;i<strResult.length();i++){
                char stack = strResult.charAt(i);

            }
            return list;
        }
    };

//


}


