package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PasswordGenerator extends AppCompatActivity {
    TextView mtv_password;
    Button mbtn_generate;
    TextView mgotosavepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_generator);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        mtv_password = (TextView)findViewById(R.id.tv_password);
        mbtn_generate = (Button) findViewById(R.id.btn_generate);
        mgotosavepassword = (TextView) findViewById(R.id.gotosavepassword);

        mbtn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = 10;

                mtv_password.setText(GetPassword(length));
            }
        });

        Intent data = getIntent();

        mgotosavepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = mtv_password.getText().toString().trim();

                if(password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Generate Password First",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Intent intent=new Intent(v.getContext(),createnote.class);
                    intent.putExtra("value", password);
                    v.getContext().startActivity(intent);
                    finish();
                }
            }
        });

    }

    public String GetPassword(int length){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$&*".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        Random rand = new Random();

        for (int i=0; i<length;i++){
            char c = chars[rand.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}