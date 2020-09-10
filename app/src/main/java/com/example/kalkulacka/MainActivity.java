package com.example.kalkulacka;

import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView Screen;
private Button AC,Equal,Plus,Minus,Power,Multiply,Divide,Back,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Point;
private String input,Answer;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        AC=findViewById(R.id.ac);
        Equal=findViewById(R.id.equal);
        Plus=findViewById(R.id.plus);
        Minus=findViewById(R.id.minus);
        Power=findViewById(R.id.power);
        Multiply=findViewById(R.id.multiply);
        Divide=findViewById(R.id.divide);
        Back=findViewById(R.id.back);
        One=findViewById(R.id.one);
        Two=findViewById(R.id.two);
        Three=findViewById(R.id.three);
        Four=findViewById(R.id.four);
        Five=findViewById(R.id.five);
        Six=findViewById(R.id.six);
        Seven=findViewById(R.id.seven);
        Eight=findViewById(R.id.eight);
        Nine=findViewById(R.id.nine);
        Zero=findViewById(R.id.zero);
        Point=findViewById(R.id.point);
    }
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case "AC":
                Solve();
                input="";
                break;
            case "x":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case "=":
                Solve();
                Answer=input;
                break;
            case "◄":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if(input==null){
                    input="";
                }
                if (data.equals("+") || data.equals("-") || data.equals("÷")){
                    Solve();
                }
                input+=data;
        }
        Screen.setText(input);
    }
    private void Solve(){
        if(input.split( "\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double multiply = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = multiply+"";
            }
            catch (Exception e){
                //toggle error
            }
        }
        else if(input.split( "÷").length==2){
            String number[]=input.split("÷");
            try {
                double divide = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = divide+"";
            }
            catch (Exception e){
                //toggle error
            }
        }
        else if(input.split( "\\^").length==2){
            String number[]=input.split("\\^");
            try {
                double power = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = power+"";
            }
            catch (Exception e){
                //toggle error
            }
        }
        else if(input.split( "\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double plus = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = plus+"";
            }
            catch (Exception e){
                //toggle error
            }
        }
        else if(input.split( "-").length>1){
            String number[]=input.split("-");
            if (number[0] =="" && number.length==2){
                number[0]=0+"";
            }
            try {
                double minus=0;
                if(number.length==2){
                    minus = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    minus = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = minus+"";
            }
            catch (Exception e){
                //toggle error
            }
        }
        String n[]=input.split("\\.");
            if(n.length>1){
                if(n[1].equals("0")){
                    input=n[0];
                }
            }
        Screen.setText(input);
    }
}