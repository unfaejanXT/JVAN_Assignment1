package com.unfaejan.jvan_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;

    private Button clearTextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        clearTextbtn = findViewById(R.id.clearTextbtn);

        clearTextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputEditText.setText("");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"On Start",Toast.LENGTH_SHORT).show();

        String dataTersimpan = this.getSharedPreferences("Siklus Hidup", Context.MODE_PRIVATE).getString("Komentar",null);
        inputEditText.setText(dataTersimpan);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"on Resume", Toast.LENGTH_SHORT).show();

        String dataTersimpan = this.getSharedPreferences("Siklus Hidup", Context.MODE_PRIVATE).getString("Komentar",null);
        inputEditText.setText(dataTersimpan);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"On Stop",Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor data = this.getSharedPreferences("Siklus Hidup",Context.MODE_PRIVATE).edit();
        data.putString("Komentar", inputEditText.getText().toString());
        data.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"on Destroy", Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor data = this.getSharedPreferences("Siklus Hidup",Context.MODE_PRIVATE).edit();
        data.putString("Komentar", inputEditText.getText().toString());
        data.apply();
    }
}