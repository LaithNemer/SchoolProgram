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
    private TextView hiddenText;
    DABook book=new DABook();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hiddenText=findViewById(R.id.printer);
        data=findViewById(R.id.spinnerBook);
        ArrayAdapter<String> stringArray=new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,book.findName());
        data.setAdapter(stringArray);


    }


    public void SubmentBook(View view) {
        String da=data.getSelectedItem().toString();
        ArrayList <Book> b=new ArrayList<>();
        b=book.findData(da);
        String st="";
        for(int i=0;i<b.size();i++){
            st=st+b.get(i).toString()+"\n";
        }
        hiddenText.setVisibility(View.VISIBLE);
        hiddenText.setText(st);
    }
}