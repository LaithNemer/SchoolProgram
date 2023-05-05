package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner data;
    EditText Ans;
    private TextView hiddenText;
    DABook book=new DABook();
    EditText firstNumber;
    EditText secoundNumber;
    TextView resultHidden;
    Spinner oparition;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hiddenText=findViewById(R.id.printer);
        data=findViewById(R.id.spinnerBook);
        ArrayAdapter<String> stringArray=new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,book.FindName());
        data.setAdapter(stringArray);
        firstNumber=findViewById(R.id.firstNUmber);
        secoundNumber=findViewById(R.id.SeocundNumber);
        oparition=findViewById(R.id.SpinnerOperation);
        resultHidden=findViewById(R.id.ReslutHidden);
        Ans=findViewById(R.id.Answer);
        getOpartions();






    }


    public void SubmentBook(View view) {
        String da=data.getSelectedItem().toString();
        ArrayList <Book> b=new ArrayList<>();
        b=book.findData(da);
        String st="";
        for(int i=0;i<b.size();i++){
            st=st+b.get(i).toString()+"\n";
        }

        hiddenText.setText(st);

    }


    public void CalculateNumber(View view){
        resultHidden.setVisibility(view.VISIBLE);
        int Number=Integer.parseInt(firstNumber.getText().toString()) ;
        int SNumber=Integer.parseInt(secoundNumber.getText().toString());
        String calculat=oparition.getSelectedItem().toString();

        if(calculat.equals("*")){
            int find=Number*SNumber;
            String answer=Ans.getText().toString();
            int number=Integer.parseInt(answer);
            if(find== number){
                resultHidden.setText("Correct...answer is: " + find);
            }
            else{
                resultHidden.setText("Wrong ... The Correct answer " + find);
            }

        }
        else if (calculat.equals("+")) {
            int find=Number+SNumber;
            String answer=Ans.getText().toString();
            if(find== Integer.parseInt(answer) ){
                resultHidden.setText("Correct...answer is: " + find);
            }
            else{
                resultHidden.setText("Wrong ... The Correct answer " + find);
            }
        }
        else if(calculat.equals("-")){
            int find=Math.abs(Number-SNumber);
            String answer=Ans.getText().toString();
            if(find== Integer.parseInt(answer) ){
                resultHidden.setText("Correct...answer is: " + find);
            }
            else{
                resultHidden.setText("Wrong ... The Correct answer " + find);
            }

        }
        else{
            int find=0;
            if(Number>SNumber){
                find=Number/SNumber;
                String answer=Ans.getText().toString();
                if(find== Integer.parseInt(answer) ){
                    resultHidden.setText("Correct...answer is: " + find);
                }
                else{
                    resultHidden.setText("Wrong ... The Correct answer " + find +"\n"+" Please try again");
                }

            }
            else{
                find=SNumber/Number;
                String answer=Ans.getText().toString();
                if(find== Integer.parseInt(answer) ){
                    resultHidden.setText("Correct...answer is: " + find);
                }
                else{
                    resultHidden.setText("Wrong ... The Correct answer " + find);
                }
            }
        }


    }

    public void RESET(View view){
        firstNumber.setText("");
        secoundNumber.setText("");
        Ans.setText("");

    }

    public void getOpartions(){
        ArrayAdapter<String >array=new ArrayAdapter<>(MainActivity.this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,book.Oparitions());
        oparition.setAdapter(array);
    }
}