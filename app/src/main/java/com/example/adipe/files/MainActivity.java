package com.example.adipe.files;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String str;
    TextView textv1;
    EditText edte1;
    InputStream is;
    String file = "file.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            setContentView(R.layout.activity_main);

            textv1=(TextView)findViewById(R.id.textView);
            edte1=(EditText) findViewById(R.id.editText); }



    public void b1(View view) {
        str=edte1.getText().toString();
        try {
            FileOutputStream f=openFileOutput(file,Context.MODE_PRIVATE);
            OutputStreamWriter o=new OutputStreamWriter(f);
            BufferedWriter bw=new BufferedWriter(o);
            bw.write(str);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void b2(View view) {
        try {
            is = openFileInput(file);
            InputStreamReader t=new InputStreamReader(is);
            BufferedReader r=new BufferedReader(t);
            StringBuffer b=new StringBuffer();
            while ((str=r.readLine())!=null)
                b.append(str+"\n");
            is.close();
            textv1.setText(b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
