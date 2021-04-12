package com.example.parcial1casa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Productos_Iva extends AppCompatActivity {
    TextView txtiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos__iva);
        txtiva= findViewById(R.id.txt_resul_iva);
        Productos pro = (Productos) getIntent().getSerializableExtra("proiva");
        txtiva.setText(pro.toString());
    }
}