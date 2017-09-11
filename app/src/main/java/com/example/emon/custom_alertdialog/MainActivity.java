package com.example.emon.custom_alertdialog;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button click;
    Context mcontex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click=(Button)findViewById(R.id.log);
        mcontex=this;
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mcontex);
                LayoutInflater layoutInflater=LayoutInflater.from(mcontex);
               final View infla=layoutInflater.inflate(R.layout.custom,null);

                final EditText name=(EditText)infla.findViewById(R.id.edit1);
                final EditText pass=(EditText)infla.findViewById(R.id.edit2);
                final Button button2=(Button)infla.findViewById(R.id.log);
                builder.setView(infla);
                final AlertDialog alertDialog=builder.create();
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nam=name.getText().toString();
                        String pas=pass.getText().toString();
                        if(nam.equals("emonm") && pas.equals("computer1234")){
                            Toast.makeText(getApplicationContext(),"UserName and Password is Correct",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(i);
                            alertDialog.dismiss();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"UserName and Password is not Correct",Toast.LENGTH_SHORT).show();
                            alertDialog.dismiss();
                        }
                    }
                });


                alertDialog.show();
            }
        });
    }
}
